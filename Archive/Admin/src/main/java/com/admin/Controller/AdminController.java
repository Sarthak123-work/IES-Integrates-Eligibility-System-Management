package com.admin.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.admin.DTO.PlanDTO;
import com.admin.Service.PlanService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/AdminPlans")
public class AdminController {
	
	@Autowired
    private PlanService plservice;

    
    @PostMapping("/savePlan")
    public ResponseEntity<String> savePlan(@RequestBody PlanDTO pldto) {
        log.info("In the Controller layer - savePlan()");
        boolean saved = plservice.savePlan(pldto);

        if (saved) {
            return new ResponseEntity<>("Plan Saved Successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Plan Failed to Save", HttpStatus.BAD_REQUEST);
    }

   
    @GetMapping("/getAllPlans")
    public ResponseEntity<List<PlanDTO>> getAllPlans() {
        List<PlanDTO> plans = plservice.getPlans();
        return new ResponseEntity<>(plans, HttpStatus.OK);
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<?> getPlanById(@PathVariable Integer id) {
        PlanDTO plan = plservice.getPlan(id);
        if (plan != null) {
            return new ResponseEntity<>(plan, HttpStatus.OK);
        }
        return new ResponseEntity<>("Plan not found with ID: " + id, HttpStatus.NOT_FOUND);
    }

    
    @PutMapping("/updatePlan/{id}")
    public ResponseEntity<?> updatePlan(@PathVariable Integer id, @RequestBody PlanDTO pldto) {
        log.info("Updating plan with ID: {}", id);
        PlanDTO updatedPlan = plservice.updatePlan(id, pldto);

        if (updatedPlan != null) {
            return new ResponseEntity<>(updatedPlan, HttpStatus.OK);
        }
        return new ResponseEntity<>("Plan not found with ID: " + id, HttpStatus.NOT_FOUND);
    }

    
    @DeleteMapping("/deletePlan/{id}")
    public ResponseEntity<String> deletePlan(@PathVariable Integer id) {
        log.info("Deleting plan with ID: {}", id);
        boolean deleted = plservice.deletePlan(id);

        if (deleted) {
            return new ResponseEntity<>("Plan deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Plan not found with ID: " + id, HttpStatus.NOT_FOUND);
    }
    
    
    @PostMapping("/getAllplanpdf")
	public ResponseEntity<?> getpdf() {
		plservice.generatePDF();

		return new ResponseEntity<>("pdf generated", HttpStatus.OK);
	}

}
