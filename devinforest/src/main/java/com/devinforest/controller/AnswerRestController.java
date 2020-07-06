package com.devinforest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devinforest.mapper.AnswerMapper;
import com.devinforest.vo.Answer;

@RestController
public class AnswerRestController {

	@Autowired
	private AnswerMapper answerMapper;
	
	/* ---------- 답변 작성하기 ---------- */
	@PostMapping("/addAnswer")
	public void addAnswer(Answer answer) {
		System.out.println(answer + " <----- AnswerRestController answer");
		answerMapper.insertAnswer(answer);
	}
	
	@GetMapping("/getAnswerList")
	public Map<String, Object> answerList(Answer answer,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage) {
		
		int rowPerPage = 10;
		int beginRow = (currentPage - 1) * rowPerPage;
		int answerTotalRow = answerMapper.answerTotalRow(answer);
		int lastPage = answerTotalRow / rowPerPage;
		if(answerTotalRow % rowPerPage != 0) {
			lastPage += 1;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowPerPage", rowPerPage);
		map.put("beginRow", beginRow);
		map.put("questionNo", answer.getQuestionNo());
		
		List<Answer> answerList = answerMapper.selectAnswerList(map);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("lastPage", lastPage);
		returnMap.put("answerList", answerList);
		
		return returnMap;
	}
}
