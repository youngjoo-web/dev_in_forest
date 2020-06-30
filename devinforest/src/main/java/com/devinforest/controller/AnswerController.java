
package com.devinforest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.devinforest.service.AnswerService;

@Controller
public class AnswerController {
	
	@Autowired
	private AnswerService answerService;
   
   /* ---------- 답변 목록 ---------- */
   @GetMapping("/getAnswerList")
   public String getAnswerList(Model model) {

      return "getQuestionOne";
   }
   
   /* ---------- 답변 작성하기 ---------- */
   @PostMapping("/addAnswer")
   public String addAnswer() {
      return "redirect:/getQuestionOne?questionNo=";
   }
   
   /* ---------- 답변 수정하기 ---------- */
   // 답변 수정 폼으로 이동
   @GetMapping("/modifyAnswer")
   public String modifyAnswer() {
      return "modifyAnswer";
   }
   
   // 답변 수정 실행
   @PostMapping("/modifyAnswer")
   public String modifyAnswer(String str) {
      return "redirect:/getQuestionOne?questionNo=";
   }
   
   
   /* 아래부턴 관리자만 가능 */
   
   /* ---------- 답변 삭제하기(+백업) ---------- */
   @GetMapping("/removeAnswer")
   public String removeAnswer() { // 백업 후 삭제 실행
      return "redirect:/";
   }
   
   /* ---------- 삭제된 답변 목록 ---------- */
   @GetMapping("/getRemovedAnswer")
   public String getRemovedAnswer() {
      return "getRemovedAnswer";
   }
}