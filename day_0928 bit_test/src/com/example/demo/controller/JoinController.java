package com.example.demo.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.youiwe.webservice.BitSms;

@Controller
@RequestMapping("/join.do")
public class JoinController {
	
	@Autowired
	private BitSms bs;
	
	public void setBs(BitSms bs) {
		this.bs = bs;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void form() {		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(String to, HttpSession session) {
		ModelAndView mav = new ModelAndView("redirect:/joinOk.do");
		Random r = new Random();
		String msg = r.nextInt(10) + ""+ r.nextInt(10)+""+ r.nextInt(10)+""+ r.nextInt(10)+"" ;
		session.setAttribute("sendMsg", msg);		
		String re = bs.sendMsg("01096873487", to, msg);
		if(!re.equals("1")) {
			mav.addObject("msg", "인증키 전송에 실패하였습니다. 올바른 전화번호를 입력하세요!");
			mav.setViewName("join");
		}
		return mav;
	}
}






