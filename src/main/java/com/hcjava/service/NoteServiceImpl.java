package com.hcjava.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hcjava.dao.NoteDao;
import com.hcjava.pojo.Note;
import com.hcjava.util.NoteResult;
import com.hcjava.util.NoteUtil;

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

	@Override
	public NoteResult loadNote(String noteId) {
		NoteResult result=new NoteResult();
		Note note = noteDao.findById(noteId);
		result.setMsg("请求成功");
		result.setData(note);
		return result;
	}

	@Override
	public NoteResult updateNote(String noteId, String title, String body) {
		NoteResult result=new NoteResult();
		Note note = new Note();
		note.setCn_note_id(noteId);
		note.setCn_note_title(title);
		note.setCn_note_body(body);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		int rows = noteDao.updateNote(note);
		if (rows==1) {
			result.setMsg("保存笔记成功");
			return result;
		}
		result.setStatus(1);
		result.setMsg("保存笔记失败");
		return result;
	}

	@Override
	public NoteResult addNote(String userId, String bookId,String title) {
		NoteResult result=new NoteResult();
		Note note = new Note();
		note.setCn_note_id(NoteUtil.createUUID());
		note.setCn_notebook_id(bookId);
		note.setCn_user_id(userId);
		note.setCn_note_title(title);
		note.setCn_note_create_time(System.currentTimeMillis());
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		note.setCn_note_status_id("1");
		note.setCn_note_type_id("1");
		note.setCn_note_body("");
		int save = noteDao.save(note);
		if (save==1) {
			result.setData(note);
			result.setMsg("笔记添加成功");
			return result;
		}
		result.setStatus(1);
		result.setMsg("笔记添加失败");
		return result;
	}

	@Override
	public NoteResult deleteNote(String noteId) {
		NoteResult result=new NoteResult();
		int c = noteDao.delete(noteId);
		if (c>0) {
			result.setMsg("删除成功");
			return result;
		}
		result.setMsg("删除失败");
		return result;
	}

	@Override
	public NoteResult moveNote(String noteId, String bookId) {
		NoteResult result=new NoteResult();
		int m = noteDao.move(noteId, bookId);
		if (m>0) {
			result.setMsg("移动成功");
			return result;
		}
		result.setMsg("移动失败");
		return result;
	}

	@Override
	public NoteResult rollbackNotes(String userId) {
		NoteResult result=new NoteResult();
		List<Note> rollback = noteDao.rollback(userId);
		result.setMsg("获取回收列表成功");
		result.setData(rollback);
		return result;
	}
}
