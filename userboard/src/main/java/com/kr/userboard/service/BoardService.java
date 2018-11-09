package com.kr.userboard.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.kr.userboard.vo.Board;

public interface BoardService {

	//게시글 작성을 위한 메소드
	public int write(HttpServletRequest request);
	
	//게시글 목록보기를 위한 메소드
	public List<Board> list(HttpServletRequest request);
}
