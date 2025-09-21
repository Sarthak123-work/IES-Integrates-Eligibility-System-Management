package com.IES.DC.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DC_Income_Tbl")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DcIncome {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "income_id")
	private Integer incomeId;

	@Min(0)
	@Column(name = "salary_income", nullable = false)
	private Integer salaryIncome;

	@Min(0)
	@Column(name = "property_income", nullable = false)
	private Integer propertyIncome;

	// Many incomes belong to one CitizenApplication
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "app_number", nullable = false)
	private CitizenApplication citizenApplication;

	public Integer getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(Integer incomeId) {
		this.incomeId = incomeId;
	}

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

	public CitizenApplication getCitizenApplication() {
		return citizenApplication;
	}

	public void setCitizenApplication(CitizenApplication citizenApplication) {
		this.citizenApplication = citizenApplication;
	}

	public DcIncome(Integer incomeId, @Min(0) Integer salaryIncome, @Min(0) Integer propertyIncome,
			CitizenApplication citizenApplication) {
		super();
		this.incomeId = incomeId;
		this.salaryIncome = salaryIncome;
		this.propertyIncome = propertyIncome;
		this.citizenApplication = citizenApplication;
	}

	public DcIncome() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DcIncome [incomeId=" + incomeId + ", salaryIncome=" + salaryIncome + ", propertyIncome="
				+ propertyIncome + ", citizenApplication=" + citizenApplication + "]";
	}
	
	
}
