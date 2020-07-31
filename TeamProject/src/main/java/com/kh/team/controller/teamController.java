package com.kh.team.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/team")
public class teamController {
	@RequestMapping(value="/yaya" , method = RequestMethod.GET)
	public void rere() {
		
	}
	
}
