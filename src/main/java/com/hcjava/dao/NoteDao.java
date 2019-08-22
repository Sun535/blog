package com.hcjava.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hcjava.pojo.Note;

public interface NoteDao {
	List<Note> findByBookId(String bookId);
	
	Note findById(String noteId);
	
	int updateNote(Note note);
	
	int save(Note note);
	
	int delete(String noteId);
	
	int move(@Param("noteId")String noteId,@Param("bookId")String bookId);
	
	List<Note> rollback(String userId);
}
