package com.devinforest.service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.StatisticsMapper;
import com.devinforest.vo.Member;

@Service
@Transactional
public class StatisticsService {
	@Autowired private StatisticsMapper statisticsMapper;
	
	public List<Member> getSignUpStatisticsByDate(LocalDate now) {
		Calendar cNow = Calendar.getInstance();
		if(now == null) {
			now = LocalDate.now();
		} else {
			cNow.set(now.getYear(), now.getMonthValue(), now.getDayOfMonth());
		}
		int month = now.getMonthValue();
		
		return statisticsMapper.selectSignUpStatisticsByDate(month);
	}
}
