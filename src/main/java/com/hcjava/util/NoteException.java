package com.hcjava.util;
/**
 * 后台异常处理类
 * @author Administrator
 *
 */
public class NoteException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public NoteException(String msg,Throwable t) {
		super(msg,t);
	}
}
