package com.devinforest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devinforest.mapper.HashtagMapper;
import com.devinforest.vo.Hashtag;

@RestController
public class HashtagRestController {

	@Autowired
	private HashtagMapper hashtagMapper;
	
	/* ---------- 해시태그 목록 ---------- */
	@PostMapping("/hashtagCheck")
	public String hashtagCheck(@RequestParam(value = "hashtagName2") String hashtagName,HttpSession session) {
		int hashtagCheck = hashtagMapper.hashtagCheck(hashtagName);
		System.out.println(hashtagName + "<--hashtagName");
		String hashtagNameText = null;
		System.out.println(hashtagCheck+"<---중복체크 1일시 중복");
		if(hashtagCheck == 1) {
			hashtagNameText = "중복된 해시태그입니다.";
		}
		else {
			hashtagNameText = "사용할 수 있는 해시태그 입니다.";
		}
		return hashtagNameText;
	}
}
