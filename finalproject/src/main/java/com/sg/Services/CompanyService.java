package com.sg.Services;

import org.springframework.stereotype.Service;

import com.sg.entity.CompanyEntity;

@Service
public interface CompanyService {
	public CompanyEntity createCompany(CompanyEntity company,String sectorname);
	public CompanyEntity  updatecompany(CompanyEntity companyEntity, CompanyEntity company, String sectorname);
}
