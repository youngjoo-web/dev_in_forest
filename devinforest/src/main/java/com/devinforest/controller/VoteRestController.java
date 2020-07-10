package com.devinforest.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devinforest.mapper.VoteMapper;
import com.devinforest.vo.Answer;
import com.devinforest.vo.AnswerVote;
import com.devinforest.vo.Vote;

@RestController
public class VoteRestController {
	@Autowired
	private VoteMapper voteMapper;
	
	// 질문 투표
	
	// Plus 버튼 눌렀을 때 생성
	@GetMapping("/plusVote")
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
	
	// 투표 삭제
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
	
	// 투표 했는지 체크
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
	
	/* ****************************************************************************** */
	
	// 답변 투표
	
	// Plus 버튼 눌렀을 때 생성
	@GetMapping("/plusAnswerVote")
	public int plusAnswerVote(Answer answer, HttpSession session) {
		System.out.println("plusvote 시작");
		int answerVoteTotalCount = 0;
		try {
			AnswerVote answerVoteCheck = voteMapper.answerVoteCheck(answer);
			System.out.println("answerPlusVote");
			System.out.println(answer.toString());
			System.out.println(answerVoteCheck);
			
			if(answerVoteCheck == null) {
				voteMapper.insertPlusAnswerVote(answer);
				System.out.println("좋아요 투표 완료");
			}
			
			answerVoteTotalCount = voteMapper.answerVoteTotalCount(answer);
			System.out.println(answerVoteTotalCount + " <--- plusVote answerVoteTotalCount");
			return answerVoteTotalCount;
		} catch(Exception e) {
			e.printStackTrace();
			
			return answerVoteTotalCount;
		}
	}
	
	// minus 버튼 눌렀을 때 생성
	@GetMapping("/minusAnswerVote")
	public int minusAnswerVote(Answer answer, HttpSession session) {
		int answerVoteTotalCount = 0;
		try {
			AnswerVote answerVoteCheck = voteMapper.answerVoteCheck(answer);
			if(answerVoteCheck == null) {
				voteMapper.insertMinusAnswerVote(answer);
				System.out.println("싫어요 투표 완료");
			}
			answerVoteTotalCount = voteMapper.answerVoteTotalCount(answer); 
			
			return answerVoteTotalCount;
		} catch(Exception e) {
			e.printStackTrace();
			return answerVoteTotalCount;
		}
	}
	// 투표 삭제
	@GetMapping("/deleteAnswerVote")
	public int deleteAnswerVote(Answer answer) {
		int answerVoteTotalCount = 0;
		try {
			AnswerVote answerVoteCheck = voteMapper.answerVoteCheck(answer);
			if(answerVoteCheck != null) {
				voteMapper.deleteAnswerVote(answer);
				System.out.println("vote 삭제 완료");
			}
			answerVoteTotalCount = voteMapper.answerVoteTotalCount(answer);
			System.out.println(answerVoteTotalCount + "<---try in deleteAnswerVote TotalCount");
			return answerVoteTotalCount;
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(answerVoteTotalCount + "<---catch in deleteAnswerVote TotalCount");
			return answerVoteTotalCount;
		}
	}	
	
	// 투표 했는지 체크
	@GetMapping("/answerVoteCheck")
	public Map<String, Object> answerVoteCheck(Answer answer, HttpSession session) {
		try {
			AnswerVote answerVoteCheck = voteMapper.answerVoteCheck(answer);
			Map<String, Object> returnMap = new HashMap<String, Object>();
			
			
			System.out.println(answerVoteCheck.getMemberName() + "<-- memberName");
			returnMap.put("memberName", answerVoteCheck.getMemberName());
			returnMap.put("votePoint", answerVoteCheck.getVotePoint());
			
			System.out.println(answerVoteCheck + "<-- answerVoteCheck answerVoteCheck");
			return returnMap;
		} catch(Exception e) {
			
			return null;
		}
	}
	
	// 질문 상세보기에서 표시되는 투표 총 개수
	@GetMapping("/answerVoteTotalCount")
	public int answerVoteTotalCount(Answer answer) {
		int answerVoteTotalCount = voteMapper.answerVoteTotalCount(answer);
		System.out.println("voteTotalCount");
		System.out.println(answer.toString());
		System.out.println(answerVoteTotalCount + " <-- answervoteTotalCount");
		return answerVoteTotalCount;
	}

}