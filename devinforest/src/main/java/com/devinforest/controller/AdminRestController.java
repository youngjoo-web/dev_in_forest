package com.devinforest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devinforest.service.AdminService;

@RestController
public class AdminRestController {
	@Autowired private AdminService adminService;
	
	@PostMapping("/checkAdminEmail")
	public String checkAdminEmail(@RequestParam(value = "adminEmail2") String checkAdminEmail) {
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
	
	@PostMapping("/checkAdminName")
	public String checkAdminName(@RequestParam(value = "adminName2") String adminName) {
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
