package com.devinforest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.RecruitMapper;
import com.devinforest.vo.Recruit;

@Service
@Transactional
public class RecruitService {
	@Autowired
	private RecruitMapper recruitMapper;
	//채용공고 리스트 출력
	public Map<String, Object> getRecruitList(int currentPage, int rowPerPage, String searchWord){
	int beginRow=(currentPage-1)*rowPerPage;
	int recruitTotalCount = recruitMapper.recruitTotalCount(searchWord);
	int lastPage = recruitTotalCount/rowPerPage;
	if(recruitTotalCount % rowPerPage != 0) {
		lastPage+=1;
	}
	Map<String, Object> inputMap = new HashMap<>();
	inputMap.put("beginRow", beginRow);
	inputMap.put("rowPerPage", rowPerPage);
	inputMap.put("searchWord", searchWord);
	List<Recruit> recruitList = recruitMapper.selectRecruitList(inputMap);
	Map<String, Object> outputMap = new HashMap<>();
	outputMap.put("recruitTotalCount", recruitTotalCount);
	outputMap.put("lastPage", lastPage);
	outputMap.put("recruitList", recruitList);
	return outputMap;
	}
}
