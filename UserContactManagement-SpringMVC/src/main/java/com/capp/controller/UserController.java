package com.capp.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capp.command.LoginCommand;
import com.capp.domain.User;
import com.capp.exception.BlockedUserException;
import com.capp.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@RequestMapping(value={"/","/index"})
	public String indexPage(Model m)
	{
		m.addAttribute("command",new LoginCommand());
		return "index";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String HandleLoginPage(@ModelAttribute("command") LoginCommand cmd,  Model m)
	{
		try {
		User loggedInUser=userservice.login(cmd.getLoginName(), cmd.getPassword());
		if(loggedInUser==null)
		{
			m.addAttribute("err","Login Failed!! Enter Valid Credentials");
			return "index";
		}
		else {
			if(loggedInUser.getRole().equals(userservice.Admin_Role)) {
				return "redirect:admin/dashboard";
			}
			else if(loggedInUser.getRole().equals(userservice.User_Role)){
				return "redirect:user/dashboard";
			}else {
				m.addAttribute("err","Invalid User Role");
				return "index";
			}
		}
			
			
		}catch(BlockedUserException ex) {
			m.addAttribute("err",ex.getMessage());
			return "index";
		}
	}
	@RequestMapping(value="/user/dashboard")
	public String userDashboard()
	{
		return "dashboard_user";
	}
	@RequestMapping(value="/admin/dashboard")
	public String adminDashboard()
	{
		return "dashboard_admin";
	}

}
