package com.devinforest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.devinforest.service.SuggestService;
import com.devinforest.vo.Suggest;

@Controller
public class SuggestController {
	@Autowired
	private SuggestService suggestService;
	//면접제의 신청작성하기
	@GetMapping("/addSuggest")
	public String addSuggest(HttpSession session) {
		if(session.getAttribute("loginCompany")==null) {
			return "redirect:/index";
		}
		return "company/addSuggest";
	}
	@PostMapping("/addSuggest")
	public String addSuggest(HttpSession session,Suggest suggest) {
		if(session.getAttribute("loginCompany")==null) {
			return "redirect:/index";
		}
		System.out.println(suggest+"<---addsuggest");
		suggestService.addSuggest(suggest);
		return "company/companyHome";
	}
}
