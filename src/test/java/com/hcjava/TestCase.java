package com.hcjava;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcjava.dao.UserDao;
import com.hcjava.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:conf/spring-mvc.xml","classpath:conf/spring-mybatis.xml"})
public class TestCase {
	@Resource
	private UserDao userDao;
	
	@Test
	public void test1() throws SQLException {
		User user = userDao.findByName("zhangsan");
		System.out.println(user);
	}
}
