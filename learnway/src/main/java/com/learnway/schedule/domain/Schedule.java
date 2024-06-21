package com.learnway.schedule.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//자동증가
	private Long scheduleId;
	
	@Column(nullable=true)
	private String startTime;
	
	@Column(nullable=true)
	private String endTime;
	
	@Column(nullable=true)
	private String studyway;
	
	@Column(nullable=true)
	private String subject;
	
	
	@Column(nullable=true)
	private String progress;
	
	@Column(nullable=true)
	private String material;
	
	@Column(nullable=true)
	private String achieveRate;

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", studyway=" + studyway + ", subject=" + subject + ", progress=" + progress + ", achieveRate="
				+ achieveRate + "]";
	}
	

}
