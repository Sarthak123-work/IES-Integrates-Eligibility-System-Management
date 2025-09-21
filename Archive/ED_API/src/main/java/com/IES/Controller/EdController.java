package com.IES.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IES.DTO.EdResponseDTO;
import com.IES.Service.EDService;

@RestController
@RequestMapping("/ED") 
public class EdController 
{
	@Autowired
    private EDService edService;

    // Check eligibility by application number
    @GetMapping("/check/{appNumber}")
    public ResponseEntity<EdResponseDTO> checkEligibility(@PathVariable Integer appNumber) {
        EdResponseDTO response = edService.determineEligibility(appNumber);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/report")
    public ResponseEntity<String> generateReport() {
        edService.generatePDF();
        return ResponseEntity.ok("✅ ED Report Generated and Uploaded to S3");
    }
}
