package com.hcjava.entity;

import org.omg.CORBA.PUBLIC_MEMBER;

import lombok.Data;

@Data
public class Result<T> {
	private int code;
	private String msg;
	private T data;
	
	public Result() {
		this.code=0;
		this.msg="ok";
	}
	//测试中文
	public Result(String msg) {
		this.code=0;
		this.msg=msg;
	}
	
	public Result(T data) {
		this.code=0;
		this.msg="ok";
		this.data=data;
	}
	
	public static <T> Result<T> newSuccess() {
		return new Result<>();
	}
	
	public static <T> Result<T> newSuccess(T obj) {
		Result<T> result = new Result<>();
		result.setData(obj);
		return result;
	}

}
