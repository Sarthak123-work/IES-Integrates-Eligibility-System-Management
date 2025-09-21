package com.IES.DC.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionhandling {

	@ExceptionHandler(value = PlanNotFoundWithName.class)
	public ResponseEntity<?> handlePlanNotFoundException() {

		return new ResponseEntity("Plan Doesnot Exist with this name", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = ApplicationNotFoundWithThisId.class)
	public ResponseEntity<?> handleApplicationNotFoundWithThisId() {

		return new ResponseEntity("Application Doesnot Exist with this ID", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = CitizenApplicationNotFound.class)
	public ResponseEntity<?> handleCitizenApplicationNotFound(Exception msg) {

		return new ResponseEntity(msg, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
