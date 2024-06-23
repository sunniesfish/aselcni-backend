package com.learnway.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnway.study.domain.Study;
import com.learnway.study.domain.StudyTag;
import com.learnway.study.domain.StudyTagRepository;
import com.learnway.study.dto.StudyTagDto;

@Service
public class StudyTagService {

	@Autowired
	private StudyTagRepository studyTagRepository;
	
	public void createTag(StudyTagDto studyTagDto,Study study) {
		
		StudyTag tag = StudyTag.builder().tag(studyTagDto.getTag()).study(study).build();
		studyTagRepository.save(tag);
		
		
	}
}
