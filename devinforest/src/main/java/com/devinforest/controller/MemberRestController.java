package com.devinforest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devinforest.service.MemberService;
import com.devinforest.vo.Member;

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
	@PostMapping("/checkRestoreEmail")
	public String checkRestoreEmail(@RequestParam(value = "restorationTitle2") String restorationTitle) {
		int checkNum=memberService.CheckMemberEmail(restorationTitle);
		String restoreMsg=null;
		if(checkNum==1) {
			restoreMsg = "재가입가능한 이메일입니다.";
		}else {
			restoreMsg = "재가입할 수 없는 이메일입니다.";
		}
		return restoreMsg;
	}
	@PostMapping("/modifyMemberReputation")
	public void modifyMemberReputation(Member member) {
		int updateResult = memberService.modifyMemberReputation(member);
		if(updateResult == 1) {
			System.out.println("내공 갱신 성공");
		} else {
			System.out.println("내공 갱신 실패");
		}
	}
}
