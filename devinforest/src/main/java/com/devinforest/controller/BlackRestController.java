package com.devinforest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devinforest.service.AdminMemberService;
import com.devinforest.service.ReportService;

@RestController
public class BlackRestController {
	@Autowired private AdminMemberService adminMemberService;
	@Autowired private ReportService reportService;
	// 블랙회원 조회
	@PostMapping("/blackMemberCheck")
	public String blackMemberCheck(HttpSession session,
									@RequestParam(value = "reportMemberName") String reportMemberName) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(reportMemberName+" <- BlackRestController.blackMemberCheck: reportMemberName");
		String blackMemberName= adminMemberService.getBlackMember(reportMemberName);
		System.out.println(blackMemberName+" <- BlackRestController.blackMemberCheck: blackMemberName");
		
		String checkMsg = "oo";
		if(blackMemberName == null) {
			checkMsg = "xx";
			return checkMsg;
		}
		return checkMsg;
	}
	// 신고 조치상태 수정
	@PostMapping("/modifyReportState")
	public String  modifyReportState(HttpSession session, @RequestParam(value = "reportNo") int reportNo) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(reportNo+" <- BlackRestController.modifyReportState: reportNo");
		reportService.modifyReportState(reportNo);
		return "";
	}
	// 신고된 게시글 삭제유무 확인
	@PostMapping("/getRemoveCheck")
	public String getRemoveCheck(HttpSession session, 
							@RequestParam(value = "reportQuestionNo") int reportQuestionNo,
							@RequestParam(value = "reportQuestionCommentNo") int reportQuestionCommentNo,
							@RequestParam(value = "reportAnswerNo") int reportAnswerNo,
							@RequestParam(value = "reportAnswerCommentNo") int reportAnswerCommentNo) {
		System.out.println(reportQuestionNo);
		System.out.println(reportQuestionCommentNo);
		System.out.println(reportAnswerNo);
		System.out.println(reportAnswerCommentNo);
		int checkNum = reportService.getRemoveCheck(reportQuestionNo, reportQuestionCommentNo, reportAnswerNo, reportAnswerCommentNo);
		String msg = "xx";
		if(checkNum == 1) {
			msg = "oo";
			return msg;
		}
		return msg;
	}
}
