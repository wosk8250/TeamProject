package com.kh.team.lsy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

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
import com.kh.team.domain.CampJoinVo;
import com.kh.team.domain.CampRecommendVo;
import com.kh.team.domain.CampNoticeVo;
import com.kh.team.domain.CampVo;
import com.kh.team.domain.CampingTipVo;
import com.kh.team.domain.FaqVo;
import com.kh.team.domain.MyReviewPagingDto;
import com.kh.team.domain.PagingDto;
import com.kh.team.domain.ReservationVo;
import com.kh.team.domain.UserVo;
import com.kh.team.domain.SearchDto;
import com.kh.team.ljh.service.AdminService;
import com.kh.team.ljh.utile.ReservationDate;
import com.kh.team.domain.ReviewVo;
import com.kh.team.lsy.service.SelectCampService;

@Controller
@RequestMapping("/camp")
public class CampController {
	
	@Inject
	private SelectCampService selectCampService;
	@Inject
	private AdminService adminService;

	@RequestMapping(value = "/home" , method = RequestMethod.GET)
	public String home(Model model,  PagingDto pagingDto, MyReviewPagingDto myReviewPagingDto) throws Exception {
		
		System.out.println(myReviewPagingDto.getCamp_area());
		System.out.println(myReviewPagingDto.getCamp_location());
		List<AreaCampLocationVo> list = selectCampService.campSelect();//검색창
		if(myReviewPagingDto.getCamp_area() != null) {
			System.out.println("조인");
			myReviewPagingDto.setmyReviewPageInfo();
			int totalCount = selectCampService.SearchCount(myReviewPagingDto);
			myReviewPagingDto.setTotalCount(totalCount);
			
			List<CampVo> campJoinList = selectCampService.mainSearchList(myReviewPagingDto);
			System.out.println("campJoinList:" + campJoinList);
			model.addAttribute("campJoinList" , campJoinList);
		}else {
			System.out.println("캠프");
			pagingDto.setPageInfo();
			int totalCount = selectCampService.pageCount(pagingDto);
			pagingDto.setTotalCount(totalCount);
			//캠핑장 리스트, 부대시설
			List<CampVo> campList = selectCampService.campList(pagingDto);
			List<AmenitiesVo> amenitiesList = selectCampService.amenitiesList();
			
			model.addAttribute("campList" , campList);
			model.addAttribute("amenitiesList", amenitiesList);
		}
		model.addAttribute("list" , list);

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
	public List<CampVo> locationArea2(@RequestBody CampVo campVo, PagingDto pagingDto) throws Exception {
		System.out.println("searchList" + campVo);
		String camp_area = campVo.getCamp_area();
		String camp_location = campVo.getCamp_location();
		List<CampVo> areaList = selectCampService.searchList(camp_area, camp_location, pagingDto);
		
		return areaList;
	}
	
	@RequestMapping(value = "/campingContent", method = RequestMethod.GET)
	public void campingContent(@RequestParam("camp_no") int camp_no, Model model) throws Exception {
		CampVo campVo = selectCampService.campingContent(camp_no);
		model.addAttribute(campVo);
		
		List<ReservationVo> reservationVo = adminService.reservationDateList(camp_no);
		ArrayList<String> reserveDate = new ArrayList<>();
		
		for (ReservationVo reservationVo2 : reservationVo) {
			reserveDate.addAll(ReservationDate.BetweenDates(reservationVo2.getStartdate(),reservationVo2.getEnddate()));
		}
		model.addAttribute("date", reserveDate);
	
	}
	
	@Transactional
	@ResponseBody
	@RequestMapping(value = "/recommend", method = RequestMethod.POST)
	public String recommend(CampRecommendVo campRecommendVo) throws Exception {
		System.out.println("recommend, camp_no" + campRecommendVo);
		CampRecommendVo vo = selectCampService.recommendCheck(campRecommendVo);
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
	public String main(Model model,HttpSession session) throws Exception {
		List<AreaCampLocationVo> list = selectCampService.campSelect();
		List<ReviewVo> reviewVo = selectCampService.reviewTop5();
		List<CampNoticeVo> CampNoticeVo = selectCampService.noticeTop5();
		List<CampingTipVo> CampingTipVo = selectCampService.tipTop5();
		List<FaqVo> faqVo = selectCampService.faqTop5();
		List<CampVo> campVo = selectCampService.recommendTop10();
		session.setAttribute("checkBoard", "camp");
		model.addAttribute("list" , list);//검색
		model.addAttribute("reviewVo" , reviewVo);//후기 리스트
		model.addAttribute("CampNoticeVo" , CampNoticeVo);// 공지사항
		model.addAttribute("CampingTipVo" , CampingTipVo);// 수칙리스트
		model.addAttribute("faqVo" , faqVo);//질문 리스트
		model.addAttribute("campVo" , campVo);//추천수 많은 캠핑장10
		return "camp/main";
	}
	
	//예약 등록
		@RequestMapping(value="/reservationDate",method = RequestMethod.POST)
		public String reservationDate(ReservationVo reservationVo) throws Exception{
			adminService.reservationDate(reservationVo);
			return "/camp/main";
			}
	//예약 불가
		@ResponseBody
		@RequestMapping(value="/reservationDateConfirm",method =RequestMethod.POST)
		public String reservationDateConfirm(@RequestBody ReservationVo reservationVo)throws Exception{

			ArrayList<String> reservationDate = ReservationDate.BetweenDates(reservationVo.getStartdate(), reservationVo.getEnddate());
			List<ReservationVo> list = adminService.reservationDateList(reservationVo.getCamp_no());
			for (ReservationVo reservationVo2 : list) {
				ArrayList<String> nowReservationDate = ReservationDate.BetweenDates(reservationVo2.getStartdate(), reservationVo2.getEnddate());
				for (int i = 0; i < reservationDate.size(); i++) {
					for (int j = 0; j < nowReservationDate.size(); j++) {
						if(reservationDate.get(i).equals(nowReservationDate.get(j))) {
							return "false";
						}
					}
				}
			}
				
			return null;
		}
	
}
