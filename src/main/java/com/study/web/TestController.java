package com.study.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping(path = { "/", "/hello" }, produces = "application/json; charset=utf-8")
	@ResponseBody
	public String hello() {
		return "{'id':'malja', 'age':34}";
	}

}
