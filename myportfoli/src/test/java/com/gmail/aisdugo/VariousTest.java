package com.gmail.aisdugo;

import java.sql.Date;
import java.util.Calendar;

public class VariousTest {

	public static void main(String[] args) {
		Calendar cal =  Calendar.getInstance();
		Date date = new Date(cal.getTimeInMillis());
		System.out.println(date);
		//util = Mon Nov 12 17:33:14 KST 2018 --> 시간을 넣을 수 있음.
		//sql = 2018-11-12 (대신 캘린더 객체가 필요함) --> 시간을 넣을 수 없음. 데이터베이스와 연동해서 쓸 때는 날짜를 제외하고 사용해야함.

	}

}
