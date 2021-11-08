package com.sg.Services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.sg.Repository.RoleRepositoryI;
import com.sg.Repository.UserRepositoryI;
import com.sg.entity.UserEntity;
import com.sg.entity.UserRole;

public class UserServiceImpl implements UserServiceI {

@Autowired
private UserRepositoryI userRepository;

@Autowired
private RoleRepositoryI roleRepository;

	@Override
	public UserEntity createUser(UserEntity user, Set<UserRole> userRoles) throws Exception {
	
		UserEntity local = this.userRepository.findByUsername(user.getUsername());
		if(local!=null)
		{
		System.out.println("User already exits");
		throw new Exception("User already exists");
		
		}
		else {
			for(UserRole ur : userRoles){
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
		return local;
	}


}
