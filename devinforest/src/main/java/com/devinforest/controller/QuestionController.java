package com.devinforest.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.devinforest.service.QuestionService;
import com.devinforest.vo.Question;

@Controller
public class QuestionController {
   
	@Autowired
	private QuestionService questionService;
   
   
	/* ---------- 질문 목록 ---------- */
	@GetMapping("/getQuestionList")
	public String getQuestionList(Model model) {
		List<Question> questionList = questionService.getQuestionList();
		model.addAttribute("questionList", questionList);
		return "question/getQuestionList";
	}
   
	/* ---------- 질문 상세보기 ---------- */
	@GetMapping("/getQuestionOne")
	public String getQuestionOne(Model model, Question question) {
		System.out.println(question.getQuestionNo() + "<-- questionNo");
		
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
	   
		// IPv4 방식의 IP주소 가지고 오기
		InetAddress local = null;
		try {
			local = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	   
		String getIp = local.getHostAddress();
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
	public String modifyQuestion() {
		return "question/modifyQeustion";
	}
   
	// 질문 수정 실행
	@PostMapping("/modifyQuestion")
	public String modifyQuestion(Question question) {
		return "redirect:/question/getQuestionList";
	}
   
   
	/* 아래부턴 관리자만 가능 */
   
	/* ---------- 질문 삭제하기(+백업) ---------- */
	@GetMapping("/removeQuestion")
	public String removeQuestion() { // 백업 후 삭제 실행
      
		return "redirect:/";
	}
   
	/* ---------- 삭제된 질문 목록 ---------- */
	@GetMapping("/getRemovedQuestion")
	public String getRemovedQuestion() { 
		return "redirect:/";
	}   
}