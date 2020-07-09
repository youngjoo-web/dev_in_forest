package com.devinforest.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.service.StatisticsService;
import com.devinforest.vo.Member;

@Controller
public class StatisticsController {
	@Autowired private StatisticsService statisticsService;
	
	// 일간 회원 가입수 통계
	@GetMapping("/getSignUpStatisticsByDate")
	public String getSignUpStatisticsByDate(HttpSession session, Model model,
											@RequestParam(value="now", required=false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate now) {
		/*
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		*/
		List<Member> signUpByDate = statisticsService.getSignUpStatisticsByDate(now);
		model.addAttribute("signUpByDate", signUpByDate);
		return "statistics/getSignUpStatisticsByDate";
	}
}
