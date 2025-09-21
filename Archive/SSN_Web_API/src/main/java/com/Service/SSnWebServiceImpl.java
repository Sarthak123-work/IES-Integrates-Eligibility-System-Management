package com.Service;

import org.springframework.stereotype.Service;

import com.DTO.SSnWebResponseDTO;
import com.DTO.SsnWebRequestDTO;

@Service
public class SSnWebServiceImpl implements SSnWebService{

	@Override
    public SSnWebResponseDTO EligibilityCheck(SsnWebRequestDTO swd) {
        // Null-safe check
        if (swd == null || swd.getCitizenSsnNumber() == null || swd.getCitizenSsnNumber().isEmpty()) {
            // Return a response indicating invalid request instead of throwing
            SSnWebResponseDTO errorResponse = new SSnWebResponseDTO();
            errorResponse.setCitizenSsnNumber(null);
            errorResponse.setStateName("Invalid SSN request");
            return errorResponse;
        }

        System.out.println("Processing SSN request: " + swd);

        SSnWebResponseDTO ssnwrdto = new SSnWebResponseDTO();
        ssnwrdto.setCitizenSsnNumber(swd.getCitizenSsnNumber());

        String ssn = swd.getCitizenSsnNumber();
        switch (ssn.charAt(0)) {
            case '1':
                ssnwrdto.setStateName("California");
                break;
            case '2':
                ssnwrdto.setStateName("Rhode Island");
                break;
            case '3':
                ssnwrdto.setStateName("Texas");
                break;
            case '4':
                ssnwrdto.setStateName("New Jersey");
                break;
            default:
                ssnwrdto.setStateName("Any State of US");
        }

        return ssnwrdto;
    }


}
