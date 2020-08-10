package com.kh.team.ksk.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class adminInterceptor extends HandlerInterceptorAdapter {

	//이전 수행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		String checkAdmin = (String)session.getAttribute("checkAdmin");
		
		//관리자 인터셉트
		if (user_id == null || user_id.equals("")) { // 세션에 아이디가 없을때
			response.sendRedirect("/camp/main");
			return false;
		} else 	if (!checkAdmin.equals("9")) {// 세션에 admin이 없을때
			response.sendRedirect("/camp/main");
			return false;
		}
		return true;
	}
	
	//이후 수행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
}
