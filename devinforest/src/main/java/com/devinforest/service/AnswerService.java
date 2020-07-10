package com.devinforest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.AnswerMapper;
import com.devinforest.vo.Answer;

@Service
@Transactional
public class AnswerService {

	@Autowired
	private AnswerMapper answerMapper;
	
	/* ---------- 답변  수정 ---------- */
	public int modifyAnswer(Answer answer) {
		
		return answerMapper.updateAnswer(answer);
	}
	
	/* ---------- 답변  삭제 ---------- */
	public void removeAnswer(Answer answer) {
		
		answerMapper.deleteAnswer(answer);
	}
	
}
