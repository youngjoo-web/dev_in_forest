package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Answer;
import com.devinforest.vo.Question;

@Mapper
public interface AnswerMapper {
	public List<Answer> selectAnswerList(Map<String, Object> map);
	public int insertAnswer(Answer answer);
	public int updateAnswer(Answer answer);
	public int answerTotalCount(Question question);
	
	public Answer selectAnswerOne(Answer answer); // 백업할 게시글 답변 가져오기
	public int insertAnswerBack(Answer answer); // 게시글 댓글 백업
	public void deleteAnswer(Answer answer); // 게시글 답변 삭제
	public void deleteAnswerAll(Question question); // 게시글 삭제를 위해 게시글의 모든 답변 삭제
	public int answerListTotalCount();
	
}
