package com.devinforest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.HashtagMapper;
import com.devinforest.vo.Hashtag;


@Service
@Transactional
public class HashtagService {
	
	@Autowired
	private HashtagMapper hashtagMapper;
	
	/* ---------- 해시태그 목록 ---------- */
	public Map<String, Object> getHashtagList(int currentPage, String searchWord) {
		System.out.println(searchWord + " <-- Service searchWord");
		
		
		int rowPerPage = 2;
		int beginRow = (currentPage -1) * rowPerPage;
		int hashtagTotalRow = hashtagMapper.hashtagTotalRow(searchWord);
		System.out.println(hashtagTotalRow + " <-- hashtagTotalRow");
		int lastPage = hashtagTotalRow / rowPerPage;
		if(hashtagTotalRow % rowPerPage != 0) {
			lastPage += 1;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchWord", searchWord);
		map.put("beginRow", beginRow);
		map.put("rowPerPage", rowPerPage);
		
		System.out.println(searchWord + " <--- searchWord");
		System.out.println(beginRow + " <--- beginRow");
		System.out.println(rowPerPage + " <--- rowPerPage");
		
		System.out.println(lastPage + "<--  hashtagServicelastPage");
		List<Hashtag> hashtagList = hashtagMapper.selectHashtagList(map);
	
		System.out.println(hashtagList);
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("lastPage", lastPage);
		returnMap.put("hashtagList", hashtagList);
		
		return returnMap;
	}
	/* ---------- 해시태그 생성 ---------- */
	public int addHashtag(Hashtag hashtag) {
		
		return hashtagMapper.insertHashtag(hashtag);
	}
}
