package com.learnway.study.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class StudyDto {
	
	private Integer postid;
	
	
	private String title;
	
	private String content;
	
	private String viewcount;
	
	private Date createdate;
	
	private Date startdate;
	
	private Date enddate;
	
	private byte isjoin;
}
