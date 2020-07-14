package com.devinforest.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.service.AdminQuestionService;

@Controller
public class AdminQuestionController {
	@Autowired private AdminQuestionService adminQuestionService;
	
	// 질문 List 조회
	@GetMapping("/admin/getQuestionList")
	public String getQuestionList(Model model, HttpSession session,
									@RequestParam(defaultValue="1") int currentPage,
									@RequestParam(defaultValue = "5") int rowPerPage,
									@RequestParam(defaultValue="") String searchWord) {
		
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		
		Map<String, Object> questionList = adminQuestionService.getQuestionList(currentPage, rowPerPage, searchWord);
		
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("questionList", questionList.get("questionList"));
		model.addAttribute("questionTotalRow", questionList.get("questionTotalRow"));
		model.addAttribute("lastPage", questionList.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		
		
		System.out.println("↓QuestionController questionList↓");
		System.out.println(questionList.get("questionList") + " <-- QuestionController questionList");
		System.out.println(questionList.get("questionTotalRow") + " <-- QuestionController questionTotalRow");
		System.out.println(questionList.get("lastPage") + " <-- QuestionController lastPage");
		System.out.println(currentPage + " <--- QuestionController currentPage");
		System.out.println(searchWord + " <--- QuestionController searchWord");
		
		return "adminQuestion/getQuestionList";
	}
	// 답변 List 조회
	@GetMapping("/admin/getAnswerList")
	public String getAnswerList(Model model, HttpSession session,
									@RequestParam(defaultValue="1") int currentPage,
									@RequestParam(defaultValue = "5") int rowPerPage,
									@RequestParam(defaultValue="") String searchWord) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		
		Map<String, Object> answerList = adminQuestionService.getAnswerList(currentPage, rowPerPage, searchWord);
		
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("answerList", answerList.get("answerList"));
		model.addAttribute("answerTotalRow", answerList.get("answerTotalRow"));
		model.addAttribute("lastPage", answerList.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		
		
		System.out.println("↓QuestionController answerList↓");
		System.out.println(answerList.get("answerList") + " <-- QuestionController answerList");
		System.out.println(answerList.get("answerTotalRow") + " <-- QuestionController answerTotalRow");
		System.out.println(answerList.get("lastPage") + " <-- QuestionController lastPage");
		System.out.println(currentPage + " <--- QuestionController currentPage");
		System.out.println(searchWord + " <--- QuestionController searchWord");
		
		return "adminQuestion/getAnswerList";
	}
	// 질문댓글 List 조회
	@GetMapping("/admin/getQuestionCommentList")
	public String getQuestionCommentList(Model model, HttpSession session,
									@RequestParam(defaultValue="1") int currentPage,
									@RequestParam(defaultValue = "5") int rowPerPage,
									@RequestParam(defaultValue="") String searchWord) {
		
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		
		Map<String, Object> questionCommentList = adminQuestionService.getQuestionCommentList(currentPage, rowPerPage, searchWord);
		
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("questionCommentList", questionCommentList.get("questionCommentList"));
		model.addAttribute("questionCommentTotalRow", questionCommentList.get("questionCommentTotalRow"));
		model.addAttribute("lastPage", questionCommentList.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		
		
		System.out.println("↓QuestionController questionCommentList↓");
		System.out.println(questionCommentList.get("questionCommentList") + " <-- QuestionController questionCommentList");
		System.out.println(questionCommentList.get("questionCommentTotalRow") + " <-- QuestionController questionCommentTotalRow");
		System.out.println(questionCommentList.get("lastPage") + " <-- QuestionController lastPage");
		System.out.println(currentPage + " <--- QuestionController currentPage");
		System.out.println(searchWord + " <--- QuestionController searchWord");
		
		return "adminQuestion/getQuestionCommentList";
	}
	// 답변댓글 List 조회
	@GetMapping("/admin/getAnswerCommentList")
	public String getAnswerCommentList(Model model, HttpSession session,
									@RequestParam(defaultValue="1") int currentPage,
									@RequestParam(defaultValue = "5") int rowPerPage,
									@RequestParam(defaultValue="") String searchWord) {
		
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}

		Map<String, Object> answerCommentList = adminQuestionService.getAnswerCommentList(currentPage, rowPerPage, searchWord);
		
		int questionNo = 1;
		
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("answerCommentList", answerCommentList.get("answerCommentList"));
		model.addAttribute("answerCommentTotalRow", answerCommentList.get("answerCommentTotalRow"));
		model.addAttribute("lastPage", answerCommentList.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("questionNo", questionNo);
		
		
		
		System.out.println("↓QuestionController answerCommentList↓");
		System.out.println(answerCommentList.get("answerCommentList") + " <-- QuestionController answerCommentList");
		System.out.println(answerCommentList.get("answerCommentTotalRow") + " <-- QuestionController answerCommentTotalRow");
		System.out.println(answerCommentList.get("lastPage") + " <-- QuestionController lastPage");
		System.out.println(currentPage + " <--- QuestionController currentPage");
		System.out.println(searchWord + " <--- QuestionController searchWord");
		
		return "adminQuestion/getAnswerCommentList";
	}
}
