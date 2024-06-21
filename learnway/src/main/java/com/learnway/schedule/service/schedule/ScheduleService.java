package com.learnway.schedule.service.schedule;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnway.global.exceptions.DataNotException;
import com.learnway.schedule.domain.Schedule;
import com.learnway.schedule.domain.ScheduleRepository;
import com.learnway.schedule.dto.schedule.ScheduleDto;

@Service
public class ScheduleService {
	
	@Autowired
	private ScheduleRepository scheduleRepository;

	// 스케쥴 추가하기
		public void add(ScheduleDto dto) {

			Schedule schedule = new Schedule();
			schedule.setScheduleId(dto.getScheduleId());
			schedule.setStartTime(dto.getStartTime());
			schedule.setEndTime(dto.getEndTime());
			schedule.setStudyway(dto.getStudyway());
			schedule.setMaterial(dto.getMaterial());
			schedule.setProgress(dto.getProgress());
			schedule.setSubject(dto.getSubject());
			schedule.setAchieveRate(dto.getAchieveRate());
			
			scheduleRepository.save(schedule);
		}
		
		public List<Schedule> findAll(){
			return scheduleRepository.findAll();
		}
		
		public void updateScheduleTime(ScheduleDto dto) {
			
			Schedule schedule = scheduleRepository.findById(dto.getScheduleId()).orElseThrow(() 
					-> new IllegalArgumentException("해당 일정이 존재하지 않습니다. id: " + dto.getScheduleId()));
			
			schedule.setStartTime(dto.getStartTime());
			schedule.setEndTime(dto.getEndTime());
			schedule.setStudyway(dto.getStudyway());
			
			scheduleRepository.save(schedule);
		}
		
		public Optional<Schedule> getDetail(Long id){
			return scheduleRepository.findById(id);
		}
		
		public ScheduleDto getDetailll(Long id) throws DataNotException {
			
			Optional<Schedule> schedule = scheduleRepository.findById(id);
			
			if (schedule.isPresent()) {
		        Schedule updateschedule = schedule.get();
		        ScheduleDto dto = convertDTO(updateschedule);

		        return dto;
		    } else {
		        throw new DataNotException("schedule not found");
		    }
		
		}
		
		private ScheduleDto convertDTO(Schedule schedule) {
			
			ScheduleDto dto = new ScheduleDto();
			
			dto.setScheduleId(schedule.getScheduleId());
			dto.setStartTime(schedule.getStartTime());
			dto.setEndTime(schedule.getEndTime());
			dto.setStudyway(schedule.getStudyway());
			dto.setSubject(schedule.getSubject());
			dto.setProgress(schedule.getProgress());
			dto.setMaterial(schedule.getMaterial());
			dto.setAchieveRate(schedule.getAchieveRate());
			
			return dto;
		}
		
		
}
