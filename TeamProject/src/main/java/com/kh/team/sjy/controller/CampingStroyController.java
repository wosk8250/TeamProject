package com.kh.team.sjy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value="/camp")
public class CampingStroyController {

	
	//캠핑 수칙 목록
	@RequestMapping(value="/campingStory" , method = RequestMethod.GET  )
	public String CampTipList(Model model)throws Exception{
	
		return  "/camp/campingStory";
	}
}
