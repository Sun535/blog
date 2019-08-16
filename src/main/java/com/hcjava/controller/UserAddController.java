package com.hcjava.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcjava.service.UserService;
import com.hcjava.util.NoteResult;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
@RestController
public class UserAddController {
	@Resource
	private UserService userService;
	
	@ApiOperation("注册")
	@ApiImplicitParams({
		@ApiImplicitParam(name="name",value = "用户名",required = true),
		@ApiImplicitParam(name="nick",value = "昵称",required = true),
		@ApiImplicitParam(name="password",value = "密码",required = true)
	})
	@PostMapping("/user/add.do")
	public NoteResult regist(String name,String nick,String password) {
		return userService.addUser(name, password, nick);
	}
}
