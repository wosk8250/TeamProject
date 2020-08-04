package com.kh.team.lsy.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.team.domain.AreaCampLocationVo;
import com.kh.team.domain.CampNoticeVo;
import com.kh.team.domain.CampVo;
import com.kh.team.domain.CampingTipVo;
import com.kh.team.domain.FaqVo;
import com.kh.team.domain.PagingDto;
import com.kh.team.domain.ReviewVo;
import com.kh.team.lsy.service.SelectCampService;

@Controller
@RequestMapping("/camp")
public class CampController {
	
	@Inject
	private SelectCampService selectCampService;
	
	@RequestMapping(value = "/home" , method = RequestMethod.GET)
	public String home(Model model,  PagingDto pagingDto) throws Exception {
		pagingDto.setPageInfo();
		
		int totalCount = selectCampService.pageCount(pagingDto);
		pagingDto.setTotalCount(totalCount);

		List<AreaCampLocationVo> list = selectCampService.campSelect();
		List<CampVo> campList = selectCampService.campList(pagingDto);
		
		System.out.println("list" + list);
		model.addAttribute("list" , list);
		model.addAttribute("campList" , campList);

		return "camp/home";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/locationArea/{camp_area}", method = RequestMethod.GET)
	public List<String> locationArea(@PathVariable("camp_area") String camp_area) throws Exception {
		System.out.println("camp_area:" + camp_area);
		List<String> list2 = selectCampService.locationArea(camp_area);
		System.out.println("list2" + list2);
		return list2;
	}
	
	@RequestMapping(value = "/campSelect", method = RequestMethod.GET)
	public void campingContent(@RequestParam("camp_no") int camp_no, Model model) throws Exception {
		CampVo campVo = selectCampService.campingContent(camp_no);
		model.addAttribute(campVo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/asd", method = RequestMethod.POST)
	public List<String> locationArea2(@RequestBody CampVo campVo) throws Exception {
		System.out.println("1234" + campVo);
		
		return null;
	}
	
	
//	@RequestMapping(value = "/listPage" , method = RequestMethod.GET)
//	public void listPage(Model model, PagingDto pagingDto) throws Exception {
//		List<CampVo> listPage = selectCampService.listPage(pagingDto);
//		System.out.println("listPage:" + listPage);
//		model.addAttribute("listPage", listPage);
//		System.out.println("pagingDto:"+ pagingDto);
//		model.addAttribute("pagingDto", pagingDto);
//	}
	
	//메인 페이지
	@RequestMapping(value = "/main" , method = RequestMethod.GET)
	public String main(Model model) throws Exception {
		List<AreaCampLocationVo> list = selectCampService.campSelect();
		List<ReviewVo> reviewVo = selectCampService.reviewTop5();
		List<CampNoticeVo> CampNoticeVo = selectCampService.noticeTop5();
		List<CampingTipVo> CampingTipVo = selectCampService.tipTop5();
		List<FaqVo> faqVo = selectCampService.faqTop5();
		List<CampVo> campVo = selectCampService.recommendTop10();
		
		model.addAttribute("list" , list);//검색
		model.addAttribute("reviewVo" , reviewVo);//후기 리스트
		model.addAttribute("CampNoticeVo" , CampNoticeVo);// 공지사항
		model.addAttribute("CampingTipVo" , CampingTipVo);// 수칙리스트
		model.addAttribute("faqVo" , faqVo);//질문 리스트
		model.addAttribute("campVo" , campVo);//추천수 많은 캠핑장10
		return "camp/main";
	}
	
}
