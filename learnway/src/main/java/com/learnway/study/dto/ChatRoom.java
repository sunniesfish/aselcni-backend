package com.learnway.study.dto;

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
@Table(name="study_chatroom")
public class ChatRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="study_chatroomid",nullable = false)
	private Integer chatroomid;
	
//	@Column(name="study_postid",nullable = false)
//	private Integer postid;
//	엔티티생성후 제거예정
//	@Column(name="member_no",nullable = false)
//	private Integer memno;
//	
	
	@Column(name="study_roomname",nullable = false)
	private String roomname;
	
}
