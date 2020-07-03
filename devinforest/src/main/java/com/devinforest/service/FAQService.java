package com.devinforest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.IPUtil;
import com.devinforest.mapper.FAQMapper;
import com.devinforest.vo.Notice;

@Service
@Transactional
public class FAQService {
	@Autowired private FAQMapper faqMapper;
	
	// FAQList 출력
	public Map<String, Object> getFAQList(String searchWord, int currentPage, int rowPerPage) {
		int beginRow = (currentPage-1) * rowPerPage;
		int FAQTotalCount = faqMapper.FAQTotalCount(searchWord);
		int lastPage = FAQTotalCount / rowPerPage;
		if(FAQTotalCount % rowPerPage != 0) {
			lastPage+=1;
		}
		Map<String, Object> inPutMap = new HashMap<>();
		inPutMap.put("searchWord", searchWord);
		inPutMap.put("beginRow", beginRow);
		inPutMap.put("rowPerPage", rowPerPage);
		
		List<Notice> FAQList = faqMapper.selectFAQList(inPutMap);
		
		Map<String, Object> outPutMap = new HashMap<>();
		outPutMap.put("FAQList", FAQList);
		outPutMap.put("FAQTotalCount", FAQTotalCount);
		outPutMap.put("lastPage", lastPage);
		return outPutMap;
	}
	// FAQ 상세보기
	public Notice getFAQOne(int noticeNo) {
		Notice notice = faqMapper.selectFAQOne(noticeNo);
		return notice;
	}
	// FAQ 추가
	public void addFAQ(Notice notice) {
		String ip = IPUtil.getIPAddress();
		System.out.println(ip + "FAQController.addFAQ(): ip");
		notice.setNoticeIp(ip);
		
		faqMapper.insertFAQ(notice);
	}
	// FAQ 수정
	public void modifyFAQ(Notice notice) {
		faqMapper.updateFAQ(notice);
	}
	// FAQ 삭제
	public void removeFAQ(int noticeNo) {
		faqMapper.deleteFAQ(noticeNo);
	}
}
