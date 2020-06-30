package com.devinforest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexCotroller {
	@GetMapping("/index")
	public String index() {
		return "index/index";
	}
}
