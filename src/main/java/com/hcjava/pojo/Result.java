package com.hcjava.pojo;

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
	
	public Result(String msg) {
		this.code=0;
		this.msg=msg;
	}
	
	public Result(T data) {
		this.code=0;
		this.msg="ok";
		this.data=data;
	}
	
	public Result(int code,String msg) {
		this.code=code;
		this.msg=msg;
	}
	
	public static <T> Result<T> newSuccess() {
		return new Result<>();
	}
	
	public static <T> Result<T> newSuccess(String msg) {
		return new Result<>(msg);
	}
	
	public static <T> Result<T> newSuccess(T obj) {
		return new Result<>(obj);
	}
	
	public static <T> Result<T> newError(int code,String msg){
		return new Result<>(code,msg);
	}

}
