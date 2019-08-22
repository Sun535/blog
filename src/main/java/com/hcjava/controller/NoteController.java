package com.hcjava.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcjava.service.NoteService;
import com.hcjava.util.NoteResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;

@Api(value="笔记",tags = {"笔记相关接口"})
@RestController
@RequestMapping("/note")
public class NoteController {
	
	@Resource
	private NoteService noteService;
	
	@ApiOperation(value="根据图书id获取笔记列表",notes="测试使用的bookid：2c0bda01-b6bb-48b3-92e5-89f42cda6d27")
	@ApiImplicitParam(name = "bookId", value = "笔记本id", required = false, dataType = "String")
	@PostMapping("/loadnotes.do")
	public NoteResult loadnotes(String bookId) {
		return noteService.loadNotes(bookId);
	}
	
	@ApiOperation(value="添加笔记")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "userId", value = "用户id", required = false, dataType = "String"),
		@ApiImplicitParam(name = "bookId", value = "笔记本id", required = false, dataType = "String"),
		@ApiImplicitParam(name = "title", value = "笔记标题", required = false, dataType = "String")
	})
	@PostMapping("/add.do")
	public NoteResult add(String userId,String bookId,String title) {
		return noteService.addNote(userId, bookId, title);
	}
	
	@ApiOperation(value="删除笔记")
	@ApiImplicitParam(name = "noteId", value = "笔记id", required = false, dataType = "String")
	@PostMapping("/delete.do")
	public NoteResult delete(String noteId) {
		return noteService.deleteNote(noteId);
	}
	
	@ApiOperation(value="移动笔记")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "noteId", value = "笔记id", required = false, dataType = "String"),
		@ApiImplicitParam(name = "bookId", value = "笔记本id", required = false, dataType = "String")
	})
	@PostMapping("/move.do")
	public NoteResult move(String noteId,String bookId) {
		return noteService.moveNote(noteId, bookId);
	}
	
	@ApiOperation(value="回收站笔记")
	@ApiImplicitParam(name = "userId", value = "用户id", required = false, dataType = "String")
	@PostMapping("/rollbacknotes.do")
	public NoteResult rollbacknotes(String userId) {
		return noteService.rollbackNotes(userId);
	}
}
