package com.kr.userboard;
import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kr.userboard.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardTest {

	@Inject
	private DataSource ds;


	@Autowired
	private SqlSession sqlSession;
	@Autowired
	private UserDao userDao;
	
	@Test
	public void sqlSessionTest() {
		//System.out.println(sqlSession);
		System.out.println(userDao.idcheck("ruru@gmail.com"));
	}
	
}
