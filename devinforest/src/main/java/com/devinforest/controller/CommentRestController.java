package com.devinforest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devinforest.mapper.QuestionCommentMapper;
import com.devinforest.vo.QuestionComment;

@RestController
public class CommentRestController {
	
	@Autowired
	private QuestionCommentMapper commentMapper;
	
	/* ---------- 질문 댓글 목록 ---------- */
	@GetMapping("/getQuestionCommentList")
	public List<QuestionComment> getQuestionCommentList(QuestionComment questionComment,
			@RequestParam(value="rowPerPage", defaultValue="5") int rowPerPage) {
		System.out.println(rowPerPage + " <--- rowPerPage");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rowPerPage", rowPerPage);
		map.put("questionNo", questionComment.getQuestionNo());
		
		List<QuestionComment> questionCommentList = commentMapper.selectQuestionCommentList(map);
		
		
		return questionCommentList;
	}
	
	@GetMapping("/getQuestionCommentTotalRow")
	public int getQuestionCommentTotalRow(QuestionComment questionComment) {
		
		int questionCommentTotalRow = commentMapper.selectQuestionCommentTotalRow(questionComment);
		
		return questionCommentTotalRow;
	}
	
	/* ---------- 질문 댓글 생성 ---------- */
	@PostMapping("/addQuestionComment")
	public void addComment(QuestionComment questionComment) {
		System.out.println("↓questionComment↓");
		System.out.println(questionComment);
		
		int addResult = commentMapper.insertQuestionComment(questionComment);
			
		if(addResult == 1) {
			System.out.println("질문 댓글 생성 성공");
		} else {
			System.out.println("질문 댓글 생성 실패");
		}
	}
	
}
