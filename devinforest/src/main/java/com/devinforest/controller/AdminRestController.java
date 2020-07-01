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
		
		String msg = null;
		if(checkNum == 1) {
			msg = "사용할 수 없는 이메일입니다.";
		} else {
			msg = "사용가능한 이메일입니다.";
		}
		System.out.println(msg + " <- AdminRestController.checkAdminEmail: msg");
		
		return msg;
	}
}
