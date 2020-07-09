package com.devinforest.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.service.ReportService;
import com.devinforest.vo.Report;

@Controller
public class ReportController {
	@Autowired private ReportService reportService;
	
	// 신고 List 출력
	@GetMapping("/getReportList")
	public String getReportList(HttpSession session, Model model,
								@RequestParam(defaultValue = "") String searchWord,
								@RequestParam(defaultValue = "1") int currentPage,
								@RequestParam(defaultValue = "5") int rowPerPage,
								@RequestParam(defaultValue = "") String reportKind) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(searchWord + " <-- ReportController.getReportList: searchWord");
		System.out.println(currentPage + " <-- ReportController.getReportList: currentPage");
		System.out.println(rowPerPage + " <-- ReportController.getReportList: rowPerPage");
		System.out.println(reportKind + " <-- ReportController.getReportList: reportKind");
		
		Map<String, Object> map = reportService.getReportList(searchWord, currentPage, rowPerPage, reportKind);
		model.addAttribute("reportTotalCount", map.get("reportTotalCount"));
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("reportList", map.get("reportList"));
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("reportKind", reportKind);
		return "report/getReportList";
	}
	// 신고내역 상세보기
	@GetMapping("/getReportOne")
	public String getReportOne(HttpSession session, Model model, 
								@RequestParam(value = "reportNo") int reportNo) {
		// 로그인 세션확인
		if(session.getAttribute("loginAdmin")==null) {
			return "redirect:/index";
		}
		System.out.println(reportNo+" <- ReportController.getReportOne: reportNo");
		
		Report report = reportService.getReportOne(reportNo);
		System.out.println(report+" <- ReportController.getReportOne: report");
		if(report == null) {
			return "redirect:/getReportList";
		} else {
			model.addAttribute("report", report);
		}
		
		return "report/getReportOne";
	}
}
