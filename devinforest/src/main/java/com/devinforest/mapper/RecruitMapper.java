package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Recruit;

@Mapper
public interface RecruitMapper {
	//통합 채용공고리스트 
	public List<Recruit> selectRecruitList(Map<String, Object> map);
	//채용공고리스트(면접제의용)
	public List<Recruit> recruitListForSuggest(String companyKorName);
	//기업별 채용공고리스트
	public List<Recruit> selectRecruitListByCompany(Map<String, Object> map);
	//기업별 채용공고 갯수
	public int recruitTotalCountByCompany(String searchWord);
	//채용공고 토탈카운트
	public int recruitTotalCount(String searchWord);
	//채용공고 상세보기
	public Recruit selectRecruitInfo(int recruitNo);
	//채용공고 추가
	public void insertRecruit(Recruit recruit);
}
