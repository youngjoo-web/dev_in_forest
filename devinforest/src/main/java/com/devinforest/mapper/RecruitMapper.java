package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Apply;
import com.devinforest.vo.Company;
import com.devinforest.vo.Recruit;

@Mapper
public interface RecruitMapper {
	//채용공고 수정
	public int updateRecruitByCompany(Recruit recruit);
	//채용공고 삭제
	public int deleteRecruitByCompany(Recruit recruit);
	//채용공고 명성도제한 출력
	public int selectRecruitReputation(Apply apply);
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
	//기업회원탈퇴
	public int deleteRecruit(Company company);
}
