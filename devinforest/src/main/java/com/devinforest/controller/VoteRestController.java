package com.devinforest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devinforest.mapper.VoteMapper;
import com.devinforest.vo.LoginMember;
import com.devinforest.vo.Vote;

@RestController
public class VoteRestController {
	@Autowired
	private VoteMapper voteMapper;

	// Plus 버튼 눌렀을 때 생성
	@GetMapping("/plusVote")
	public int plusVote(Vote vote, HttpSession session) {
		System.out.println("plusvote 시작");
		
		String voteCheck = voteMapper.voteCheck(vote);
		
		System.out.println("plusVote");
		System.out.println(vote.toString());
		System.out.println(voteCheck);
		
		if(voteCheck == null) {
			voteMapper.insertPlusVote(vote);
		}
		int voteTotalCount = voteMapper.voteTotalCount(vote);
		System.out.println(vote.toString());
		return voteTotalCount;
	}
	
	// minus 버튼 눌렀을 때 생성
	@GetMapping("/minusVote")
	public int minusVote(Vote vote, HttpSession session) {
		String voteCheck = voteMapper.voteCheck(vote);
		if(voteCheck == null) {
			voteMapper.insertMinusVote(vote);
		}
		int voteTotalCount = voteMapper.voteTotalCount(vote);
		System.out.println(vote.toString());
		
		return voteTotalCount;
	}
	@GetMapping("deleteVote")
	public int deleteVote(Vote vote) {
		String voteCheck = voteMapper.voteCheck(vote);
		
		if(voteCheck != null) {
			voteMapper.deleteVote(vote);
			System.out.println("vote 삭제 완료");
		}
		int voteTotalCount = voteMapper.voteTotalCount(vote);
		return voteTotalCount;
	}
	
	// minus를 누른 상태에서 Plus 버튼 눌렀을 때 수정
	@GetMapping("/updatePlusVote")
	public void updatePlusVote(Vote vote, HttpSession session) {
		
		String voteCheck = voteMapper.voteCheck(vote);
		if(voteCheck != null) {
			voteMapper.updatePlustVote(vote);
			System.out.println("minus -> plus로 변경");
		}
		
		System.out.println(vote.toString());
		
	}
	
	// plus를 누른 상태에서 minus  버튼 눌렀을 때 수정
	@GetMapping("/updateMinusVote")
	public void updateMinusVote(Vote vote, HttpSession session) {
		
		String voteCheck = voteMapper.voteCheck(vote);
		if(voteCheck != null) {
			voteMapper.updateMinustVote(vote);
			System.out.println("plus -> minus로 변경");
		}
		
		System.out.println(vote.toString());
		
	}
	
	@GetMapping("/voteCheck")
	public String voteCheck(Vote vote, HttpSession session) {
		String voteCheck = voteMapper.voteCheck(vote);
		System.out.println(voteCheck + "<-- voteCheck voteCheck");
		return voteCheck;
	}
			
	// 질문 상세보기에서 표시되는 투표 총 개수
	@GetMapping("/voteTotalCount")
	public int voteTotalCount(Vote vote) {
		int voteTotalCount = voteMapper.voteTotalCount(vote);
		System.out.println("voteTotalCount");
		System.out.println(vote.toString());
		System.out.println(voteTotalCount + " <--voteTotalCount");
		return voteTotalCount;
	}

}