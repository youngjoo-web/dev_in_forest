package com.devinforest.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.service.RecruitService;

@Controller
public class RecruitController {
	@Autowired
	private RecruitService recruitService;
	
	//채용공고 리스트
	@GetMapping("/getRecruitList")
	public String getRecruitList(HttpSession session, 
							   Model model,
							   @RequestParam(defaultValue = "1") int currentPage,
							   @RequestParam(defaultValue = "5") int rowPerPage,
							   @RequestParam(defaultValue = "") String searchWord) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/index";
		}
		Map<String, Object> map = recruitService.getRecruitList(currentPage, rowPerPage, searchWord);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("recruitTotalCount", map.get("recruitTotalCount"));
		model.addAttribute("recruitList", map.get("recruitList"));
		return "member/getRecruitList";
	}
	@GetMapping("/getRecruitInfo")
	public String getRecruitInfo(HttpSession session) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/index";
		}
		return "member/getRecruitInfo";
	}
}
