package com.devinforest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.AdminBlackQuestionMapper;
import com.devinforest.vo.AnswerBack;
import com.devinforest.vo.AnswerCommentBack;
import com.devinforest.vo.QuestionBack;
import com.devinforest.vo.QuestionCommentBack;

@Service
@Transactional
public class AdminBlackQuestionService {
	@Autowired private AdminBlackQuestionMapper adminBlackQuestionMapper;
	// 블랙 질문 목록
	public Map<String, Object> getBlackQuestionList(int currentPage, int rowPerPage, String searchWord){
		int beginRow =(currentPage-1)*rowPerPage;
		int blackQuestionTotalCount = adminBlackQuestionMapper.blackQuestionTotalCount(searchWord); 
		System.out.println(blackQuestionTotalCount+" <- AdminBlackQuestionService.getBlackQuestionList: blackQuestionTotalCount");
		int lastPage = blackQuestionTotalCount/rowPerPage;
		if(blackQuestionTotalCount % rowPerPage != 0) {
			lastPage+=1;
		}
		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("beginRow", beginRow);
		inputMap.put("rowPerPage", rowPerPage);
		inputMap.put("searchWord", searchWord);
		List<QuestionBack> blackQuestionList = adminBlackQuestionMapper.selectBlackQuestionList(inputMap);
		System.out.println(lastPage+" <- AdminBlackQuestionService.getBlackQuestionList: lastPage");
		System.out.println(blackQuestionList+" <- AdminBlackQuestionService.getBlackQuestionList: blackQuestionList");
		Map<String, Object> outputMap = new HashMap<>();
		outputMap.put("blackQuestionTotalCount", blackQuestionTotalCount);
		outputMap.put("lastPage", lastPage);
		outputMap.put("blackQuestionList", blackQuestionList);
		return outputMap;
	}
	// 블랙 답변 목록
	public Map<String, Object> getBlackAnswerList(int currentPage, int rowPerPage, String searchWord){
		int beginRow =(currentPage-1)*rowPerPage;
		int blackAnswerTotalCount = adminBlackQuestionMapper.blackAnswerTotalCount(searchWord); 
		System.out.println(blackAnswerTotalCount+" <- AdminBlackQuestionService.getBlackAnswerList: blackAnswerTotalCount");
		int lastPage = blackAnswerTotalCount/rowPerPage;
		if(blackAnswerTotalCount % rowPerPage != 0) {
			lastPage+=1;
		}
		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("beginRow", beginRow);
		inputMap.put("rowPerPage", rowPerPage);
		inputMap.put("searchWord", searchWord);
		List<AnswerBack> blackAnswerList = adminBlackQuestionMapper.selectBlackAnswerList(inputMap);
		System.out.println(lastPage+" <- AdminBlackQuestionService.getBlackQuestionList: lastPage");
		System.out.println(blackAnswerList+" <- AdminBlackQuestionService.getBlackAnswerList: blackAnswerList");
		Map<String, Object> outputMap = new HashMap<>();
		outputMap.put("blackAnswerTotalCount", blackAnswerTotalCount);
		outputMap.put("lastPage", lastPage);
		outputMap.put("blackAnswerList", blackAnswerList);
		return outputMap;
	}
	// 블랙 질문댓글 목록
	public Map<String, Object> getBlackQuestionCommentList(int currentPage, int rowPerPage, String searchWord){
		int beginRow =(currentPage-1)*rowPerPage;
		int blackQuestionCommentTotalCount = adminBlackQuestionMapper.blackQuestionCommentTotalCount(searchWord); 
		System.out.println(blackQuestionCommentTotalCount+" <- AdminBlackQuestionService.getBlackQuestionCommentList: blackQuestionCommentTotalCount");
		int lastPage = blackQuestionCommentTotalCount/rowPerPage;
		if(blackQuestionCommentTotalCount % rowPerPage != 0) {
			lastPage+=1;
		}
		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("beginRow", beginRow);
		inputMap.put("rowPerPage", rowPerPage);
		inputMap.put("searchWord", searchWord);
		List<QuestionCommentBack> blackQuestionCommentList = adminBlackQuestionMapper.selectBlackQuestionCommentList(inputMap);
		System.out.println(lastPage+" <- AdminBlackQuestionService.getBlackQuestionCommentList: lastPage");
		System.out.println(blackQuestionCommentList+" <- AdminBlackQuestionService.getBlackQuestionCommentList: blackQuestionCommentList");
		Map<String, Object> outputMap = new HashMap<>();
		outputMap.put("blackQuestionCommentTotalCount", blackQuestionCommentTotalCount);
		outputMap.put("lastPage", lastPage);
		outputMap.put("blackQuestionCommentList", blackQuestionCommentList);
		return outputMap;
	}
	// 블랙 답변댓글 목록
		public Map<String, Object> getBlackAnswerCommentList(int currentPage, int rowPerPage, String searchWord){
			int beginRow =(currentPage-1)*rowPerPage;
			int blackAnswerCommentTotalCount = adminBlackQuestionMapper.blackAnswerCommentTotalCount(searchWord); 
			System.out.println(blackAnswerCommentTotalCount+" <- AdminBlackQuestionService.getBlackAnswerCommentList: blackAnswerCommentTotalCount");
			int lastPage = blackAnswerCommentTotalCount/rowPerPage;
			if(blackAnswerCommentTotalCount % rowPerPage != 0) {
				lastPage+=1;
			}
			Map<String, Object> inputMap = new HashMap<>();
			inputMap.put("beginRow", beginRow);
			inputMap.put("rowPerPage", rowPerPage);
			inputMap.put("searchWord", searchWord);
			List<AnswerCommentBack> blackAnswerCommentList = adminBlackQuestionMapper.selectBlackAnswerCommentList(inputMap);
			System.out.println(lastPage+" <- AdminBlackQuestionService.getBlackAnswerCommentList: lastPage");
			System.out.println(blackAnswerCommentList+" <- AdminBlackQuestionService.getBlackAnswerCommentList: blackQuestionCommentList");
			Map<String, Object> outputMap = new HashMap<>();
			outputMap.put("blackAnswerCommentTotalCount", blackAnswerCommentTotalCount);
			outputMap.put("lastPage", lastPage);
			outputMap.put("blackAnswerCommentList", blackAnswerCommentList);
			return outputMap;
		}
}
