package com.devinforest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.MemberMapper;
import com.devinforest.vo.LoginMember;
import com.devinforest.vo.Member;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	//회원가입
	public int addMember(LoginMember loginMember) {
		Member member = new Member();
		member.setMemberEmail(loginMember.getMemberEmail());
		member.setMemberPassword(loginMember.getMemberPassword());
		member.setMemberName(loginMember.getMemberName());
		int row=memberMapper.insertMember(member);
		return row;
	}
	//로그인
	public LoginMember memberLogin(LoginMember loginMember) {
		System.out.println("memberService"+loginMember);
		return memberMapper.selectLoginMember(loginMember);
	}
	public String CheckMemberEmail (LoginMember loginMember) {
		return memberMapper.selectMemberEmail(loginMember.getMemberEmail());
	}
	public String CheckMemberName (LoginMember loginMember) {
		return memberMapper.selectMemberName(loginMember.getMemberName());
	}
}
