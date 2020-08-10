package com.kh.team.lsy.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.team.domain.AreaCampLocationVo;
import com.kh.team.domain.CampVo;
import com.kh.team.domain.PagingDto;
import com.kh.team.lsy.service.SelectCampService;

@Controller
@RequestMapping("/board")
public class CampListController {

	@Inject
	private SelectCampService selectCampService;

//	@RequestMapping(value = "/campingContent", method = RequestMethod.GET)
//	public void campingContent(@RequestParam("camp_no") int camp_no, Model model) throws Exception {
//		CampVo campVo = selectCampService.campingContent(camp_no);
//		model.addAttribute(campVo);
//	}
//
//	@RequestMapping("/recommend")
//	public String recommend(@RequestParam int camp_no) throws Exception {
//
//		selectCampService.recommend(camp_no);
//
//		return "forward:/camp/home";
//	}

}
