package com.devinforest.service;

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
	public List<Question> getQuestionList() {
		List<Question> questionList = questionMapper.selectQuestionList();
		return questionList;
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
		}
		
		int viewsCount = questionMapper.viewsCount(question);
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
		return 0;
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
}
