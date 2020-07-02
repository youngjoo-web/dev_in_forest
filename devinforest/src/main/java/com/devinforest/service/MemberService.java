package com.devinforest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.MemberMapper;
import com.devinforest.vo.Admin;
import com.devinforest.vo.LoginMember;
import com.devinforest.vo.Member;
import com.devinforest.vo.Restoration;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	   private JavaMailSender javaMailSender;
	//회원 재가입요청
	public int addrequestRestoreMember(Restoration restoration) {
		return memberMapper.insertRequestRestore(restoration);
	}
	// 회원목록
	public Map<String, Object> getMemberList(int currentPage, int rowPerPage, String searchWord) {
		int beginRow=(currentPage-1)*rowPerPage;
		int memberTotalCount = memberMapper.memberTotalCount(searchWord);
		int lastPage = memberTotalCount/rowPerPage;
		
		if(memberTotalCount % rowPerPage != 0) {
			lastPage+=1;
		}
		Map<String, Object> inputMap = new HashMap<>();
		inputMap.put("beginRow", beginRow);
		inputMap.put("rowPerPage", rowPerPage);
		inputMap.put("searchWord", searchWord);
		List<Member> memberList = memberMapper.selectMemberList(inputMap);
		System.out.println(memberTotalCount+" <- memberService.getmember: memberTotalCount");
		System.out.println(lastPage+" <- memberService.getmember: lastPage");
		System.out.println(memberList+" <- memberService.getmember: memberList");
		Map<String, Object> outputMap = new HashMap<>();
		outputMap.put("memberTotalCount", memberTotalCount);
		outputMap.put("lastPage", lastPage);
		outputMap.put("memberList", memberList);
		return outputMap;
	}

	// 회원가입
	public int addMember(LoginMember loginMember) {
		Member member = new Member();
		member.setMemberEmail(loginMember.getMemberEmail());
		member.setMemberPassword(loginMember.getMemberPassword());
		member.setMemberName(loginMember.getMemberName());
		int row = memberMapper.insertMember(member);
		return row;
	}

	// 로그인
	public LoginMember memberLogin(LoginMember loginMember) {
		System.out.println("memberService" + loginMember);
		return memberMapper.selectLoginMember(loginMember);
	}

	// 이메일 중복확인
	public String CheckMemberEmail(LoginMember loginMember) {
		return memberMapper.selectMemberEmail(loginMember.getMemberEmail());
	}

	// 닉네임 중복확인
	public String CheckMemberName(LoginMember loginMember) {
		return memberMapper.selectMemberName(loginMember.getMemberName());
	}

	// 회원정보 상세보기
	public Member getMemberInfo(LoginMember loginMember) {
		return memberMapper.selectMemberInfo(loginMember);
	}

	// 회원탈퇴
	public void removeMember(LoginMember loginMember) {
		memberMapper.deleteMember(loginMember);
	}

	// 회원정보 수정
	public int modifyMember(Member member) {
		return memberMapper.updateMember(member);
	}
	//회원의 비밀번호 찾기(변경해주기)
	public int findMemberPw(LoginMember loginMember) {
		//pw추가
	      UUID uuid=UUID.randomUUID();      
	      String memberPw=uuid.toString().substring(0,8);
	      loginMember.setMemberPassword(memberPw);
	      int row = memberMapper.findMemberPw(loginMember);
	      //메일로 update성공한 랜덤 pw를 전송
	      //메일객체 new JavaMailSender();
	      if(row ==1) {
	         System.out.println(memberPw+"<--update memberPw");
	         SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	         simpleMailMessage.setTo(loginMember.getMemberEmail());//메일 받는사람
	         simpleMailMessage.setFrom("youngjoo715@gmail.com");//메일 보내는사람
	         simpleMailMessage.setSubject("devinforest 비밀번호찾기 메일");//메일제목
	         simpleMailMessage.setText("변경된 비밀번호는"+memberPw+"입니다.");//메일 내용
	         javaMailSender.send(simpleMailMessage);
	      }
	      return row;
	}
	//회원의 이메일 찾기
	public String findMemberEmail(Member member) {
		return memberMapper.selectEmailByMember(member);
	}
}
