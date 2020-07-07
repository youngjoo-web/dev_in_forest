package com.devinforest.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.devinforest.vo.Restoration;

@Mapper
public interface RestorationMapper {
	// 재가입요청 목록
	public List<Restoration> selectRestorationList(Map<String, Object> map);
	// 재가입요청 totalCount
	public int restorationTotalCount(String searchWord);
	// 재가입요청 상세보기
	public Restoration selectRestorationOne(int restorationNo);
	// 요청상태 확인
	public String selectInquiryKind(int restorationNo);
	// 재가입 실행 - 요청상태 변경
	public void updateInquiryKind(int restorationNo);
	// 재가입 복구요청 개수(관리자 홈에서 확인)
	public int selectInquiryStateTotalCount();
}
