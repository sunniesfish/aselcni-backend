package com.learnway.study.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="Study_tag")
public class StudyTag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="study_tagid" , nullable = false)
	private Integer tagId;
	
	@Column(name="tag")
	private String tag;
	
	@ManyToOne
	@JoinColumn(name = "study_postid", nullable = false)
	private Study study;
}
