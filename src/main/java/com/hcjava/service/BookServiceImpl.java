package com.hcjava.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hcjava.dao.BookDao;
import com.hcjava.pojo.Book;
import com.hcjava.util.NoteResult;
import com.hcjava.util.NoteUtil;

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

	@Override
	public NoteResult addBook(String userId, String bookName) {
		NoteResult result=new NoteResult();
		Book book=new Book();
		book.setCn_notebook_id(NoteUtil.createUUID());
		book.setCn_notebook_name(bookName);
		book.setCn_notebook_type_id("1");
		book.setCn_user_id(userId);
		book.setCn_notebook_createtime(new Timestamp(System.currentTimeMillis()));
		int save = bookDao.save(book);
		if (save==1) {
			result.setMsg("添加成功");
			result.setData(book);
			return result;
		}
		result.setStatus(1);
		result.setMsg("保存失败");
		return result;
	}
}
