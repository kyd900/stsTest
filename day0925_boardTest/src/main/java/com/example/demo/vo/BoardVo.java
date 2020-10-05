package com.example.demo.vo;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardVo {
	private int no;
	private String title;
	private String writer;
	private String pwd;
	private String content;
	private Date regdate;
	private int hit;
	private int b_ref;
	private int b_level;
	private int b_step;
	private String fname;
	private String ip;
	private MultipartFile uploadFile;
	private int fsize;	
}