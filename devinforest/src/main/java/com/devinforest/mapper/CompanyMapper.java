package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Company;
import com.devinforest.vo.LoginCompany;

@Mapper
public interface CompanyMapper {
	//기업회원가입
	public int insertCompanyMember(Company company);
	//이메일중복확인
	public int checkCompanyEmail(String companyEmail);
	//한글이름중복확인
	public int checkCompanyKorName(String companyKorName);
	//영어이름중복확인
	public int checkCompanyEngName(String companyEngName);
	//기업 로그인
	public LoginCompany selectLoginCompanyMamber(LoginCompany loginCompany);
	//기업정보 상세보기
	public Company selectCompanyInfo(LoginCompany loginCompany);
	//기업정보 업데이트
	public void updateCompany(Company company);
	//기업정보 업데이트 하기 전에 확인
	public int checkCompanyPw(LoginCompany loginCompany);
	//기업리스트 출력
	public List<Company> selectCompanyList(Map<String, Object> map);
	//기업토탈갯수
	public int selectSearchCompanyCount(String searchWord);
}
