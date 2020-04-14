package com.techelevator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@Controller
public class MapAPIController {

	private String apiKey = "AIzaSyBvxfdPSYjCtOO_vyW3KGAIF2SzpKNgnGA";
	
	@RequestMapping(path="/maptest", method = RequestMethod.GET)
	public String displayMapTest(ModelMap map) {
		
		map.addAttribute("apiKey", apiKey);
		
		return "mapTest";
	}
	
}
