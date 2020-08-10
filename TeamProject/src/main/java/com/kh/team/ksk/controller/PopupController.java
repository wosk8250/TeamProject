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
@RequestMapping(value = "/popup")
public class PopupController {
	
	// 주소 팝업
	@RequestMapping(value = "/jusoPopup", method = RequestMethod.GET)
	public void campForm() throws Exception {

	}

}
