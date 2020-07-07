package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.BlackList;
import com.devinforest.vo.Report;

@Mapper
public interface ReportMapper {
	// 신고 List 출력
	public List<Report> selectReportList(Map<String, Object> inputMap);
	// 페이징에 필요한  ReportTotalCount 출력
	public int ReportTotalCount(Map<String, Object> totalCountMap);
	// 상세보기 출력
	public Report selectReportOne(int reportNo);
	// 블랙 팝업창에 출력할 데이터 출력
	public String blackMemberOne(String memberName);
	// 멤버 삭제
	public int deleteMemberByName(String memberName);
	// 블랙리스트 추가
	public void insertBlackList(BlackList blackList);
}
