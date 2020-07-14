package com.devinforest.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.service.HashtagService;
import com.devinforest.vo.Hashtag;
import com.devinforest.vo.LoginMember;

@Controller
public class HashtagController {
	
	@Autowired
	private HashtagService hashtagService;
	
	/* ---------- 해시태그 상세보기 ---------- */
	@GetMapping("/getHashtagOne")
	public String getHashtagOne(Model model, HttpSession session, Hashtag hashtag) {
		String memberName = "Guest";
		
		if(session.getAttribute("loginMember") != null) {
			memberName = ((LoginMember)session.getAttribute("loginMember")).getMemberName();
		}
		System.out.println(hashtag.getHashtagNo());
		Hashtag returnHashtag=hashtagService.getHashtagOne(hashtag.getHashtagNo());
		model.addAttribute("hashtag", returnHashtag);
		model.addAttribute("memberName", memberName);
		return "hashtag/getHashtagOne";
	}
	
	/* ---------- 해시태그 목록 ---------- */
	@GetMapping("/getHashtagList")
	public String getHashtagList(Model model, HttpSession session,
			@RequestParam(value="currentPage", defaultValue="1") int currentPage,
			@RequestParam(value="searchWord", defaultValue="") String searchWord)
	{
		String memberName = "Guest";
		
		if(session.getAttribute("loginMember") != null) {
			memberName = ((LoginMember)session.getAttribute("loginMember")).getMemberName();
		}
		Map<String, Object> hashtagList = hashtagService.getHashtagList(currentPage, searchWord);
		
		System.out.println(memberName+"<--memberName");
		
		model.addAttribute("memberName", memberName);
		model.addAttribute("hashtagList", hashtagList.get("hashtagList"));
		model.addAttribute("lastPage", hashtagList.get("lastPage"));
		model.addAttribute("currentPage", currentPage);
		
		System.out.println("↓hashtagController hashtagList↓");
		System.out.println(hashtagList.get("hashtagList"));
		System.out.println(currentPage + " <--- hashtagController currentPage");
		System.out.println(searchWord + " <--- hashtagController searchWord");
		
		return "hashtag/getHashtagList";
	}
	
	/* ---------- 해시태그 생성 ---------- */
	// 해시태그 생성 폼으로 이동
	@GetMapping("/addHashtag")
	public String addHashtag(Model model,HttpSession session) {
		System.out.println("addHashtag 폼으로 이동");
		//비로그인 시 로그인창으로 (조건 더 추가할 예정)
		
		if(session.getAttribute("loginMember") == null) {
			return "redirect:/memberLogin";
		}
		
		String memberName = ((LoginMember)session.getAttribute("loginMember")).getMemberName();
		
		System.out.println();
		System.out.println(memberName +"<-- memberName");
		model.addAttribute("memberName",memberName);
		return "hashtag/addHashtag";
	}
	
	// 해시태그 생성 실행
	@PostMapping("/addHashtag")
	public String addHashtag(Model model, Hashtag hashtag,HttpSession session) {
		System.out.println("addHashtag post로 이동");
		String memberName = "Guest";
		if(session.getAttribute("loginMember") != null) {
			memberName = ((LoginMember)session.getAttribute("loginMember")).getMemberName();
		}
		System.out.println(hashtag.toString());
		hashtagService.addHashtag(hashtag);
		System.out.println(memberName +"<-- memberName");
		model.addAttribute("memberName",memberName);
		return "redirect:/getHashtagList";
	}
}
