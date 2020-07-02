package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Notice;

@Mapper
public interface NoticeMapper {
	// 공지사항 목록 
	public List<Notice> selectNoticeList(Map<String, Object> map);
	// 공지사항 totalCount
	public int adminTotalCount(String searchWord);
	// 공지사항 상세보기
	public Notice selectNoticeOne(int noticeNo);
}
