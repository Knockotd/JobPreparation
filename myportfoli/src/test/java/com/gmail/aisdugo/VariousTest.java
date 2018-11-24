package com.gmail.aisdugo;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class VariousTest {

	public static void main(String[] args) {
		/*
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
		*/
		
		//데이터를 저장 할 참조형 변수 선언
				//List<Map<String, Object>> list = new ArrayList<>();
				
				/*
				//웹 데이터를 다운로드 받기 위한 스레드를 생성하고 재정의
				Thread th = new Thread() {
					public void run() {
						try {
							//다운로드 받을 URL
							URL url = new URL("http://www.mfds.go.kr/www/rss/brd.do?brdId=ntc0021");
							//URL 연결 객체 생성
							HttpURLConnection con = (HttpURLConnection)url.openConnection();
							//캐시설정--다운로드 받아두고 다음에 설정할 것인지를 설정
							con.setUseCaches(true);
							con.setConnectTimeout(30000);
							//문자열을 읽기 위한 스트림 생성
							BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
							//줄단위로 읽기
							StringBuilder sb = new StringBuilder();
							while(true) {
								String line = br.readLine();
								if(line == null) {
									break;
								}
								sb.append(line);
							}
							//읽은 내용을 하나의 문자열로 만들기
							String xml = sb.toString();
							//System.out.println(xml);
							
							
							//xml을 파싱
							//xml을 파싱할 수 있는 객체 생성
							DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
							DocumentBuilder builder = factory.newDocumentBuilder();
							//파싱 할 문자열을 스트림으로 변환
							InputStream is = new ByteArrayInputStream(xml.getBytes());
							//문자열 파싱을 수행 - org.w3c.dom
							Document doc = builder.parse(is);
							//루트를 찾기 - org.w3c.dom
							Element root = doc.getDocumentElement();
							//System.out.println(root);
							//title, link, content:encoded, pubDate의 모든 태그를 각각 가져오기
							//title과 link는 0번째에 1번 더 있어서 content:encoded, pubDate의 개수와는 1개씩 차이난다.
							NodeList titles = root.getElementsByTagName("title");
							NodeList links = root.getElementsByTagName("link");
							NodeList contents = root.getElementsByTagName("content:encoded");
							NodeList pubDates = root.getElementsByTagName("pubDate");
							int i = 0;
							while(i<titles.getLength()) {
								Map<String, Object> map = new HashMap<>();
								//의미 없는 태그를 버리고 태그 순서 맞춰주기
							if(i == 0) {
								//첫번째 title
								Node title0 = titles.item(i);
								//첫번째 titles안에 있는 첫번째 자식. 태그가 있으면 태그. 태그가 없으면 값. 값이 없으면 null
								Node titleFirstChild0 = title0.getFirstChild();
								//child의 값을 문자열로 리턴
								String titleFirstChildValue0 = titleFirstChild0.getNodeValue();
								//System.out.println("<<<"+title0+">>>");
								//System.out.println("<<<"+titleFirstChild0+">>>");
								//System.out.println("<<<"+titleFirstChildValue0+">>>");
								String link0 = links.item(i).getFirstChild().getNodeValue();
								//System.out.println("<<<"+link0+">>>");
							}else {
								//두번째부터 link, content:encoded, pubDate
								Node title = titles.item(i);
								Node link = links.item(i);
								Node content = contents.item(i-1);
								Node pubDate = pubDates.item(i-1);
								//두번째 태그의 자식. 태그가 있으면 태그. 태그가 없으면 값. 값이 없으면 null
								Node titleFirstChild = title.getFirstChild();
								Node linkFirstChild = link.getFirstChild();
								//첫번째 태그의 자식. 태그가 있으면 태그. 태그가 없으면 값. 값이 없으면 null
								Node contentFirstChild = content.getFirstChild();
								Node pubDateFirstChild = pubDate.getFirstChild();
								//위에서 찾은 title의 첫번째 자식과 content:encoded의 첫번재 자식의 값을 문자열로 리
								String titleData = titleFirstChild.getNodeValue();
								String linkData = linkFirstChild.getNodeValue();
								String contentData = contentFirstChild.getNodeValue();
								String pubDateData = pubDateFirstChild.getNodeValue();
								System.out.println(pubDateData);
								
								//가져온 문자열 출력
								//System.out.println(titleData+" : "+contentData+"\n"+pubDateData+"\n"+linkData);
								map.put("title", titleData);
								
								map.put("link", linkData);
								map.put("content", contentData);
								//Fri, 02 Nov 2018 01:09:55 GMT
								//날짜
								String days = pubDateData.substring(5, 7);
								//월
								String months = pubDateData.substring(8, 11);
								switch(months) {
								case "Jan" : 
									months = "01";
									break;
								case "Feb" : 
									months = "02";
									break;
								case "Mar" : 
									months = "03";
									break;
								case "Apr" : 
									months = "04";
									break;
								case "May" : 
									months = "05";
									break;
								case "Jun" : 
									months = "06";
									break;
								case "Jul" : 
									months = "07";
									break;
								case "Aug" : 
									months = "08";
									break;
								case "Sep" : 
									months = "09";
									break;
								case "Oct" : 
									months = "10";
									break;
								case "Nov" : 
									months = "11";
									break;
								case "Dec" : 
									months = "12";
									break;
									
								}
								//년
								String years = pubDateData.substring(12, 16);
								//시간
								String clocks = pubDateData.substring(17);
								//System.out.println(clocks);
								pubDateData = String.format("%s-%s-%s", years,months,days);
								
								map.put("pubDate", pubDateData);
								//System.out.println(titleData+" : "+contentData+"\n"+pubDateData+"\n"+linkData);
								//System.out.println(map.toString());
							}
							i=i+1;
							}
							
						}catch(Exception e) {
							System.out.println(e.getMessage());
							e.printStackTrace();
						}
					}
				};
				th.start();
*/
	}

}
