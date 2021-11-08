package com.sg.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sg.entity.IPODetailEntity;
@Repository
public interface IPORepositoryI extends JpaRepository<IPODetailEntity, Integer>{
	
	@Query(value="SELECT * FROM IPO",nativeQuery = true)
	public Page<IPODetailEntity> findallIpos(Pageable pePageable);
	
	
}