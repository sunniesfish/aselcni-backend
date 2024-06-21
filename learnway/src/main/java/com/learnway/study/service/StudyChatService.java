package com.learnway.study.service;

import org.springframework.stereotype.Service;

import com.learnway.study.domain.ChatMessage;
import com.learnway.study.domain.ChatRoom;
import com.learnway.study.dto.ChatRoomDto;

@Service
public class StudyChatService {


	//채팅방 생성 메서드
	public ChatRoom chatRoomCreate(ChatRoomDto dto) {
		ChatRoom room = ChatRoom.builder().roomname(dto.getRoomname()).build();
		return room;
	}
	
	//채팅 보관 메서드
	public ChatMessage storechat(ChatRoomDto dto) {
		ChatMessage msg = ChatMessage.builder().msg(dto.getMessage())
											   .datetime(dto.getDatetime()).build();
		return msg;
	}
}
