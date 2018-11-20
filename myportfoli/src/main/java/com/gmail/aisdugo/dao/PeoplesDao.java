package com.gmail.aisdugo.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gmail.aisdugo.vo.Peoples;


@Repository
public class PeoplesDao {
@Autowired
private SqlSession sqlSession;
//아이디 중복체크 메소드
public String idcheck(String pid) {
	return sqlSession.selectOne("peoples.idcheck", pid);
}

//회원가입 메소드
public boolean register(Peoples peoples) {
	boolean registerSuccess = false;
	sqlSession.insert("peoples.register", peoples);
	registerSuccess = true;
	System.out.print(registerSuccess);
	return registerSuccess;
}

//로그인 메소드
public Peoples login(String pid) {
	System.out.println("로그인 DAO:"+sqlSession.selectOne("peoples.login", pid));
	return sqlSession.selectOne("peoples.login", pid);
}

}
