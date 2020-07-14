package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Question;

@Mapper
public interface QuestionMapper {
	public List<Question> selectQuestionList(Map<String, Object> map); // 질문 목록
	public int insertQuestion(Question question); // 질문 작성
	public Question selectQuestionOne(Question question); // 질문 상세보기
	public int plusViews(Question question); // 조회수 +1 
	public int viewsCountOne(Question question); // 조회수
	public String viewsCheck(Question question); // 조회수 체크
	public int listViewsCount(int viewsCountOne, int questionNo);
	public int updateQuestion(Question question); // 질문 수정
	public int deleteQuestion(Question question); // 질문 삭제
	public int insertQuestionBack(Question question); // 질문 삭제 전 백업
	public int questionTotalRow(String searchWord); // 질문 총 개수
	public int deletedQuestionTotalRow(String searchWord); // 삭제된 질문 총 개수
	public List<Question> selectRomovedQuestion(); // 삭제된 질문 목록
	public List<Integer> voteTotalCount(List<Integer> questionNo);
}
