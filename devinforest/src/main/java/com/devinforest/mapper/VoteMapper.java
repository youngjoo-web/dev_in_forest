package com.devinforest.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Vote;

@Mapper
public interface VoteMapper {
	public int insertPlusVote(Vote vote);
	public int insertMinusVote(Vote vote);
	public int updatePlustVote(Vote vote);
	public int updateMinustVote(Vote vote);
	public int voteTotalCount(Vote vote);
	public Vote voteCheck(Vote vote);
	public int deleteVote(Vote vote);
}