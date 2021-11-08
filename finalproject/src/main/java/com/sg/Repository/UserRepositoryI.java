package com.sg.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.entity.UserEntity;

@Repository
public interface UserRepositoryI extends JpaRepository<UserEntity , Integer>{

	public UserEntity findByUsername(String username);
	
	
}