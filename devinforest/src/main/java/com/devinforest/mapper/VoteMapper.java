package com.devinforest.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Answer;
import com.devinforest.vo.AnswerVote;
import com.devinforest.vo.Vote;

@Mapper
public interface VoteMapper {
	// 질문 투표
	public int insertPlusVote(Vote vote);
	public int insertMinusVote(Vote vote);
	public int voteTotalCount(Vote vote);
	public Vote voteCheck(Vote vote);
	public int deleteVote(Vote vote);
	
	/* ******************************************* */
	
	// 답변  투표
	public int insertPlusAnswerVote(Answer answer);
	public int insertMinusAnswerVote(Answer answer);
	public int answerVoteTotalCount(Answer answer);
	public AnswerVote answerVoteCheck(Answer answer);
	public int deleteAnswerVote(Answer answer);
}