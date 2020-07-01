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
		// 조회수 +1
//		questionMapper.plusViews(question);
		questionMapper.insertViews(question);
		int viewsCount = questionMapper.viewsCount(question);
		Question questionOne = questionMapper.selectQuestionOne(question); 
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("viewsCount", viewsCount);
		map.put("questionOne", questionOne);
		return map;
	}
}
