package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Hashtag;

@Mapper
public interface HashtagMapper {
	public List<Hashtag> selectHashtagList(Map<String, Object>map);
	public int insertHashtag(Hashtag hashtag);
	public int hashtagTotalRow(String searchWord);
	public int hashtagCheck(String hashtagName);
}
