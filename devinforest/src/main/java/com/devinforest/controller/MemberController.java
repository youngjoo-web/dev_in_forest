package com.devinforest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.devinforest.service.MemberService;
import com.devinforest.vo.LoginMember;
import com.devinforest.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	@GetMapping("/addMember")
	public String addMember(HttpSession session) {
		
		if(session.getAttribute("loginMember")!=null) {
			return "redirect:/";
		}
		
		return "member/addMember";
	}
	@PostMapping("/addMember")
	public String addMember(LoginMember loginMember, HttpSession session) {
		if(session.getAttribute("loginMember")!=null) {
			return "redirect:/";
		}
		memberService.addMember(loginMember);
		return "redirect:/index";
		
	}
}
