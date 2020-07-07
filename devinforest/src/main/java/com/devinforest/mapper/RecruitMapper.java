package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Recruit;

@Mapper
public interface RecruitMapper {
	//통합 채용공고리스트 
	public List<Recruit> selectRecruitList(Map<String, Object> map);
	//기업별 채용공고리스트
	//채용공고 토탈카운트
	public int recruitTotalCount(String searchWord);
}
