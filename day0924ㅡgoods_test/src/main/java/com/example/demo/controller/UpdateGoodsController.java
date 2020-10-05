package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.GoodsDao;
import com.example.demo.vo.GoodsVo;

@Controller
@RequestMapping("/updateGoods.do")
public class UpdateGoodsController {
	
	@Autowired
	private GoodsDao dao;
	

	public void setDao(GoodsDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void form(int no, Model model) {
		model.addAttribute("g",dao.findByNo(no));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(HttpServletRequest request, GoodsVo g) {
		String path = request.getRealPath("image");
		String oldFname = g.getFname();
		MultipartFile uploadFile = g.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		if(fname != null && !fname.equals("")) {
			try {
				byte[]data = uploadFile.getBytes();
				FileOutputStream fos = new FileOutputStream(path + "/"+ fname);
				fos.write(data);
				fos.close();
			}catch (Exception e) {
				System.out.println("예외발생:"+e.getMessage());
			}
			g.setFname(fname);
		}else {
			g.setFname(oldFname);
		}
		
		ModelAndView mav = new ModelAndView("redirect:/listGoods.do");
		int re = dao.update(g);
		if(re <= 0) {
			mav.addObject("msg", "상품수정에 실패하였습니다.");
			mav.setViewName("error");
		}else {
			if( fname != null && !fname.equals("") && !oldFname.equals("")) {
				File file = new File(path + "/" +oldFname);
				file.delete();
			}
		}
		
		return mav;
	}
}