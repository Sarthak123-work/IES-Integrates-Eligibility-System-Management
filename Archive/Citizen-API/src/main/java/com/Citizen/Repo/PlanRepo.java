package com.Citizen.Repo;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.Citizen.Entity.PlanMaster;

import java.lang.String;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlanRepo extends JpaRepository<PlanMaster, Integer>{

	
	Optional<PlanMaster> findByPlanName(String planname);
}
