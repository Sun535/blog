package com.hcjava.service;

import com.hcjava.util.NoteResult;

public interface NoteService {
	NoteResult loadNotes(String bookId);
	
	NoteResult loadNote(String noteId);
	
	NoteResult updateNote(String noteId,String title,String body);
	
	NoteResult addNote(String userId,String bookId,String title);
	
	NoteResult deleteNote(String noteId);
	
	NoteResult moveNote(String noteId,String bookId);
	
	NoteResult rollbackNotes(String userId);
}
