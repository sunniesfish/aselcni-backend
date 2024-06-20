package com.learnway.study.dto;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="study")
public class Study {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="study_postid" , nullable = false)
	private Integer postid;
	
	
	@Column(name="study_title")
	private String title;
	
	@Column(name="study_content")
	private String content;
	
	@Column(name="study_viewcount")
	private String viewcount;
	
	@Column(name="study_createdate")
	@CreationTimestamp
	private Date createdate;
	
	@Column(name="study_startdate",nullable = false)
	private Date startdate;
	
	@Column(name="study_enddate",nullable = false)
	private Date enddate;
	
	@Column(name="study_isjoin",nullable = false)
	private byte isjoin;
	

	
}
