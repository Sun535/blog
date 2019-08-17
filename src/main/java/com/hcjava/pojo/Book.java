package com.hcjava.pojo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Book {
	private String cn_notebook_id;
	private String cn_user_id;
	private String cn_notebook_type_id;
	private String cn_notebook_name;
	private String cn_notebook_desc;
	private Timestamp cn_notebook_createtime;
}
