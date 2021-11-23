package com.capp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capp.domain.Contact;
import com.capp.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactservice;
	
	@RequestMapping(value="/user/contact_form")
	public String contactform(Model m) {
		
		Contact contact=new Contact();
		m.addAttribute("command", contact);
		return "contact_form";
	}
	@RequestMapping(value="/user/save_contact")
	public String saveContact(@ModelAttribute("command") Contact c, Model m, HttpSession session) {
		try {
		Integer userid=(Integer) session.getAttribute("userid");
		c.setUserid(userid);
		contactservice.save(c);
		return "redirect:clist?act=sv";
		}catch(Exception e)
		{
			e.printStackTrace();
			m.addAttribute("err","Failed to save COntact");
			return "contact_form";
		}
	}
	@RequestMapping(value="/user/clist")
	public String contactList(Model m) {
		return "clist";
	}

}
