package com.learnway.schedule.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
	
	//달력 모든 정보 불러오기
	List<Schedule> findAll();
}
