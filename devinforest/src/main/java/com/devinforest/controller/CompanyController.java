package com.devinforest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.devinforest.service.CompanyService;
import com.devinforest.vo.Admin;
import com.devinforest.vo.Company;
import com.devinforest.vo.LoginCompany;
import com.devinforest.vo.LoginMember;
import com.devinforest.vo.Member;

@Controller
public class CompanyController {
	@Autowired	
	private CompanyService companyService;
	//기업 로그인폼
	/*@GetMapping("/memberLogin")
	public String companyLogin(HttpSession session) {
		//로그인 중일때
		if(session.getAttribute("loginMember")!=null) {
				return "redirect:/index";
		}
		return "member/memberLogin";
	}
	@PostMapping("/memberLogin")
	public String memberLogin(HttpSession session,LoginCompany loginCompany) {
		//로그인 중일때
		if(session.getAttribute("loginMember")!=null) {
			return "redirect:/index";
		}
		LoginCompany returnLoginCompany=companyService.companyLogin(loginCompany);
		System.out.println("loginCompamy-->"+loginCompany);
		System.out.println("returnloginCompany-->"+returnLoginCompany);
		if(returnLoginCompany == null) {
			System.out.println("로그인실패");
			//회원로그인 실패시 관리자 서비스 로그인 시도 
			return "member/memberLogin";
		}
		returnLoginMember.setMemberPassword("");//비밀번호 지워주기!!
		//로그인 회원 종류 구별
		//일반회원
		if(returnLoginMember.getAccountKind().equals("M")) {
			
			Member member = memberService.getMemberInfo(returnLoginMember);
			returnLoginMember.setMemberReputation(member.getMemberReputation());
			System.out.println(returnLoginMember+"<-------로그인 컨트롤러 액션");	
			session.setAttribute("loginMember", returnLoginMember);
			System.out.println("로그인성공");
			return "index/home";
			
			
		}
		if(returnLoginMember.getAccountKind().equals("A")) {
			System.out.println(returnLoginMember+"<-------로그인 컨트롤러 액션");	
			session.setAttribute("loginMember", returnLoginMember);
			System.out.println("로그인성공");
			return "admin/adminHome";
		}
		if(returnLoginMember.getAccountKind().equals("C")) {
			System.out.println(returnLoginMember+"<-------로그인 컨트롤러 액션");	
			
			session.setAttribute("loginMember", returnLoginMember);
			System.out.println("로그인성공");
			return "index/companyHome";
		}
		else {
			return "redirect:/index";
		}
	}*/
	//기업 회원가입 폼
	@GetMapping("/addCompanyMember")
	public String addCompanyMember(HttpSession session) {
		if(session.getAttribute("loginMember")!=null) {
			return "redirect:/companyhome";
		}
		return "company/addCompanyMember";
	}
	//기업 회원가입 액션
	@PostMapping("addCompanyMember")
	public String addAdmin(HttpSession session, Company company) {
		System.out.println(company+" <- AdminController.addAdmin: admin");
		String companyEmail = company.getCompanyEmail();
		System.out.println(companyEmail+" <- CompanyController.addCompany: companyEmail");
		company.setCompanyEmail(companyEmail);
		companyService.addCompanyMember(company);
		return "redirect:/index";
	}
}
