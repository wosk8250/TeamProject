package com.kh.team.sjy.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.kh.team.domain.CampNoticeVo;
import com.kh.team.domain.myReviewPagingDto;
import com.kh.team.sjy.persitence.CampNoticeDaoImpl;
import com.kh.team.sjy.service.CampingNoticeService;

@Controller
@RequestMapping(value="/camp")
public class CampingNoticeController {
	
	@Inject
	private  CampNoticeDaoImpl campNoticeDaoImpl;
	@Inject
	private CampingNoticeService campingNoticeService;
	
	
	//공지사항 목록
	@RequestMapping(value="/campingNoticeList",method= RequestMethod.GET)
	public String campNoticeList(myReviewPagingDto myReviewPagingDto,Model model)throws Exception{
		System.out.println("myReviewPagingDto" + myReviewPagingDto);
		myReviewPagingDto.setmyReviewPageInfo();
		int totalCount = campingNoticeService.campingNoticeListCount(myReviewPagingDto);
		myReviewPagingDto.setTotalCount(totalCount);
		List<CampNoticeVo> list = campingNoticeService.noticeListPage(myReviewPagingDto);
	
		model.addAttribute("list",list);
		model.addAttribute("pagingDto", myReviewPagingDto);
	
		return "camp/campingNoticeList";
			
	}
	
	//공지사항 글 내용
	@Transactional
	@RequestMapping(value="/singleContentsCampNotice/{notice_no}", method= RequestMethod.GET)
	public String  singleContentsCampNotice(@PathVariable("notice_no") int notice_no,myReviewPagingDto myReviewPagingDto,  Model model,HttpServletRequest request)throws Exception{
//		System.out.println("notice_no:"+ notice_no);
		CampNoticeVo campNoticeVo = campNoticeDaoImpl.singleContentsCampNotice(notice_no); //  공지사항 글내용
		campNoticeDaoImpl.updateNoticeView(notice_no);  //조회수
//		System.out.println("campNoticeVo:" + campNoticeVo );
		model.addAttribute("campNoticeVo",campNoticeVo);
		model.addAttribute("pagingDto",myReviewPagingDto);
		return "camp/singleContentsCampNotice";
		
	}
	

	
}
