package com.devinforest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.MemberMapper;
import com.devinforest.vo.Admin;
import com.devinforest.vo.LoginMember;
import com.devinforest.vo.Member;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;

	// 회원목록
	public Map<String, Object> getMemberList(int currentPage, int rowPerPage, String searchWord) {
		int beginRow=(currentPage-1)*rowPerPage;
		int memberTotalCount = memberMapper.memberTotalCount(searchWord);
		int lastPage = memberTotalCount/rowPerPage;
		
		if(memberTotalCount % rowPerPage != 0) {
			lastPage+=1;
		}
		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("beginRow", beginRow);
		inputMap.put("rowPerPage", rowPerPage);
		inputMap.put("searchWord", searchWord);
		List<Member> memberList = memberMapper.selectMemberList(inputMap);
		System.out.println(memberTotalCount+" <- memberService.getmember: memberTotalCount");
		System.out.println(lastPage+" <- memberService.getmember: lastPage");
		System.out.println(memberList+" <- memberService.getmember: memberList");
		Map<String, Object> outputMap = new HashMap<>();
		outputMap.put("memberTotalCount", memberTotalCount);
		outputMap.put("lastPage", lastPage);
		outputMap.put("memberList", memberList);
		return outputMap;
	}

	// 회원가입
	public int addMember(LoginMember loginMember) {
		Member member = new Member();
		member.setMemberEmail(loginMember.getMemberEmail());
		member.setMemberPassword(loginMember.getMemberPassword());
		member.setMemberName(loginMember.getMemberName());
		int row = memberMapper.insertMember(member);
		return row;
	}

	// 로그인
	public LoginMember memberLogin(LoginMember loginMember) {
		System.out.println("memberService" + loginMember);
		return memberMapper.selectLoginMember(loginMember);
	}

	// 이메일 중복확인
	public String CheckMemberEmail(LoginMember loginMember) {
		return memberMapper.selectMemberEmail(loginMember.getMemberEmail());
	}

	// 닉네임 중복확인
	public String CheckMemberName(LoginMember loginMember) {
		return memberMapper.selectMemberName(loginMember.getMemberName());
	}

	// 회원정보 상세보기
	public Member getMemberInfo(LoginMember loginMember) {
		return memberMapper.selectMemberInfo(loginMember);
	}

	// 회원탈퇴
	public void removeMember(LoginMember loginMember) {
		memberMapper.deleteMember(loginMember);
	}

	// 회원정보 수정
	public int modifyMember(Member member) {
		return memberMapper.updateMember(member);
	}
}
