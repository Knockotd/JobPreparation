package com.gmail.aisdugo.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gmail.aisdugo.vo.Peoples;

public interface PeoplesService {

	//아이디 중복체크 메소드
	public String idcheck(String pid);
	
	//회원가입 메소드
	public boolean register(MultipartHttpServletRequest request);
	
	//로그인 메소드
	public Peoples login(HttpServletRequest request);
	
}
