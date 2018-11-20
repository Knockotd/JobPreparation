package com.gmail.aisdugo;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class VariousTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Date date = new Date(cal.getTimeInMillis());
		System.out.println(date);
		// util = Mon Nov 12 17:33:14 KST 2018 --> 시간을 넣을 수 있음.
		// sql = 2018-11-12 (대신 캘린더 객체가 필요함) --> 시간을 넣을 수 없음. 데이터베이스와 연동해서 쓸 때는 날짜를 제외하고
		// 사용해야함.
		
		String str = "aisdugo@naver.com";
		String [] array = str.split("\\|\\|");
		boolean togle = false;
		if(array.length >= 2) {
			// ||가 1개 이상 존재 할 
			String temp = str.substring(array[0].length(), array[0].length()+2);
			if(temp == "||") {
				togle = false;
			}
		}else {
			// ||가 없을 때
			togle = true;
		}
		System.out.println(array[0].length());
		for(String temp : array) {
			System.out.println(temp);
		}
		
		System.out.println(array.length);
		System.out.println(togle);
		//System.out.println(str.substring(array[0].length(),array[0].length()+2));
		
	String password = "안녕하세요!a";
System.out.println(password.getBytes().length);
		

	}

}
