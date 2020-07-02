package com.devinforest.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.IPUtil;
import com.devinforest.service.QuestionService;
import com.devinforest.vo.Question;

@Controller
public class QuestionController {
   
	@Autowired private QuestionService questionService;
   
	/* ---------- 질문 목록 ---------- */
	@GetMapping("/getQuestionList")
	public String getQuestionList(Model model, @RequestParam(value="currentPage", defaultValue="1") int currentPage,
		@RequestParam(value="searchWord", defaultValue="") String searchWord) {
		
		Map<String, Object> questionList = questionService.getQuestionList(currentPage, searchWord);
		model.addAttribute("questionList", questionList.get("questionList"));
		model.addAttribute("lastPage", questionList.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		System.out.println(questionList.get("questionList"));
		System.out.println(currentPage + " <-- currentPage");
		System.out.println(searchWord + " <-- searchWord");
		
		return "question/getQuestionList";
	}
   
	/* ---------- 질문 상세보기 ---------- */
	@GetMapping("/getQuestionOne")
	public String getQuestionOne(Model model, Question question) {
		System.out.println(question.getQuestionNo() + "<-- questionNo");
		
		// 로그인 세션 임시 대체
		String memberName = "김경태";
		
		question.setMemberName(memberName);
		
		Map<String, Object> map = questionService.getQuestionOne(question);
		model.addAttribute("question", map.get("questionOne"));
		model.addAttribute("viewsCount", map.get("viewsCount"));
		
		return "question/getQuestionOne";
	}
   
	/* ---------- 질문 작성하기 ---------- */
	// 질문 작성 폼으로 이동
	@GetMapping("/addQuestion")
	public String addQuestion(Model model, HttpServletRequest request) {
	   
		String getIp = IPUtil.getIPAddress();
		System.out.println(getIp + "<-- addQuestion ip");
	 
		String memberName = "가재우"; // 로그인 세션 임시 대체
		model.addAttribute("memberName", memberName);
		model.addAttribute("questionIp", getIp);
		
		return "question/addQuestion";
	}
   
	// 질문 작성 실행
	@PostMapping("/addQuestion")
	public String addQuestion(Question question) {
		questionService.addQuestion(question);
		return "redirect:/getQuestionList";
	}
   
	/* ---------- 질문 수정하기 ---------- */
	// 질문 수정 폼으로 이동
	@GetMapping("/modifyQuestion")
	public String modifyQuestion(Model model, Question question) {
		Question modifyQuestion = questionService.getModifyQuestionOne(question);
		model.addAttribute("modifyQuestion", modifyQuestion);
		return "question/modifyQeustion";
	}
   
	// 질문 수정 실행
	@PostMapping("/modifyQuestion")
	public String modifyQuestion(Question question) {
		questionService.modifyQuestion(question);
		return "redirect:/question/getQuestionList";
	}
   
   
	/* 아래부턴 관리자만 가능 */
   
	/* ---------- 질문 삭제하기(+백업) ---------- */
	@GetMapping("/removeQuestion")
	public String removeQuestion(Question question) { // 백업 후 삭제 실행
		questionService.removeQuestion(question);
		return "redirect:/";
	}
   
	/* ---------- 삭제된 질문 목록 ---------- */
	@GetMapping("/getRemovedQuestion")
	public String getRemovedQuestion() { 
		return "redirect:/";
	}   
}