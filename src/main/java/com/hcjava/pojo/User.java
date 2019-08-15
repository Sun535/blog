package com.hcjava.pojo;

import lombok.Data;
/**
 * PoJo的属性和数据库中的表字段保持一致
 * @author Administrator
 *
 */
@Data
public class User {
	private String cn_user_id;
	private String cn_user_name;
	private String cn_user_password;
	private String cn_user_token;
	private String cn_user_nick;
}
