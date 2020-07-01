package com.devinforest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Question;

@Mapper
public interface QuestionMapper {
	public List<Question> selectQuestionList(); // 질문 목록
	public int insertQuestion(Question question); // 질문 작성
	public Question selectQuestionOne(Question question); // 질문 상세보기
	public int plusViews(Question question); // 조회수 +1 
	public int viewsCount(Question question); // 조회수
	public String viewsCheck(Question question); // 조회수 체크
	public int updateQuestion(Question question); // 질문 수정
	public int deleteQuestion(Question question); // 질문 삭제
	public int insertQuestionBack(Question question); // 질문 삭제 전 백업
}
