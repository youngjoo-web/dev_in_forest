package com.devinforest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.AdminQuestionMapper;
import com.devinforest.vo.Answer;
import com.devinforest.vo.AnswerComment;
import com.devinforest.vo.Question;
import com.devinforest.vo.QuestionComment;

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
	
		System.out.println(questionList + " <--- questionList");
		
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
		System.out.println(answerTotalRow + " <-- answerTotalRow");
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
		List<Answer> answerList = adminQuestionMapper.selectAnswerList(inputMap);
	
		System.out.println(answerList + " <--- answerList");
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("answerTotalRow", answerTotalRow);
		returnMap.put("lastPage", lastPage);
		returnMap.put("answerList", answerList);
		
		return returnMap;
	}
	// 질문댓글 List 조회
	public Map<String, Object> getQuestionCommentList(int currentPage, int rowPerPage, String searchWord) {
		System.out.println(searchWord + " <-- Service searchWord");
		
		int beginRow = (currentPage -1) * rowPerPage;
		int questionCommentTotalRow = adminQuestionMapper.selectQuestionCommentTotalRow(searchWord);
		System.out.println(questionCommentTotalRow + " <-- questionCommentTotalRow");
		int lastPage = questionCommentTotalRow / rowPerPage;
		if(questionCommentTotalRow % rowPerPage != 0) {
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
		List<QuestionComment> questionCommentList = adminQuestionMapper.selectQuestionCommentList(inputMap);
	
		System.out.println(questionCommentList + " <--- questionCommentList");
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("questionCommentTotalRow", questionCommentTotalRow);
		returnMap.put("lastPage", lastPage);
		returnMap.put("questionCommentList", questionCommentList);
		
		return returnMap;
	}
	// 답변댓글 List 조회
	public Map<String, Object> getAnswerCommentList(int currentPage, int rowPerPage, String searchWord) {
		System.out.println(searchWord + " <-- Service searchWord");
		
		int beginRow = (currentPage -1) * rowPerPage;
		int answerCommentTotalRow = adminQuestionMapper.selectAnswerCommentTotalRow(searchWord);
		System.out.println(answerCommentTotalRow + " <-- answerCommentTotalRow");
		int lastPage = answerCommentTotalRow / rowPerPage;
		if(answerCommentTotalRow % rowPerPage != 0) {
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
		
		List<AnswerComment> answerCommentList = adminQuestionMapper.selectAnswerCommentList(inputMap);
		System.out.println(answerCommentList + " <--- answerCommentList");
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("answerCommentTotalRow", answerCommentTotalRow);
		returnMap.put("lastPage", lastPage);
		returnMap.put("answerCommentList", answerCommentList);
		
		return returnMap;
	}
	// 질문내용 상세보기
	public Question getQuestionOne(int questionNo) {
		return adminQuestionMapper.selectQuestionOne(questionNo);
	}
	// 상세보기 답변내용
	public List<Answer> getAnswerOne(int questionNo) {
		return adminQuestionMapper.selectAnswerOne(questionNo);
	}
	// 상세보기 질문댓글
	public List<QuestionComment> getQuestionCommentOne(int questionNo) {
		return adminQuestionMapper.selectQuestionCommentOne(questionNo);
	}
	// 상세보기 답변댓글
	public List<AnswerComment> getAnswerCommentOne(int answerNo) {
		return adminQuestionMapper.selectAnswerCommentOne(answerNo);
	}
}
