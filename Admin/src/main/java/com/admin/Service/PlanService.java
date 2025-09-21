package com.admin.Service;

import java.util.List;

import com.admin.DTO.PlanDTO;

public interface PlanService {

	boolean savePlan(PlanDTO pldto);

	PlanDTO getPlan(Integer id);

	List<PlanDTO> getPlans();

	PlanDTO updatePlan(Integer id, PlanDTO pldto);

	boolean deletePlan(Integer id);

	public void generatePDF();
}
