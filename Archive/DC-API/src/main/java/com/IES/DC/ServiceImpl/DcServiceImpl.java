package com.IES.DC.ServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.IES.DC.Dto.EductationDto;
import com.IES.DC.Dto.IncomeDto;
import com.IES.DC.Dto.KidsDto;
import com.IES.DC.Dto.SummeryResponseDto;
import com.IES.DC.Entity.CitizenApplication;
import com.IES.DC.Entity.DcEducation;
import com.IES.DC.Entity.DcIncome;
import com.IES.DC.Entity.DcKid;
import com.IES.DC.Entity.User;
import com.IES.DC.Exception.CitizenApplicationNotFound;
import com.IES.DC.Repository.CitizenArRepo;
import com.IES.DC.Repository.EducationRepo;
import com.IES.DC.Repository.IncomeRepo;
import com.IES.DC.Repository.KidRepo;
import com.IES.DC.Service.DcService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DcServiceImpl implements DcService {

	@Autowired
	private IncomeRepo dciRepo;

	@Autowired
	private EducationRepo dceRepo;

	@Autowired
	private KidRepo dckRepo;

	@Autowired
	private CitizenArRepo CitizenArRepo;

	@Override
	public boolean saveIncome(@Valid IncomeDto income, Integer appNum) {

		log.info("Income Details in DCService :: " + income);

		ModelMapper model = new ModelMapper();

		DcIncome dcIcome = model.map(income, DcIncome.class);

		log.info("DTO to Entity (incomeDto -> DcIcome) " + dcIcome);

		
		//loged in banda bahar nikala 
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();

		log.info("Loged in user " + user);

		//jo banda ayahe uske applictions bahar nikala maye wo 1 ya usse zyda ho sakte he
		List<CitizenApplication> citizenApps = CitizenArRepo.findByUser(user)
				.orElseThrow(() -> new CitizenApplicationNotFound("Citizen Application not Found"));

		log.info("Citizen App from Loged in user " + citizenApps);

		//applications mese me unke app numbers ko check karrun , enter kiye hue appnum ke sath...
		CitizenApplication citizenApplication = citizenApps.stream().filter(ca -> ca.getAppNumber() == appNum)
				.findFirst().get();

		dcIcome.setCitizenApplication(citizenApplication);

		DcIncome dcIncome2 = dciRepo.save(dcIcome);

		return dcIncome2 != null;
	}

	@Override
	public boolean saveEducation(@Valid EductationDto eduDto, Integer appNum) {

		log.info("Education Details in DCService :: " + eduDto);

		ModelMapper model = new ModelMapper();

		DcEducation dcEducation = model.map(eduDto, DcEducation.class);

		log.info("DTO to Entity (dcEducation -> EductationDto) " + dcEducation);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();

		log.info("Loged in user " + user);

		List<CitizenApplication> citizenApps = CitizenArRepo.findByUser(user)
				.orElseThrow(() -> new CitizenApplicationNotFound("Citizen Application not Found"));

		CitizenApplication citizenApplication = citizenApps.stream().filter(ca -> ca.getAppNumber() == appNum)
				.findFirst().get();

		log.info("Citizen App from Loged in user " + citizenApplication);

		dcEducation.setCitizenApplication(citizenApplication);

		DcEducation dcEducation2 = dceRepo.save(dcEducation);

		return dcEducation2 != null;
	}

	@Override
	public boolean saveKids(@Valid KidsDto kidsdto, Integer appNum) {
		log.info("kids Details in DCService :: " + kidsdto);

		ModelMapper model = new ModelMapper();

		DcKid dckids = model.map(kidsdto, DcKid.class);

		log.info("DTO to Entity (dckids -> DcKid) " + kidsdto);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();

		log.info("Loged in user " + user);

		List<CitizenApplication> citizenApps = CitizenArRepo.findByUser(user)
				.orElseThrow(() -> new CitizenApplicationNotFound("Citizen Application not Found"));

		log.info("Citizen App from Loged in user " + citizenApps);

		CitizenApplication citizenApplication = citizenApps.stream().filter(ca -> ca.getAppNumber() == appNum)
				.findFirst().get();

		dckids.setCitizenApplication(citizenApplication);

		DcKid dckids2 = dckRepo.save(dckids);

		return dckids2 != null;
	}

	@Override
	public SummeryResponseDto getSummeryData(Integer appNum) {

		DcEducation educationDetails = dceRepo.findByCitizenApplicationAppNumber(appNum);

		log.info("educationDetails " + educationDetails);

		DcIncome incomeDetails = dciRepo.findByCitizenApplicationAppNumber(appNum);

		log.info("incomeDetails " + incomeDetails);

		DcKid kidDetails = dckRepo.findByCitizenApplicationAppNumber(appNum);

		log.info("kidDetails " + kidDetails);

		SummeryResponseDto srd = new SummeryResponseDto();

		srd.setEducationDetails(Arrays.asList(educationDetails));
		srd.setIncomdeDetails(Arrays.asList(incomeDetails));
		srd.setKidDetails(Arrays.asList(kidDetails));

		return srd;

	}

}
