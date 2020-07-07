package com.devinforest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.service.ReportService;
import com.devinforest.vo.BlackList;
import com.devinforest.vo.Report;

@Controller
public class ReportController {
	@Autowired private ReportService reportService;
	
	@GetMapping("/getReportList")
	public String getReportList(Model model,
								@RequestParam(defaultValue = "") String searchWord,
								@RequestParam(defaultValue = "1") int currentPage,
								@RequestParam(defaultValue = "5") int rowPerPage,
								@RequestParam(defaultValue = "") String reportKind) {
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
	@GetMapping("/getReportOne")
	public String getReportOne(Model model, 
								@RequestParam(value = "reportNo") int reportNo) {
		System.out.println(reportNo);
		
		Report report = reportService.getReportOne(reportNo);
		
		if(report == null) {
			return "redirect:/getReportList";
		} else {
			model.addAttribute("report", report);
		}
		
		return "report/getReportOne";
	}
	@GetMapping("/black")
	public String black(Model model,
						@RequestParam(value = "memberName") String memberName) {
		System.out.println(memberName + " <-- ReportController.black: memberName");
		
		String email = reportService.blackMemberOne(memberName);
		model.addAttribute("memberEmail", email);
		model.addAttribute("memberName", memberName);
		return "report/black";
	}
	@PostMapping("/black")
	public String black(BlackList blackList) {
		System.out.println(blackList + " <-- ReportController.black: blackList");
		reportService.removeMember(blackList);
		return "redirect:/done";
	}
	@GetMapping("/done")
	public String done() {
		return "report/done";
	}
}
