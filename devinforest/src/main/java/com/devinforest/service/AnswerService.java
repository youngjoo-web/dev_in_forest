package com.devinforest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	/* ---------- 답변 목록 ---------- */
	public Map<String, Object> getAnswerList(int currentPage, Answer answer){
		System.out.println("answerList service 시작");
		
		int rowPerPage = 5;
		int beginRow = (currentPage -1) * rowPerPage;
		int answerTotalRow = answerMapper.answerTotalRow(answer);
		System.out.println(answerTotalRow + " <-- answerTotalRow");
		int lastPage = answerTotalRow / rowPerPage;
		if(answerTotalRow % rowPerPage != 0) {
			lastPage += 1;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		map.put("questionNo", answer.getQuestionNo());
		
		System.out.println(beginRow + " <--- beginRow");
		System.out.println(rowPerPage + " <--- rowPerPage");
		System.out.println(lastPage + "<--  answerServicelastPage");
		
		List<Answer> answerList = answerMapper.selectAnswerList(map);
		
		System.out.println(answer + "<---- AnswerService answer");
		System.out.println(answerList + " <---- AnswerService answerList");
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("lastPage", lastPage);
		returnMap.put("answerList", answerList);
		
		return returnMap;
		
	}
	
	/* ---------- 답변  수정 ---------- */
	public int modifyAnswer(Answer answer) {
		
		return answerMapper.updateAnswer(answer);
	}
	
	/* ---------- 답변  삭제 ---------- */
	public int removeAnswer(Answer answer) {
		
		return answerMapper.deleteAnswer(answer);
	}
	
}
