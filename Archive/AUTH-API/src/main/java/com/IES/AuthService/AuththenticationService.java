package com.IES.AuthService;

import javax.validation.Valid;

import org.springframework.util.MultiValueMap;

import com.IES.DTO.changePassDTO;
import com.IES.DTO.loginResponseDTO;
import com.IES.DTO.loginreqDTO;
import com.IES.DTO.signUpDTO;

public interface AuththenticationService {

	String signUp(@Valid signUpDTO sdtorequest);

	String login(@Valid loginreqDTO lgDTO);

	String changePass(@Valid changePassDTO cpDTO);

}
