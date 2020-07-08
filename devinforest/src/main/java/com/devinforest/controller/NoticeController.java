package com.devinforest.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devinforest.IPUtil;
import com.devinforest.service.NoticeService;
import com.devinforest.vo.Notice;

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
	// 공지사항 상세보기
	@GetMapping("/getNoticeOne")
	public String getNoticeOne(HttpSession session, Model model, Notice notice){
		int noticeNo = notice.getNoticeNo();
		System.out.println(noticeNo+" <- NoticeController.getNoticeOne: noticeNo");
		notice = noticeService.getNoticeOne(noticeNo);
		//System.out.println(notice+" <- NoticeController.getNoticeOne: notice");
		model.addAttribute("notice", notice);
		return "notice/getNoticeOne";
	}
	// 공지사항 추가
	@GetMapping("/addNotice")
	public String addNotice(HttpSession session) {
		return "notice/addNotice";
	}
	@PostMapping("/addNotice")
	public String addNotice(HttpSession session, Notice notice, IPUtil ipUtil) {
		System.out.println(notice+" <- NoticeController.addNotice: notice(주입 전)");
		String adminName = "관리자1호"; // 로그인 세션 적용시 세션에 들어있는 닉네임 값 가져와서 주입 시켜야함.
		notice.setAdminName(adminName);
		String noticeIp = ipUtil.getIPAddress();
		notice.setNoticeIp(noticeIp); // IP주입
		System.out.println(notice+" <- NoticeController.addNotice: notice(주입 후)");
		noticeService.addNotice(notice);
		return "redirect:/getNoticeList";
	}
	// 공지사항 삭제
	@PostMapping("/removeNotice")
	public String removeNotice(HttpSession session,
								@RequestParam(value = "noticeNo") int noticeNo) {
		System.out.println(noticeNo+" <- NoticeController.removeNotice: noticeNo");
		noticeService.removeNotice(noticeNo);
		return "redirect:/getNoticeList";
	}
	// 공지사항 수정
	@PostMapping("/modifyNoticeForm")
	public String modifyNotice(HttpSession session, Model model, Notice notice){
		System.out.println(notice+" <- notice test");
		int noticeNo = notice.getNoticeNo();
		System.out.println(noticeNo+" <- NoticeController.modifyNotice: noticeNo");
		notice = noticeService.getNoticeOne(noticeNo);
		System.out.println(notice+" <- NoticeController.modifyNotice: notice(수정 전)");
		model.addAttribute("notice", notice);
		return "notice/modifyNotice";
	}
	@PostMapping("/modifyNotice")
	public String modifyNotice(HttpSession session, Notice notice){
		System.out.println(notice+" <- NoticeController.modifyNotice: notice(수정 후)");
		int noticeNo = notice.getNoticeNo();
		noticeService.modifyNotice(notice);
		return "redirect:/getNoticeOne?noticeNo="+noticeNo;
	}
}