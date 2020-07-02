package com.devinforest.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Company;

@Mapper
public interface CompanyMapper {
	//기업회원가입
	public int insertCompanyMember(Company company);
	//이메일중복확인
	public int selectselectCompanyEmail(String companyEmail);
	//한글이름중복확인
	public int checkCompanyKorName(String companyKorName);
	//영어이름중복확인
	public int checkCompanyEngName(String companyEngName);
}
