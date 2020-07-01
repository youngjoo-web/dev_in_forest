package com.devinforest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.service.FAQService;

@Controller
public class FAQController {
	@Autowired private FAQService faqService;
	
	@GetMapping("/getFAQList")
	public String getFAQList(Model model,
							@RequestParam(defaultValue = "") String searchWord,
							@RequestParam(defaultValue = "1") int currentPage,
							@RequestParam(defaultValue = "5") int rowPerPage) {
		System.out.println(searchWord + " <-- FAQController.getFAQList: searchWord");
		
		Map<String, Object> map = faqService.getFAQList(searchWord, currentPage, rowPerPage);
		model.addAttribute("FAQList", map.get("FAQList"));
		model.addAttribute("FAQTotalCount", map.get("FAQTotalCount"));
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		return "FAQ/getFAQList";
	}
}
