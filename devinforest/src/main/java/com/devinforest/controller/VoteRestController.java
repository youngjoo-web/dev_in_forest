package com.devinforest.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devinforest.mapper.VoteMapper;
import com.devinforest.vo.Vote;

@RestController
public class VoteRestController {
	@Autowired
	private VoteMapper voteMapper;

	// Plus 버튼 눌렀을 때 생성
	@GetMapping("/plusVote")
	public int plusVote(Vote vote, HttpSession session) {
		System.out.println("plusvote 시작");
		
		Vote voteCheck = voteMapper.voteCheck(vote);
		
		System.out.println("plusVote");
		System.out.println(vote.toString());
		System.out.println(voteCheck.getMemberName());
		
		if(voteCheck.getMemberName() == null) {
			voteMapper.insertPlusVote(vote);
		}
		int voteTotalCount = voteMapper.voteTotalCount(vote);
		System.out.println(vote.toString());
		return voteTotalCount;
	}
	// minus 버튼 눌렀을 때 생성
	@GetMapping("/minusVote")
	public int minusVote(Vote vote, HttpSession session) {
		Vote voteCheck = voteMapper.voteCheck(vote);
		if(voteCheck == null) {
			voteMapper.insertMinusVote(vote);
		}
		int voteTotalCount = voteMapper.voteTotalCount(vote);
		System.out.println(vote.toString());
		
		return voteTotalCount;
	}
		
	@GetMapping("/voteTotalCount")
	public int voteTotalCount(Vote vote) {
		int voteTotalCount = voteMapper.voteTotalCount(vote);
		System.out.println("voteTotalCount");
		System.out.println(vote.toString());
		System.out.println(voteTotalCount + " <--voteTotalCount");
		return voteTotalCount;
	}

}