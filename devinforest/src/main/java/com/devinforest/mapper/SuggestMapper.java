package com.devinforest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Suggest;

@Mapper
public interface SuggestMapper {
	//면접제의 중복체크
	public int checkSuggest(Suggest suggest);
	//면접제의 작성하기
	public void insertSuggest(Suggest suggest);
	//면접제의 리스트 출력
	public List<Suggest> selectSuggestList(String memberName);
	//기업용 면접제의 리스트
	public List<Suggest> selectSuggestListForCompany(String companyName);
	//면접제의 거부에서 수락으로 변경
	public void updateSuggestType(Suggest suggest);
	//면접제의 수락에서 거부으로 변경
	public void unupdateSuggestType(Suggest suggest);
	

}	
