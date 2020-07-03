package com.devinforest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devinforest.service.CompanyService;
import com.devinforest.service.MemberService;
import com.devinforest.vo.LoginMember;

@RestController
public class CompanyRestController {
	@Autowired private CompanyService companyService;
	@Autowired private MemberService memberService;
	
	@PostMapping("/checkCompanyEmail")
	public String checkCompanyEmail(@RequestParam(value = "companyEmail2") String companyEmail) {
		System.out.println(companyEmail + " <- CompanyRestController.checkCompanyEmail: checkCompanyEmail");
		int checkNum = companyService.checkCompanyEmail(companyEmail);
		System.out.println(checkNum + " <- AdminRestController.checkAdminEmail: checkNum");
		
		String emailMsg = null;
		if(checkNum == 1) {
			emailMsg = "사용할 수 없는 이메일입니다.";
		} else {
			emailMsg = "사용가능한 이메일입니다.";
		}
		System.out.println(emailMsg + " <- CompanyRestController.checkCompanyEmail: emailMsg");
		
		return emailMsg;
	}
	
	@PostMapping("/checkCompanyKorName")
	public String checkCompanyKorName(@RequestParam(value = "companyKorName2") String companyKorName) {
		System.out.println(companyKorName + " <- AdminRestController.checkAdminName: adminName");

		int checkNum = companyService.checkCompanyKorName(companyKorName);
		System.out.println(checkNum + " <- AdminRestController.checkAdminName: checkNum");
		
		String kornameMsg = null;
		if(checkNum == 1) {
			kornameMsg = "사용할 수 없는 닉네임입니다.";
		} else {
			kornameMsg = "사용가능한 닉네임입니다.";
		}
		System.out.println(kornameMsg + " <- AdminRestController.checkAdminName: nameMsg");
		
		return kornameMsg;
	}
	@PostMapping("/checkCompanyEngName")
	public String checkCompanyEngName(@RequestParam(value = "companyEngName2") String companyEngName) {
		System.out.println(companyEngName + " <- AdminRestController.checkAdminName: adminName");

		int checkNum = companyService.checkCompanyEngName(companyEngName);
		System.out.println(checkNum + " <- AdminRestController.checkAdminName: checkNum");
		
		String engnameMsg = null;
		if(checkNum == 1) {
			engnameMsg = "사용할 수 없는 닉네임입니다.";
		} else {
			engnameMsg = "사용가능한 닉네임입니다.";
		}
		System.out.println(engnameMsg + " <- AdminRestController.checkAdminName: nameMsg");
		
		return engnameMsg;
	}
}
