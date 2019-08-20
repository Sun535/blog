package com.hcjava.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcjava.service.NoteService;
import com.hcjava.util.NoteResult;

@RestController
@RequestMapping("/note")
public class LoadNoteController {
	@Resource
	private NoteService noteService;
	
	@PostMapping("/load.do")
	public NoteResult load(String noteId) {
		return noteService.loadNote(noteId);
	}
}
