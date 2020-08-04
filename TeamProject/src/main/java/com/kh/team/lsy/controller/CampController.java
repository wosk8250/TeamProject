package com.kh.team.lsy.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.team.domain.AmenitiesVo;
import com.kh.team.domain.AreaCampLocationVo;
import com.kh.team.domain.CampRecommendVo;
import com.kh.team.domain.CampVo;
import com.kh.team.domain.PagingDto;
import com.kh.team.domain.UserVo;
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
	
	
	@ResponseBody
	@RequestMapping(value = "/searchList", method = RequestMethod.POST)
	public List<CampVo> locationArea2(@RequestBody CampVo campVo) throws Exception {
		System.out.println("searchList" + campVo);
		String camp_area = campVo.getCamp_area();
		String camp_location = campVo.getCamp_location();
		List<CampVo> areaList = selectCampService.searchList(camp_area, camp_location);
		
		return areaList;
	}
	
	@RequestMapping(value = "/campingContent", method = RequestMethod.GET)
	public void campingContent(@RequestParam("camp_no") int camp_no, Model model) throws Exception {
		CampVo campVo = selectCampService.campingContent(camp_no);
		model.addAttribute(campVo);
	}
	
	@Transactional
	@ResponseBody
	@RequestMapping(value = "/recommend", method = RequestMethod.POST)
	public String recommend(CampRecommendVo campRecommendVo) throws Exception {
		System.out.println("recommend, camp_no" + campRecommendVo);
		CampRecommendVo vo = selectCampService.recommendCheck(campRecommendVo.getUser_id());
		if(vo != null) {
			return "fail";
		} 
		System.out.println("insert");
		selectCampService.recommendInsert(campRecommendVo);// 추천 테이블
		selectCampService.recommend(campRecommendVo.getCamp_no());// 추천 테이블
		//
		return "success";
	}
	
	@ResponseBody
	@RequestMapping(value = "/recommendInsert" , method = RequestMethod.GET)
	public String recommendInsert(CampRecommendVo campRecommendVo) throws Exception {
		System.out.println("campRecommendVo:" + campRecommendVo);
		selectCampService.recommendInsert(campRecommendVo);
		
		return "success";
	}
	
	@RequestMapping(value = "/areaLocationSelect/{camp_location}", method = RequestMethod.GET)
	public List<String> areaLocationSelect(@PathVariable("camp_location") String camp_location) throws Exception {
		
		List<String> list3 = selectCampService.areaLocationSelect(camp_location);
		return list3;
	}
	
	
	//메인 페이지
	@RequestMapping(value = "/main" , method = RequestMethod.GET)
	public void main() throws Exception {
		
	}
	
}
