package com.kr.userboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kr.userboard.vo.Board;

@Repository
public class BoardDao {
@Autowired
private SqlSession sqlSession;

//게시글 저장을 위한 메소드
public int write(Board board) {
	return sqlSession.insert("springboard.write", board);
}

//게시글 목록보기를 위한 메소드
public List<Board> list(){
	return sqlSession.selectList("springboard.list");
}
}
