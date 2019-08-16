package com.hcjava.service;

import com.hcjava.util.NoteResult;

public interface UserService {
	NoteResult checkLogin(String name,String password);
	
	NoteResult addUser(String name,String password,String nick);
}
