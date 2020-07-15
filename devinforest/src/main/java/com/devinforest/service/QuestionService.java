package com.devinforest.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.QuestionMapper;
import com.devinforest.vo.Question;

@Service
@Transactional
public class QuestionService {
	
	@Autowired
	private QuestionMapper questionMapper;
	
	/* ---------- 질문 목록 ---------- */
	public Map<String, Object> getQuestionList(int currentPage, String searchWord) {
		System.out.println(searchWord + " <-- Service searchWord");
		
		
		int rowPerPage = 5;
		int beginRow = (currentPage -1) * rowPerPage;
		int questionTotalRow = questionMapper.questionTotalRow(searchWord);
		System.out.println(questionTotalRow + " <-- questionTotalRow");
		int lastPage = questionTotalRow / rowPerPage;
		if(questionTotalRow % rowPerPage != 0) {
			lastPage += 1;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchWord", searchWord);
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		
		System.out.println(searchWord + " <--- searchWord");
		System.out.println(beginRow + " <--- beginRow");
		System.out.println(rowPerPage + " <--- rowPerPage");
		System.out.println(lastPage + "<--  questionServicelastPage");
		
		
		List<Question> questionList = questionMapper.selectQuestionList(map);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("lastPage", lastPage);
		returnMap.put("questionList", questionList);
		
		return returnMap;
	}
	
	/* ---------- 질문 작성 ---------- */
	public int addQuestion(Question question) {
		return questionMapper.insertQuestion(question);
	}
	
	/* ---------- 질문 상세보기 ---------- */
	public Map<String, Object> getQuestionOne(Question question) {
		
		String viewsCheck = questionMapper.viewsCheck(question);
		System.out.println(viewsCheck + " <-- viewsCheck");
		
		if(viewsCheck == null) { // member_name == null 이면 조회수를 +1 , 체크를 name으로 할지 ip로 할지는 생각 해봐야 함, 비회원은 어떻게 할 건지도 생각
			questionMapper.plusViews(question);
			int viewsCountOne = questionMapper.viewsCountOne(question); // 질문 상세보기의 조회수를 가져온다.
			
			// viewsCountOne 변수를 매개변수로 질문 목록의 조회수를 수정해준다. (질문 목록 조회수 = 질문 상세보기 조회수)
			questionMapper.listViewsCount(viewsCountOne, question.getQuestionNo());
		}
		
		int viewsCount = questionMapper.viewsCountOne(question);
		Question questionOne = questionMapper.selectQuestionOne(question); 
			
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("viewsCount", viewsCount);
		map.put("questionOne", questionOne);
			
		return map;
	}
	
	/* ---------- 질문 수정 ---------- */
	// 수정할 질문 가져오기
	public Question getModifyQuestionOne(Question question) {
		return questionMapper.selectQuestionOne(question);
	}
	
	
	public int modifyQuestion(Question question) {
		return questionMapper.updateQuestion(question);
	}
	
	/* ---------- 질문 삭제 ---------- */
	public int removeQuestion(Question question) {
		System.out.println(question.getQuestionNo() + "<--- removeQuestionNo");
		Question questionBack = questionMapper.selectQuestionOne(question);
		int backResult = questionMapper.insertQuestionBack(questionBack);
		if(backResult == 1) {
			System.out.println("질문 백업 성공");
		} else {
			System.out.println("질문 백업 실패");
		}
		return questionMapper.deleteQuestion(question);
	}
	/* ---------- 삭제된 질문 목록 ---------- */
	public Map<String, Object> getRemovedQuestionList(int currentPage, String searchWord) {
		System.out.println(searchWord + " <-- Service searchWord");
		
		
		int rowPerPage = 5;
		int beginRow = (currentPage -1) * rowPerPage;
		int deletedQuestionTotalRow = questionMapper.questionTotalRow(searchWord);
		System.out.println(deletedQuestionTotalRow + " <-- deletedQuestionTotalRow");
		int lastPage = deletedQuestionTotalRow / rowPerPage;
		if(deletedQuestionTotalRow % rowPerPage != 0) {
			lastPage += 1;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchWord", searchWord);
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		
		System.out.println(searchWord + " <--- searchWord");
		System.out.println(beginRow + " <--- beginRow");
		System.out.println(rowPerPage + " <--- rowPerPage");
		
		System.out.println(lastPage + "<--  questionServicelastPage");
		List<Question> questionList = questionMapper.selectQuestionList(map);
	
		System.out.println(questionList);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("lastPage", lastPage);
		returnMap.put("questionList", questionList);
		
		return returnMap;
	}
}
