package com.example.demo.controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.GoodsDao;
import com.example.demo.vo.GoodsVo;
@Controller
@RequestMapping("/insertGoods.do")
public class InsertGoodsController {
	@Autowired
	private GoodsDao dao;
	
	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method=RequestMethod.GET)
	public void form() {
		
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView submit(GoodsVo g,HttpServletRequest request) {
		String path = request.getRealPath("img");
		System.out.println("path :"+path);
		MultipartFile uploadFile = g.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		if(fname != null && !fname.equals("")) {
			try {
			byte []data= uploadFile.getBytes();
			FileOutputStream fos = new FileOutputStream(path+"/"+fname);
			fos.write(data);
			fos.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
				
			}
		}else {
			fname="";
		}
		g.setFname(fname);
		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");
		int re= dao.insert(g);

		if(re<=0) {
			mav.addObject("msg", "상품등록실패");
			mav.setViewName("error");
		}
		return mav;
	}
	
}
