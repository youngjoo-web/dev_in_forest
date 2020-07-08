package com.devinforest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.SuggestMapper;
import com.devinforest.vo.Suggest;
@Transactional
@Service
public class SuggestService {
	@Autowired
	private SuggestMapper suggestMapper;
	//면접제의 작성하기
	public void addSuggest(Suggest suggest) {
		suggestMapper.insertSuggest(suggest);
		return;
	}
	//면접제의 리스트 출력
	public List<Suggest> getSuggestList(String memberName) {
		return suggestMapper.selectSuggestList(memberName);
	}
}
