package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.AnswerBack;
import com.devinforest.vo.AnswerCommentBack;
import com.devinforest.vo.QuestionBack;
import com.devinforest.vo.QuestionCommentBack;

@Mapper
public interface AdminBlackQuestionMapper {
	// 블랙 질문 목록
	public List<QuestionBack> selectBlackQuestionList(Map<String, Object> map);
	// 블랙 질문 totalCount
	public int blackQuestionTotalCount(String searchWord);
	// 블랙 답변 목록
	public List<AnswerBack> selectBlackAnswerList(Map<String, Object> map);
	// 블랙 답변 totalCount
	public int blackAnswerTotalCount(String searchWord);
	// 블랙 질문댓글 목록
	public List<QuestionCommentBack> selectBlackQuestionCommentList(Map<String, Object> map);
	// 블랙 질문댓글 totalCount
	public int blackQuestionCommentTotalCount(String searchWord);
	// 블랙 답변댓글 목록
	public List<AnswerCommentBack> selectBlackAnswerCommentList(Map<String, Object> map);
	// 블랙 답변댓글 totalCount
	public int blackAnswerCommentTotalCount(String searchWord);
}
