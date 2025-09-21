package com.IES.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IES.Entity.DCIncome;

public interface IncomeRepo extends JpaRepository<DCIncome, Integer> 
{
	DCIncome findByCitizenApplicationAppNumber(Integer appNum);
}
