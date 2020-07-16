package com.devinforest.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.service.CompanyService;
import com.devinforest.service.RecruitService;
import com.devinforest.vo.Admin;
import com.devinforest.vo.Company;
import com.devinforest.vo.LoginCompany;
import com.devinforest.vo.LoginMember;
import com.devinforest.vo.Member;
import com.devinforest.vo.Recruit;

@Controller
public class CompanyController {
	@Autowired	
	private CompanyService companyService;
	@Autowired
	private RecruitService recruitService;
	
	//채용공고 추가
	   @GetMapping("/addRecruit")
	   public String addRecruit(HttpSession session, Model model, String companyEmail) {
	      if(session.getAttribute("loginCompany")==null) {
	         return "redirect:/index";
	      }
	      System.out.println(companyEmail+"<-----addRecruit");
	      LoginCompany loginCompany= new LoginCompany();
	      loginCompany.setCompanyEmail(companyEmail);
	      Company company = companyService.getCompanyInfo(loginCompany);
	      System.out.println(company+"<---addRecruit Class");
	      model.addAttribute("company", company);
	      return "company/addRecruit";
	   }
	   @PostMapping("/addRecruit")
	   public String addRecruit(HttpSession session, Model model,
			   @RequestParam(defaultValue = "1") int currentPage,
			   @RequestParam(defaultValue = "5") int rowPerPage,
			   @RequestParam(defaultValue = "") String searchWord, Recruit recruit) {
	      System.out.println(recruit+"<---addRecruit(Post)");
	      recruitService.addRecruit(recruit);
	      searchWord = recruit.getCompanyKorName();
	      Map<String, Object> map = recruitService.getRecruitListByCompany(currentPage, rowPerPage, searchWord);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("rowPerPage", rowPerPage);
			model.addAttribute("searchWord", searchWord);
			model.addAttribute("lastPage", map.get("lastPage"));
			model.addAttribute("recruitTotalCount", map.get("recruitTotalCount"));
			model.addAttribute("recruitList", map.get("recruitList"));
	      return "company/getRecruitListByCompany";
	   }
	//기업 목록
	@GetMapping("/getCompanyList")
	public String getCompanyList(HttpSession session, Model model,
				   @RequestParam(defaultValue = "1") int currentPage,
				   @RequestParam(defaultValue = "5") int rowPerPage,
				   @RequestParam(defaultValue = "") String searchWord) {
		Map<String, Object> map = companyService.getCompanyList(currentPage, rowPerPage, searchWord);
		System.out.println(map.get("companyList"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("companyTotalCount", map.get("companyTotalCount"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("companyList", map.get("companyList"));
		
		
		if(session.getAttribute("loginMember")==null) {
			String memberName = "Guest";
			model.addAttribute("memberName", memberName);
			return "company/companyListForGuest";
		}
		
		return "member/companyList";
	}
	
	
	//기업 회원가입 폼
	@GetMapping("/addCompanyMember")
	public String addCompanyMember(HttpSession session) {
		if(session.getAttribute("loginMember")!=null) {
			return "redirect:/companyhome";
		}
		return "company/addCompanyMember";
	}
	
	
	//기업 회원가입 액션
	@PostMapping("addCompanyMember")
	public String addAdmin(HttpSession session, Company company) {
		System.out.println(company+" <- AdminController.addAdmin: admin");
		String companyEmail = company.getCompanyEmail();
		System.out.println(companyEmail+" <- CompanyController.addCompany: companyEmail");
		company.setCompanyEmail(companyEmail);
		companyService.addCompanyMember(company);
		return "redirect:/index";
	}
	//기업 채용공고 보기
	@GetMapping("/getRecruitListByCompany")
	public String getRecruitListByCompany(HttpSession session,Model model,
			   @RequestParam(defaultValue = "1") int currentPage,
			   @RequestParam(defaultValue = "5") int rowPerPage,String searchWord) {
		if(session.getAttribute("loginCompany")==null) {
			return "redirect:/index";
		}
		
		Map<String, Object> map = recruitService.getRecruitListByCompany(currentPage, rowPerPage, searchWord);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("recruitTotalCount", map.get("recruitTotalCount"));
		model.addAttribute("recruitList", map.get("recruitList"));
		return "company/getRecruitListByCompany";
	}
	//기업 정보 상세보기
	@GetMapping("/getCompanyInfo")
	public String getCompanyInfo(HttpSession session,Model model,LoginCompany loginCompany) {
		System.out.println();
		Company company = new Company();
		company=companyService.getCompanyInfo(loginCompany);
		System.out.println(company+"<---company");
		model.addAttribute("company", company);
		if(session.getAttribute("loginCompany")!=null) {	
			return "company/companyInfo";
		}
		if(session.getAttribute("loginMember")!=null) {
			return "member/getCompanyInfo";
		}
		
		return "redirect:/index";
	}
	
	
	//비밀번호 일치하면 수정폼으로 이동
	@GetMapping("/modifyCompany")
	public String modifyCompany(HttpSession session) {
		if(session.getAttribute("loginCompany")==null) {
			return "redirect:/index";
		}
		return "company/companyPwCheck";
	}
	
	
	//기업 정보 수정
	@PostMapping("/modifyCompany")
	public String modifyCompany(HttpSession session, Model model, Company company) {
		if(session.getAttribute("loginCompany")==null) {
			return "redirect:/index";
		}
		System.out.println(company+"<----modifyCompany");
		companyService.modifyCompany(company);
		model.addAttribute("company", company);
		return "company/companyInfo";
	}
	
	
	//수정폼 이동하기전 비밀번호확인 메서드
	@GetMapping("/companyPwCheck")
	public String companyPwCheck(HttpSession session,Model model, LoginCompany loginCompany) {
		if(session.getAttribute("loginCompany")==null) {
			return "redirect:/index";
		}
		System.out.println(loginCompany+"<---companyPwCheck");
		Company company = new Company();
		company=companyService.getCompanyInfo(loginCompany);
		company.setCompanyPw(loginCompany.getCompanyPw());
		System.out.println(company+"<---company");
		model.addAttribute("company", company);
		int pwCheckNo = companyService.checkCompanyPw(loginCompany);
		if(pwCheckNo==0) {
			return "company/companyInfo";
		}
		return "company/modifyCompany";
		
		
	}
	
	
	//비밀번호 일치하면 기업회원탈퇴
	@GetMapping("/removeCompany")
	public String removeCompany(HttpSession session) {
		if(session.getAttribute("loginCompany")==null) {
			return "redirect:/index";
		}
		return "company/removeCompany";
	}
	@PostMapping("/removeCompany")
	public String removeCompany(HttpSession session, LoginCompany loginCompany) {
		if(session.getAttribute("loginCompany")==null) {
			return "redirect:/index";
		}
		Company company = companyService.getCompanyInfo(loginCompany);
		companyService.removeCompany(company);
		session.invalidate();
		return "redirect:/index";
	}
}
