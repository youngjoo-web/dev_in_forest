package com.devinforest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.AdminQuestionMapper;
import com.devinforest.vo.Question;

@Service
@Transactional
public class AdminQuestionService {
	@Autowired private AdminQuestionMapper adminQuestionMapper;
	
	// 질문 List 조회
	public Map<String, Object> getQuestionList(int currentPage, int rowPerPage, String searchWord) {
		System.out.println(searchWord + " <-- Service searchWord");
		
		int beginRow = (currentPage -1) * rowPerPage;
		int questionTotalRow = adminQuestionMapper.questionTotalRow(searchWord);
		System.out.println(questionTotalRow + " <-- questionTotalRow");
		int lastPage = questionTotalRow / rowPerPage;
		if(questionTotalRow % rowPerPage != 0) {
			lastPage += 1;
		}
		Map<String, Object> inputMap = new HashMap<String, Object>();
		inputMap.put("searchWord", searchWord);
		inputMap.put("beginRow", beginRow);
		inputMap.put("rowPerPage", rowPerPage);
		
		System.out.println(searchWord + " <--- searchWord");
		System.out.println(beginRow + " <--- beginRow");
		System.out.println(rowPerPage + " <--- rowPerPage");
		
		System.out.println(lastPage + "<--  questionService lastPage");
		List<Question> questionList = adminQuestionMapper.selectQuestionList(inputMap);
	
		System.out.println(questionList);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("questionTotalRow", questionTotalRow);
		returnMap.put("lastPage", lastPage);
		returnMap.put("questionList", questionList);
		
		return returnMap;
	}
	// 답변 List 조회
	public Map<String, Object> getAnswerList(int currentPage, int rowPerPage, String searchWord) {
		System.out.println(searchWord + " <-- Service searchWord");
		
		int beginRow = (currentPage -1) * rowPerPage;
		int answerTotalRow = adminQuestionMapper.answerTotalRow(searchWord);
		System.out.println(answerTotalRow + " <-- questionTotalRow");
		int lastPage = answerTotalRow / rowPerPage;
		if(answerTotalRow % rowPerPage != 0) {
			lastPage += 1;
		}
		Map<String, Object> inputMap = new HashMap<String, Object>();
		inputMap.put("searchWord", searchWord);
		inputMap.put("beginRow", beginRow);
		inputMap.put("rowPerPage", rowPerPage);
		
		System.out.println(searchWord + " <--- searchWord");
		System.out.println(beginRow + " <--- beginRow");
		System.out.println(rowPerPage + " <--- rowPerPage");
		
		System.out.println(lastPage + "<--  questionService lastPage");
		List<Question> answerList = adminQuestionMapper.selectAnswerList(inputMap);
	
		System.out.println(answerList);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("answerTotalRow", answerTotalRow);
		returnMap.put("lastPage", lastPage);
		returnMap.put("answerList", answerList);
		
		return returnMap;
	}
}
