package com.learnway.study.dto;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ChatRoomDto {

	private String roomname;
	private String name;
	private Integer roomId;
	private String message;
	private String type;
	private String date;
	private LocalDateTime datetime;
}
