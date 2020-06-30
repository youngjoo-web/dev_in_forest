package com.devinforest.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.devinforest.service.AdminService;
import com.devinforest.vo.Admin;

@Controller
public class AdminController {
	@Autowired private AdminService adminService;
	
	// 관리자 목록 출력
	@GetMapping("/getAdminList")
	public String getAdminList(HttpSession session, Model model) {
			List<Admin> adminList = adminService.getAdminList();
			model.addAttribute("adminList", adminList);
			/*
			for(Admin a : adminList) {
				System.out.println(a);
			}
			*/
		return "admin/getAdminList";
	}
	
	// 관리자 추가
	@GetMapping("/addAdmin")
	public String addAdmin(HttpSession session) {
		return "admin/addAdmin";
	}
	@PostMapping("/addAdmin")
	public String addAdmin(HttpSession session, Admin admin) {
		System.out.println(admin+" <- AdminController.addAdmin: admin");
		adminService.addAdmin(admin);
		return "redirect:/getAdminList";
	}
}
