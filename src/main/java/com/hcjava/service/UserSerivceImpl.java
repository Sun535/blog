package com.hcjava.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hcjava.dao.UserDao;
import com.hcjava.pojo.Result;
import com.hcjava.pojo.User;
import com.hcjava.util.NoteException;
import com.hcjava.util.NoteResult;
import com.hcjava.util.NoteUtil;

@Service
public class UserSerivceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	@Override
	public NoteResult checkLogin(String name, String password) {
		NoteResult result=new NoteResult();
		User user = userDao.findByName(name);
		//1.判断用户名是否存在
		if (user==null) {
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		try {
			String md5pwd=NoteUtil.md5(password);
			if (!user.getCn_user_password().equals(md5pwd)) {
				result.setStatus(2);
				result.setMsg("密码错误");
				return result;
			}
		} catch (Exception e) {
			throw new NoteException("密码加密异常", e);
		}
		user.setCn_user_password("");//把密码屏蔽不
		result.setStatus(0);
		result.setMsg("登录成功");
		result.setData(user);
		return result;
	}

}
