package com.IES.DC.Entity;

import java.time.LocalDate;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.IES.DC.Entity.PlanMaster;
import com.IES.DC.Entity.User;
import com.IES.DC.Enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "citizen_apps_tbl")
@Builder
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class CitizenApplication {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "app_number")
    private Integer appNumber;

    @NotBlank(message = "Fullname is required")
    @Size(min = 3, max = 100, message = "Fullname must be between 3 and 100 characters")
    @Column(name = "fullname", nullable = false, length = 100)
    private String fullname;

    @NotNull(message = "Date of Birth is required")
    @Column(name = "dob", nullable = false)
    private String dob;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @NotNull(message = "SSN is required")
    @Digits(integer = 9, fraction = 0, message = "SSN must be 9 digits")
    @Column(name = "ssn", nullable = false, unique = true)
    private Long ssn;

    // ==============================
    // Relationships
    // ==============================

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", nullable = true)
    private PlanMaster plan;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    private LocalDate createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    private LocalDate updatedDate;

	public Integer getAppNumber() {
		return appNumber;
	}

	public void setAppNumber(Integer appNumber) {
		this.appNumber = appNumber;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
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

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public CitizenApplication(Integer appNumber,
			@NotBlank(message = "Fullname is required") @Size(min = 3, max = 100, message = "Fullname must be between 3 and 100 characters") String fullname,
			@NotNull(message = "Date of Birth is required") String dob,
			@NotBlank(message = "Gender is required") @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female or Other") Gender gender,
			@NotNull(message = "SSN is required") @Digits(integer = 9, fraction = 0, message = "SSN must be 9 digits") Long ssn,
			@NotNull(message = "User must be linked with application") User user,
			@NotNull(message = "Plan must be selected for application") PlanMaster plan, LocalDate createdDate,
			LocalDate updatedDate) {
		super();
		this.appNumber = appNumber;
		this.fullname = fullname;
		this.dob = dob;
		this.gender = gender;
		this.ssn = ssn;
		this.user = user;
		this.plan = plan;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public CitizenApplication() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CitizenApplication [appNumber=" + appNumber + ", fullname=" + fullname + ", dob=" + dob + ", gender="
				+ gender + ", ssn=" + ssn + ", user=" + user + ", plan=" + plan + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}
	
	
}
