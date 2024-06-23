package com.learnway.study.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learnway.study.domain.Study;
import com.learnway.study.domain.StudyRepository;
import com.learnway.study.dto.ChatRoomDto;
import com.learnway.study.dto.StudyDto;
import com.learnway.study.dto.StudyTagDto;
import com.learnway.study.service.StudyPostService;
import com.learnway.study.service.StudyService;

@Controller
@RequestMapping
public class StudyController {
	
	
	@Autowired
	private StudyService studyService; 
	@Autowired
	StudyRepository studyRepository;
	@Autowired
	StudyPostService studyPostService;
	
	

//	@RequestMapping(value="/studylist",method= {RequestMethod.GET,RequestMethod.POST})
	@GetMapping(value="/studylist")
	public String study(Model model) {
		model.addAttribute("study",studyRepository.findAll(Sort.by(Sort.Direction.DESC,"postid")));
		System.out.println("study list 진입");
		return "/study/studylist";
	}
	
	@GetMapping(value="/studyadd")
	public String studyAddView() {
		return "/study/studyadd";
	}
	
	@PostMapping(value="/studyadd")
	public String studyadd(StudyDto studyDto,ChatRoomDto chatRoomDto,StudyTagDto studyTagDto) {
		
		studyService.crateBoard(studyDto,chatRoomDto,studyTagDto);
		System.out.println(studyTagDto.getTag()+"태그값");
		
		System.out.println("post studyadd 진입");
		return "redirect:/studylist";
	}
	
	@GetMapping(value="/study/detail/"+"{postid}")
	public String studydetail(@PathVariable("postid") Integer postid,Model model) {
		System.out.println(postid);
		Optional<Study> optionalStudy = studyRepository.findById(postid);
		
		if(optionalStudy.isPresent()) {
			Study study = optionalStudy.get();
			model.addAttribute("study",study);
			return "study/studydetail";
		}else {
			model.addAttribute("errmsg","게시글을 찾을 수 없습니다.");
			return "error/404";
		}
		
		}
		

	
	
	

}
