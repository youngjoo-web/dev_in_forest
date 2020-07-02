package com.devinforest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.devinforest.service.CompanyService;
import com.devinforest.vo.Admin;
import com.devinforest.vo.Company;

@Controller
public class CompanyController {
	@Autowired	
	private CompanyService companyService;
	
	@GetMapping("/addCompanyMember")
	public String addCompanyMember(HttpSession session) {
		if(session.getAttribute("loginMember")!=null) {
			return "redirect:/companyhome";
		}
		return "company/addCompanyMember";
	}
	@PostMapping("addCompanyMember")
	public String addAdmin(HttpSession session, Company company) {
		System.out.println(company+" <- AdminController.addAdmin: admin");
		String email = "@devinforest.com";
		String companyEmail = company.getCompanyEmail()+email;
		System.out.println(companyEmail+" <- CompanyController.addCompany: companyEmail");
		company.setCompanyEmail(companyEmail);
		companyService.addCompanyMember(company);
		return "redirect:/index";
	}
}
