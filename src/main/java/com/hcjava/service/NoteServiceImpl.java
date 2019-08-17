package com.hcjava.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hcjava.dao.NoteDao;
import com.hcjava.pojo.Note;
import com.hcjava.util.NoteResult;

@Service
public class NoteServiceImpl implements NoteService {
	
	@Resource
	private NoteDao noteDao;

	@Override
	public NoteResult loadNotes(String bookId) {
		NoteResult result=new NoteResult();
		List<Note> list = noteDao.findByBookId(bookId);
		result.setMsg("请求成功");
		result.setData(list);
		return result;
	}
}
