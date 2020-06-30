package com.devinforest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Admin;

@Mapper
public interface AdminMapper {
	// 관리자 목록 출력
	public List<Admin> selectAdminList();
	// 관리자 추가
	public void insertAdmin(Admin admin);
}
