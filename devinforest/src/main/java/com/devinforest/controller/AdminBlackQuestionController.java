package com.devinforest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.devinforest.service.AdminBlackQuestionService;

@Controller
public class AdminBlackQuestionController {
	@Autowired private AdminBlackQuestionService adminBlackQuestionService;
	
}
