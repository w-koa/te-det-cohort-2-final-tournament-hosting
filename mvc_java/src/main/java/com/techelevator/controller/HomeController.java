package com.techelevator.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.model.UserModel.User;

@Controller
public class HomeController {
	
	@RequestMapping(path= {"/", "/home"}, method = RequestMethod.GET)
	public String homeDisplay(ModelMap map, HttpSession session) {
		
		User currentUser = (User) session.getAttribute("currentUser");
		map.addAttribute("currentUser", currentUser);
		
		return "home";
	}

}
