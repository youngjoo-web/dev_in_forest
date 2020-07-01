package com.devinforest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Question;

@Mapper
public interface QuestionMapper {
	public List<Question> selectQuestionList(); // 질문 목록
	public int insertQuestion(Question question); // 질문 작성
	public Question selectQuestionOne(Question question); // 질문 상세보기
	public int plusViews(int questionNo); // 조회수 +1
	public int insertViews(Question question); // 조회수 +1 (별도 테이블)
	public int viewsCount(Question question); // 조회수
}
