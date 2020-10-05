package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDao;
import com.example.demo.vo.BoardVo;

@Controller
@RequestMapping("/deleteBoard.do")
public class DeleteBoardController {
	
	@Autowired
	private BoardDao dao;
	
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void form(int no, Model model) {
		model.addAttribute("no", no);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(HttpServletRequest request, int no, String pwd) {
		
		String oldFname = dao.findByNo(no).getFname();
		int oldFsize = dao.findByNo(no).getFsize();		
		String path = request.getRealPath("upload");
		System.out.println("path:"+path);
		
		HashMap map = new HashMap();
		map.put("no", no);
		map.put("pwd", pwd);
		
		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");
		int re = dao.delete(map);
		if(re <= 0) {
			mav.addObject("msg", "게시물 삭제에 실패하였습니다.");
			mav.setViewName("error");
		}else {
					if(oldFsize > 0) {
						File file = new File(path + "/" + oldFname);
						file.delete();
				}
			
		}
		
		return mav;
	}
}








