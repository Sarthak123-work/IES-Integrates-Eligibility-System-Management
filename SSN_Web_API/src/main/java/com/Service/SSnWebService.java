package com.Service;

import com.DTO.SSnWebResponseDTO;
import com.DTO.SsnWebRequestDTO;

public interface SSnWebService {

	SSnWebResponseDTO EligibilityCheck(SsnWebRequestDTO swd);

}
