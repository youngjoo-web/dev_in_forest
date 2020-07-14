package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Answer;
import com.devinforest.vo.AnswerComment;
import com.devinforest.vo.Question;
import com.devinforest.vo.QuestionComment;

@Mapper
public interface AdminQuestionMapper {
	// 질문 List 조회
	public List<Question> selectQuestionList(Map<String, Object> inputMap);
	// 질문 총 갯수 조회
	public int questionTotalRow(String searchWord);
	// 답변 List 조회
	public List<Answer> selectAnswerList(Map<String, Object> inputMap);
	// 답변 총 갯수 조회
	public int answerTotalRow(String searchWord);
	// 질문댓글 List 조회
	public List<QuestionComment> selectQuestionCommentList(Map<String, Object> inputMap);
	// 질문댓글 총 갯수 조회
	public int selectQuestionCommentTotalRow(String searchWord);
	// 답변댓글 List 조회
	public List<AnswerComment> selectAnswerCommentList(Map<String, Object> inputMap);
	// 답변댓글 총 갯수 조회
	public int selectAnswerCommentTotalRow(String searchWord);
	// 질문 내용 상세보기
	public Question selectQuestionOne(int questionNo);
	// 상세보기 답변 내용
	public List<Answer> selectAnswerOne(int questionNo);
	// 상세보기 질문댓글
	public List<QuestionComment> selectQuestionCommentOne(int questionNo);
	// 상세보기 답변댓글
	public List<AnswerComment> selectAnswerCommentOne(int answerNo);
}
