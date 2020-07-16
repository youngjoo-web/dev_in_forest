package com.devinforest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.ApplyMapper;
import com.devinforest.mapper.MemberMapper;
import com.devinforest.mapper.RecruitMapper;
import com.devinforest.vo.Apply;

@Service
@Transactional
public class ApplyService {
	@Autowired
	private ApplyMapper applyMapper;
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private RecruitMapper recruitMapper;
	
	//회원 명성도
	public int getMemberReputation(Apply apply) {
		return memberMapper.selectMemberReputation(apply);
	}
	//공고 명성도
	public int getRecruitReputation(Apply apply) {
		return recruitMapper.selectRecruitReputation(apply);
	}
	//지원자 리스트출력
	public Map<String, Object> getApplyList(int currentPage, int rowPerPage, int recruitNo){
		int beginRow=(currentPage-1)*rowPerPage;
		int applyTotalCount = applyMapper.applyTotalCount(recruitNo);
		int lastPage = applyTotalCount/rowPerPage;
		if(applyTotalCount % rowPerPage != 0) {
			lastPage+=1;
		}
		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("beginRow", beginRow);
		inputMap.put("rowPerPage", rowPerPage);
		inputMap.put("recruitNo", recruitNo);
		List<Apply> applyList = applyMapper.selectApply(inputMap);
		Map<String, Object> outputMap = new HashMap<>();
		outputMap.put("applyTotalCount", applyTotalCount);
		outputMap.put("lastPage", lastPage);
		outputMap.put("applyList", applyList);
		return outputMap;
	}
	//지원하기
	public int addApply(Apply apply) {
		return applyMapper.insertApply(apply);
	}
	//중복체크
	public int checkApply(Apply apply) {
		return applyMapper.checkApply(apply);
	}
}
