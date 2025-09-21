package com.IES.Controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.IES.AuthService.AuththenticationService;
import com.IES.DTO.signUpDTO;

public class AuthControllerTest {
	
	@Mock
	private AuththenticationService au;
	
	@InjectMocks
	private AuthenticationControlller ac;
	
	
	@Test
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	public void testSignUp() {
		
		signUpDTO dto = new signUpDTO();
		dto.setEmail("xyz@gmail.com");
		
		String value="User registered Successfully";
		
		when(au.signUp(dto)).thenReturn(value);
		
		ResponseEntity<?> result=ac.signUp(dto);
		
		assertEquals(value, result);
	}

}
