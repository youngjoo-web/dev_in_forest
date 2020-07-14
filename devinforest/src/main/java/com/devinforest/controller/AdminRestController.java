package com.devinforest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devinforest.service.AdminQuestionService;
import com.devinforest.service.AdminService;
import com.devinforest.vo.Question;

@RestController
public class AdminRestController {
	@Autowired private AdminService adminService;
	@Autowired private AdminQuestionService adminQuestionService;
	// 아이디 중복체크
	@PostMapping("/checkAdminEmail")
	public String checkAdminEmail(HttpSession session, 
								@RequestParam(value = "adminEmail2") String checkAdminEmail) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(checkAdminEmail + " <- AdminRestController.checkAdminEmail: checkAdminEmail");
		
		String email = "@devinforest.com";
		String adminEmail = checkAdminEmail + email;
		System.out.println(adminEmail + " <- AdminRestController.checkAdminEmail: adminEmail");
		
		int checkNum = adminService.checkAdminEmail(adminEmail);
		System.out.println(checkNum + " <- AdminRestController.checkAdminEmail: checkNum");
		
		String emailMsg = null;
		if(checkNum == 1) {
			emailMsg = "사용할 수 없는 이메일입니다.";
		} else {
			emailMsg = "사용가능한 이메일입니다.";
		}
		System.out.println(emailMsg + " <- AdminRestController.checkAdminEmail: emailMsg");
		
		return emailMsg;
	}
	// 닉네임 중복체크
	@PostMapping("/checkAdminName")
	public String checkAdminName(HttpSession session, 
								@RequestParam(value = "adminName2") String adminName) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(adminName + " <- AdminRestController.checkAdminName: adminName");

		int checkNum = adminService.checkAdminName(adminName);
		System.out.println(checkNum + " <- AdminRestController.checkAdminName: checkNum");
		
		String nameMsg = null;
		if(checkNum == 1) {
			nameMsg = "사용할 수 없는 닉네임입니다.";
		} else {
			nameMsg = "사용가능한 닉네임입니다.";
		}
		System.out.println(nameMsg + " <- AdminRestController.checkAdminName: nameMsg");
		
		return nameMsg;
	}
}
