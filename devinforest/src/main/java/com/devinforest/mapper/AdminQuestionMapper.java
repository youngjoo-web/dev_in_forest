package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Question;

@Mapper
public interface AdminQuestionMapper {
	// 질문 List 조회
	public List<Question> selectQuestionList(Map<String, Object> inputMap);
	// 질문 총 갯수 조회
	public int questionTotalRow(String searchWord);
	// 답변 List 조회
	public List<Question> selectAnswerList(Map<String, Object> inputMap);
	// 답변 총 갯수 조회
	public int answerTotalRow(String searchWord);
}
