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

import com.devinforest.IPUtil;
import com.devinforest.service.QuestionService;
import com.devinforest.vo.Answer;
import com.devinforest.vo.LoginMember;
import com.devinforest.vo.Question;
import com.devinforest.vo.QuestionHashtag;

@Controller
public class QuestionController {
   
	@Autowired 
	private QuestionService questionService;
   
	/* ---------- 질문 목록 ---------- */
	@GetMapping("/getQuestionList")
	public String getQuestionList(Model model, HttpSession session,
		@RequestParam(value="currentPage", defaultValue="1") int currentPage,
		@RequestParam(value="searchWord", defaultValue="") String searchWord) {
		
		String memberName = "Guest";
		
		if(session.getAttribute("loginMember") != null) {
			memberName = ((LoginMember)session.getAttribute("loginMember")).getMemberName();
		}
		
		Map<String, Object> questionList = questionService.getQuestionList(currentPage, searchWord);
		List<QuestionHashtag> questionHashtagList = questionService.getQuestionHashtagList();
		
		System.out.println(memberName+"<--memberName");
		
		model.addAttribute("memberName", memberName);
		model.addAttribute("questionList", questionList.get("questionList"));
		model.addAttribute("questionHashtagList", questionHashtagList);
		model.addAttribute("lastPage", questionList.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		
		
//		System.out.println("↓QuestionController questionList↓");
//		System.out.println(questionList.get("questionList"));
//		System.out.println(currentPage + " <--- QuestionController currentPage");
//		System.out.println(searchWord + " <--- QuestionController searchWord");
		
		return "question/getQuestionList";
	}
   
	/* ---------- 삭제된 질문 목록 ---------- */
	@GetMapping("/getRemovedQuestionList")
	public String getRemovedQuestionList(Model model, HttpSession session,
		@RequestParam(value="currentPage", defaultValue="1") int currentPage,
		@RequestParam(value="searchWord", defaultValue="") String searchWord) {
		
		String memberName=((LoginMember)session.getAttribute("loginMember")).getMemberName();
		
		// 관리자 로그인이 아닐 시에 로그인창으로 돌려보냄
		if(((LoginMember)session.getAttribute("loginMember")).getAccountKind() != "A") {
			return "redirect:/memberLogin";
		}
		System.out.println(memberName + " <--- memberName");
		
		Map<String, Object> deletedQuestionList = questionService.getRemovedQuestionList(currentPage, searchWord);
		
		model.addAttribute("memberName", memberName);
		model.addAttribute("questionList", deletedQuestionList.get("questionList"));
		model.addAttribute("lastPage", deletedQuestionList.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		
		
		System.out.println("↓QuestionController deletedQuestionList↓");
		System.out.println(deletedQuestionList.get("questionList"));
		System.out.println(currentPage + " <--- QuestionController currentPage");
		System.out.println(searchWord + " <--- QuestionController searchWord");
		
		return "question/getQuestionList";
	}
	
	/* ---------- 질문 상세보기 ---------- */
	@GetMapping("/getQuestionOne")
	public String getQuestionOne(Model model, HttpSession session, Question question, Answer answer,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage) {
		System.out.println(question.getQuestionNo() + "<-- questionNo");
		
		String memberName = "Guest";
		
		if(session.getAttribute("loginMember")!=null) {
			memberName=((LoginMember)session.getAttribute("loginMember")).getMemberName();
		}
		
		String getIp = IPUtil.getIPAddress();
		
		System.out.println(memberName + " <--- QuestionController memberName");

		question.setMemberName(memberName);
					
		Map<String, Object> map = questionService.getQuestionOne(question);
		
		// 질문
		model.addAttribute("ip", getIp);
		model.addAttribute("memberName", memberName);
		model.addAttribute("question", map.get("questionOne"));
		model.addAttribute("viewsCount", map.get("viewsCount"));

		
		return "question/getQuestionOne";
	}
   
	/* ---------- 질문 작성하기 ---------- */
	// 질문 작성 폼으로 이동
	@GetMapping("/addQuestion")
	public String addQuestion(Model model,HttpSession session, LoginMember loginMember) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/memberLogin";
		}
		String getIp = IPUtil.getIPAddress();
		System.out.println(getIp + "<-- addQuestion ip");
		
		System.out.println(loginMember.getMemberName() + " <--- addQuestion memberName");
		
		model.addAttribute("memberName", loginMember.getMemberName());
		model.addAttribute("ip", getIp);
		System.out.println(loginMember.getMemberName()+"<--memberName");
		
		return "question/addQuestion";
	}
   
	// 질문 작성 실행
	@PostMapping("/addQuestion")
	public String addQuestion(Question question, QuestionHashtag questionHashtag) {
		
		System.out.println(questionHashtag + "<--- add Question questionHashtag");
		questionService.addQuestion(question);
		int questionNo = questionService.getQuestionNoMax();
		System.out.println(questionNo + "<--questionNo");
		System.out.println("질문추가");
		
		questionHashtag.setQuestionNo(questionNo);
		
		System.out.println(questionHashtag.getQuestionNo()+"<---questionNo");
		System.out.println(questionHashtag + "<--- add Question questionHashtag");
		questionService.addQuestionHashtag(questionHashtag);
		System.out.println("질문의 해시태그추가");
		return "redirect:/getQuestionList";
	}
   
	/* ---------- 질문 수정하기 ---------- */
	// 질문 수정 폼으로 이동
	@GetMapping("/modifyQuestion")
	public String modifyQuestion(Model model, Question question,HttpSession session) {
		if(session.getAttribute("loginMember")==null) {
			return "redirect:/memberLogin";
		}
		Question modifyQuestion = questionService.getModifyQuestionOne(question);
		model.addAttribute("modifyQuestion", modifyQuestion);
		return "question/modifyQuestion";
	}
   
	// 질문 수정 실행
	@PostMapping("/modifyQuestion")
	public String modifyQuestion(Question question) {
		questionService.modifyQuestion(question);
		return "redirect:/getQuestionList?questionNo=" + question.getQuestionNo();
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