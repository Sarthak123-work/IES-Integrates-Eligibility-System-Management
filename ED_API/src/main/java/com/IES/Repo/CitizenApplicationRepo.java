package com.IES.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IES.Entity.CitizenApplication;

public interface CitizenApplicationRepo extends JpaRepository<CitizenApplication, Integer>
{
	Optional<CitizenApplication> findByAppNumber(Integer appNum);
}
