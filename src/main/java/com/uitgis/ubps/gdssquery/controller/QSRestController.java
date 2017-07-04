package com.uitgis.ubps.gdssquery.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
class QSRestController {
	
	
	@RequestMapping("/howru")
	String greet(){
		return "Hi! I AM OK";
	}	

}