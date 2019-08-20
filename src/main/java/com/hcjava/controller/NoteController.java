package com.hcjava.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcjava.service.NoteService;
import com.hcjava.util.NoteResult;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

@RestController
@RequestMapping("/note")
public class NoteController {
	
	@Resource
	private NoteService noteService;
	
	@ApiImplicitParam(name = "bookId", value = "用户id", required = false, dataType = "String")
	@PostMapping("/loadnotes.do")
	public NoteResult loadnotes(String bookId) {
		return noteService.loadNotes(bookId);
	}
	
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId", value = "笔记id", required = false, dataType = "String"),
		@ApiImplicitParam(name = "bookId", value = "用户id", required = false, dataType = "String"),
		@ApiImplicitParam(name = "title", value = "笔记标题", required = false, dataType = "String")
	})
	@PostMapping("/add.do")
	public NoteResult add(String userId,String bookId,String title) {
		return noteService.addNote(userId, bookId, title);
	}
	
	
}
