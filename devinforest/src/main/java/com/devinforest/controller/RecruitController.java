package com.devinforest.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.service.ApplyService;
import com.devinforest.service.RecruitService;
import com.devinforest.vo.Apply;
import com.devinforest.vo.Recruit;

@Controller
public class RecruitController {
	@Autowired
	private RecruitService recruitService;
	@Autowired
	private ApplyService applyService;
	
	//채용공고 리스트
	@GetMapping("/getRecruitList")
	public String getRecruitList(HttpSession session, 
							   Model model,
							   @RequestParam(defaultValue = "1") int currentPage,
							   @RequestParam(defaultValue = "5") int rowPerPage,
							   @RequestParam(defaultValue = "") String searchWord) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/index";
		}
		Map<String, Object> map = recruitService.getRecruitList(currentPage, rowPerPage, searchWord);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("recruitTotalCount", map.get("recruitTotalCount"));
		model.addAttribute("recruitList", map.get("recruitList"));
		return "member/getRecruitList";
	}
	//채용공고  상세보기
	@GetMapping("/getRecruitInfo")
	public String getRecruitInfo(HttpSession session, Model model,@RequestParam(defaultValue = "1") int currentPage,
			   @RequestParam(defaultValue = "5") int rowPerPage, int recruitNo) {
		Recruit recruit = recruitService.getRecruitInfo(recruitNo);
		model.addAttribute("recruit", recruit);
		if(session.getAttribute("loginMember")!=null) {
			return "member/getRecruitInfo";
		}
		if(session.getAttribute("loginCompany")!=null) {
			
			Map<String, Object> map = applyService.getApplyList(currentPage, rowPerPage, recruitNo);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("rowPerPage", rowPerPage);
			model.addAttribute("lastPage", map.get("lastPage"));
			model.addAttribute("applyTotalCount", map.get("applyTotalCount"));
			model.addAttribute("applyList", map.get("applyList"));
			return "company/getRecruitInfoByCompany";
		}
		return "redirect:/index";
	}
	@PostMapping("/addApply")
	public String addApply(HttpSession session, Model model, Apply apply) {
		Recruit recruit = recruitService.getRecruitInfo(apply.getRecruitNo());
		
		applyService.addApply(apply);
		model.addAttribute("recruit", recruit);
		return "member/getRecruitInfo";
	}
	
}
