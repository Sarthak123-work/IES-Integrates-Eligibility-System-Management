package com.IES.DC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IES.DC.Entity.DcEducation;

@Repository
public interface EducationRepo extends JpaRepository<DcEducation, Integer> {

	DcEducation findByCitizenApplicationAppNumber(Integer appNum);
}
