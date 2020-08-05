package com.kh.team.ksk.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.team.domain.DemeritVo;
import com.kh.team.domain.ReviewVo;
import com.kh.team.domain.UserVo;
import com.kh.team.domain.myReviewPagingDto;
import com.kh.team.ksk.service.UserService;
import com.kh.team.ljh.utile.DateUtile;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Inject
	private UserService userService;
	
	// 로그인 폼
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void LoginGet() throws Exception {
	}

	// 로그인 처리
	@Transactional
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String LoginPost(String user_id, String user_pw, HttpSession session, RedirectAttributes rttr) throws Exception {
		try {
		boolean result = userService.checkByIdAndPw(user_id, user_pw);
		String checkAdmin = userService.checkAdmin(user_id);
			if (result == true) {// 아이디 비번 확인
				if (checkAdmin.equals("1")) {// 1이면 일지 정지
					String strStopDateTime = userService.getStopDate(user_id);
					LocalDateTime nowDateTime = LocalDateTime.now();
					LocalDateTime StopDateTime = DateUtile.stopDateTime(strStopDateTime);
					boolean resultTime = StopDateTime.isBefore(nowDateTime);// 현제 시간이 정지시간이후면 true/ 정지상태 false
	
					if (resultTime == false) {// 정지상태
						rttr.addFlashAttribute("userStopTime", strStopDateTime);
						rttr.addFlashAttribute("message", "userBlock");
						return "redirect:/user/login";
	
					} else {// 정지 시간 이후
						userService.stopUserBlock(user_id);
					}
				}
				session.setAttribute("checkAdmin", checkAdmin);
				session.setAttribute("user_id", user_id);
	
				String tergetLoction = (String) session.getAttribute("tergetLoction");
				if (tergetLoction != null && !tergetLoction.equals("")) {
					session.removeAttribute("tergetLoction");
					return "redirect:" + tergetLoction;
				}
				return "redirect:/camp/home";
			}
		} catch (NullPointerException e) {
			rttr.addFlashAttribute("message", "fail");
			return "redirect:/user/login";
		}
		rttr.addFlashAttribute("message", "fail");
		return "redirect:/user/login";

	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();// 세션 무효화 -> 로그아웃
		return "redirect:/camp/main";
	}

	// 회원가입 폼
	@RequestMapping(value = "/insertUser", method = RequestMethod.GET)
	public void isnertUserGet(UserVo userVo) throws Exception {
	}

	// 회원가입 처리
	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public String isnertUserPost(UserVo userVo) throws Exception {
		userVo.setAdmin("0");
		userService.insertUser(userVo);
		System.out.println(userVo);
		return "redirect:/camp/home";
	}
	
	//사업자 회원가입 처리
	@RequestMapping(value = "/insertBusiness", method = RequestMethod.POST)
	public String insertBusinessPost(UserVo userVo) throws Exception {
		userVo.setAdmin("2");
		userService.insertUser(userVo);
		System.out.println(userVo);
		return "redirect:/camp/home";
	}
	
	// 사업자 회원가입 폼
	@RequestMapping(value = "/insertBusiness", method = RequestMethod.GET)
	public void insertBusinessGet(UserVo userVo) throws Exception {
	}

	// 프로필 보기
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Model model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		UserVo userVo = userService.profile(user_id);
		List<DemeritVo> demeritList = userService.userDemerit(user_id);
		model.addAttribute("userVo", userVo);
		model.addAttribute("demeritList", demeritList);
		return "/user/profile";
	}

	// 회원정보 수정 폼
	@RequestMapping(value = "/updateInfo", method = RequestMethod.GET)
	public void updateInfoGet(Model model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		UserVo userVo = userService.profile(user_id);
		model.addAttribute("userVo", userVo);
	}

	// 회원정보 수정 처리
	@RequestMapping(value = "/updateInfo", method = RequestMethod.POST)
	public String updateInfoPost(UserVo userVo, RedirectAttributes rttr) throws Exception {
		boolean result = userService.checkByIdAndPw(userVo.getUser_id(), userVo.getUser_pw());
		if (result == true) {
			userService.updateInfo(userVo);
			rttr.addFlashAttribute("message", "updateInfo");
			return "redirect:/user/profile?user_id=" + userVo.getUser_id();
		}
		rttr.addFlashAttribute("message", "fail_info");
		return "redirect:/user/updateInfo?user_id=" + userVo.getUser_id();

	}

	// 아이디 중복 체크
	@ResponseBody
	@RequestMapping(value = "/checkId", method = RequestMethod.GET)
	public String checkId(String user_id) throws Exception {
		UserVo userVo = userService.checkId(user_id);
		if (userVo == null) {
			// 사용 가능
			return "possible";
		} else {
			// 사용 불가능
			return "impossible";
		}
	}

	// 비밀번호 수정 폼
	@RequestMapping(value = "/updatePw", method = RequestMethod.GET)
	public void updatePw() throws Exception {

	}

	// 비밀번호 수정 처리
	@Transactional
	@RequestMapping(value = "/updatePw", method = RequestMethod.POST)
	public String updatePw(String user_pw, String new_pw, HttpServletRequest request, RedirectAttributes rttr)
			throws Exception {
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		// 비번 체크
		boolean result = userService.checkByIdAndPw(user_id, user_pw);
		if (result == true) {
			rttr.addFlashAttribute("message", "success");
			userService.updatePw(user_id, new_pw);
			return "redirect:/user/profile?user_id=" + user_id;
		}
		rttr.addFlashAttribute("message", "fail_pw");
		return "redirect:/user/updatePw";
	}

	// 회원 탈퇴 폼
	@RequestMapping(value = "/secession", method = RequestMethod.GET)
	public void secessionUserGet() throws Exception {
	}

	// 회원 탈퇴 처리
	@RequestMapping(value = "/secession", method = RequestMethod.POST)
	public String secessionUserPost(String user_pw, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		boolean result = userService.checkByIdAndPw(user_id, user_pw);
		if (result == true) {
			userService.secessionUser(user_id);
			return "redirect:/user/secessionSuccess";
		}
		return "redirect:/user/secession";
	}

	// 탈퇴성공 폼
	@RequestMapping(value = "/secessionSuccess", method = RequestMethod.GET)
	public void secessionSuccess() throws Exception {

	}

	// 내가 쓴 후기
	@RequestMapping(value = "/myReviewList", method = RequestMethod.GET)
	public String myReviewList(Model model, HttpServletRequest request, myReviewPagingDto pagingDto) throws Exception {
		HttpSession session = request.getSession();
		String user_id = (String) session.getAttribute("user_id");
		pagingDto.setUser_id(user_id);
		// 후기 리스트 페이징
		pagingDto.setmyReviewPageInfo();
		int totalCount = userService.getCount(pagingDto);
		pagingDto.setTotalCount(totalCount);
		List<ReviewVo> reviewList = userService.myReviewList(pagingDto);
		model.addAttribute("pagingDto", pagingDto);
		model.addAttribute("reviewList", reviewList);
		return "/user/myReviewList";
	}
	
	//비밀번호 찾기 폼
	@RequestMapping(value = "/findPw", method = RequestMethod.GET)
	public void findPwGet()throws Exception{
		
	}
	

}
