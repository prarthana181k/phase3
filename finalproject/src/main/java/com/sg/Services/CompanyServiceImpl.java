package com.sg.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.Repository.CompanyRepositoryI;
import com.sg.Repository.SectorRepositoryI;
import com.sg.entity.CompanyEntity;
import com.sg.entity.SectorEntity;


@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private SectorRepositoryI sectorRepository;
	
	@Autowired
	private CompanyRepositoryI companyRepository;
	
	
	public CompanyEntity createCompany(CompanyEntity company, String sectorname) {
		SectorEntity sector = this.sectorRepository.findBysector_name(sectorname);
		company.setSector(sector);
		CompanyEntity companyEntity = this.companyRepository.save(company);
		return companyEntity;
	}

	public CompanyEntity updatecompany(CompanyEntity companyEntity, CompanyEntity company, String sectorname) {
		 companyEntity.setCompanyName(company.getCompanyName());
		 companyEntity.setTurnover(company.getTurnover());
		 companyEntity.setCEO(company.getCEO());
		 companyEntity.setBoard_of_Directors(company.getBoard_of_Directors());
		 companyEntity.setWrite_Up(company.getWrite_Up());
		 
		SectorEntity sector = this.sectorRepository.findBysector_name(sectorname);
		companyEntity.setSector(sector);
		
		CompanyEntity companyEntity2 = this.companyRepository.save(companyEntity);
		return companyEntity2;
	}




}
