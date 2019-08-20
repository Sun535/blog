package com.hcjava.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcjava.service.NoteService;
import com.hcjava.util.NoteResult;

@RestController
public class UpdateNoteController {

	@Resource
	private NoteService noteService;
	
	@PostMapping("/note/update.do")
	public NoteResult update(String noteId,String title,String body) {
		return noteService.updateNote(noteId, title, body);
	}
}
