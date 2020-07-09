package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Apply;

@Mapper
public interface ApplyMapper {
	//지원자 관리
	public List<Apply> selectApply(Map<String, Object> map);
	//지원하기
	public int insertApply(Apply apply);
	//지원리스트 토탈카운트
	public int applyTotalCount(int recruitNo);
	//지원공고 중복확인
	public int checkApply(Apply apply);
}
