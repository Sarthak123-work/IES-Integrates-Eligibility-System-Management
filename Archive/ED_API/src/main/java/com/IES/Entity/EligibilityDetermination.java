package com.IES.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Eligibility_tbl")
//@Data
@Builder
public class EligibilityDetermination 
{
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer edTraceId;

	    @OneToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "app_number", nullable = false)
	    private CitizenApplication citizenApplication;

	    @Column(name = "plan_status", nullable = false)
	    private String planStatus; // APPROVED / DENIED

	    @Column(name = "plan_start_date")
	    private LocalDate planStartDate;

	    @Column(name = "plan_end_date")
	    private LocalDate planEndDate;

	    @Column(name = "benefit_amount")
	    private Double benefitAmount;

	    @Column(name = "denial_reason")
	    private String denialReason;

		public Integer getEdTraceId() {
			return edTraceId;
		}

		public void setEdTraceId(Integer edTraceId) {
			this.edTraceId = edTraceId;
		}

		public CitizenApplication getCitizenApplication() {
			return citizenApplication;
		}

		public void setCitizenApplication(CitizenApplication citizenApplication) {
			this.citizenApplication = citizenApplication;
		}

		public String getPlanStatus() {
			return planStatus;
		}

		public void setPlanStatus(String planStatus) {
			this.planStatus = planStatus;
		}

		public LocalDate getPlanStartDate() {
			return planStartDate;
		}

		public void setPlanStartDate(LocalDate planStartDate) {
			this.planStartDate = planStartDate;
		}

		public LocalDate getPlanEndDate() {
			return planEndDate;
		}

		public void setPlanEndDate(LocalDate planEndDate) {
			this.planEndDate = planEndDate;
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

		public EligibilityDetermination(Integer edTraceId, CitizenApplication citizenApplication, String planStatus,
				LocalDate planStartDate, LocalDate planEndDate, Double benefitAmount, String denialReason) {
			super();
			this.edTraceId = edTraceId;
			this.citizenApplication = citizenApplication;
			this.planStatus = planStatus;
			this.planStartDate = planStartDate;
			this.planEndDate = planEndDate;
			this.benefitAmount = benefitAmount;
			this.denialReason = denialReason;
		}

		public EligibilityDetermination() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "EligibilityDetermination [edTraceId=" + edTraceId + ", citizenApplication=" + citizenApplication
					+ ", planStatus=" + planStatus + ", planStartDate=" + planStartDate + ", planEndDate=" + planEndDate
					+ ", benefitAmount=" + benefitAmount + ", denialReason=" + denialReason + "]";
		}
	    
	    
	    
	    
}
