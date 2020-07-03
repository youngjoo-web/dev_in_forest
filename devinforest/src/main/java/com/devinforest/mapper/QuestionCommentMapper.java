package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.QuestionComment;

@Mapper
public interface QuestionCommentMapper {
	public List<QuestionComment> selectQuestionCommentList(Map<String, Object> map); // 질문 댓글 목록
	public int insertQuestionComment(QuestionComment questionComment); // 질문 댓글 추가
	public int selectQuestionCommentTotalRow(QuestionComment questionComment); // 질문 댓글 총 개수
	
}
