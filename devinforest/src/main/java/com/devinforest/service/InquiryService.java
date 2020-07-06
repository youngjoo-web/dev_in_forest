package com.devinforest.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.InquiryMapper;
import com.devinforest.vo.Inquiry;


@Service
@Transactional
public class InquiryService {
	@Autowired private InquiryMapper inquiryMapper;
	// 문의사항 목록
	public Map<String, Object> getInquiryList(int currentPage, int rowPerPage, String searchWord){
		int beginRow = (currentPage-1)*rowPerPage;
		int inquiryTotalCount = inquiryMapper.inquiryTotalCount(searchWord);
		System.out.println(inquiryTotalCount+" <- InquiryService.selectInquiryList: inquiryTotalCount");
		int lastPage = inquiryTotalCount/rowPerPage;
		if(inquiryTotalCount%rowPerPage != 0) {
			lastPage += 1;
		}
		System.out.println(lastPage+" <- InquiryService.selectInquiryList: lastPage");
		Map<String, Object> inputMap = new HashMap<String, Object>();
		inputMap.put("beginRow", beginRow);
		inputMap.put("rowPerPage", rowPerPage);
		inputMap.put("searchWord", searchWord);
		Map<String, Object> outputMap = new HashMap<String, Object>();
		outputMap.put("inquiryList", inquiryMapper.selectInquiryList(inputMap));
		outputMap.put("inquiryTotalCount", inquiryTotalCount);
		outputMap.put("lastPage", lastPage);
		return outputMap; 
	}
	// 문의사항 상세보기
	public Inquiry getInquiryOne(int inquiryNo) {
		return inquiryMapper.selectInquiryOne(inquiryNo);
	}
}
