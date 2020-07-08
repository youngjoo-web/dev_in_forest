package com.devinforest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.AdminMapper;
import com.devinforest.vo.Admin;

@Service
@Transactional
public class AdminService {
	@Autowired private AdminMapper adminMapper;
	// 관리자 목록 출력
	public Map<String, Object> getAdminList(int currentPage, int rowPerPage, String searchWord){
		int beginRow=(currentPage-1)*rowPerPage;
		int adminTotalCount = adminMapper.adminTotalCount(searchWord);
		System.out.println(adminTotalCount+" <- adminService.getAdminList: adminTotalCount");
		int lastPage = adminTotalCount/rowPerPage;
		if(adminTotalCount % rowPerPage != 0) {
			lastPage+=1;
		}
		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("beginRow", beginRow);
		inputMap.put("rowPerPage", rowPerPage);
		inputMap.put("searchWord", searchWord);
		List<Admin> adminList = adminMapper.selectAdminList(inputMap);
		System.out.println(adminTotalCount+" <- AdminService.getAdminList: adminTotalCount");
		System.out.println(lastPage+" <- AdminService.getAdminList: lastPage");
		System.out.println(adminList+" <- AdminService.getAdminList: adminList");
		Map<String, Object> outputMap = new HashMap<>();
		outputMap.put("adminTotalCount", adminTotalCount);
		outputMap.put("lastPage", lastPage);
		outputMap.put("adminList", adminList);
		return outputMap;
	}
	// 관리자 추가
	public void addAdmin(Admin admin) {
		adminMapper.insertAdmin(admin);
		return;
	}
	// 관리자 이메일 중복체크
	public int checkAdminEmail(String adminEmail) {
		return adminMapper.selectAdminEmail(adminEmail);
	}
	// 관리자 닉네임 중복체크
	public int checkAdminName(String adminName) {
		return adminMapper.selectAdminName(adminName);
	}
}
