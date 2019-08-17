package com.hcjava.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcjava.service.NoteService;
import com.hcjava.util.NoteResult;

@RestController
@RequestMapping("/note")
public class NoteController {
	
	@Resource
	private NoteService noteService;
	
	@PostMapping("/loadnotes.do")
	public NoteResult loadnotes(String bookId) {
		return noteService.loadNotes(bookId);
	}
}
