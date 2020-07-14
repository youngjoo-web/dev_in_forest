package com.devinforest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.AdminBlackQuestionMapper;

@Service
@Transactional
public class AdminBlackQuestionService {
	@Autowired private AdminBlackQuestionMapper adminBlackQuestionMapper;
	
}
