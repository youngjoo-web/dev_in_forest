package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.FAQ;

@Mapper
public interface FAQMapper {
	public List<FAQ> selectFAQList(Map<String, Object> inPutMap);
	public int FAQTotalCount(String searchWord);
}
