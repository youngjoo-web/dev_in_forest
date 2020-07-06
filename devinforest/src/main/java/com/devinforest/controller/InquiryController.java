package com.devinforest.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.service.InquiryService;

@Controller
public class InquiryController {
	@Autowired private InquiryService inquiryService;
	// 문의사항 목록
	@GetMapping("/getInquiryList")
	public String getInquiryList(HttpSession session, Model model,
								@RequestParam(defaultValue = "1") int currentPage,
								@RequestParam(defaultValue = "1") int rowPerPage,
								@RequestParam(defaultValue = "") String searchWord) {
		System.out.println(currentPage+" <- InquiryController.getInquiryList: currentPage");
		
		Map<String, Object> map = inquiryService.selectInquiryList(currentPage, rowPerPage, searchWord);
		model.addAttribute("inquiryList", map.get("inquiryList"));
		model.addAttribute("inquiryTotalCount", map.get("inquiryTotalCount"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("searchWord", searchWord);
		return "inquiry/getInquiryList";
	}
}
