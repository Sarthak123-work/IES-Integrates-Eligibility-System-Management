package com.Citizen.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Citizen.CitizenApiApplication;
import com.Citizen.DTO.CitizenDTO;
import com.Citizen.Entity.CitizenApplication;
import com.Citizen.Service.CitizenArService;

import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
@RequestMapping("/IES/AR")
public class CitizenController {
	
	
	

		@Autowired
		private CitizenArService citizenArService;

		@PostMapping("/createApp")
		public ResponseEntity<?> createApplication(@RequestBody CitizenDTO citizendto) {
			log.info("CitizenController :: " + citizendto);

			boolean createApplicationResult = citizenArService.createApplication(citizendto);

			if (createApplicationResult) {
				return new ResponseEntity<>("Application Created !!", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Application is not Created !! ", HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}

		@GetMapping("/getApplication/{appnum}")
		public ResponseEntity<?> getApplication(@PathVariable Integer appnum) {
			log.info("CitizenController :: " + appnum);

			CitizenApplication application = citizenArService.getApp(appnum);

			return new ResponseEntity<>(application, HttpStatus.OK);

		}

		@GetMapping("/getAllApplication")
		public ResponseEntity<?> getApps() {

			return new ResponseEntity<>(citizenArService.getApps(), HttpStatus.OK);

		}

		@GetMapping("/getAppWithCitizenId/{citizenID}")
		public ResponseEntity<?> getAppWithCitizenId(@PathVariable Integer citizenID) {

			return new ResponseEntity<>(citizenArService.getAppWithCitizenId(citizenID), HttpStatus.OK);

		}

	}



