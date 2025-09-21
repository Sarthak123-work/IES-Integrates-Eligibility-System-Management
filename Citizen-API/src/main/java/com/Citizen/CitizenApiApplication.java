package com.Citizen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.Citizen.Entity")
@EnableJpaRepositories(basePackages = "com.Citizen.Repo")
public class CitizenApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CitizenApiApplication.class, args);
	}

}
