package com.devinforest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.AdminMemberMapper;
import com.devinforest.vo.BlackList;

@Service
@Transactional
public class AdminMemberService {
	@Autowired private AdminMemberMapper adminMemberMapper;
	
	// 블랙 팝업창
	public String blackMemberOne(String memberName) {
		return adminMemberMapper.blackMemberOne(memberName);
	}
	// 블랙 실행
	public void removeMember(BlackList blackList) {
		// 멤버 삭제
		int count = adminMemberMapper.deleteMemberByName(blackList.getMemberName());
		System.out.println(count);
		
		if(count == 1) {
			// 블랙 리스트에 추가
			adminMemberMapper.insertBlackList(blackList);
		} else {
			System.out.println("블랙에 실패하였습니다.");
		}
	}
}
