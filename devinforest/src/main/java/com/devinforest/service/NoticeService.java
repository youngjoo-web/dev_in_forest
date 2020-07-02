package com.devinforest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.NoticeMapper;
import com.devinforest.vo.Notice;

@Service
@Transactional
public class NoticeService {
	@Autowired private NoticeMapper noticeMapper;
	// 공지사항 목록 
	public Map<String, Object> getNoticeList(int currentPage, int rowPerPage, String searchWord){
		int beginRow =(currentPage-1)*rowPerPage;
		int noticeTotalCount = noticeMapper.adminTotalCount(searchWord);
		System.out.println(noticeTotalCount+" <- NoticeService.getNoticeList: noticeTotalCount");
		int lastPage = noticeTotalCount/rowPerPage;
		if(noticeTotalCount % rowPerPage != 0) {
			lastPage+=1;
		}
		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("beginRow", beginRow);
		inputMap.put("rowPerPage", rowPerPage);
		inputMap.put("searchWord", searchWord);
		List<Notice> noticeList = noticeMapper.selectNoticeList(inputMap);
		System.out.println(lastPage+" <- NoticeService.getNoticeList: lastPage");
		System.out.println(noticeList+" <- NoticeService.getNoticeList: noticeList");
		Map<String, Object> outputMap = new HashMap<>();
		outputMap.put("noticeTotalCount", noticeTotalCount);
		outputMap.put("lastPage", lastPage);
		outputMap.put("noticeList", noticeList);
		return outputMap;
	}
	// 공지사항 상세보기
	public Notice getNoticeOne(int noticeNo) {
		return noticeMapper.selectNoticeOne(noticeNo);
	}
	// 공지사항 추가
	public void addNotice(Notice notice) {
		noticeMapper.insertNotice(notice);
	}
}
