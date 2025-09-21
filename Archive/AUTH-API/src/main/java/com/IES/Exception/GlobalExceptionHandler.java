package com.IES.Exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mysql.cj.x.protobuf.Mysqlx.Error;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = UserAlreadyExisted.class)
	public ResponseEntity<?> handleUserAlreadyExists(){
		
		log.warn("User was Already existed with given Email");
		
		return new ResponseEntity<>("User Alrady Exists",HttpStatus.OK);
	}
	
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleApiValidationsException(MethodArgumentNotValidException e){
		
		log.warn("Api payload is wrong");
		
		List<String> errors = new ArrayList<String>();
		
		e.getBindingResult().getFieldErrors().forEach(error -> {
			
			errors.add(error.getDefaultMessage());
		});
		
		
		return new ResponseEntity<>(errors,HttpStatus.OK);
	}
	
	@ExceptionHandler(value = UserNotExistwithEmail.class)
	public ResponseEntity<?> userNptExistsWithEmail(){
		
		log.warn("User not exists given Email");
		
		return new ResponseEntity<>("User Not Exists",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = invalidPassword.class)
	public ResponseEntity<?> inavalisPass(){
		
		log.warn("Password is Invalid");
		
		return new ResponseEntity<>("Password Incorrect",HttpStatus.BAD_REQUEST);
	}
	
	

}
