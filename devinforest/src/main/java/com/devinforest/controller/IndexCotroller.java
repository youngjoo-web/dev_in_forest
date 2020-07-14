package com.devinforest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexCotroller {
	@GetMapping({"/", "/index"})
	public String index(HttpSession session,Model model) {
		if(session.getAttribute("loginMember")!=null) {
			return "index/home";
		}
		String memberName = "Guest";
		model.addAttribute("memberName", memberName);
		return "index/index";
	}
	@GetMapping("/home")
	public String home(HttpSession session) {
		if(session.getAttribute("loginMember")==null) {
			return "member/memberLogin";
		}
		return "index/home";
	}
	@GetMapping("/companyHome")
	public String companyHome(HttpSession session) {
		if(session.getAttribute("loginCompany")==null) {
			return "member/memberLogin";
		}
		
		return "company/companyHome";
	}
}
