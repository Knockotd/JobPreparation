package com.gmail.aisdugo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gmail.aisdugo.service.PeoplesService;

@RestController
public class JsonController {

	@Autowired
	private PeoplesService peoplesService;
	
	@RequestMapping(value="peoples/idcheck", method=RequestMethod.GET)
	public Map<String, Object> idcheck(@RequestParam("pid") String pid, @RequestParam("togle") boolean togle, Model model){
		
		Map<String, Object> map = new HashMap<>();
		String result = peoplesService.idcheck(pid);
		//결과가 null인지 아닌지를 리턴한다. false일 때 중복체크 통과할 수 있음
		map.put("result", result==null);
		
		String [] array = pid.split("\\|\\|");
		if(array.length >= 2){
			String resultPid = pid.substring(array[0].length(), array[0].length()+2);
			if(resultPid == "||"){
				// ||가 1개 이상 존재 할 
				togle = false;
			}else {
				// ||가 없음
				togle = true;
			}
		}
		map.put("togle", togle);
		
		return map;
		
	}
	
	@RequestMapping(value="peoples/registercheck", method=RequestMethod.POST)
	public Map<String, Object> registercheck(HttpServletRequest request, Model model){
		
		Map<String, Object> map = new HashMap<>();
		
		//서버에서 온 값을 받기
		
		//맵에 저장
		
		
		return map;
	}
	
	@RequestMapping(value="peoples/pwlength", method=RequestMethod.GET)
	public Map<String, Object> stringlength(@RequestParam("pw") String pw){
		Map<String, Object> map = new HashMap<>();
		System.out.println(pw);
		int pwlength = pw.getBytes().length;
		map.put("pwlength",pwlength );
		
		return map;
	}

}
