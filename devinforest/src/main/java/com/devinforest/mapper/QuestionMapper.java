package com.devinforest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Question;

@Mapper
public interface QuestionMapper {
	public List<Question> selectQuestionList(); // 질문 목록
	public int insertQuestion(Question question); // 질문 작성
}
