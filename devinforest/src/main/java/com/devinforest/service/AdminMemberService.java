package com.devinforest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.AdminMemberMapper;
import com.devinforest.vo.BlackList;
import com.devinforest.vo.Member;

@Service
@Transactional
public class AdminMemberService {
	@Autowired private AdminMemberMapper adminMemberMapper;
	// 탈퇴회원 목록
	public Map<String, Object> getRemoveMemberList(int currentPage, int rowPerPage, String searchWord){
		int beginRow =(currentPage-1)*rowPerPage;
		int removeMemberTotalCount = adminMemberMapper.selectRemoveMemberTotalCount(searchWord);
		System.out.println(removeMemberTotalCount+" <- AdminMemberService.getRemoveMemberList: removeMemberTotalCount");
		int lastPage = removeMemberTotalCount/rowPerPage;
		if(removeMemberTotalCount % rowPerPage != 0) {
			lastPage+=1;
		}
		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("beginRow", beginRow);
		inputMap.put("rowPerPage", rowPerPage);
		inputMap.put("searchWord", searchWord);
		List<Member> removeMemberList = adminMemberMapper.selectRemoveMemberList(inputMap);
		System.out.println(lastPage+" <- AdminMemberService.getRemoveMemberList: lastPage");
		System.out.println(removeMemberList+" <- AdminMemberService.getRemoveMemberList: removeMemberList");
		Map<String, Object> outputMap = new HashMap<>();
		outputMap.put("removeMemberTotalCount", removeMemberTotalCount);
		outputMap.put("lastPage", lastPage);
		outputMap.put("removeMemberList", removeMemberList);
		return outputMap;
	}
	
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
	// blackMemberList 출력
	public Map<String, Object> getBlackMemberList(String searchWord, int currentPage, int rowPerPage) {
		int beginRow = (currentPage-1) * rowPerPage;
		int blackTotalCount = adminMemberMapper.blackTotalCount(searchWord);
		int lastPage = blackTotalCount / rowPerPage;
		if(blackTotalCount % rowPerPage != 0) {
			lastPage+=1;
		}
		Map<String, Object> inPutMap = new HashMap<>();
		inPutMap.put("searchWord", searchWord);
		inPutMap.put("beginRow", beginRow);
		inPutMap.put("rowPerPage", rowPerPage);
		
		List<BlackList> blackMemberList = adminMemberMapper.selectBlackMemberList(inPutMap);
		
		Map<String, Object> outPutMap = new HashMap<>();
		outPutMap.put("blackMemberList", blackMemberList);
		outPutMap.put("blackTotalCount", blackTotalCount);
		outPutMap.put("lastPage", lastPage);
		return outPutMap;
	}
}
