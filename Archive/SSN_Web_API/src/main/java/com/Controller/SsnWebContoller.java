package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.SSnWebResponseDTO;
import com.DTO.SsnWebRequestDTO;
import com.Service.SSnWebService;

@RestController
public class SsnWebContoller {

	@Autowired
	private SSnWebService ssn;

	@PostMapping("/checkSSN")
    public ResponseEntity<?> checkforSSNCitizen(@RequestBody SsnWebRequestDTO swd) {
        // Basic null check
        if (swd == null || swd.getCitizenSsnNumber() == null || swd.getCitizenSsnNumber().isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body("SSN request cannot be null or empty");
        }

        System.out.println("SSN Request DTO: " + swd);

        // Call the service safely
        SSnWebResponseDTO check = ssn.EligibilityCheck(swd);

        System.out.println("SSN Response DTO: " + check);

        return ResponseEntity.ok(check);
    }

}
