package com.devinforest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.devinforest.IPUtil;
import com.devinforest.service.FAQService;

@Controller
public class FAQController {
	@Autowired private FAQService faqService;
	
	@GetMapping("/getFAQList")
	public String getFAQList() {
		String getIp = IPUtil.getIPAddress();
		System.out.println(getIp + " <-- FAQController.getFAQList: getIp");
		return "FAQ/getFAQList";
	}
}
