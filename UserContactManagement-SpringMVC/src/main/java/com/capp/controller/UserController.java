package com.capp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capp.command.LoginCommand;
import com.capp.command.UserCommand;
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
	public String HandleLoginPage(@ModelAttribute("command") LoginCommand cmd,  Model m, HttpSession session)
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
				addLoggedInUserInSession(loggedInUser,session);
				return "redirect:admin/dashboard";
			}
			else if(loggedInUser.getRole().equals(userservice.User_Role)){
				addLoggedInUserInSession(loggedInUser,session);
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
	@RequestMapping(value="/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "redirect:index?act=lo";
	}
	
	@RequestMapping(value="/reg_form")
	public String registerForm(Model m) {
		UserCommand cmd=new UserCommand();
		m.addAttribute("command",cmd);
		return "reg_form";
	}
	@RequestMapping(value="/register")
	public String registerUser(@ModelAttribute("command") UserCommand cmd,Model m) {
		try {
		User user=cmd.getUser();
		user.setRole(UserService.User_Role);
		user.setLoginStatus(UserService.loginStatusActive);
		
		userservice.register(user);
		return "redirect:index?act=reg";
		}
		catch(DuplicateKeyException e) {
			e.printStackTrace();
			m.addAttribute("err","Username is already registered. Please enter another username!");
			return "reg_form";
		}
	}
	
	private void addLoggedInUserInSession(User u, HttpSession session) {
		session.setAttribute("user", u);
		session.setAttribute("userid", u.getUserid());
		session.setAttribute("role", u.getRole());
	}

}
