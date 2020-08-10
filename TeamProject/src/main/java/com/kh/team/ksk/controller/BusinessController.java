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
import com.kh.team.domain.ReviewVo;
import com.kh.team.domain.myReviewPagingDto;
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
	public String campInsert(CampVo campVo, AmenitiesVo amenitiesVo, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		campVo.setUser_id(user_id);
		System.out.println(campVo);
		System.out.println(amenitiesVo);
		adminService.campInsertRun(campVo, amenitiesVo);


		return "redirect:/camp/main";
	}
	
	//캠핑장 수정 폼
	@RequestMapping(value = "/campModify", method = RequestMethod.GET)
	public String campModify(String camp_address, Model model) throws Exception {
		System.out.println("camp_address" + camp_address);
		CampVo campVo = adminService.campModifyForm(camp_address);
		model.addAttribute("campVo", campVo);
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
	public String campModifyRun(CampVo campVo) throws Exception {
		
		adminService.campModifyRun(campVo);
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
	public String MycampListPaging(Model model, HttpServletRequest request, myReviewPagingDto pagingDto) throws Exception{
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

}
