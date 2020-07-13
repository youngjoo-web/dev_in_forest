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
	// 신고 조치유무 변경- 답글의 댓글 조치완료
	public void updateAnswerCommentNoOfReportState(int answerCommentNo);
	// 신고 조치유무 변경- 게시글 답글 조치완료
	public void updateAnswerNoOfReportState(int answerNo);
	// 신고 조치유무 변경- 게시글 댓글 조치완료
	public void updateQuestionCommentNoOfReportState(int questionCommentNo);
	// 신고 조치유무 변경- 게시글  조치완료
	public void updateQuestionNoOfReportState(int questionNo);
	// 신고 조치유무 변경 - 이미 블랙된 회원일 경우
	public void updateReportState(int reportNo);
	// 게시글 삭제유무 확인
	public String selectQuestionNo(int questionNo);
	// 게시글 댓글 삭제유무 확인
	public String selectQuestionCommentNo(int questionCommentNo);
	// 게시글 답변 삭제유무 확인
	public String selectAnswerNo(int answerNo);
	// 게시글 답변의 댓글 삭제유무 확인
	public String selectAnswerCommentNo(int answerCommentNo);
	//
}
