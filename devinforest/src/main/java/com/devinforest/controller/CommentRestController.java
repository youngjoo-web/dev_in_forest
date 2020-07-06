package com.devinforest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devinforest.mapper.CommentMapper;
import com.devinforest.vo.AnswerComment;
import com.devinforest.vo.QuestionComment;

@RestController
public class CommentRestController {
	
	@Autowired
	private CommentMapper commentMapper;
	
	/* ---------- 질문 댓글 목록 ---------- */
	@GetMapping("/getQuestionCommentList")
	public List<QuestionComment> getQuestionCommentList(QuestionComment questionComment,
			@RequestParam(value="rowPerPage", defaultValue="5") int rowPerPage,
			@RequestParam(value="showMore", defaultValue="false") boolean showMoreSwitch) {
		System.out.println(rowPerPage + " <--- rowPerPage");
		System.out.println(showMoreSwitch + " <--- showMoreSwitch");
		
		if(showMoreSwitch == true) {
			int questionCommentTotalRow = commentMapper.selectQuestionCommentTotalRow(questionComment);
			System.out.println(questionCommentTotalRow + " <---questionCommentTotalRow");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("rowPerPage", questionCommentTotalRow);
			map.put("questionNo", questionComment.getQuestionNo());
			
			List<QuestionComment> questionCommentList = commentMapper.selectQuestionCommentList(map);
			
			return questionCommentList;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowPerPage", rowPerPage);
		map.put("questionNo", questionComment.getQuestionNo());
		
		List<QuestionComment> questionCommentList = commentMapper.selectQuestionCommentList(map);
		
		
		return questionCommentList;
	}
	
	/* ---------- 질문 댓글 총 개수 ---------- */
	@GetMapping("/getQuestionCommentTotalRow")
	public int getQuestionCommentTotalRow(QuestionComment questionComment) {
		
		int questionCommentTotalRow = commentMapper.selectQuestionCommentTotalRow(questionComment);
		
		return questionCommentTotalRow;
	}
	
	/* ---------- 질문 댓글 생성 ---------- */
	@PostMapping("/addQuestionComment")
	public void addQuestionComment(QuestionComment questionComment) {
		System.out.println("↓questionComment↓");
		System.out.println(questionComment);
		
		int addResult = commentMapper.insertQuestionComment(questionComment);
			
		if(addResult == 1) {
			System.out.println("질문 댓글 생성 성공");
		} else {
			System.out.println("질문 댓글 생성 실패");
		}
	}
	
	
	/************************************************************************************************/
	/************************************************************************************************/
	
	
	/* ---------- 답변 댓글 목록 ---------- */
	@GetMapping("/getAnswerCommentList")
	public List<AnswerComment> getAnswerCommentList(AnswerComment answerComment,
			@RequestParam(value="rowPerPage", defaultValue="5") int rowPerPage,
			@RequestParam(value="showMore", defaultValue="false") boolean showMoreSwitch) {
		System.out.println(rowPerPage + " <--- rowPerPage");
		System.out.println(showMoreSwitch + " <--- showMoreSwitch");
		
		if(showMoreSwitch == true) {
			int answerCommentTotalRow = commentMapper.selectAnswerCommentTotalRow(answerComment);
			System.out.println(answerCommentTotalRow + " <---questionCommentTotalRow");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("rowPerPage", answerCommentTotalRow);
			map.put("answerNo", answerComment.getAnswerNo());
			
			List<AnswerComment> answerCommentList = commentMapper.selectAnswerCommentList(map);
			
			return answerCommentList;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowPerPage", rowPerPage);
		map.put("answerNo", answerComment.getAnswerNo());
		
		List<AnswerComment> answerCommentList = commentMapper.selectAnswerCommentList(map);
		
		
		return answerCommentList;
	}
	
	/* ---------- 답변 댓글 총 개수 ---------- */
	@GetMapping("/getAnswerCommentTotalRow")
	public int getAnswerCommentTotalRow(AnswerComment answerComment) {
		
		int answerCommentTotalRow = commentMapper.selectAnswerCommentTotalRow(answerComment);
		
		return answerCommentTotalRow;
	}
	
	/* ---------- 답변 댓글 생성 ---------- */
	@PostMapping("/addAnswerComment")
	public void addAnswerComment(AnswerComment answerComment) {
		System.out.println("↓answerComment↓");
		System.out.println(answerComment);
		
		int addResult = commentMapper.insertAnswerComment(answerComment);
			
		if(addResult == 1) {
			System.out.println("답변 댓글 생성 성공");
		} else {
			System.out.println("답변 댓글 생성 실패");
		}
	}
}
