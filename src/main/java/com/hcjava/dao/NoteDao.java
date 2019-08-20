package com.hcjava.dao;

import java.util.List;

import com.hcjava.pojo.Note;

public interface NoteDao {
	List<Note> findByBookId(String bookId);
	
	Note findById(String noteId);
	
	int updateNote(Note note);
	
	int save(Note note);
}
