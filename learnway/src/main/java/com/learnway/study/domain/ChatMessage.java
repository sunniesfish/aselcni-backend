package com.learnway.study.domain;

import java.time.LocalDateTime;

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
@Table(name="ChatMessage")
public class ChatMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="chat_msg_id",nullable = false)
	private Integer msgid;
	
	@Column(name="chat_msg",nullable = false)
	private String msg;
	
	@Column(name="chat_date",nullable = false)
	private LocalDateTime datetime;
	
	
}
