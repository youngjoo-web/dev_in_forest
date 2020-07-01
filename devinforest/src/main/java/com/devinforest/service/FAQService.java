package com.devinforest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devinforest.mapper.FAQMapper;

@Service
@Transactional
public class FAQService {
	@Autowired private FAQMapper faqMapper;
}
