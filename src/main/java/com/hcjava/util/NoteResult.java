package com.hcjava.util;

import com.hcjava.pojo.Result;

import lombok.Data;
import sun.launcher.resources.launcher;

/**
 * 用来封装后台处理的结果集
 * @author Administrator
 *
 */
@Data
public class NoteResult {
	private int status;//0表示成功，其他表示失败
	private String msg;//消息
	private Object data;//数据
}
