package com.kh.team.sjy.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.team.domain.CampNoticeVo;
import com.kh.team.domain.FaqVo;
import com.kh.team.domain.myReviewPagingDto;
import com.kh.team.sjy.persitence.CampNoticeDaoImpl;

@Controller
@RequestMapping(value="/camp")
public class CampNoticeController {
	
	@Inject
	private  CampNoticeDaoImpl campNoticeDaoImpl;
	
	
	//공지사항 목록
	@RequestMapping(value="/campNoticeList",method= RequestMethod.GET)
	public String campNoticeList(Model model)throws Exception{
		List<CampNoticeVo> list = campNoticeDaoImpl.campNoticeList();
		model.addAttribute("list",list);
	return "/camp/campNoticeList";
	}
	
	//공지사항 글 내용
	@Transactional
	@RequestMapping(value="/singleContentsCampNotice/{notice_no}", method= RequestMethod.GET)
	public String  singleContentsCampNotice(@PathVariable("notice_no") int notice_no,  Model model)throws Exception{
		System.out.println("notice_no:"+ notice_no);
		CampNoticeVo campNoticeVo = campNoticeDaoImpl.singleContentsCampNotice(notice_no); //  공지사항 글내용
		campNoticeDaoImpl.updateNoticeView(notice_no);  //조회수
		System.out.println("campNoticeVo:" + campNoticeVo );
		model.addAttribute(campNoticeVo);
		return "camp/singleContentsCampNotice";
		
	}
	
	//자주묻는 질문
	@RequestMapping(value="/faqList", method= RequestMethod.GET)
	public void faqList(Model model, myReviewPagingDto pagingDto)throws Exception{
		pagingDto.setmyReviewPageInfo();
		int totalCount = campNoticeDaoImpl.getCount(pagingDto);
		pagingDto.setTotalCount(totalCount);
		System.out.println("pagingDto:"+ pagingDto);
		System.out.println("totalCount:"+ totalCount);
		List<FaqVo> faqList = campNoticeDaoImpl.faqList(pagingDto);
		model.addAttribute("pagingDto", pagingDto);
		model.addAttribute("faqList",faqList);
		
		model.addAttribute("checkBoard","camp" );
	}
	
	//자주 묻는 질문보기
	@Transactional
	@RequestMapping(value="/selectByfaq/{faq_no}/{checkBoard}", method= RequestMethod.GET)
	public String selectByfaq(@PathVariable("faq_no") int faq_no,@PathVariable("checkBoard") String checkBoard, Model model,HttpServletRequest request)throws Exception{
		//뷰 추가
		HttpSession httpSession = request.getSession();
		String admin = (String) httpSession.getAttribute("checkAdmin");
		model.addAttribute("checkAdmin", admin);
		model.addAttribute("checkBoard", checkBoard);
		
		campNoticeDaoImpl.faqViewCount(faq_no);
		FaqVo faqVo = campNoticeDaoImpl.selectByfaq(faq_no);
		model.addAttribute("faqVo", faqVo);
		return "/camp/selectByfaq";
	}
	
}
