package com.devinforest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexCotroller {
	@GetMapping({"/", "/index"})
	public String index(HttpSession session) {
		if(session.getAttribute("loginMember")!=null) {
			return "index/home";
		}
		return "index/index";
	}
	@GetMapping("/home")
	public String home(HttpSession session) {
		if(session.getAttribute("loginMember")==null) {
			return "member/memberLogin";
		}
		return "index/home";
	}
}
