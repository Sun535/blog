package com.hcjava.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 * 1.生成UUID
 * 2.密码加密
 * @author Administrator
 *
 */
public class NoteUtil {
	public static String createUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	public static String md5(String src){
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] digest = md.digest(src.getBytes());
			//将MD5处理结果利用base64转成字符串
			String str = Base64.encodeBase64String(digest);
			return str;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		String createUUID = createUUID();
		System.out.println(createUUID);
		String md5 = md5("123456");
		System.out.println(md5);
	}
}