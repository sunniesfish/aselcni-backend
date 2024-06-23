package com.learnway.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnway.study.domain.Study;
import com.learnway.study.dto.ChatRoomDto;
import com.learnway.study.dto.StudyDto;
import com.learnway.study.dto.StudyTagDto;



//스터디게시글 트랜젝션 처리 서비스
@Service
public class StudyService {

	
	private StudyPostService studyPostService;
	private StudyChatService studyChatService;
	private StudyTagService studyTagService;
	
	@Autowired
	public StudyService(StudyPostService studyPostService, StudyChatService studyChatService,StudyTagService studyTagService) {
		this.studyPostService = studyPostService;
		this.studyChatService = studyChatService;
		this.studyTagService = studyTagService;
		
	}
	
	
	
	@Transactional
	public void crateBoard(StudyDto dto,ChatRoomDto chatRoomDto,StudyTagDto studyTagDto) {
		
		System.out.println("게시글생성");
		//게시글 생성
		Study postid = studyPostService.boardadd(dto);
		//채팅방 생성
		studyChatService.chatRoomCreate(chatRoomDto, postid);
		//태그값 저장
		studyTagService.createTag(studyTagDto, postid);
		
		
		
		
	}
}
