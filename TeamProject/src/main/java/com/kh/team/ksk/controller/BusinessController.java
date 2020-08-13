package com.kh.team.ksk.controller;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.team.domain.AmenitiesVo;
import com.kh.team.domain.CampVo;
import com.kh.team.domain.FilesVo;
import com.kh.team.domain.ReservationVo;
import com.kh.team.domain.ReviewVo;
import com.kh.team.domain.MyReviewPagingDto;
import com.kh.team.ksk.service.BusinessService;
import com.kh.team.ljh.service.AdminService;

@Controller
@RequestMapping(value = "/business")
public class BusinessController {

	@Inject
	private AdminService adminService;
	@Inject
	private BusinessService businessService;
	
	// 캠핑장 입력폼
	@RequestMapping(value = "/campForm", method = RequestMethod.GET)
	public void campForm() throws Exception {

	}

	// 캠핑장 글쓰기 처리 
	@RequestMapping(value = "/campRun", method = RequestMethod.POST) 
	public String campInsert(CampVo campVo, AmenitiesVo amenitiesVo, HttpSession session) throws Exception {
//		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		campVo.setUser_id(user_id);
		//캠핑장 소개글 글자 자르기
		String camp_intro = "";
		if(campVo.getCamp_content().length() >=15) {
			String sub = campVo.getCamp_content();
			camp_intro = sub.substring(0, 15) + "...";
		} else {
			camp_intro = campVo.getCamp_content();
		}
		campVo.setCamp_intro(camp_intro);
		adminService.campInsertRun(campVo, amenitiesVo);

		System.out.println("run, session, user_id:"  + session.getAttribute("user_id"));
		return "redirect:/camp/main";
	}
	
	// 캠핑장 수정 글
	@RequestMapping(value = "/campModify", method = RequestMethod.GET)
	public String campModifyForm(int camp_no, Model model) throws Exception {
		CampVo campVo = adminService.campModifyForm(camp_no);
		AmenitiesVo amenitiesVo = adminService.selectByAmenities(camp_no);
		model.addAttribute("campVo", campVo);
		model.addAttribute("amenitiesVo", amenitiesVo);
		List<FilesVo> list = adminService.filesList(campVo.getTable_name());
		List<FilesVo> fileList = new ArrayList<>();
		for (FilesVo filesVo : list) {
			if (filesVo.getFiles_no() == campVo.getCamp_no()) {
				String file = filesVo.getFiles();
				filesVo.setFiles(file);
				int lastSlash = file.lastIndexOf("/");
				String front = file.substring(0, lastSlash + 1);
				String rear = file.substring(lastSlash + 1);
				String thumbnailName = front + "sm_" + rear;
				filesVo.setThumbnailName(thumbnailName);
				int lastUnderBar = file.lastIndexOf("_");
				String orgFileName = file.substring(lastUnderBar + 1);
				filesVo.setOrgFileName(orgFileName);
				fileList.add(filesVo);
			}
		}
		model.addAttribute("fileList", fileList);
		return "business/campModify";
	}
	//캠핑장 수정 처리
	@RequestMapping(value = "/campModifyRun", method = RequestMethod.POST)
	public String campModifyRun(CampVo campVo, AmenitiesVo amenitiesVo, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		campVo.setUser_id(user_id);
		
		String camp_intro = "";
		if(campVo.getCamp_content().length() >=15) {
			String sub = campVo.getCamp_content();
			camp_intro = sub.substring(0, 15) + "...";
		} else {
			camp_intro = campVo.getCamp_content();
		}
		campVo.setCamp_intro(camp_intro);
		adminService.campModifyRun(campVo, amenitiesVo);
		return "redirect:/camp/main";
	}
	
	//삭제
	@RequestMapping(value = "/campDelete", method = RequestMethod.GET)
	public String campDelete(int camp_no, RedirectAttributes attr) throws Exception {
		attr.addFlashAttribute("msg", "delete");
		adminService.campDelete(camp_no);
		return "redirect:/camp/main";

	}
	
	
	//내가 등록한 캠핑장 목록-페이징
	@RequestMapping(value = "/myCampList", method = RequestMethod.GET)
	public String MycampListPaging(Model model, HttpServletRequest request, MyReviewPagingDto pagingDto) throws Exception{
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		pagingDto.setUser_id(user_id);
		
		pagingDto.setmyReviewPageInfo();
		int totalCount = businessService.getCount(pagingDto);
		pagingDto.setTotalCount(totalCount);
		System.out.println(pagingDto);
		List<CampVo> myCampList = businessService.mycampList(pagingDto);
		
		model.addAttribute("pagingDto", pagingDto);
		model.addAttribute("myCampList", myCampList);
		System.out.println(myCampList);
		return "business/myCampList";
	}
	
	//예약목록
	@RequestMapping(value = "/campReservation", method = RequestMethod.GET)
	public String campReservation(Model model, HttpServletRequest request, MyReviewPagingDto pagingDto)throws Exception{
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		pagingDto.setUser_id(user_id);
		
		pagingDto.setmyReviewPageInfo();
		int totalCount = businessService.getReservationCount(pagingDto);
		pagingDto.setTotalCount(totalCount);
		
		List<ReservationVo> list = businessService.campReservation(pagingDto);
		System.out.println("list : " + list);
		model.addAttribute("pagingDto", pagingDto);
		model.addAttribute("list", list);
		return "business/campReservation";
	}

}
