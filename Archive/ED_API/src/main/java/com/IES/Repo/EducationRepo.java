package com.IES.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IES.Entity.DCEducation;

public interface EducationRepo extends JpaRepository<DCEducation, Integer>
{
	DCEducation findByCitizenApplicationAppNumber(Integer appNum);
}
