package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Answer;

@Mapper
public interface AnswerMapper {
	public List<Answer> selectAnswerList(Map<String, Object>map);
	public int insertAnswer(Answer answer);
	public int deleteAnswer(Answer answer);
	public int updateAnswer(Answer answer);
	public int insertAnswerBack(Answer answer);
	public int answerTotalRow(Answer answer);
}
