package com.kh.team.sjy.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.team.domain.CampingTipVo;
import com.kh.team.sjy.persitence.CampingTipDaoImpl;

@Controller
@RequestMapping(value="/camp")
public class CampingTipConroller {
	
	@Inject
	private CampingTipDaoImpl campingTipDaoImpl;
	
	//캠핑 수칙 목록
	@RequestMapping(value="/campingTipList" , method = RequestMethod.GET  )
	public String CampTipList(HttpSession session,Model model)throws Exception{
		List<CampingTipVo> list = campingTipDaoImpl.campingTipList();
		model.addAttribute("list",list);
		session.setAttribute("checkBoard", "camp");
		model.addAttribute("checkBoard", "camp");
		return  "/camp/campingTipList";
	}
	//캠핑 수칙 글 내용
	@Transactional
	@RequestMapping(value="/singleContentsCampingTip/{campingtip_no}/{checkBoard}", method= RequestMethod.GET)
	public String singleContentsCampingTip(@PathVariable("checkBoard") String checkBoard,@PathVariable("campingtip_no") int campingtip_no,Model model,HttpServletRequest request)throws Exception{
		System.out.println("campingtip_no:"+ campingtip_no);
		CampingTipVo campingTipVo = campingTipDaoImpl.singleContentsCampingTip(campingtip_no); //  캠핑수칙 글내용
		campingTipDaoImpl.updateCampingTipView(campingtip_no);  //조회수
		System.out.println("campNoticeVo:" + campingTipVo );
		model.addAttribute("checkBoard", checkBoard);
		HttpSession httpSession = request.getSession();
		String admin = (String) httpSession.getAttribute("checkAdmin");
		model.addAttribute("checkAdmin", admin);
		model.addAttribute(campingTipVo);
		
		String asd = (String) httpSession.getAttribute("checkBoard");
		System.out.println("checkBoard = " + asd);
		
		return  "/camp/singleContentsCampingTip";
	}
	
	

}
