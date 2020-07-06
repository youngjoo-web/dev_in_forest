package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Inquiry;

@Mapper
public interface InquiryMapper {
	// 문의사항 목록
	public List<Inquiry> selectInquiryList(Map<String, Object> map);
	// 문의사항 TotalCount
	public int inquiryTotalCount(String searchWord);
	// 문의사항 상세보기
	public Inquiry selectInquiryOne(int inquiryNo);
	// 문의사항 답변 작성
	public void updateInquiry(Inquiry inquiry);
	// 문의사항 답변유무 확인
	public String selectInquiryAnswer(int inquiryNo);
}
