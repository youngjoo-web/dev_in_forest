package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Question;
import com.devinforest.vo.QuestionAndQuestionHashtag;

@Mapper
public interface QuestionMapper {
   public List<Question> selectQuestionList(Map<String, Object> map); // 질문 목록
   public List<QuestionAndQuestionHashtag>selectQuestionListByHashtag(Map<String, Object> map); // 해시태그로 검색한 질문 목록
   public int insertQuestion(Question question); // 질문 작성
   public Question selectQuestionOne(Question question); // 질문 상세보기
   public int plusViews(Question question); // 조회수 +1 
   public int viewsCountOne(Question question); // 조회수
   public String viewsCheck(Question question); // 조회수 체크
   public int listViewsCount(int viewsCountOne, int questionNo); // 질문리스트 조회수 
   public int updateQuestion(Question question); // 질문 수정
   public int deleteQuestion(Question question); // 질문 삭제
   public int insertQuestionBack(Question question); // 질문 삭제 전 백업
   public int questionTotalRow(String searchWord); // 질문 총 개수
   public int questionHashtagTotalRow(String hashtagName); // 해시태그 검색 질문 총 개수
   public int deletedQuestionTotalRow(String searchWord); // 삭제된 질문 총 개수
   public List<Question> selectRomovedQuestion(); // 삭제된 질문 목록
   public List<Integer> voteTotalCount(List<Integer> questionNo); // 투표 총 카운트
   public int answersCountOne(Question question); // 질문에 대한 답변 개수
   public int listAnswersCount(int answersCountOne, int questionNo); // 질문리스트 답변수
   public int votesCountOne(Question question); // 질문리스트에 대한 투표 개수
   public int listVotesCount(int votesCountOne, int questionNo); // 질문리스트 투표수
   public int selectQuestionNoMax(); // 가장 큰 질문번호
}