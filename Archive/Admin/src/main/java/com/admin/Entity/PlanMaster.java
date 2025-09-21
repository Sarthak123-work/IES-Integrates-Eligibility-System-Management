package com.admin.Entity;

import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.admin.Enun.ActiveStatus;

@Entity
@Table(name = "plan_master_tbl")
@Builder
public class PlanMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id")
    private Integer planId;

    @NotBlank(message = "Plan name is mandatory")
    @Size(min = 3, max = 100, message = "Plan name must be between 3 and 100 characters")
    @Column(name = "plan_name", nullable = false)
    private String planName;

    @NotNull(message = "Plan start date is required")
    @Column(name = "plan_start_date", nullable = false)
    private LocalDate planStartDate;

    @NotNull(message = "Plan end date is required")
    @Column(name = "plan_end_date", nullable = false)
    private LocalDate planEndDate;

    @NotNull(message = "Plan status is required (Y or N)")
    @Enumerated(EnumType.STRING)
    @Column(name = "active_sw", nullable = false, length = 1)
    private ActiveStatus activeSw;

    @Size(max = 255, message = "Comments cannot be more than 255 characters")
    @Column(name = "comments")
    private String comments;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private LocalDate createdDate;

    @LastModifiedDate
    @Column(name = "updated_date")
    private LocalDate updatedDate;

    @NotNull(message = "CreatedBy is required")
    @Column(name = "created_by", updatable = false)
    private Integer createdBy;

    @Column(name = "updated_by")
    private Integer updatedBy;

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
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

	public ActiveStatus getActiveSw() {
		return activeSw;
	}

	public void setActiveSw(ActiveStatus activeSw) {
		this.activeSw = activeSw;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public PlanMaster(Integer planId,
			@NotBlank(message = "Plan name is mandatory") @Size(min = 3, max = 100, message = "Plan name must be between 3 and 100 characters") String planName,
			@NotNull(message = "Plan start date is required") LocalDate planStartDate,
			@NotNull(message = "Plan end date is required") LocalDate planEndDate,
			@NotNull(message = "Plan status is required (Y or N)") ActiveStatus activeSw,
			@Size(max = 255, message = "Comments cannot be more than 255 characters") String comments,
			LocalDate createdDate, LocalDate updatedDate, @NotNull(message = "CreatedBy is required") Integer createdBy,
			Integer updatedBy) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.planStartDate = planStartDate;
		this.planEndDate = planEndDate;
		this.activeSw = activeSw;
		this.comments = comments;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "PlanMaster [planId=" + planId + ", planName=" + planName + ", planStartDate=" + planStartDate
				+ ", planEndDate=" + planEndDate + ", activeSw=" + activeSw + ", comments=" + comments
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + "]";
	}

	public PlanMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
