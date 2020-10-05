package com.example.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.GoodsVo;

@Repository
public class GoodsDao {
	public List<GoodsVo> findAll(){
		return DBManager.findAll();	
	}
	public int insert(GoodsVo g) {
		return DBManager.insert(g);
	}
	public GoodsVo findByNo(int no) {
		return DBManager.findByNo(no);
	}

	public int update(GoodsVo g) {
		return DBManager.update(g);
	}
	
	public int delete(int no) {
		return DBManager.delete(no);
	}
	
}
