package com.js.home;

import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	
	private String message;
	
	private String app;
	
	@GetMapping("/")
	public String home() throws Exception{
		
		
		return "/index";
	}

}
