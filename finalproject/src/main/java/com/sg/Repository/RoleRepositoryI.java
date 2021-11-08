package com.sg.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.entity.Role;

@Repository
public interface RoleRepositoryI extends JpaRepository<Role, Long> {


}