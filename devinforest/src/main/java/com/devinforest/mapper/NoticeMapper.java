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
	// 공지사항 추가
	public void insertNotice(Notice notice);
	// 공지사항 삭제
	public void deleteNotice(int noticeNo);
	// 공지사항 수정
	public void updateNotice(Notice notice);
}
