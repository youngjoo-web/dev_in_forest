package com.devinforest.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.devinforest.service.MemberService;
import com.devinforest.service.RecruitService;
import com.devinforest.service.SuggestService;
import com.devinforest.vo.LoginMember;
import com.devinforest.vo.Member;
import com.devinforest.vo.Recruit;
import com.devinforest.vo.Suggest;

@Controller
public class SuggestController {
	@Autowired
	private SuggestService suggestService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private RecruitService recruitService;
	//면접제의 신청작성하기
	@GetMapping("/addSuggest")
	public String addSuggest(HttpSession session, Suggest suggest, Model model) {
	      if(session.getAttribute("loginCompany")==null) {
	         return "redirect:/index";
	      }
	      List<Recruit>list = recruitService.getRecruitListForSuggest(suggest.getCompanyName());
	      model.addAttribute("recruitList", list);
	      model.addAttribute("suggest", suggest);
	      return "company/addSuggest";
	   }
	@PostMapping("/addSuggest")
	public String addSuggest(HttpSession session,Suggest suggest) {
		if(session.getAttribute("loginCompany")==null) {
			return "redirect:/index";
		}
		System.out.println(suggest+"<---addsuggest");
		suggestService.addSuggest(suggest);
		return "company/companyHome";
	}
	@GetMapping("/suggestList")
	public String suggestList(HttpSession session, String companyName, Model model) {
		if(session.getAttribute("loginCompany")==null) {
			return "redirect:/index";
		}
		System.out.println(companyName+"<---suggestList");
		List<Suggest>list=suggestService.getSuggestListForCompany(companyName);
		model.addAttribute("suggestList", list);
		return "company/suggestList";
	}
	
	@PostMapping("/modifySuggestType")
	public String modifySuggestType(HttpSession session,Suggest suggest,Model model,String suggestType) {
		Member member = new Member();
		LoginMember loginMember = ((LoginMember)session.getAttribute("loginMember"));
		member=memberService.getMemberInfo(loginMember);
		System.out.println(member+"<---member");		
		
		System.out.println(suggest+"<--받아 오는 값modifySuggestType");
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/index";
		}
		if(suggest.getSuggestType().equals("Y")) {
			suggestService.unmodifySuggestType(suggest);
			suggest.setSuggestType("거부");
			System.out.println(suggest+"<--unmodifySuggestType");
			
		}
		if(suggest.getSuggestType().equals("N")) {
			suggestService.modifySuggestType(suggest);
			System.out.println(suggest+"<--modifySuggestType");
			suggest.setSuggestType("수락");
			
		}
		List<Suggest> suggestList = suggestService.getSuggestList(member.getMemberName());
		model.addAttribute("member",member);
		model.addAttribute("suggestList", suggestList );
		return "member/memberInfo";
		
	}
}
