package com.hcjava.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hcjava.dao.BookDao;
import com.hcjava.pojo.Book;
import com.hcjava.util.NoteResult;

@Service
public class BookServiceImpl implements BookService {
	
	@Resource
	private BookDao bookDao;

	@Override
	public NoteResult loadUserBooks(String userId) {
		NoteResult result=new NoteResult();
		List<Book> list = bookDao.findByUserId(userId);
		result.setMsg("查询笔记完毕");
		result.setData(list);
		return result;
	}
}
