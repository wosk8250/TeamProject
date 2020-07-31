package com.kh.team.ksk.controller;


import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.team.domain.CampVo;
import com.kh.team.ljh.service.AdminService;

@Controller
@RequestMapping(value = "/business")
public class BusinessController {

	@Inject
	private AdminService adminService;
	
	// 캠핑장 입력폼
	@RequestMapping(value = "/campForm", method = RequestMethod.GET)
	public void campForm() throws Exception {

	}

	// 캠핑장 글쓰기
	@RequestMapping(value = "/campRun", method = RequestMethod.POST)
	public String campInsertRun(CampVo campVo) throws Exception {
		adminService.campInsertRun(campVo);

		return "redirect:/admin/camp";
	}
	

}
