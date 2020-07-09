package com.devinforest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Member;

@Mapper
public interface StatisticsMapper {
	public List<Member> selectSignUpStatisticsByDate(int month);
}
