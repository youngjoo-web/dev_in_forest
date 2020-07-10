package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.LoginMember;
import com.devinforest.vo.Member;
import com.devinforest.vo.Restoration;

@Mapper
public interface MemberMapper {
	//회원 재가입요청
	public int insertRequestRestore(Restoration restoration);
	//회원정보 수정
	public int updateMember(Member member);
	//아이디 찾기
	public String selectEmailByMember(Member member);
	//비밀번호 찾기
	public int findMemberPw(LoginMember loginMember);
	//회원 탈퇴
	public int deleteMember(LoginMember loginMember);
	//회원정보 불러오기
	public Member selectMemberInfo(LoginMember loginMember);
	//재가입 이메일 중복확인
	public int checkRestEmail(String restorationTitle);
	//이름 중복 확인
	public int checkMemberName(String memberName);
	//이메일 중복 확인
	public int checkMemberEmail(String memberEmail);
	//로그인
	public LoginMember selectLoginMember(LoginMember loginMember);
	//회원가입
	public int insertMember(Member member);
	//회원목록
	public List<Member> selectMemberList(Map<String, Object> map);
	//회원 totalCount
	public int memberTotalCount(String searchWord);
}
