package com.hcjava.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcjava.service.UserService;
import com.hcjava.util.NoteResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api("用户系统")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@ApiOperation("登录")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "name",value = "用户名",dataType = "String"),
		@ApiImplicitParam(name = "password",value = "密码",dataType = "String")
	})
	@PostMapping("/login.do")
	public NoteResult hello(String name,String password) {
		return userService.checkLogin(name, password);
	}
}
