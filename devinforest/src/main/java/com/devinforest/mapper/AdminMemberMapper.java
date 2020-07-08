package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.BlackList;
import com.devinforest.vo.Company;
import com.devinforest.vo.Member;

@Mapper
public interface AdminMemberMapper {
	// 블랙 팝업창에 출력할 데이터 출력
	public String blackMemberOne(String memberName);
	// 멤버 삭제
	public int deleteMemberByName(String memberName);
	// 블랙리스트 추가
	public void insertBlackList(BlackList blackList);
	// 재가입 실행 시 이메일 있는지 확인
	public String selectMemberEmail(String memberEmail);
	// 회원복구 or 재가입 실행- 회원상태변경
	public void updateMemberState(String memberEmail);
	// 블랙회원 목록
	public List<BlackList> selectBlackMemberList(Map<String, Object> inputMap);
	// 블랙회원 totalCount
	public int blackTotalCount(String searchWord);
	// 탈퇴회원 목록
	public List<Member> selectRemoveMemberList(Map<String, Object> map);
	// 탈퇴회원 totalCount
	public int selectRemoveMemberTotalCount(String searchWord);
	// 기업회원 목록
	public List<Company> selectCompanyList(Map<String, Object> map);
	// 기업회원 totalCount
	public int selectCompanyTotalCount(String searchWord);
	// 기업회원 상세보기
	public Company selectCompanyInfo(String companyEmail);
	// 일반회원 목록
	public List<Member> selectMemberList(Map<String, Object> inputMap);
	// 일반회원 totalCount
	public int memberTotalCount(String searchWord);
	// 일반회원 상세보기
	public Member selectMemberInfo(String memberEmail);
}
