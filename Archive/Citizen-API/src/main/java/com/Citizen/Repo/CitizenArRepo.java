package com.Citizen.Repo;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Citizen.Entity.CitizenApplication;
import com.Citizen.Entity.User;

public interface CitizenArRepo extends JpaRepository<CitizenApplication, Integer>{
	
	Optional<CitizenApplication> findByUser(User user);

}
