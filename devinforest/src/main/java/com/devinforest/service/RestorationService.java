package com.devinforest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.AdminMemberMapper;
import com.devinforest.mapper.RestorationMapper;
import com.devinforest.vo.Restoration;

@Service
@Transactional
public class RestorationService {
	@Autowired private RestorationMapper restorationMapper;
	@Autowired private AdminMemberMapper adminMemberMapper;
	// 재가입요청 목록 
	public Map<String, Object> getRestorationList(int currentPage, int rowPerPage, String searchWord){
		int beginRow =(currentPage-1)*rowPerPage;
		int restorationTotalCount = restorationMapper.restorationTotalCount(searchWord);
		System.out.println(restorationTotalCount+" <- RestorationService.getRestorationList: restorationTotalCount");
		int lastPage = restorationTotalCount/rowPerPage;
		if(restorationTotalCount % rowPerPage != 0) {
			lastPage+=1;
		}
		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("beginRow", beginRow);
		inputMap.put("rowPerPage", rowPerPage);
		inputMap.put("searchWord", searchWord);
		List<Restoration> restorationList = restorationMapper.selectRestorationList(inputMap);
		System.out.println(lastPage+" <- RestorationService.getRestorationList: lastPage");
		System.out.println(restorationList+" <- RestorationService.getRestorationList: restorationList");
		Map<String, Object> outputMap = new HashMap<>();
		outputMap.put("restorationTotalCount", restorationTotalCount);
		outputMap.put("lastPage", lastPage);
		outputMap.put("restorationList", restorationList);
		return outputMap;
	}
	// 재가입요청 상세보기
	public Map<String,Object> getRestorationOne(int restorationNo){
		Restoration restoration = restorationMapper.selectRestorationOne(restorationNo);
		String inquiryKind = restoration.getInquiryKind();
		System.out.println(inquiryKind);
		int checkPoint = 0;
		if(!inquiryKind.equals("복구요청")) {
			 checkPoint = 1;
		}
		System.out.println(checkPoint+" <- RestorationService.getRestorationOne: checkPoint");
		Map<String, Object> map = new HashMap<>();
		map.put("checkPoint", checkPoint);
		map.put("restoration", restoration);
		return map;
	}
	// 재가입 실행
	public int restorationExecution(int restorationNo, String memberEmail) {
		String memberEmailCheck = adminMemberMapper.selectMemberEmail(memberEmail);
		System.out.println(memberEmailCheck+" <- RestorationService.restorationExecution: memberEmailCheck");
		int checkNum = 0;
		if(memberEmailCheck==null) {
			System.out.println("입력된 아이디로 가입된 회원 없음");
			checkNum = 1;
			return checkNum;
		}
		restorationMapper.updateInquiryKind(restorationNo); // 재가입 실행 - restoration 요청상태 수정
		adminMemberMapper.updateMemberState(memberEmail); // 재가입  실행 - member 테이블 member_state 수정
		System.out.println("입력된 아이디로 가입된 회원 없음");
		return checkNum;
	}
}
