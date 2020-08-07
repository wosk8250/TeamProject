package com.kh.team.sjy.controller;

import java.util.List;

import javax.inject.Inject;


import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.team.domain.FaqVo;
import com.kh.team.domain.myReviewPagingDto;
import com.kh.team.sjy.persitence.CampingFaqDaoImpl;



@Controller
@RequestMapping(value="/camp")
public class CampingFaqController {
	@Inject
	private  CampingFaqDaoImpl campingFaqDaoImpl;
	

	
	//자주묻는 질문
	@RequestMapping(value="/faqList", method= RequestMethod.GET)
	public void faqList(Model model, myReviewPagingDto pagingDto)throws Exception{
		pagingDto.setmyReviewPageInfo();
		int totalCount = campingFaqDaoImpl.getCount(pagingDto);
		pagingDto.setTotalCount(totalCount);
		System.out.println("pagingDto:"+ pagingDto);
		System.out.println("totalCount:"+ totalCount);
		List<FaqVo> faqList = campingFaqDaoImpl.faqList(pagingDto);
		model.addAttribute("pagingDto", pagingDto);
		model.addAttribute("faqList",faqList);
		
	}
	
	//자주 묻는 질문보기
	@Transactional
	@RequestMapping(value="/selectByfaq/{faq_no}", method= RequestMethod.GET)
	public String selectByfaq(@PathVariable("faq_no") int faq_no,Model model)throws Exception{
		//뷰 추가
		
		campingFaqDaoImpl.faqViewCount(faq_no);
		FaqVo faqVo = campingFaqDaoImpl.selectByfaq(faq_no);
		model.addAttribute("faqVo", faqVo);
		return "/camp/selectByfaq";
	}
}
