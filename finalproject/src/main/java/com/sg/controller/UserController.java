package com.sg.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/normal")
public class UserController {
	
	@RequestMapping("/user_dashboard")
	public String dashborad()
	{
		return "normal/user_dashboard";
	}

}