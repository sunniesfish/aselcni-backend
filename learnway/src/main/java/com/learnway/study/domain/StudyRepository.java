package com.learnway.study.domain;
import org.springframework.data.jpa.repository.JpaRepository;

import com.learnway.study.dto.Study;


public interface StudyRepository extends JpaRepository<Study, Integer> {
	
	
}


