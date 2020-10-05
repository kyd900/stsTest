package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DeptManager;
import com.example.demo.vo.DeptVo;
@Repository
public class deptDao {
	 public List<DeptVo> selectAll() {
		 return DeptManager.findAll();
	 }
	 
	 public int insert(DeptVo d) {
		 return DeptManager.insert(d);
	 }
}
