package com.devinforest.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.service.FAQService;
import com.devinforest.vo.LoginAdmin;
import com.devinforest.vo.Notice;

@Controller
public class FAQController {
	@Autowired private FAQService faqService;
	
	// FAQList 출력
	@GetMapping("/getFAQList")
	public String getFAQList(HttpSession session, Model model,
							@RequestParam(defaultValue = "") String searchWord,
							@RequestParam(defaultValue = "1") int currentPage,
							@RequestParam(defaultValue = "5") int rowPerPage) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(searchWord + " <-- FAQController.getFAQList: searchWord");
		
		Map<String, Object> map = faqService.getFAQList(searchWord, currentPage, rowPerPage);
		System.out.println(map.get("lastPage")+" <- FAQController.getFAQList: lastPage");
		System.out.println(map.get("FAQTotalCount") + " <-- FAQController.getFAQList: map.get(\"FAQTotalCount\")");
		model.addAttribute("FAQList", map.get("FAQList"));
		model.addAttribute("FAQTotalCount", map.get("FAQTotalCount"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		return "FAQ/getFAQList";
	}
	// FAQ 상세보기
	@GetMapping("/getFAQOne")
	public String getFAQOne(HttpSession session, Model model,
							@RequestParam(value = "noticeNo") int noticeNo) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		Notice FAQ = faqService.getFAQOne(noticeNo);
		model.addAttribute("FAQ", FAQ);
		return "FAQ/getFAQOne";
	}
	
	// FAQ 추가 폼
	@GetMapping("/addFAQ")
	public String addFAQ(HttpSession session, Model model) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		// 로그인부분 구현되면 수정해야하는 부분
		String admin = ((LoginAdmin)(session.getAttribute("loginAdmin"))).getAdminName();
		
		model.addAttribute("admin", admin);
		return "FAQ/addFAQ";
	}
	// FAQ 추가 입력
	@PostMapping("/addFAQ")
	public String addFAQ(HttpSession session, Notice notice) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(notice + " <-- FAQController.addFAQ(post): notice");
		
		// 로그인부분 구현되면 수정해야하는 부분
		String admin = ((LoginAdmin)(session.getAttribute("loginAdmin"))).getAdminName();
		notice.setAdminName(admin);
		
		faqService.addFAQ(notice);
		
		return "redirect:/getFAQList";
	}
	// FAQ 수정 폼
	@PostMapping("/modifyFAQForm")
	public String modifyFAQ(HttpSession session, Model model,
							@RequestParam(value = "noticeNo") int noticeNo) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		Notice FAQ = faqService.getFAQOne(noticeNo);
		// 로그인부분 구현되면 수정해야하는 부분
		String admin = ((LoginAdmin)(session.getAttribute("loginAdmin"))).getAdminName();
		
		model.addAttribute("FAQ", FAQ);
		model.addAttribute("admin", admin);
		return "FAQ/modifyFAQ";
	}
	// FAQ 수정 입력
	@PostMapping("/modifyFAQ")
	public String modifyFAQ(HttpSession session, Notice notice) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(notice + " <-- FAQController.modifyFAQ(post): notice");
		
		faqService.modifyFAQ(notice);
		System.out.println(notice.getNoticeNo());
		
		return "redirect:/getFAQList";
	}
	// FAQ 삭제
	@PostMapping("/removeFAQ")
	public String removeFAQ(HttpSession session,
							@RequestParam(value = "noticeNo") int noticeNo) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(noticeNo + " <-- FAQController.removeFAQ: noticeNo");
		faqService.removeFAQ(noticeNo);
		return "redirect:/getFAQList";
	}
}
