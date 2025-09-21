package com.Citizen.DTO;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.Citizen.Enums.Gender;
import com.IES.Entity.User;
import com.admin.Entity.PlanMaster;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CitizenDTO {

	@NotBlank(message = "Fullname is required")
	@Size(min = 3, max = 100, message = "Fullname must be between 3 and 100 characters")
	@Column(name = "fullname", nullable = false, length = 100)
	private String fullname;

	@NotNull(message = "Date of Birth is required")
	@Past(message = "Date of Birth must be in the past")
	@Column(name = "dob", nullable = false)
	private LocalDate dob;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@NotNull(message = "SSN is required")
	@Pattern(regexp = "\\d{9}", message = "SSN must be exactly 9 digits")
	@Column(name = "ssn", nullable = false, unique = true)
	private String ssn;
	
	
	@NotBlank(message = "planName is required")
	@Size(min = 3, max = 100, message = "planName must be between 3 and 100 characters")
	@Column(name = "planName", nullable = false, length = 100)
	private String planName;

	// ==============================
	// Relationships
	// ==============================
	
	
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	@NotNull(message = "User must be linked with application")
	private User user;
	
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "plan_id", nullable = false)
	@NotNull(message = "Plan must be selected for application")
	private PlanMaster plan;



	public String getFullname() {
		return fullname;
	}



	public void setFullname(String fullname) {
		this.fullname = fullname;
	}



	public LocalDate getDob() {
		return dob;
	}



	public void setDob(LocalDate dob) {
		this.dob = dob;
	}



	public Gender getGender() {
		return gender;
	}



	public void setGender(Gender gender) {
		this.gender = gender;
	}



	public String getSsn() {
		return ssn;
	}



	public void setSsn(String ssn) {
		this.ssn = ssn;
	}



	public String getPlanName() {
		return planName;
	}



	public void setPlanName(String planName) {
		this.planName = planName;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public PlanMaster getPlan() {
		return plan;
	}



	public void setPlan(PlanMaster plan) {
		this.plan = plan;
	}



	public static org.slf4j.Logger getLog() {
		return log;
	}



	public CitizenDTO(
			@NotBlank(message = "Fullname is required") @Size(min = 3, max = 100, message = "Fullname must be between 3 and 100 characters") String fullname,
			@NotNull(message = "Date of Birth is required") LocalDate dob,
			@NotBlank(message = "Gender is required") @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female or Other") Gender gender,
			@NotNull(message = "SSN is required") @Digits(integer = 9, fraction = 0, message = "SSN must be 9 digits") String ssn,
			@NotBlank(message = "planName is required") @Size(min = 3, max = 100, message = "planName must be between 3 and 100 characters") String planName,
			@NotNull(message = "User must be linked with application") User user,
			@NotNull(message = "Plan must be selected for application") PlanMaster plan) {
		super();
		this.fullname = fullname;
		this.dob = dob;
		this.gender = gender;
		this.ssn = ssn;
		this.planName = planName;
		this.user = user;
		this.plan = plan;
	}



	public CitizenDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "CitizenDTO [fullname=" + fullname + ", dob=" + dob + ", gender=" + gender + ", ssn=" + ssn
				+ ", planName=" + planName + ", user=" + user + ", plan=" + plan + "]";
	}
	
	
}
