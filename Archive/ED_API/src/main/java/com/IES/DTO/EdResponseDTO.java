package com.IES.DTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data

public class EdResponseDTO 
{
	@Column(name = "app_number")
	private Integer appNumber;
	
	@NotBlank(message = "Plan name is mandatory")
	@Size(min = 3, max = 100, message = "Plan name must be between 3 and 100 characters")
	private String planName;
	
	
	@Column(name = "plan_status", nullable = false)
    private String planStatus; // APPROVED / DENIED
    
    @Column(name = "benefit_amount")
    private Double benefitAmount;

    @Column(name = "denial_reason")
    private String denialReason;

	public Integer getAppNumber() {
		return appNumber;
	}

	public void setAppNumber(Integer appNumber) {
		this.appNumber = appNumber;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public Double getBenefitAmount() {
		return benefitAmount;
	}

	public void setBenefitAmount(Double benefitAmount) {
		this.benefitAmount = benefitAmount;
	}

	public String getDenialReason() {
		return denialReason;
	}

	public void setDenialReason(String denialReason) {
		this.denialReason = denialReason;
	}

	public EdResponseDTO(Integer appNumber,
			@NotBlank(message = "Plan name is mandatory") @Size(min = 3, max = 100, message = "Plan name must be between 3 and 100 characters") String planName,
			String planStatus, Double benefitAmount, String denialReason) {
		super();
		this.appNumber = appNumber;
		this.planName = planName;
		this.planStatus = planStatus;
		this.benefitAmount = benefitAmount;
		this.denialReason = denialReason;
	}

	@Override
	public String toString() {
		return "EdResponseDTO [appNumber=" + appNumber + ", planName=" + planName + ", planStatus=" + planStatus
				+ ", benefitAmount=" + benefitAmount + ", denialReason=" + denialReason + "]";
	}

	public EdResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
    
    
    
    
}
