package com.kh.team.ksk.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	//이전 수행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
			String uri = request.getRequestURI();
			String Loction = "";
			int last = uri.lastIndexOf("/");
			String subString = uri.substring(1, last);
			if(subString.equals("camp")) {
				Loction = subString;
				if(uri.equals("/camp/main")) {
					Loction = "main";
				} else if(uri.equals("/camp/home")) {
					Loction = "home";
				}
			} else {
				Loction = subString;
			}
			session.setAttribute("Loction", Loction);
		return true;// 가로채기한 요청 계속 수행, false- 수행중지
	}
	
	//나중에 수행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
}
