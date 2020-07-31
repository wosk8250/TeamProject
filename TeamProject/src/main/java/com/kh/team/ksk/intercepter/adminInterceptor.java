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
		String checkAdmin = (String)session.getAttribute("checkAdmin");
		System.out.println("checkAdmin : " + checkAdmin);
		//로그인 되어있지 않은 상태
		if (!checkAdmin.equals("9")) {
			System.out.println("인터셉트(메인 페이지로) : " + checkAdmin);
			response.sendRedirect("/camp/home");
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
