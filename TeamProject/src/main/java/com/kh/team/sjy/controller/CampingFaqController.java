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
import com.kh.team.domain.MyReviewPagingDto;
import com.kh.team.sjy.persitence.CampingFaqDaoImpl;
import com.kh.team.sjy.service.CampingFaqService;



@Controller
@RequestMapping(value="/camp")
public class CampingFaqController {
	@Inject
	private  CampingFaqDaoImpl campingFaqDaoImpl;
	@Inject
	private CampingFaqService campingFaqService;
	

	
	//자주묻는 질문
	@RequestMapping(value="/campingFaqList", method= RequestMethod.GET)
	public String faqList(Model model, MyReviewPagingDto myReviewPagingDto)throws Exception{
//		System.out.println("List/myReviewPagingDto:"+myReviewPagingDto);
		myReviewPagingDto.setmyReviewPageInfo();
		int totalCount = campingFaqService.campingFaqListCount(myReviewPagingDto);
		myReviewPagingDto.setTotalCount(totalCount);
		List<FaqVo> list = campingFaqService.faqListPage(myReviewPagingDto);
		
		model.addAttribute("list",list);
		model.addAttribute("pagingDto", myReviewPagingDto);
		
		return "camp/campingFaqList";
		
	}
	
	//자주 묻는 질문보기
	@Transactional
	@RequestMapping(value="/selectByFaq/{faq_no}", method= RequestMethod.GET)
	public String selectByFaq(@PathVariable("faq_no") int faq_no,Model model, MyReviewPagingDto myReviewPagingDto)throws Exception{
		//뷰 추가
//		System.out.println("faq_no:" +faq_no);
//			System.out.println("selectByFaq/myReviewPagingDto:" + myReviewPagingDto);
		
		campingFaqDaoImpl.faqViewCount(faq_no);
		FaqVo faqVo = campingFaqDaoImpl.selectByFaq(faq_no);
		model.addAttribute("faqVo", faqVo);
		model.addAttribute("pagingDto", myReviewPagingDto);
	
		return "camp/selectByFaq";
	}
}
