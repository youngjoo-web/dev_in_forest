package com.devinforest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.devinforest.service.MemberService;
import com.devinforest.vo.LoginMember;
import com.devinforest.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	//이메일 중복체크
	@PostMapping("/checkMemberEmail")
	public String checkMemberEmail(HttpSession session, Model model, LoginMember loginMember) {
		String confirmMemberEmail = memberService.CheckMemberEmail(loginMember);
		if(confirmMemberEmail != null) {//일치하는데이터가 있음
			model.addAttribute("EmailMsg", "사용중인 이메일입니다.");
			loginMember.setMemberEmail("");
		}else {//일치하는데이터가 없음
			model.addAttribute("EmailMsg", "사용가능한 이메일입니다..");
		}
		model.addAttribute("NameMsg", "");
		model.addAttribute("loginMember", loginMember);
		return "member/addMember";
	}
	//닉네임 중복체크
	@PostMapping("/checkMemberName")
	public String checkMemberName(HttpSession session, Model model, LoginMember loginMember) {
		String confirmMemberName = memberService.CheckMemberName(loginMember);
		if(confirmMemberName != null) {//일치하는데이터가 있음
			model.addAttribute("NameMsg", "사용중인 닉네임입니다.");
			loginMember.setMemberName("");
		}else {//일치하는데이터가 없음
			model.addAttribute("NameMsg", "사용가능한 닉네임입니다..");
		}
		model.addAttribute("EmailMsg", "");
		model.addAttribute("loginMember", loginMember);
		return "member/addMember";
	}
	//회원가입 폼으로 이동
	@GetMapping("/addMember")
	public String addMember(HttpSession session, Model model) {
		//로그인 중일때
		if(session.getAttribute("loginMember")!=null) {
			return "redirect:/";
		}
		LoginMember loginMember = new LoginMember();
		model.addAttribute("NameMsg", "");
		model.addAttribute("EmailMsg", "");
		model.addAttribute("loginMember", loginMember);
		return "member/addMember";
	}
	//회원가입 액션
	@PostMapping("/addMember")
	public String addMember(LoginMember loginMember, HttpSession session, Model model) {
		//로그인 중일때
		if(session.getAttribute("loginMember")!=null) {
			return "redirect:/";
		}
		memberService.addMember(loginMember);
		model.addAttribute("loginMember", loginMember);
		return "redirect:/index";
		
	}
	//로그인 폼으로 이동
	@GetMapping("/memberLogin")
	public String memberLogin(HttpSession session) {
		//로그인 중일때
		if(session.getAttribute("loginMember")!=null) {
			return "redirect:/";
		}
		
		return "member/memberLogin";
	}
	//로그인 액션
	@PostMapping("/memberLogin")
	public String memberLogin(HttpSession session,LoginMember loginMember) {
		//로그인 중일때
		if(session.getAttribute("loginMember")!=null) {
			return "redirect:/";
		}
		LoginMember returnLoginMember = memberService.memberLogin(loginMember);
		
		System.out.println("loginMember-->"+loginMember);
		System.out.println("returnloginMember-->"+returnLoginMember);
		if(returnLoginMember == null) {
			System.out.println("로그인실패");
			return "member/memberLogin";
		}else {
			session.setAttribute("loginMember", returnLoginMember);
			System.out.println("로그인성공");
			return "redirect:/home";
		}
	}
	//로그인 아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/";
		}
		session.invalidate();
		return "redirect:/index";
	}
}
