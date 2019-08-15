package com.hcjava;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:conf/spring-mvc.xml","classpath:conf/spring-mybatis.xml"})
public class TestCase {
	@Resource
	private DataSource dataSource;
	
	@Test
	public void test1() throws SQLException {
		System.out.println(dataSource.getConnection());
	}
}
