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
	@GetMapping("/getRemoveMemberList")
	public String getRemoveMemberList(HttpSession session, Model model,
									@RequestParam(defaultValue = "1") int currentPage,
									@RequestParam(defaultValue = "10") int rowPerPage,
									@RequestParam(defaultValue = "") String searchWord) {
		System.out.println(currentPage+" <- RestorationController.getRestorationList: currentPage");
		System.out.println(searchWord+" <- RestorationController.getRestorationList: searchWord");
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
	@PostMapping("/recoveryMember")
	public String recoveryMember(HttpSession session, Member member) {
		String memberEmail = member.getMemberEmail();
		System.out.println(memberEmail+" <- AdminMemberController.recoveryMember: memberEmail");
		adminMemberService.recoveryMember(memberEmail);
		return "redirect:/getRemoveMemberList";
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
	// blackMemberList 출력
	@GetMapping("/getBlackMemberList")
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
}