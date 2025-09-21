package com.admin.ServiceImpl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.admin.DTO.PlanDTO;
import com.admin.Entity.PlanMaster;
import com.admin.Enun.ActiveStatus;
import com.admin.Repo.AdminRepo;
import com.admin.Service.PlanService;
import com.admin.Service.S3Service;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class PlanServiceImpl implements PlanService{
	
	@Autowired
    private AdminRepo repo;

    @Autowired
    private ModelMapper mapper;
    
    @Autowired
    private S3Service ss;


	@Override
	public boolean savePlan(PlanDTO pldto) {
		PlanMaster entity = mapper.map(pldto, PlanMaster.class);
		
		pldto.setActiveSw(entity.getActiveSw()); // directly set enum

        repo.save(entity);
        return true;
	}

	@Override
	public List<PlanDTO> getPlans() {
		List<PlanMaster> entities = repo.findAll();
	    List<PlanDTO> dtos = new ArrayList<>();

	    for (PlanMaster entity : entities) {
	        dtos.add(mapper.map(entity, PlanDTO.class));
	    }

	    return dtos;
	}

	@Override
	public PlanDTO getPlan(Integer planId) {
        Optional<PlanMaster> plan = repo.findById(planId);
        if (plan.isPresent()) {
            PlanDTO dto = mapper.map(plan.get(), PlanDTO.class);
            dto.setActiveSw(plan.get().getActiveSw());
            return dto;
        }
        return null;
        
    }

	@Override
	public PlanDTO updatePlan(Integer id, PlanDTO pldto) {
		Optional<PlanMaster> existingPlan = repo.findById(id);
        if (existingPlan.isPresent()) {
            PlanMaster plan = existingPlan.get();
            plan.setPlanName(pldto.getPlanName());
            plan.setPlanStartDate(pldto.getPlanStartDate());
            plan.setPlanEndDate(pldto.getPlanEndDate());
            plan.setActiveSw(pldto.getActiveSw());
            repo.save(plan);
            return mapper.map(plan, PlanDTO.class);
        }
        return null;
	}
	
	@Override
    public boolean deletePlan(Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true; 
        }
        return false;
    }

	@Override
	public void generatePDF() {

		// jasperReport....= PDF.

		List<PlanMaster> allPlans = repo.findAll();

		try {

			File file = ResourceUtils.getFile("classpath:allplans.jrxml");

			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("created by", "expoent");

			JRBeanCollectionDataSource jrb = new JRBeanCollectionDataSource(allPlans);

			JasperPrint report = JasperFillManager.fillReport(jasperReport, map, jrb);

			JasperExportManager.exportReportToPdfFile(report, "/Users/sarthakjagtap/Downloads/testplans.pdf"); 

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			JasperExportManager.exportReportToPdfStream(report, outputStream);
			String s3FileName = "AllPlans/plans.pdf";

			ss.uploadToS3(outputStream, s3FileName);
		} catch (Exception e) {
			System.out.println(e);
		}

	}



}
