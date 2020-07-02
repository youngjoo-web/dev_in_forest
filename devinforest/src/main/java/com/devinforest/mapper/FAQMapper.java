package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Notice;

@Mapper
public interface FAQMapper {
	// FAQList 출력
	public List<Notice> selectFAQList(Map<String, Object> inPutMap);
	// FAQ 총 갯수 출력
	public int FAQTotalCount(String searchWord);
	// FAQ 상세보기
	public Notice selectFAQOne(int noticeNo);
	// FAQ 추가
	public void insertFAQ(Notice notice);
	// FAQ 수정
	public void updateFAQ(Notice notice);
	// FAQ 삭제
	public void deleteFAQ(int noticeNo);
}
