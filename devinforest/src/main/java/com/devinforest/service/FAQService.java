package com.devinforest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.FAQMapper;
import com.devinforest.vo.Notice;

@Service
@Transactional
public class FAQService {
	@Autowired private FAQMapper faqMapper;
	
	public Map<String, Object> getFAQList(String searchWord, int currentPage, int rowPerPage) {
		
		int beginRow = (currentPage-1) * rowPerPage;
		int FAQTotalCount = faqMapper.FAQTotalCount(searchWord);
		
		Map<String, Object> inPutMap = new HashMap<>();
		inPutMap.put("searchWord", searchWord);
		inPutMap.put("beginRow", beginRow);
		inPutMap.put("rowPerPage", rowPerPage);
		
		List<Notice> FAQList = faqMapper.selectFAQList(inPutMap);
		
		Map<String, Object> outPutMap = new HashMap<>();
		outPutMap.put("FAQList", FAQList);
		outPutMap.put("FAQTotalCount", FAQTotalCount);
		return outPutMap;
	}
}
