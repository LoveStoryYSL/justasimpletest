package com.xtu.liuli.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor 
{

	@Override
	public boolean preHandle(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("user");
		String uri=request.getRequestURI();
		System.out.println(uri);
		if(uri.endsWith("login")||uri.endsWith("regist"))
		{
			System.out.println("注册或登录请求，予以放行");
			return true;
		}
		if(obj==null)
		{
			System.out.println("用户未登录，被拒绝访问");
			System.out.println("被转发到登录界面");
			String path = request.getContextPath();
			System.out.println(path);
			response.sendRedirect(path+"/jsp/login.jsp");
			return false;
		}
		else
		{
			System.out.println("用户已经登录，允许访问");
			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response,
			Object handler,
			ModelAndView modelAndView) throws Exception 
	{
		
	}
	@Override
	public void afterCompletion(
			HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler, 
			Exception ex)
			throws Exception 
	{
		
	}

}
