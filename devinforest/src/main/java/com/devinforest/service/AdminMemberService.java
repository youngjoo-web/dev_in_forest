package com.devinforest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.AdminMemberMapper;
import com.devinforest.mapper.AnswerMapper;
import com.devinforest.mapper.CommentMapper;
import com.devinforest.mapper.QuestionMapper;
import com.devinforest.vo.Answer;
import com.devinforest.vo.AnswerComment;
import com.devinforest.vo.BlackList;
import com.devinforest.vo.Company;
import com.devinforest.vo.Member;
import com.devinforest.vo.Question;
import com.devinforest.vo.QuestionComment;

@Service
@Transactional
public class AdminMemberService {
	@Autowired private AdminMemberMapper adminMemberMapper;
	@Autowired private QuestionMapper questionMapper;
	@Autowired private AnswerMapper answerMapper;
	@Autowired private CommentMapper commentMapper;
	// 탈퇴회원 목록
	public Map<String, Object> getRemoveMemberList(int currentPage, int rowPerPage, String searchWord){
		int beginRow =(currentPage-1)*rowPerPage;
		int removeMemberTotalCount = adminMemberMapper.selectRemoveMemberTotalCount(searchWord);
		System.out.println(removeMemberTotalCount+" <- AdminMemberService.getRemoveMemberList: removeMemberTotalCount");
		int lastPage = removeMemberTotalCount/rowPerPage;
		if(removeMemberTotalCount % rowPerPage != 0) {
			lastPage+=1;
		}
		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("beginRow", beginRow);
		inputMap.put("rowPerPage", rowPerPage);
		inputMap.put("searchWord", searchWord);
		List<Member> removeMemberList = adminMemberMapper.selectRemoveMemberList(inputMap);
		System.out.println(lastPage+" <- AdminMemberService.getRemoveMemberList: lastPage");
		//System.out.println(removeMemberList+" <- AdminMemberService.getRemoveMemberList: removeMemberList");
		Map<String, Object> outputMap = new HashMap<>();
		outputMap.put("removeMemberTotalCount", removeMemberTotalCount);
		outputMap.put("lastPage", lastPage);
		outputMap.put("removeMemberList", removeMemberList);
		return outputMap;
	}
	// 회원 복구
	public void recoveryMember(String memberEmail) {
		adminMemberMapper.updateMemberState(memberEmail);
	}
	// 기업회원 목록
	public Map<String, Object> getCompanyList(int currentPage, int rowPerPage, String searchWord){
		int beginRow =(currentPage-1)*rowPerPage;
		int companyTotalCount = adminMemberMapper.selectCompanyTotalCount(searchWord);
		System.out.println(companyTotalCount+" <- AdminMemberService.getCompanyList: companyTotalCount");
		int lastPage = companyTotalCount/rowPerPage;
		if(companyTotalCount % rowPerPage != 0) {
			lastPage+=1;
		}
		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("beginRow", beginRow);
		inputMap.put("rowPerPage", rowPerPage);
		inputMap.put("searchWord", searchWord);
		List<Company> companyList = adminMemberMapper.selectCompanyList(inputMap);
		System.out.println(lastPage+" <- AdminMemberService.getCompanyList: lastPage");
		//System.out.println(companyList+" <- AdminMemberService.getCompanyList: companyList");
		Map<String, Object> outputMap = new HashMap<>();
		outputMap.put("companyTotalCount", companyTotalCount);
		outputMap.put("lastPage", lastPage);
		outputMap.put("companyList", companyList);
		return outputMap;
	}
	// 기업회원 상세보기
	public Company getCompanyInfo(String companyEmail) {
		return adminMemberMapper.selectCompanyInfo(companyEmail);
	}
	
