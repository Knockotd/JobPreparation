package com.kr.userboard.util;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//설정된 패키지에서 예외가 발생하면 여기 메소드가 처리
@ControllerAdvice("com.kr.userboard")
//인스턴스 자동생성
@Component
public class ErrorPage {
	@ExceptionHandler(Exception.class)
	private ModelAndView errorModelAndView(Exception ex) {

		ModelAndView modelAndView = new ModelAndView();
		//에러 페이지 경로
		modelAndView.setViewName("/error/error");
		modelAndView.addObject("exception", ex);

		return modelAndView;
	}
}
