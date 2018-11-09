package com.kr.userboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kr.userboard.service.UserService;
import com.kr.userboard.vo.User;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/register", method=RequestMethod.GET)
//단순 page 이동은 리턴없이 생성해도 됩니다.
//뷰 이름이 user/register가 됩니다.
public void register(Model model) {}
	
	@RequestMapping(value="/user/register",method=RequestMethod.POST)
	public String register(MultipartHttpServletRequest request) {
		userService.register(request);
		
		//회원가입을 처리하고 메인으로 리다이렉트
		//데이터베이스에 변화를 주면 반드시 리다이렉트
		return "redirect:/";
	}
	
	//Ambiguous mapping found. Cannot map 'userController' bean method  - value 값을 안 바꿔서 500에러가 남.
	@RequestMapping(value="/user/login",method=RequestMethod.GET)
	//단순 page 이동은 리턴없이 생성해도 됩니다.
	//뷰 이름이 user/register가 됩니다.
	public void login(Model model) {}
	
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request, HttpSession session, RedirectAttributes attr) {
		User user = userService.login(request);
		//로그인 실패하면 user에 null이라고 저장
		if(user == null) {
			session.setAttribute("user", null);
			//RedirectAttributes는 리다이렉트될 때 한번만 데이터를 전달합니다. (세션은 계속 데이터를 들고다녀서 데이터를 저장하지 않기 위해 사용)
			attr.addFlashAttribute("msg", "없는 이메일이거나 잘못된 비밀번호입니다.");
			return "redirect:login";
		}else {
			//로그인 성공시 user에 로그인 정보를 저장
			session.setAttribute("user", user);
			//user부분을 없애기 위해 ..을 추가. 메인 화면으로 이동함.
			return "redirect:../";
		}
	}
	@RequestMapping(value="/user/logout",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:../";
	}

}

