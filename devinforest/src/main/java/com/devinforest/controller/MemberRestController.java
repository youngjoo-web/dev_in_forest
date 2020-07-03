package com.devinforest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devinforest.service.MemberService;

@RestController
public class MemberRestController {
	@Autowired private MemberService memberService;
	
	@PostMapping("/checkMemberEmail")
	public String checkMemberEmail(@RequestParam(value = "memberEmail2") String memberEmail) {
		int checkNum = memberService.CheckMemberEmail(memberEmail);
		String emailMsg = null;
		if(checkNum == 1) {
			emailMsg = "사용할 수 없는 이메일입니다.";
		} else {
			emailMsg = "사용가능한 이메일입니다.";
		}
		return emailMsg;
	}
	
	@PostMapping("/checkMemberName")
	public String checkMemberName(@RequestParam(value = "memberName2") String memberName) {
		int checkNum = memberService.CheckMemberName(memberName);
		
		String nameMsg = null;
		if(checkNum == 1) {
			nameMsg = "사용할 수 없는 닉네임입니다.";
		} else {
			nameMsg = "사용가능한 닉네임입니다.";
		}
		return nameMsg;
	}
}
