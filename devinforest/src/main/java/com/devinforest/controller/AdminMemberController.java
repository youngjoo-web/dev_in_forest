package com.devinforest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.devinforest.service.AdminMemberService;

@Controller
public class AdminMemberController {
	@Autowired private AdminMemberService adminMemberService;
}
