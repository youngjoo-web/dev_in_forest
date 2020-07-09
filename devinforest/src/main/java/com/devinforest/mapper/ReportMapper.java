package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.BlackList;
import com.devinforest.vo.Report;

@Mapper
public interface ReportMapper {
	// 신고내역 목록
	public List<Report> selectReportList(Map<String, Object> inputMap);
	// 신고내역 TotalCount
	public int reportTotalCount(Map<String, Object> totalCountMap);
	// 신고내역 상세보기
	public Report selectReportOne(int reportNo);
}
