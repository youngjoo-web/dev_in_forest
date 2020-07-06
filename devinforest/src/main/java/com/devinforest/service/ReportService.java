package com.devinforest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.ReportMapper;
import com.devinforest.vo.Report;

@Service
@Transactional
public class ReportService {
	@Autowired private ReportMapper reportMapper;
	
	public Map<String, Object> getReportList(String searchWord, int currentPage, int rowPerPage, String reportKind) {
		System.out.println(searchWord + " <--ReportService.getReportList: searchWord");
		System.out.println(currentPage + " <--ReportService.getReportList: currentPage");
		System.out.println(rowPerPage + " <--ReportService.getReportList: rowPerPage");
		System.out.println(reportKind + " <--ReportService.getReportList: reportKind");
		
		// 시작행 구하기
		int beginRow = (currentPage-1) * rowPerPage;
		System.out.println(beginRow + " <--ReportService.getReportList: beginRow");
		
		Map<String, Object> totalCountMap = new HashMap<>();
		totalCountMap.put("searchWord", searchWord);
		totalCountMap.put("reportKind", reportKind);
		
		// 총 신고갯수 구하기
		int reportTotalCount = reportMapper.ReportTotalCount(totalCountMap);
		System.out.println(reportTotalCount + " <-- ReportService.getReportList: reportTotalCount");
		int lastPage = reportTotalCount / rowPerPage;
		if(reportTotalCount % rowPerPage != 0) {
			lastPage+=1;
		}
		System.out.println(lastPage + " <--ReportService.getReportList: lastPage");
		
		// List 구하기
		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("searchWord", searchWord);
		inputMap.put("reportKind", reportKind);
		inputMap.put("beginRow", beginRow);
		inputMap.put("rowPerPage", rowPerPage);
		List<Report> reportList =  reportMapper.selectReportList(inputMap);
		
		// List 출력
		Map<String, Object> outputMap = new HashMap<>();
		outputMap.put("reportTotalCount", reportTotalCount);
		outputMap.put("lastPage", lastPage);
		outputMap.put("reportList", reportList);
		
		return outputMap;
	}
}
