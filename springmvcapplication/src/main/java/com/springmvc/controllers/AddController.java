package com.springmvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.services.AddService;

@Controller
public class AddController {
	
	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("t1")int num1, @RequestParam("t2")int num2,HttpServletRequest request, HttpServletResponse response)
	{
		//int num1=Integer.parseInt(request.getParameter("t1"));
		//int num2=Integer.parseInt(request.getParameter("t2"));
		AddService as=new AddService();
		int add=as.add(num1, num2);
		//request.setAttribute("addition", add);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("display");
		mv.addObject("addition",add);
		return mv;
	}

}
