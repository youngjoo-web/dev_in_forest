package com.devinforest.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.service.AdminBlackQuestionService;

@Controller
public class AdminBlackQuestionController {
	@Autowired private AdminBlackQuestionService adminBlackQuestionService;
	
	// 블랙 질문 목록 
	@GetMapping("/admin/getBlackQuestionList")
	public String getBlackQuestionList(HttpSession session, Model model,
										@RequestParam(defaultValue = "1") int currentPage,
										@RequestParam(defaultValue = "10") int rowPerPage,
										@RequestParam(defaultValue = "") String searchWord) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(currentPage+" <- AdminBlackQuestionController.getBlackQuestionList: currentPage");
		System.out.println(searchWord+" <- AdminBlackQuestionController.getBlackQuestionList: searchWord");
		Map<String, Object> map = adminBlackQuestionService.getBlackQuestionList(currentPage, rowPerPage, searchWord);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("blackQuestionTotalCount", map.get("blackQuestionTotalCount"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("blackQuestionList", map.get("blackQuestionList"));
		
		return "adminBlackQuestion/getBlackQuestionList";
	}
	// 블랙 답변 목록
	@GetMapping("/admin/getBlackAnswerList")
	public String getBlackAnswerList(HttpSession session, Model model,
									@RequestParam(defaultValue = "1") int currentPage,
									@RequestParam(defaultValue = "10") int rowPerPage,
									@RequestParam(defaultValue = "") String searchWord) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(currentPage+" <- AdminBlackQuestionController.getBlackAnswerList: currentPage");
		System.out.println(searchWord+" <- AdminBlackQuestionController.getBlackAnswerList: searchWord");
		Map<String, Object> map = adminBlackQuestionService.getBlackAnswerList(currentPage, rowPerPage, searchWord);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("blackAnswerTotalCount", map.get("blackAnswerTotalCount"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("blackAnswerList", map.get("blackAnswerList"));
		
		return "adminBlackQuestion/getBlackAnswerList";
	}
	// 블랙 질문댓글 목록
	@GetMapping("/admin/getBlackQuestionCommentList")
	public String getBlackQuestionCommentList(HttpSession session, Model model,
											@RequestParam(defaultValue = "1") int currentPage,
											@RequestParam(defaultValue = "10") int rowPerPage,
											@RequestParam(defaultValue = "") String searchWord) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(currentPage+" <- AdminBlackQuestionController.getBlackQuestionCommentList: currentPage");
		System.out.println(searchWord+" <- AdminBlackQuestionController.getBlackQuestionCommentList: searchWord");
		Map<String, Object> map = adminBlackQuestionService.getBlackQuestionCommentList(currentPage, rowPerPage, searchWord);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("blackQuestionCommentTotalCount", map.get("blackQuestionCommentTotalCount"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("blackQuestionCommentList", map.get("blackQuestionCommentList"));
		
		return "adminBlackQuestion/getBlackQuestionCommentList";
	}
	// 블랙 질문댓글 목록
	@GetMapping("/admin/getBlackAnswerCommentList")
	public String getBlackAnswerCommentList(HttpSession session, Model model,
											@RequestParam(defaultValue = "1") int currentPage,
											@RequestParam(defaultValue = "10") int rowPerPage,
											@RequestParam(defaultValue = "") String searchWord) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(currentPage+" <- AdminBlackQuestionController.getBlackAnswerCommentList: currentPage");
		System.out.println(searchWord+" <- AdminBlackQuestionController.getBlackAnswerCommentList: searchWord");
		Map<String, Object> map = adminBlackQuestionService.getBlackAnswerCommentList(currentPage, rowPerPage, searchWord);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("blackAnswerCommentTotalCount", map.get("blackAnswerCommentTotalCount"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("blackAnswerCommentList", map.get("blackAnswerCommentList"));
		
		return "adminBlackQuestion/getBlackAnswerCommentList";
	}
}
