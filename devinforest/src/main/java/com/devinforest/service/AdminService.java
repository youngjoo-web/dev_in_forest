package com.devinforest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devinforest.mapper.AdminMapper;
import com.devinforest.vo.Admin;

@Service
public class AdminService {
	@Autowired private AdminMapper adminMapper;
	// 관리자 목록 출력
	public List<Admin> getAdminList(){
		return adminMapper.selectAdminList();
	}
	// 관리자 추가
	public void addAdmin(Admin admin) {
		adminMapper.insertAdmin(admin);
	}
}
