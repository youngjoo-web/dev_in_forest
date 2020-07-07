package com.devinforest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.service.AdminMemberService;
import com.devinforest.vo.BlackList;

@Controller
public class AdminMemberController {
	@Autowired private AdminMemberService adminMemberService;
	
	// 회원 블랙 팝업창
	@GetMapping("/black")
	public String black(Model model,
						@RequestParam(value = "memberName") String memberName) {
		System.out.println(memberName + " <-- ReportController.black: memberName");
		
		String email = adminMemberService.blackMemberOne(memberName);
		model.addAttribute("memberEmail", email);
		model.addAttribute("memberName", memberName);
		return "report/black";
	}
	// 회원 블랙 실행
	@PostMapping("/black")
	public String black(BlackList blackList) {
		System.out.println(blackList + " <-- ReportController.black: blackList");
		adminMemberService.removeMember(blackList);
		return "redirect:/done";
	}
	// 블랙 완료 창
	@GetMapping("/done")
	public String done() {
		return "report/done";
	}
}
