package com.devinforest.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.service.AdminMemberService;
import com.devinforest.vo.BlackList;
import com.devinforest.vo.Company;
import com.devinforest.vo.Member;

@Controller
public class AdminMemberController {
	@Autowired private AdminMemberService adminMemberService;
	// 탈퇴회원 목록
	@GetMapping("/admin/getRemoveMemberList")
	public String getRemoveMemberList(HttpSession session, Model model,
									@RequestParam(defaultValue = "1") int currentPage,
									@RequestParam(defaultValue = "10") int rowPerPage,
									@RequestParam(defaultValue = "") String searchWord) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(currentPage+" <- AdminMemberController.getRemoveMemberList: currentPage");
		System.out.println(searchWord+" <- AdminMemberController.getRemoveMemberList: searchWord");
		Map<String, Object> map = adminMemberService.getRemoveMemberList(currentPage, rowPerPage, searchWord);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("removeMemberTotalCount", map.get("removeMemberTotalCount"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("removeMemberList", map.get("removeMemberList"));
		return "adminMember/getRemoveMemberList";
	}
	// 탈퇴회원 복구
	@PostMapping("/admin/recoveryMember")
	public String recoveryMember(HttpSession session, Member member) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		String memberEmail = member.getMemberEmail();
		System.out.println(memberEmail+" <- AdminMemberController.recoveryMember: memberEmail");
		adminMemberService.recoveryMember(memberEmail);
		return "redirect:/admin/getRemoveMemberList";
	}
	// 기업회원 목록
	@GetMapping("/admin/getCompanyList")
	public String getCompanyList(HttpSession session, Model model,
								@RequestParam(defaultValue = "1") int currentPage,
								@RequestParam(defaultValue = "10") int rowPerPage,
								@RequestParam(defaultValue = "") String searchWord) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(currentPage+" <- AdminMemberController.getCompanyList: currentPage");
		System.out.println(searchWord+" <- AdminMemberController.getCompanyList: searchWord");
		Map<String, Object> map = adminMemberService.getCompanyList(currentPage, rowPerPage, searchWord);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("companyTotalCount", map.get("companyTotalCount"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("companyList", map.get("companyList"));
		return "adminMember/getCompanyList";
	}
	// 기업회원 상세보기
		@GetMapping("/admin/getCompanyInfo")
		public String getCompanyInfo(HttpSession session, Model model, Company company) {
			// 로그인 세션확인
			if(session.getAttribute("loginAdmin")==null) {
				return "redirect:/index";
			}
			String companyEmail = company.getCompanyEmail();
			System.out.println(companyEmail+" <- AdminMemberController.getCompanyInfo: companyEmail");
			company = adminMemberService.getCompanyInfo(companyEmail);
			System.out.println(company+" <- AdminMemberController.getCompanyInfo: company");
			model.addAttribute("company", company);
			return "adminMember/getCompanyInfo";
		}
	
	
	// 회원 블랙 팝업창
	@GetMapping("/blackMember")
	public String blackMember(HttpSession session, Model model,
						@RequestParam(value = "memberName") String memberName) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(memberName + " <-- ReportController.black: memberName");
		
		String email = adminMemberService.blackMemberOne(memberName);
		model.addAttribute("memberEmail", email);
		model.addAttribute("memberName", memberName);
		return "black/addblackMember";
	}
	// 회원 블랙 실행
	@PostMapping("/blackMember")
	public String blackMember(HttpSession session, Model model, BlackList blackList) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(blackList + " <-- ReportController.black: blackList");
		adminMemberService.removeMember(blackList);
		model.addAttribute("check", "check");
		return "black/addblackMember";
	}
	// 블랙 완료 창
	@GetMapping("/done")
	public String done(HttpSession session) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		return "report/done";
	}
	// 블랙 회원 목록
	@GetMapping("/admin/getBlackMemberList")
	public String getBlackMemberList(HttpSession session, Model model,
									@RequestParam(defaultValue = "") String searchWord,
									@RequestParam(defaultValue = "1") int currentPage,
									@RequestParam(defaultValue = "5") int rowPerPage) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(searchWord + " <-- FAQController.getFAQList: searchWord");
		
		Map<String, Object> map = adminMemberService.getBlackMemberList(searchWord, currentPage, rowPerPage);
		System.out.println(map.get("lastPage")+" <- FAQController.getFAQList: lastPage");
		System.out.println(map.get("blackTotalCount") + " <-- FAQController.getFAQList: map.get(\"FAQTotalCount\")");
		model.addAttribute("blackMemberList", map.get("blackMemberList"));
		model.addAttribute("blackTotalCount", map.get("blackTotalCount"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		return "adminMember/getBlackMemberList";
	}
	// 일반회원 목록
	@GetMapping("/admin/getMemberList")
	public String getMemberList(HttpSession session, Model model,
								@RequestParam(defaultValue = "") String searchWord,
								@RequestParam(defaultValue = "1") int currentPage,
								@RequestParam(defaultValue = "5") int rowPerPage) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(searchWord + " <-- AdminMemberController.getMemberList: searchWord");
		
		Map<String, Object> map = adminMemberService.getMemberList(searchWord, currentPage, rowPerPage);
		model.addAttribute("memberList", map.get("memberList"));
		model.addAttribute("memberTotalCount", map.get("memberTotalCount"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		return "adminMember/getMemberList";
	}
	// 일반 회원 상세보기
	@GetMapping("/admin/getMemberInfo")
	public String getMemberInfo(HttpSession session, Model model,
								@RequestParam(value = "memberEmail") String memberEmail) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		Member member = adminMemberService.getMemberInfo(memberEmail);
		model.addAttribute("member", member);
		
		return "adminMember/getMemberInfo";
	}
}