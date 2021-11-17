package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {
	
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response)
	{
		int num1=Integer.parseInt(request.getParameter("t1"));
		int num2=Integer.parseInt(request.getParameter("t2"));
		int add=num1+num2;
		//request.setAttribute("addition", add);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("addition",add);
		return mv;
	}

}
