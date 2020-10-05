package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/joinOk.do")
public class joinOkController {
	
	@RequestMapping(method=RequestMethod.GET)
	public void form() {
		
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(HttpSession session, String num) {
	ModelAndView mav = new ModelAndView();
	
	String sendMsg = (String)session.getAttribute("sendMsg");
	
	if(sendMsg.equals(num)) {
		
		session.setAttribute("msg", "번호인증성공");
		mav.setViewName("redirect:/insertMember.do");
	}else {
	
		session.setAttribute("msg", "번호인증실패");
		mav.setViewName("redirect:/join.do");
	}
	return mav;
	}
}
