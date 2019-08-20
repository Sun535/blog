package com.hcjava.service;

import com.hcjava.util.NoteResult;

public interface BookService {
	NoteResult loadUserBooks(String userId);
	
	NoteResult addBook(String userId,String bookName);
}
