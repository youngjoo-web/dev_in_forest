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
	
	public int addMember(LoginMember loginMember) {
		Member member = new Member();
		member.setMemberEmail(loginMember.getMemberEmail());
		member.setMemberPassword(loginMember.getMemberPassword());
		member.setMemberName(loginMember.getMemberName());
		int row=memberMapper.insertMember(member);
		return row;
	}
	
}
