package com.devinforest.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.BlackList;

@Mapper
public interface AdminMemberMapper {
	// 블랙 팝업창에 출력할 데이터 출력
	public String blackMemberOne(String memberName);
	// 멤버 삭제
	public int deleteMemberByName(String memberName);
	// 블랙리스트 추가
	public void insertBlackList(BlackList blackList);
}
