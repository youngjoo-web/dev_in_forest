package com.devinforest.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.service.RestorationService;
import com.devinforest.vo.Restoration;

@Controller
public class RestorationController {
	@Autowired private RestorationService restorationService;
	
	// 재가입요청 목록
	@GetMapping("/getRestorationList")
	public String getRestorationList(HttpSession session, Model model,
											@RequestParam(defaultValue = "1") int currentPage,
											@RequestParam(defaultValue = "10") int rowPerPage,
											@RequestParam(defaultValue = "") String searchWord) {
		System.out.println(currentPage+" <- RestorationController.getRestorationList: currentPage");
		System.out.println(searchWord+" <- RestorationController.getRestorationList: searchWord");
		Map<String, Object> map = restorationService.getRestorationList(currentPage, rowPerPage, searchWord);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("restorationTotalCount", map.get("restorationTotalCount"));
		model.addAttribute("inquiryStateTotalCount", map.get("inquiryStateTotalCount"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("restorationList", map.get("restorationList"));
		return "restoration/getRestorationList";
	}
	// 재가입요청 상세보기
	@GetMapping("/getRestorationOne")
	public String getRestorationOne(HttpSession session, Model model, Restoration restoration,
									@RequestParam(defaultValue = "") String memberEmail){
		int restorationNo = restoration.getRestorationNo();
		System.out.println(restorationNo+" <- RestorationController.getRestorationOne: restorationNo");
		Map<String, Object> map = new HashMap<>();
		map = restorationService.getRestorationOne(restorationNo);
		model.addAttribute("checkPoint", map.get("checkPoint"));
		model.addAttribute("restoration", map.get("restoration"));
		if(memberEmail.equals("not")) {
			String msg = "존재하지 않는 회원입니다.";
			model.addAttribute("msg", msg);
		}
		return "restoration/getRestorationOne";
	}
	// 재가입 실행
	@PostMapping("/restorationExecution")
	public String restorationExecution(HttpSession session, Restoration restoration){
		int restorationNo = restoration.getRestorationNo();
		System.out.println(restorationNo+" <- RestorationController.getRestorationOne: restorationNo");
		String memberEmail = restoration.getRestorationTitle();
		System.out.println(memberEmail+" <- RestorationController.getRestorationOne: memberEmail");
		int checkNum = restorationService.restorationExecution(restorationNo, memberEmail);
		if(checkNum==1) {
			return "redirect:/getRestorationOne?restorationNo="+restorationNo+"&memberEmail=not";
		}
		return "redirect:/getRestorationOne?restorationNo="+restorationNo; 
	}
}
