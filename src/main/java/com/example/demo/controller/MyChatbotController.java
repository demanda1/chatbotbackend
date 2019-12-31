package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MyChatbotService;

@RestController
public class MyChatbotController {
	@Autowired MyChatbotService chatbotservice;
	@GetMapping("/send/{msg}")
	public Object sendMessage(@PathVariable String msg){
		System.out.println(msg);
		List<String> m=new ArrayList<String>();
		String message=chatbotservice.botService(msg);
		m.add(message);
		return m;
	}

}
