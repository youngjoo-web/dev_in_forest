package com.devinforest.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.service.AdminQuestionService;
import com.devinforest.vo.LoginAdmin;

@Controller
public class AdminQuestionController {
	@Autowired private AdminQuestionService adminQuestionService;
	
	@GetMapping("/admin/getQuestionList")
	public String getQuestionList(Model model, HttpSession session,
									@RequestParam(defaultValue="1") int currentPage,
									@RequestParam(defaultValue = "5") int rowPerPage,
									@RequestParam(defaultValue="") String searchWord) {
		String memberName = "";
		
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		memberName = ((LoginAdmin)session.getAttribute("loginAdmin")).getAdminName();
		
		Map<String, Object> questionList = adminQuestionService.getQuestionList(currentPage, rowPerPage, searchWord);
		
		System.out.println(memberName+"<--memberName");
		
		model.addAttribute("memberName", memberName);
		model.addAttribute("questionList", questionList.get("questionList"));
		model.addAttribute("questionTotalRow", questionList.get("questionTotalRow"));
		model.addAttribute("lastPage", questionList.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		
		
		System.out.println("↓QuestionController questionList↓");
		System.out.println(questionList.get("questionList") + " <-- QuestionController questionList");
		System.out.println(questionList.get("questionTotalRow") + " <-- QuestionController questionTotalRow");
		System.out.println(questionList.get("lastPage") + " <-- QuestionController lastPage");
		System.out.println(memberName + " <--- QuestionController memberName");
		System.out.println(currentPage + " <--- QuestionController currentPage");
		System.out.println(searchWord + " <--- QuestionController searchWord");
		
		return "adminQuestion/getQuestionList";
	}
}
