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
@RequestMapping("/updateBoard.do")
public class UpateBoardController {
	
	@Autowired
	private BoardDao dao;
	
	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void form(int no, Model model) {
		model.addAttribute("b", dao.findByNo(no));
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(HttpServletRequest request, BoardVo b) {
		String oldFname = b.getFname();
		int oldFsize = b.getFsize();
		System.out.println("oldFname:"+oldFname);
		System.out.println("oldFsize:"+oldFsize);
		
		String path = request.getRealPath("upload");
		System.out.println("path:"+path);
		MultipartFile uploadFile = b.getUploadFile();
		String fname = uploadFile.getOriginalFilename();
		int fsize = 0;
		byte []data = null;
		if( fname != null && !fname.equals("")) {
			System.out.println("파일도 수정합니다!");
			try{
				data = uploadFile.getBytes();
				fsize = data.length;
			}catch (Exception e) {	
			}
		}else {
			System.out.println("파일은 수정하지않아요!");
			fname = oldFname;
			fsize = oldFsize;
		}
		
		b.setFname(fname);
		b.setFsize(fsize);
		
		System.out.println("수정할 객체입니다.");
		System.out.println(b);
		
		
		ModelAndView mav = new ModelAndView("redirect:/listBoard.do");
		int re = dao.update(b);
		if(re <= 0) {
			mav.addObject("msg", "게시물 수정에 실패하였습니다.");
			mav.setViewName("error");
		}else {
			if(!fname.equals("")) {
				try {
					
					FileOutputStream fos = new FileOutputStream(path + "/"+ fname);
					fos.write(data);
					fos.close();
					
					if(oldFsize > 0) {
						File file = new File(path + "/" + oldFname);
						file.delete();
					}
					
				}catch (Exception e) {
					System.out.println("예외발생:"+e.getMessage());
				}
			}
			
		}
		
		return mav;
	}
}








