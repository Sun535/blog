package com.hcjava.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcjava.service.UserService;
import com.hcjava.util.NoteResult;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@PostMapping("/login")
	public NoteResult hello(String name,String password) {
		return userService.checkLogin(name, password);
	}
}
