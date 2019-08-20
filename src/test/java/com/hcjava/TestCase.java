package com.hcjava;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcjava.dao.NoteDao;
import com.hcjava.dao.UserDao;
import com.hcjava.pojo.Note;
import com.hcjava.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:conf/spring-mybatis.xml"})
public class TestCase {
	@Resource
	private UserDao userDao;
	
	@Resource
	private NoteDao noteDao;
	
	@Test
	public void test1() throws SQLException {
		User user = userDao.findByName("zhangsan");
		System.out.println(user);
	}
	@Test
	public void test2() {
		try {
			 Note note = noteDao.findById("51b92c98d7274896b16c5a922dbdd555");
			 System.out.println(note);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
