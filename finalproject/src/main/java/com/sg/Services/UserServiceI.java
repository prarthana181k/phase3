package com.sg.Services;

import java.util.Set;

import com.sg.entity.UserEntity;
import com.sg.entity.UserRole;

public interface UserServiceI {
	public UserEntity createUser(UserEntity user, Set<UserRole> userRoles) throws Exception ;
}
