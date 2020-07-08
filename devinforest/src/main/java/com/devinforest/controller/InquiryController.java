package com.devinforest.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.service.InquiryService;
import com.devinforest.vo.Inquiry;

@Controller
public class InquiryController {
	@Autowired private InquiryService inquiryService;
	// 문의사항 목록
	@GetMapping("/getInquiryList")
	public String getInquiryList(HttpSession session, Model model,
								@RequestParam(defaultValue = "1") int currentPage,
								@RequestParam(defaultValue = "10") int rowPerPage,
								@RequestParam(defaultValue = "") String searchWord) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(currentPage+" <- InquiryController.getInquiryList: currentPage");
		
		Map<String, Object> map = inquiryService.getInquiryList(currentPage, rowPerPage, searchWord);
		model.addAttribute("inquiryList", map.get("inquiryList"));
		model.addAttribute("inquiryTotalCount", map.get("inquiryTotalCount"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("searchWord", searchWord);
		return "inquiry/getInquiryList";
	}
	// 문의사항 상세보기
	@GetMapping("/getInquiryOne")
	public String getInquiryOne(HttpSession session, Model model, Inquiry inquiry) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		int inquiryNo = inquiry.getInquiryNo();
		System.out.println(inquiryNo+" <- InquiryController.getInquiryOne: inquiryNo");
		Map<String, Object> map = new HashMap<>();
		map = inquiryService.getInquiryOne(inquiryNo);
		String inquiryAnswer = (String)map.get("inquiryAnswer");
		if(inquiryAnswer != null) {
			System.out.println(inquiryAnswer);
			model.addAttribute("inquiryAnswer", inquiryAnswer);
		}
		model.addAttribute("inquiry", map.get("inquiry"));
		model.addAttribute("checkPoint", map.get("checkPoint"));
		return "inquiry/getInquiryOne";
	}
	// 문의사항 답변작성
	@PostMapping("/addInquiryAnswer")
	public String addInquiryAnswer(HttpSession session, Inquiry inquiry) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(inquiry);
		inquiryService.addInquiryAnswer(inquiry);
		return "redirect:/getInquiryOne?inquiryNo="+inquiry.getInquiryNo();
	}
}
