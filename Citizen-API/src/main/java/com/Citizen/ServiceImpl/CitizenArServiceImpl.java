package com.Citizen.ServiceImpl;

import java.time.format.DateTimeFormatter;
import java.util.List;
 


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.Citizen.DTO.CitizenDTO;
import com.Citizen.DTO.SsnWebRequestDTO;
import com.Citizen.DTO.SsnWebResponseDTO;
import com.Citizen.Entity.CitizenApplication;
import com.Citizen.Entity.User;
import com.Citizen.Entity.PlanMaster;
import com.Citizen.Exception.ApplicationNotFoundWithThisId;
import com.Citizen.Exception.PlanNotFoundWithName;
import com.Citizen.Exception.UserNoFoungThisID;
import com.Citizen.Repo.AuthenticationRepo;
import com.Citizen.Repo.CitizenArRepo;
import com.Citizen.Repo.PlanRepo;
import com.Citizen.Service.CitizenArService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CitizenArServiceImpl implements CitizenArService {

    @Autowired
    private CitizenArRepo citizenArRepo;

    @Autowired
    private PlanRepo pr;

    @Autowired
    private AuthenticationRepo authrep;

    @Override
    @PreAuthorize("hasRole('Citizen')")
    public boolean createApplication(CitizenDTO citizenDto) {

        log.info("Citizen Service :: {}", citizenDto);

        // Validate SSN early
        
        if (citizenDto.getSsn() == null) {
            throw new IllegalArgumentException("SSN cannot be null");
        }
        if (citizenDto.getSsn() == null || citizenDto.getSsn().toString().trim().isEmpty()) {
            throw new IllegalArgumentException("SSN cannot be null or empty");
        }

        if (citizenDto.getSsn().toString().length() != 9) {
            throw new IllegalArgumentException("SSN must be exactly 9 digits");
        }

        String url = "http://localhost:7001/checkSSN";

        // Get authenticated user's email from SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName(); 
        log.info("Authenticated Email : {}", userEmail);

        // Fetch User entity from DB
        User authenticatedUser = authrep.findByEmail(userEmail);
        if (authenticatedUser == null) {
            throw new UserNoFoungThisID("Authenticated user not found in DB!");
        }
       
        // Prepare SSN request DTO
        SsnWebRequestDTO ssnWebRequestDto = new SsnWebRequestDTO();
        ssnWebRequestDto.setCitizenName(citizenDto.getFullname());

        // Format DOB as MM/dd/yyyy (adjust if your API expects different format)
        ssnWebRequestDto.setCitizenDob(
            citizenDto.getDob().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"))
        );

        // Ensure SSN is exactly 9 digits, preserving leading zeros
     // Ensure SSN is 9 characters, pad with leading zeros if needed
        String ssn = citizenDto.getSsn();
        if (ssn.length() != 9) {
            ssn = String.format("%09d", Long.parseLong(ssn)); // only if numeric
        }
        ssnWebRequestDto.setCitizenSsnNo(ssn);


        // Log JSON payload
        try {
            ObjectMapper mapper = new ObjectMapper();
            log.info("SSN Request JSON: {}", mapper.writeValueAsString(ssnWebRequestDto));
        } catch (Exception e) {
            log.warn("Failed to log SSN request JSON", e);
        }

        // Set headers for JSON
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<SsnWebRequestDTO> requestEntity = new HttpEntity<>(ssnWebRequestDto, headers);

        RestTemplate rt = new RestTemplate();
        ResponseEntity<SsnWebResponseDTO> response;

        try {
            response = rt.postForEntity(url, requestEntity, SsnWebResponseDTO.class);
        } catch (HttpClientErrorException.BadRequest e) {
            log.error("SSN Service returned 400 Bad Request: {}", e.getResponseBodyAsString());
            throw new IllegalArgumentException("Invalid SSN request: " + e.getResponseBodyAsString());
        }

        log.info("SSN Service Response: {}", response.getBody());

        // Process response if state is Rhode Island
        if (response.getBody() != null &&
            "Rhode Island".equalsIgnoreCase(response.getBody().getStateName())) {

            ModelMapper model = new ModelMapper();
            CitizenApplication cap = model.map(citizenDto, CitizenApplication.class);
            cap.setUser(authenticatedUser);

            PlanMaster plan = pr.findByPlanName(citizenDto.getPlanName())
                    .orElseThrow(() -> new PlanNotFoundWithName("Plan does not exist with this name"));
            cap.setPlan(plan);

            citizenArRepo.save(cap);

            return true;
        }

        return false;
    }
 

    @Override
    @PreAuthorize("hasAnyRole('Admin','Citizen')")
    public CitizenApplication getApp(Integer appNum) {
        return citizenArRepo.findById(appNum)
                .orElseThrow(() -> new ApplicationNotFoundWithThisId("Application Number invalid!!"));
    }

    @Override
    @PreAuthorize("hasAnyRole('Admin','Citizen')")
    public List<CitizenApplication> getApps() {
        return citizenArRepo.findAll();
    }

    @Override
    @PreAuthorize("hasRole('Citizen')")
    public CitizenApplication getAppWithCitizenId(Integer citizenId) {
        User user = authrep.findById(citizenId)
                .orElseThrow(() -> new UserNoFoungThisID("Citizen ID Invalid!!"));

        return citizenArRepo.findByUser(user)
                .orElseThrow(() -> new UserNoFoungThisID("Citizen ID Invalid!!"));
    }
}
