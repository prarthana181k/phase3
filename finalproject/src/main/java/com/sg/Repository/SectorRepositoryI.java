package com.sg.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.entity.SectorEntity;

@Repository
public interface SectorRepositoryI extends JpaRepository<SectorEntity, Integer>{
	
	public SectorEntity findBysector_name(String sector_name);
}