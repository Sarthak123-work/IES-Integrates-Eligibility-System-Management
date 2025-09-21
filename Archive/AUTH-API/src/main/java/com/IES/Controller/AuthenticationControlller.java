package com.IES.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody; // ✅ Correct one
import org.springframework.web.bind.annotation.RestController;

import com.IES.AuthService.AuththenticationService;
import com.IES.DTO.changePassDTO;
import com.IES.DTO.loginreqDTO;
import com.IES.DTO.signUpDTO;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Tag(name = "This is Authentication API")
@RequestMapping("/IES/v1/Auth")
public class AuthenticationControlller {
	
	@Autowired
	private AuththenticationService authservice;
	
	@PostMapping("/signUp")
	public ResponseEntity<?> signUp(@Valid @RequestBody signUpDTO sdtorequest){
		
		log.info("Controller Layer: " + sdtorequest);
		log.debug("Debug signUpDTO value: " + sdtorequest);
		
		return new ResponseEntity<>(authservice.signUp(sdtorequest), HttpStatus.OK);
	}
	
	@PostMapping("/signIn")
	public ResponseEntity<?> signIn(@Valid @RequestBody loginreqDTO lgDTO){
		
		log.info("Controller Login: "+lgDTO);
		log.debug("Debug LoginRequest DTO value: "+lgDTO);
		
		return new ResponseEntity(authservice.login(lgDTO),HttpStatus.OK);
	}
	
	@PostMapping("/updatePass")
	public ResponseEntity<?> updatePass(@Valid @RequestBody changePassDTO cpDTO){

		log.info("Controller Login: "+cpDTO);
		log.debug("Debug LoginRequest DTO value: "+cpDTO);
			
		return new ResponseEntity(authservice.changePass(cpDTO),HttpStatus.OK);
		
		
	}
}
