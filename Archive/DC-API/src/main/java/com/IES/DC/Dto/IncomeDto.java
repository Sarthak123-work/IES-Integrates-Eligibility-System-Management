package com.IES.DC.Dto;

import javax.persistence.Column;
import javax.validation.constraints.Min;

import lombok.Data;


public class IncomeDto {
	@Min(0)
	@Column(name = "salary_income", nullable = false)
	private Integer salaryIncome;

	@Min(0)
	@Column(name = "property_income", nullable = false)
	private Integer propertyIncome;

	public Integer getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Integer salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Integer getPropertyIncome() {
		return propertyIncome;
	}

	public void setPropertyIncome(Integer propertyIncome) {
		this.propertyIncome = propertyIncome;
	}

	@Override
	public String toString() {
		return "IncomeDto [salaryIncome=" + salaryIncome + ", propertyIncome=" + propertyIncome + "]";
	}
	
	
	
	

}
