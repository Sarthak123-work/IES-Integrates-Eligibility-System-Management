package com.IES.DC.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IES.DC.Entity.DcIncome;

public interface IncomeRepo extends JpaRepository<DcIncome, Integer> {

	DcIncome findByCitizenApplicationAppNumber(Integer appNum);
}
