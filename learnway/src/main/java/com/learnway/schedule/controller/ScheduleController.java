package com.learnway.schedule.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learnway.schedule.service.schedule.ScheduleService;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
	
		@Autowired
		private ScheduleService scheduleService;
		
		@GetMapping("/weekSchedule")
		public String weekSchedule() {
			
			return "/schedule/weekSchedule";
		}
		
		
		
		
		
		
}
