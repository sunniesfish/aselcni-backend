package com.learnway.schedule.dto.schedule;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto {
	
	private Long scheduleId;
	private String startTime;
	private String endTime;
	private String studyway;
	private String subject;
	private String progress;
	private String material;
	private String achieveRate;
	
	@Override
	public String toString() {
		return "ScheduleDto [scheduleId=" + scheduleId + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", studyway=" + studyway + ", subject=" + subject + ", progress=" + progress + ", achieveRate="
				+ achieveRate + "]";
	}
	
	

}
