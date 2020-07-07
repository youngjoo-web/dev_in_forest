package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Restoration;

@Mapper
public interface RestorationMapper {
	// 재가입요청 목록
	public List<Restoration> selectRestorationList(Map<String, Object> map);
	// 재가입요청 totalCount
	public int restorationTotalCount(String searchWord);
}
