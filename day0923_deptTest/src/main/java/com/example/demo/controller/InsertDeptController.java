package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.deptDao;
import com.example.demo.vo.DeptVo;

@Controller
@RequestMapping("/insertDept.do")
public class InsertDeptController {
	@Autowired
	private deptDao dao;
	
	
	public void setDao(deptDao dao) {
		this.dao = dao;
	}
	@RequestMapping(method=RequestMethod.GET)
	public void form() {
		
		
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(DeptVo d) {
		ModelAndView mav = new ModelAndView("redirect:/listDept.do");
		int re = dao.insert(d);
		if(re<=0) {
			mav.addObject("msg", "부서등록실패");
			mav.setViewName("error");
		}
		return mav;
	}
}
