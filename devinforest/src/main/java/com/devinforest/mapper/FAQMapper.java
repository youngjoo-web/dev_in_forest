package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Notice;

@Mapper
public interface FAQMapper {
	public List<Notice> selectFAQList(Map<String, Object> inPutMap);
	public int FAQTotalCount(String searchWord);
}
