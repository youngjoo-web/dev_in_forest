package com.devinforest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.CompanyMapper;
import com.devinforest.vo.Company;

@Service
@Transactional
public class CompanyService {
	@Autowired
	private CompanyMapper companyMapper;

	// 기업회원가입
	public int addCompanyMember(Company company) {
		return companyMapper.insertCompanyMember(company);

	}

	// 관리자 이메일 중복체크
	public int checkCompanyEmail(String companyEmail) {
		return companyMapper.selectselectCompanyEmail(companyEmail);
	}

	// 기업한글이름 중복체크
	public int checkCompanyKorName(String companyKorName) {
		return companyMapper.checkCompanyKorName(companyKorName);
	}
	// 기업영어이름 중복체크
		public int checkCompanyEngName(String companyEngName) {
			return companyMapper.checkCompanyEngName(companyEngName);
		}
}
