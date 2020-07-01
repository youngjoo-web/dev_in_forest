package com.devinforest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.devinforest.mapper.MemberMapper;
import com.devinforest.service.MemberService;
import com.devinforest.vo.LoginMember;
import com.devinforest.vo.Member;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	//회원탈퇴
	@GetMapping("/removeMember")
	public String removeMember(HttpSession session,Model model,LoginMember loginMember) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/";
		}
		Member member = memberService.getMemberInfo(loginMember);
		model.addAttribute("member", member);
		return "member/removeMember";
	}
	@PostMapping("/removeMember")
	public String removeMember(HttpSession session,LoginMember loginMember) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/";
		}
		memberService.removeMember(loginMember);
		session.invalidate();
		return "redirect:/index";
	}
	//비밀번호 일치하면 수정폼으로 이동
	//회원정보 수정
	@GetMapping("/modifyMember")
	public String modifyMember(HttpSession session) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/";
		}
		return "member/memberPwCheck";
	}
	@GetMapping("/memberPwCheck")
	public String memberPwCheck(HttpSession session,LoginMember loginMember,Model model) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/";
		}
		LoginMember returnLoginMember = memberService.memberLogin(loginMember);
		
		System.out.println("loginMember-->"+loginMember);
		System.out.println("returnloginMember-->"+returnLoginMember);
		if(returnLoginMember == null) {
			System.out.println("비밀번호 인증실패");
			return "index/home";
		}else {
			session.setAttribute("loginMember", returnLoginMember);
			System.out.println("로그인성공");
			Member member = new Member();
			member=memberService.getMemberInfo(loginMember);
			member.setMemberPassword(loginMember.getMemberPassword());
			model.addAttribute("member",member);
			return "member/modifyMember";
		}
	}
	@PostMapping("/modifyMember")
	public String modifyMember(HttpSession session,Member member,Model model) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/";
		}
		memberService.modifyMember(member);
		Member modifiedMember = new Member();
		LoginMember loginMember = new LoginMember();
		loginMember.setMemberEmail(member.getMemberEmail());
		loginMember.setMemberName(member.getMemberName());
		member=memberService.getMemberInfo(loginMember);
		model.addAttribute("member",member);
		return "member/memberInfo";
	}
	//회원정보 상세보기
	@GetMapping("/getMemberInfo")
	public String getMemberInfo(HttpSession session, Model model, LoginMember loginMember) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/";
		}
		Member member = new Member();
		member=memberService.getMemberInfo(loginMember);
		model.addAttribute("member",member);
		return "member/memberInfo";
	}
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
	//수정닉네임 중복체크
		@PostMapping("/checkModifyMemberName")
		public String checkModifyMemberName(HttpSession session, Model model, LoginMember loginMember) {
			String confirmMemberName = memberService.CheckMemberName(loginMember);
			if(confirmMemberName != null) {//일치하는데이터가 있음
				model.addAttribute("NameMsg", "사용중인 닉네임입니다.");
				loginMember.setMemberName("");
			}else {//일치하는데이터가 없음
				model.addAttribute("NameMsg", "사용가능한 닉네임입니다..");
			}
			
			model.addAttribute("loginMember", loginMember);
			return "member/modifyMember";
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
