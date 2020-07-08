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
import com.devinforest.vo.Member;

@Controller
public class AdminMemberController {
	@Autowired private AdminMemberService adminMemberService;
	// 탈퇴 회원 목록
	@GetMapping("/admin/getRemoveMemberList")
	public String getRemoveMemberList(HttpSession session, Model model,
									@RequestParam(defaultValue = "1") int currentPage,
									@RequestParam(defaultValue = "10") int rowPerPage,
									@RequestParam(defaultValue = "") String searchWord) {
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
	// 탈퇴 회원 복구
	@PostMapping("/admin/recoveryMember")
	public String recoveryMember(HttpSession session, Member member) {
		String memberEmail = member.getMemberEmail();
		System.out.println(memberEmail+" <- AdminMemberController.recoveryMember: memberEmail");
		adminMemberService.recoveryMember(memberEmail);
		return "redirect:/admin/getRemoveMemberList";
	}
	// 기업 회원 목록
	@GetMapping("/admin/getCompanyList")
	public String getCompanyList(HttpSession session, Model model,
								@RequestParam(defaultValue = "1") int currentPage,
								@RequestParam(defaultValue = "10") int rowPerPage,
								@RequestParam(defaultValue = "") String searchWord) {
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
	
	// 회원 블랙 팝업창
	@GetMapping("/blackMember")
	public String blackMember(Model model,
						@RequestParam(value = "memberName") String memberName) {
		System.out.println(memberName + " <-- ReportController.black: memberName");
		
		String email = adminMemberService.blackMemberOne(memberName);
		model.addAttribute("memberEmail", email);
		model.addAttribute("memberName", memberName);
		return "black/addblackMember";
	}
	// 회원 블랙 실행
	@PostMapping("/blackMember")
	public String blackMember(BlackList blackList) {
		System.out.println(blackList + " <-- ReportController.black: blackList");
		adminMemberService.removeMember(blackList);
		return "redirect:/done";
	}
	// 블랙 완료 창
	@GetMapping("/done")
	public String done() {
		return "report/done";
	}
	// 블랙 회원 목록
	@GetMapping("/admin/getBlackMemberList")
	public String getBlackMemberList(Model model,
							@RequestParam(defaultValue = "") String searchWord,
							@RequestParam(defaultValue = "1") int currentPage,
							@RequestParam(defaultValue = "5") int rowPerPage) {
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
	// 일반 회원 List 출력
	@GetMapping("/admin/getMemberListForAdmin")
	public String getMemberListForAdmin(Model model,
									@RequestParam(defaultValue = "") String searchWord,
									@RequestParam(defaultValue = "1") int currentPage,
									@RequestParam(defaultValue = "5") int rowPerPage) {
		System.out.println(searchWord + " <-- AdminMemberController.getAdminMemberList: searchWord");
		
		Map<String, Object> map = adminMemberService.getMemberListForAdmin(searchWord, currentPage, rowPerPage);
		System.out.println(map.get("lastPage")+" <- AdminMemberController.getAdminMemberList: lastPage");
		System.out.println(map.get("memberTotalCount") + " <-- AdminMemberController.getAdminMemberList: map.get(\"memberTotalCount\")");
		model.addAttribute("memberList", map.get("memberList"));
		model.addAttribute("memberTotalCount", map.get("memberTotalCount"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		return "adminMember/getMemberListForAdmin";
	}
	// 일반 회원 상세보기
	@GetMapping("/admin/getMemberInfoForAdmin")
	public String getMemberInfoForAdmin(Model model,
										@RequestParam(value = "memberEmail") String memberEmail) {
		
		Member member = adminMemberService.getMemberInfoForAdmin(memberEmail);
		model.addAttribute("member", member);
		
		return "adminMember/getMemberInfoForAdmin";
	}
}