package com.learnway.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnway.member.domain.Member;
import com.learnway.member.domain.MemberRepository;
import com.learnway.study.domain.ChatMessage;
import com.learnway.study.domain.ChatRoom;
import com.learnway.study.domain.Study;
import com.learnway.study.domain.StudyChatRepository;
import com.learnway.study.dto.ChatRoomDto;

@Service
public class StudyChatService {

	@Autowired
	private StudyChatRepository studyChatRepository;
	@Autowired
	private MemberRepository memberRepository;
	
	//채팅방 생성 메서드
	public ChatRoom chatRoomCreate(ChatRoomDto dto,Study study) {
		
		Member member = memberRepository.findById(1)
	            .orElseThrow(() -> new IllegalArgumentException("Invalid member ID: " + "1"));
		
		ChatRoom room = ChatRoom.builder().roomname(dto.getRoomname())
				.study(study).member(member).build();
		System.out.println(room.getRoomname() + "룸이름");
		
		return studyChatRepository.save(ChatRoom.builder().roomname(dto.getRoomname())
				.study(study).member(member).build());
	}
	
	//채팅 보관 메서드
	public ChatMessage storechat(ChatRoomDto dto) {
		
		//멤버값 넣을예정 임시로 1로지정
		Member member = memberRepository.findById(1)
	            .orElseThrow(() -> new IllegalArgumentException("Invalid member ID: " + "1"));
		ChatRoom chatRoom = studyChatRepository.findById(dto.getRoomId())
				.orElseThrow(()-> new IllegalArgumentException("Invalid member ID: " + "1"));
		
		ChatMessage msg = ChatMessage.builder().msg(dto.getMessage()).member(member)
										       .chatroom(chatRoom)
											   .datetime(dto.getDatetime()).build();
		return msg;
	}
}
