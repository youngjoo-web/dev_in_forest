package com.devinforest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.CompanyMapper;
import com.devinforest.vo.Company;
import com.devinforest.vo.LoginCompany;

@Service
@Transactional
public class CompanyService {
	@Autowired
	private CompanyMapper companyMapper;
	//기업 정보 수정
	public void modifyCompany(Company company) {
		companyMapper.updateCompany(company);
	}
	//기업정보 상세보기
	public Company getCompanyInfo(LoginCompany loginCompany) {
		System.out.println(loginCompany+"----companyService");
		return companyMapper.selectCompanyInfo(loginCompany);
	}
	//비밀번호확인(정보수정)
	public int checkCompanyPw(LoginCompany loginCompany) {
		return companyMapper.checkCompanyPw(loginCompany);
	}
	//기업리스트 출력
	public Map<String, Object> getCompanyList(int currentPage, int rowPerPage, String searchWord){
		int beginRow=(currentPage-1)*rowPerPage;
		int companyTotalCount = companyMapper.selectSearchCompanyCount(searchWord);
		int lastPage = companyTotalCount/rowPerPage;
		
		if(companyTotalCount % rowPerPage != 0) {
			lastPage+=1;
		}
		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("beginRow", beginRow);
		inputMap.put("rowPerPage", rowPerPage);
		inputMap.put("searchWord", searchWord);
		List<Company> companyList= companyMapper.selectCompanyList(inputMap);
		Map<String, Object> outputMap = new HashMap<>();
		outputMap.put("companyTotalCount", companyTotalCount);
		outputMap.put("lastPage", lastPage);
		outputMap.put("companyList", companyList);
		return outputMap;
	}
	//기업 로그인
	public LoginCompany companyLogin(LoginCompany loginCompany) {
		System.out.println("companyService" + loginCompany);
		return companyMapper.selectLoginCompanyMamber(loginCompany);
	}
	// 기업회원가입
	public int addCompanyMember(Company company) {
		return companyMapper.insertCompanyMember(company);
	}
	// 관리자 이메일 중복체크
	public int checkCompanyEmail(String companyEmail) {
		return companyMapper.checkCompanyEmail(companyEmail);
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
