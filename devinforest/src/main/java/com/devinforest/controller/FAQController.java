package com.devinforest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.service.FAQService;
import com.devinforest.vo.Notice;

@Controller
public class FAQController {
	@Autowired private FAQService faqService;
	String admin = "admin@devinforest.com";
	
	// FAQList 출력
	@GetMapping("/getFAQList")
	public String getFAQList(Model model,
							@RequestParam(defaultValue = "") String searchWord,
							@RequestParam(defaultValue = "1") int currentPage,
							@RequestParam(defaultValue = "5") int rowPerPage) {
		System.out.println(searchWord + " <-- FAQController.getFAQList: searchWord");
		
		Map<String, Object> map = faqService.getFAQList(searchWord, currentPage, rowPerPage);
		
		System.out.println(map.get("FAQTotalCount") + " <-- FAQController.getFAQList: map.get(\"FAQTotalCount\")");
		model.addAttribute("FAQList", map.get("FAQList"));
		model.addAttribute("FAQTotalCount", map.get("FAQTotalCount"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		return "FAQ/getFAQList";
	}
	// FAQ 추가
	@GetMapping("/addFAQ")
	public String addFAQ(Model model) {
		model.addAttribute("admin", admin);
		return "FAQ/addFAQ";
	}
	@PostMapping("/addFAQ")
	public String addFAQ(Model model, Notice notice) {
		System.out.println(notice + " <-- FAQController.addFAQ(post): notice");
		model.addAttribute("admin", admin);
		return "FAQ/addFAQ";
	}
}