	// 블랙 팝업창
	public String blackMemberOne(String memberName) {
		return adminMemberMapper.blackMemberOne(memberName);
	}
	// 블랙 실행
	public void blackMember(BlackList blackList, Question question, QuestionComment questionComment, 
							Answer answer, AnswerComment answerComment) {
		int questionNo = question.getQuestionNo();
		int questionCommentNo = questionComment.getQuestionCommentNo();
		int answerNo = answer.getAnswerNo();
		int answerCommentNo = answerComment.getAnswerCommentNo();
		System.out.println(blackList + " <- AdminMemberService.blackMember: blackList");
		System.out.println(questionNo+" <- AdminMemberService.blackMember: questionNo(게시글번호)");
		System.out.println(questionCommentNo+" <- AdminMemberService.blackMember: questionCommentNo(게시글 댓글번호)");
		System.out.println(answerNo+" <- AdminMemberService.blackMember: answerNo(답변번호)");
		System.out.println(answerCommentNo+" <- AdminMemberService.blackMember: answerCommentNo(답변 댓글번호)");
		if(questionCommentNo==0 && answerNo==0 && answerCommentNo==0) {
			System.out.println("게시글 신고");
			// 게시글 삭제
			
			// 게시글 백업테이블 추가
			
		}
		if(questionCommentNo!=0) {
			System.out.println("게시글 댓글 신고");
			// 게시글의 댓글 삭제
			// 댓글 백업테이블 추가
		}
		if(answerNo!=0 && answerCommentNo==0) {
			System.out.println("게시글 답변 신고");
			// 게시글 답변 삭제
			// 답변 백업 테이블 추가
		}else if(answerCommentNo!=0) {
			System.out.println("게시글 답변의 댓글 신고");
			// 게시글 답변의 댓글 삭제
			
			// 답변의 댓글 백업테이블 추가
		}
		// 회원 삭제
		/*
		int count = adminMemberMapper.deleteMemberByName(blackList.getMemberName());
		System.out.println(count);
		
		if(count == 1) {
			// 블랙회원에 추가
			adminMemberMapper.insertBlackList(blackList);
		} else {
			System.out.println("블랙 실패  -> count=0 확인바람");
		}
		*/
	}
	// 블랙회원 목록
	public Map<String, Object> getBlackMemberList(String searchWord, int currentPage, int rowPerPage) {
		int beginRow = (currentPage-1) * rowPerPage;
		int blackTotalCount = adminMemberMapper.blackTotalCount(searchWord);
		int lastPage = blackTotalCount / rowPerPage;
		if(blackTotalCount % rowPerPage != 0) {
			lastPage+=1;
		}
		Map<String, Object> inPutMap = new HashMap<>();
		inPutMap.put("searchWord", searchWord);
		inPutMap.put("beginRow", beginRow);
		inPutMap.put("rowPerPage", rowPerPage);
		
		List<BlackList> blackMemberList = adminMemberMapper.selectBlackMemberList(inPutMap);
		
		Map<String, Object> outPutMap = new HashMap<>();
		outPutMap.put("blackMemberList", blackMemberList);
		outPutMap.put("blackTotalCount", blackTotalCount);
		outPutMap.put("lastPage", lastPage);
		return outPutMap;
	}
	// 일반회원 목록
	public Map<String, Object> getMemberList(String searchWord, int currentPage, int rowPerPage) {
		int beginRow = (currentPage-1) * rowPerPage;
		int memberTotalCount = adminMemberMapper.memberTotalCount(searchWord);
		int lastPage = memberTotalCount / rowPerPage;
		if(memberTotalCount % rowPerPage != 0) {
			lastPage+=1;
		}
		Map<String, Object> inPutMap = new HashMap<>();
		inPutMap.put("searchWord", searchWord);
		inPutMap.put("beginRow", beginRow);
		inPutMap.put("rowPerPage", rowPerPage);
		
		List<Member> memberList = adminMemberMapper.selectMemberList(inPutMap);
		
		Map<String, Object> outPutMap = new HashMap<>();
		outPutMap.put("memberList", memberList);
		outPutMap.put("memberTotalCount", memberTotalCount);
		outPutMap.put("lastPage", lastPage);
		return outPutMap;
	}
	// 일반회원 상세보기
	public Member getMemberInfo(String memberEmail) {
		Member member = adminMemberMapper.selectMemberInfo(memberEmail);
		return member;
	}
}