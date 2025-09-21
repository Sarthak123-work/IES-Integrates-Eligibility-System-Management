package com.IES.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IES.Entity.EligibilityDetermination;

public interface EDRepo extends JpaRepository<EligibilityDetermination, Integer>
{
	EligibilityDetermination findByCitizenApplicationAppNumber(Integer appNum);
}
