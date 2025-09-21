package com.IES.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IES.Entity.DCKid;

public interface KidRepo extends JpaRepository<DCKid, Integer>
{
	List<DCKid> findByCitizenApplicationAppNumber(Integer appNum);
}
