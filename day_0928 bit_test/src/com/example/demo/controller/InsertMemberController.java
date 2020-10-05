package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.MemberDao;
import com.example.demo.vo.MemberVo;

@Controller
@RequestMapping("/insertMember.do")
public class InsertMemberController {
	
	@Autowired
	private MemberDao dao;
	
	
	
	public void setDao(MemberDao dao) {
		this.dao = dao;
	}


	@RequestMapping(method = RequestMethod.GET)
	public void form() {
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(MemberVo m) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "회원가입에 성공하였습니다.");
		mav.addObject("text_color", "blue");
		int re = dao.insert(m);
		if(re <= 0) {
			mav.addObject("msg", "회원가입에 실패하였습니다.");
			mav.addObject("text_color", "red");
		}
		return mav;
	}
}





