package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.deptDao;

@Controller
public class DeptController {
	@Autowired
	private deptDao dao;
	
	public void setDao(deptDao dao) {
		this.dao = dao;
	}

	@RequestMapping("/listDept.do")
	public void list(Model model) {
		model.addAttribute("list",dao.selectAll());
		model.addAttribute("title", "부서목록");
	}
	
}
