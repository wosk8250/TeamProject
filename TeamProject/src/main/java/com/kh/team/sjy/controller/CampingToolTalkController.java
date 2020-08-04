package com.kh.team.sjy.controller;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.team.domain.CampingTalkVo;
import com.kh.team.sjy.persitence.CampingToolTalkDaoImpl;



@Controller
@RequestMapping(value="/camp")
public class CampingToolTalkController {
	
	
	@Inject
	private CampingToolTalkDaoImpl campingToolTalkDaoImpl;

	
	//캠핑장비 게시판
	@RequestMapping(value="/campingToolTalkList" , method = RequestMethod.GET  )
	public String CampTipList(Model model)throws Exception{
		List<CampingTalkVo> list = campingToolTalkDaoImpl.campingToolTalk();
		model.addAttribute("list",list);
	
		return  "/camp/campingToolTalkList";
	}
	//캠핑장비 게시글 보기
	@Transactional
	@RequestMapping(value="/selectCampingToolTalk/{campingtalk_no}", method = RequestMethod.GET)
	public String selectCampingToolTalk(@PathVariable("campingtalk_no") int campingtalk_no, Model model)throws Exception{
		CampingTalkVo campingTalkVo = campingToolTalkDaoImpl.selectCampingToolTalk(campingtalk_no);
		campingToolTalkDaoImpl.campingToolTalkView(campingtalk_no);
		model.addAttribute(campingTalkVo);
		return "/camp/selectCampingToolTalk";
	}
	
}
