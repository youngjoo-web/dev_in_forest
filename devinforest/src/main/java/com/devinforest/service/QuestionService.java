package com.devinforest.service;

import java.util.List;

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
}
