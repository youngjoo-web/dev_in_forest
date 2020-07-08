package com.devinforest.controller;

import java.util.HashMap;
import java.util.Map;

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
	@GetMapping("/devinforest/plusVote")
	public int plusVote(Vote vote, HttpSession session) {
		System.out.println("plusvote 시작");
		int voteTotalCount = 0;
		try {
			Vote voteCheck = voteMapper.voteCheck(vote);
			System.out.println("plusVote");
			System.out.println(vote.toString());
			System.out.println(voteCheck);
			
			if(voteCheck == null) {
				voteMapper.insertPlusVote(vote);
				System.out.println("좋아요 투표 완료");
			}
			
			voteTotalCount = voteMapper.voteTotalCount(vote);
			System.out.println(voteTotalCount + " <--- plusVote voteTotalCount");
			return voteTotalCount;
		} catch(Exception e) {
			e.printStackTrace();
			
			return voteTotalCount;
		}
	}
	
	// minus 버튼 눌렀을 때 생성
	@GetMapping("/minusVote")
	public int minusVote(Vote vote, HttpSession session) {
		int voteTotalCount = 0;
		try {
			Vote voteCheck = voteMapper.voteCheck(vote);
			if(voteCheck == null) {
				voteMapper.insertMinusVote(vote);
				System.out.println("싫어요 투표 완료");
			}
			voteTotalCount = voteMapper.voteTotalCount(vote); 
			
			return voteTotalCount;
		} catch(Exception e) {
			e.printStackTrace();
			return voteTotalCount;
		}
	}
	@GetMapping("/deleteVote")
	public int deleteVote(Vote vote) {
		int voteTotalCount = 0;
		try {
			Vote voteCheck = voteMapper.voteCheck(vote);
			if(voteCheck != null) {
				voteMapper.deleteVote(vote);
				System.out.println("vote 삭제 완료");
			}
			voteTotalCount = voteMapper.voteTotalCount(vote);
			return voteTotalCount;
		} catch(Exception e) {
			e.printStackTrace();
			return voteTotalCount;
		}
	}	
	@GetMapping("/voteCheck")
	public Map<String, Object> voteCheck(Vote vote, HttpSession session) {
		try {
			Vote voteCheck = voteMapper.voteCheck(vote);
			Map<String, Object> returnMap = new HashMap<String, Object>();
			
			
			System.out.println(voteCheck.getMemberName() + "<-- memberName");
			returnMap.put("memberName", voteCheck.getMemberName());
			returnMap.put("votePoint", voteCheck.getVotePoint());
			
			System.out.println(voteCheck + "<-- voteCheck voteCheck");
			return returnMap;
		} catch(Exception e) {
			
			return null;
		}
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