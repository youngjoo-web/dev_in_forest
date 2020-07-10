package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Question;

@Mapper
public interface AdminQuestionMapper {
	public List<Question> selectQuestionList(Map<String, Object> inputMap);
	public int questionTotalRow(String searchWord);
}
