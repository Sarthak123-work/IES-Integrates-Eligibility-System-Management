package com.IES.DC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IES.DC.Entity.DcKid;

@Repository
public interface KidRepo extends JpaRepository<DcKid, Integer> {

	DcKid findByCitizenApplicationAppNumber(Integer appNum);
}
