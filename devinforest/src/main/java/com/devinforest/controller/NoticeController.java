package com.devinforest.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.service.NoticeService;

@Controller
public class NoticeController {
	@Autowired private NoticeService noticeService;
	
	// 공지사항 목록 
	@GetMapping("/getNoticeList")
	public String getNoticeList(HttpSession session, Model model,
								@RequestParam(defaultValue = "1") int currentPage,
								@RequestParam(defaultValue = "10") int rowPerPage,
								@RequestParam(defaultValue = "") String searchWord) {
		System.out.println(currentPage+" <- NoticeController.getNoticeList: currentPage");
		System.out.println(searchWord+" <- NoticeController.getNoticeList: searchWord");
		Map<String, Object> map = noticeService.getNoticeList(currentPage, rowPerPage, searchWord);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("rowPerPage", rowPerPage);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("noticeTotalCount", map.get("noticeTotalCount"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("noticeList", map.get("noticeList"));
		
		return "notice/getNoticeList";
	}
}
