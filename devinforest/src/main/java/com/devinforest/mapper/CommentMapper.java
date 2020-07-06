package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.AnswerComment;
import com.devinforest.vo.QuestionComment;

@Mapper
public interface CommentMapper {
	public List<QuestionComment> selectQuestionCommentList(Map<String, Object> map); // 질문 댓글 목록
	public int insertQuestionComment(QuestionComment questionComment); // 질문 댓글 추가
	public int selectQuestionCommentTotalRow(QuestionComment questionComment); // 질문 댓글 총 개수
	
	/************************************************************************************************/
	
	public List<AnswerComment> selectAnswerCommentList(Map<String, Object> map); // 답변 댓글 목록
	public int insertAnswerComment(AnswerComment answerComment); // 답변 댓글 추가
	public int selectAnswerCommentTotalRow(AnswerComment answerComment); // 답변 댓글 총 개수
	
}
