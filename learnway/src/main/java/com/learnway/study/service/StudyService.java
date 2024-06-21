package com.learnway.study.service;

import org.springframework.stereotype.Service;

import com.learnway.study.domain.Study;
import com.learnway.study.dto.StudyDto;

@Service
public class StudyService {

	
	public Study boardadd(StudyDto dto) {
		
		Study study = Study.builder().title(dto.getTitle())
									       .content(dto.getContent())
									       .viewcount("0")
									       .startdate(dto.getStartdate())
									       .enddate(dto.getEnddate())
									       .isjoin((byte) 0).build();

	      
		return study;
		
		
	}

}
