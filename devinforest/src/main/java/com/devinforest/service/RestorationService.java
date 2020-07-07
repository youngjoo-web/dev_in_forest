package com.devinforest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.RestorationMapper;
import com.devinforest.vo.Restoration;

@Service
@Transactional
public class RestorationService {
	@Autowired private RestorationMapper restorationMapper;
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
}
