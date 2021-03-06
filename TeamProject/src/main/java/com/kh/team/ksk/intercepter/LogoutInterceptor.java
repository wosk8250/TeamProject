package com.kh.team.ksk.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogoutInterceptor extends HandlerInterceptorAdapter {

	//이전 수행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
		//로그인 되어있지 않은 상태
		if (user_id == null || user_id.equals("")) {
			System.out.println(" 유저 인터셉트(로그인 페이지로)");
			String uri = request.getRequestURI();//가려고 했던 페이지
			String queryString = request.getQueryString();
			String tergetLoction = uri;
			if(queryString != null) {
				tergetLoction += "?" + queryString;
			}
			session.setAttribute("tergetLoction", tergetLoction);
			response.sendRedirect("/user/login");
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
