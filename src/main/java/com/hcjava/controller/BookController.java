package com.hcjava.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcjava.service.BookService;
import com.hcjava.util.NoteResult;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Resource
	private BookService bookService;
	
	@PostMapping("/loadbooks.do")
	public NoteResult loadbooks(String userId) {
		return bookService.loadUserBooks(userId);
	}
	
	@PostMapping("/add.do")
	public NoteResult add(String userId,String bookName) {
		return bookService.addBook(userId, bookName);
	}
}
