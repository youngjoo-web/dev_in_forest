package com.devinforest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.devinforest.service.FAQService;

@Controller
public class FAQController {
	@Autowired private FAQService faqService;
}
