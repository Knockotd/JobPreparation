package com.gmail.aisdugo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PeoplesController {

	@RequestMapping(value="/peoples/register", method=RequestMethod.GET)
	//단순 페이지이동. ==> 리턴 없이 생성해도 된다.
	//뷰 이름이 peoples/register가 된다.
	public void register(Model model) {
		
	}
	
}
