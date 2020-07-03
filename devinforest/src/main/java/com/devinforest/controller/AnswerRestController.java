package com.devinforest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.devinforest.mapper.AnswerMapper;

@RestController
public class AnswerRestController {

	@Autowired
	private AnswerMapper answerMapper;
	
}
