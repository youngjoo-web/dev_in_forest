package com.devinforest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Suggest;

@Mapper
public interface SuggestMapper {
	//면접제의 작성하기
	public void insertSuggest(Suggest suggest);
	//면접제의 리스트 출력
	public List<Suggest> selectSuggestList(String memberName);
}	
