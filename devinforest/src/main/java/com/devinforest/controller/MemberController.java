package com.devinforest.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.mapper.MemberMapper;
import com.devinforest.service.MemberService;
import com.devinforest.vo.LoginMember;
import com.devinforest.vo.Member;
import com.devinforest.vo.Restoration;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	//회원 재가입 요청
	@GetMapping("/requestMemberRestore")
	public String requestMemberRestore(HttpSession session) {
		if(session.getAttribute("loginMember")!=null) {
			return "redirect:/index";
		}
		return "member/requestMemberRestore";
	}
	@PostMapping("/requestMemberRestore")
	public String requestMemberRestore(HttpSession session, Restoration restoration) {
		if(session.getAttribute("loginMember")!=null) {
			return "redirect:/index";
		}
		memberService.addrequestRestoreMember(restoration);
		System.out.println(restoration+"<---post controller restoration");
		return "index/index";
	}
	//회원비밀번호 찾기
	@GetMapping("/findMemberPw")
	public String findMemberPw(HttpSession session) {
		if(session.getAttribute("loginMember")!=null) {
			return "redirect:/index";
		}
		return "member/findMemberPw";
	}
	@PostMapping("/findMemberPw")
	public String findMemberPw(HttpSession session,LoginMember loginMember, Model model) {
		if(session.getAttribute("loginMember")!=null) {
			return "redirect:/index";
		}
		memberService.findMemberPw(loginMember);
		model.addAttribute("msg","병경된 비밀번호를 이메일로 보냈습니다.");
		return "member/findMemberPw";
	}
	//회원이메일 찾기
	@GetMapping("/findMemberEmail")
	public String findMemberEmail(HttpSession session,LoginMember loginMember) {
		if(session.getAttribute("loginMember")!=null) {
			return "redirect:/index";
		}
		return "member/findMemberEmail";
	}
	//회원이메일 찾기 액션
	@PostMapping("/findMemberEmail")
	public String findMemberEmail(HttpSession session,Model model,Member member) {
		
		if(session.getAttribute("loginMember")!=null) {
			return "redirect:/index";
		}
		String findEmail = memberService.findMemberEmail(member);
		if(findEmail == null) {
			model.addAttribute("msg","이메일을 찾을 수 없습니다.");
		}else {
			model.addAttribute("msg",findEmail);
		}
		return "member/findMemberEmail";
	}
	//회원목록
		@GetMapping("/getMemberList")
		public String getMemberList(HttpSession session, Model model,
				   @RequestParam(defaultValue = "1") int currentPage,
				   @RequestParam(defaultValue = "5") int rowPerPage,
				   @RequestParam(defaultValue = "") String searchWord) {
			if(session.getAttribute("loginMember")==null) {
				return "redirect:/index";
			}
			Map<String, Object> map = memberService.getMemberList(currentPage, rowPerPage, searchWord);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("rowPerPage", rowPerPage);
			model.addAttribute("searchWord", searchWord);
			model.addAttribute("memberTotalCount", map.get("memberTotalCount"));
			model.addAttribute("lastPage", map.get("lastPage"));
			model.addAttribute("memberList", map.get("memberList"));
			return "member/memberList";
		}
	
	//회원탈퇴
	@GetMapping("/removeMember")
	public String removeMember(HttpSession session,Model model,LoginMember loginMember) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/index";
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
			return "redirect:/index";
		}
		return "member/memberPwCheck";
	}
	@GetMapping("/memberPwCheck")
	public String memberPwCheck(HttpSession session,LoginMember loginMember,Model model) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/index";
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
			return "redirect:/index";
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
			return "redirect:/index";
		}
		Member member = new Member();
		member=memberService.getMemberInfo(loginMember);
		model.addAttribute("member",member);
		return "member/memberInfo";
	}
	//이메일 중복체크
	/*@PostMapping("/checkMemberEmail")
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
		}*/
	//회원가입 폼으로 이동
	@GetMapping("/addMember")
	public String addMember(HttpSession session, Model model) {
		//로그인 중일때
		if(session.getAttribute("loginMember")!=null) {
			return "redirect:/index";
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
			return "redirect:/index";
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
			return "redirect:/index";
		}
		
		return "member/memberLogin";
	}
	//로그인 액션
	@PostMapping("/memberLogin")
	public String memberLogin(HttpSession session,LoginMember loginMember) {
		//로그인 중일때
		if(session.getAttribute("loginMember")!=null) {
			return "redirect:/index";
		}
		LoginMember returnLoginMember = memberService.memberLogin(loginMember);
		
		System.out.println("loginMember-->"+loginMember);
		System.out.println("returnloginMember-->"+returnLoginMember);
		if(returnLoginMember == null) {
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
			return "company/companyHome";
		}
		else {
			return "redirect:/index";
		}
	}
	//로그인 아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/index";
		}
		session.invalidate();
		return "redirect:/index";
	}
	
}
