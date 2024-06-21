package com.learnway.schedule.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learnway.schedule.domain.Schedule;
import com.learnway.schedule.dto.schedule.ScheduleDto;
import com.learnway.schedule.service.schedule.ScheduleService;


@RestController
@RequestMapping("/schedule")
public class ScheduleRestController {
	
	private static final Logger log = LoggerFactory.getLogger(ScheduleRestController.class);
	@Autowired
	private ScheduleService scheduleService;
	
	@GetMapping("/findAll")
	public List<Map<String,Object>> weekScheduleList() {
		
		List<Schedule> listAll = scheduleService.findAll();
		List<Map<String,Object>> eventList = new ArrayList<>();
		
		for(int i=0; i<listAll.size(); i++) {
			Map<String,Object> map = new HashMap<>();
			
			map.put("title",listAll.get(i).getStudyway());
			map.put("start",listAll.get(i).getStartTime());
			map.put("end",listAll.get(i).getEndTime());
			map.put("id", listAll.get(i).getScheduleId());
			eventList.add(map);
		}
		
		return eventList;
	}
	
	@GetMapping("/getDetail")
	public Map<String,Object> getDetail(@RequestParam("id") Long id,ScheduleDto dto) {
					
			
			Optional<Schedule> detail = scheduleService.getDetail(id);
			Map<String,Object> detailList = new HashMap<>();
			
			detailList.put("startTime",formatDateTime(detail.get().getStartTime()));
			detailList.put("endTime",formatDateTime(detail.get().getEndTime()));
			detailList.put("id", detail.get().getScheduleId());
			detailList.put("studyway", detail.get().getStudyway());
			detailList.put("subject", detail.get().getSubject());
			detailList.put("material", detail.get().getMaterial());
			detailList.put("progress", detail.get().getProgress());
			detailList.put("achieveRate", detail.get().getAchieveRate());
	
			return detailList;
		}
		
	
	@PostMapping("/add")
	public ResponseEntity<String> addSchedule(@RequestBody Map<String,Object> scheduledata,ScheduleDto dto){
		
		try {
            // 전송된 데이터 추출
		dto.setStartTime((String) scheduledata.get("startTime"));
		dto.setEndTime((String) scheduledata.get("endTime"));
        dto.setStudyway((String) scheduledata.get("studyway"));
        dto.setSubject((String) scheduledata.get("subject"));
        dto.setMaterial((String) scheduledata.get("material"));
        dto.setProgress((String) scheduledata.get("progress"));
        dto.setAchieveRate((String) scheduledata.get("achieveRate"));
        // 데이터 처리 로직 (DB 저장 등)
        scheduleService.add(dto);
        
        return ResponseEntity.ok("일정이 추가되었습니다.");
        
		}catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("일정 추가 중 오류가 발생했습니다.");
	    	}
		
	}
	
	//테이블 리사이즈 또는 드래그앤드롭 이벤트시에 수정 코드
	@PatchMapping("/updateTime")
	public ResponseEntity<String> updateTime(@RequestBody Map<String,Object> param,ScheduleDto dto){
	
			
			Long id = Long.parseLong((param.get("id").toString()));
			String studyway = (String)param.get("title");
			String startTime = (String)param.get("start");
			String endTime = (String)param.get("end");
			

		    
			dto.setScheduleId(id);
			dto.setStudyway(studyway);
			dto.setStartTime(startTime);
			dto.setEndTime(endTime);
			
			scheduleService.updateScheduleTime(dto);
	
		
		return ResponseEntity.ok("일정이 업데이트 되었습니다");
		
	}
	
	private String formatDateTime(String dateTime) {
		
		// UTC 시간 파싱
	    ZonedDateTime utcDateTime = ZonedDateTime.parse(dateTime);

	    // UTC를 로컬 시간대로 변환
	    ZonedDateTime localDateTime = utcDateTime.withZoneSameInstant(ZoneId.systemDefault());

	    // 원하는 형식으로 포맷팅
	    return localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
	}
		
}
