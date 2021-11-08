package com.sg.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sg.entity.CompanyEntity;
@Repository
public interface CompanyRepositoryI extends JpaRepository<CompanyEntity, Integer>{

	@Query(value="SELECT * FROM Company",nativeQuery = true)
	public Page<CompanyEntity> findallCompany(Pageable pePageable);
	@Query(value="SELECT * FROM Company WHERE company_name = ?1",nativeQuery = true)
	public CompanyEntity findBycompany_name(String company_name);
}