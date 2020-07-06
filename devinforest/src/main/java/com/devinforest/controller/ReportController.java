package com.devinforest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.service.ReportService;

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
}
