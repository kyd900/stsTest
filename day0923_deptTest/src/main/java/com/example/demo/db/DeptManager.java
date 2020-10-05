package com.example.demo.db;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.DeptVo;

	
public class DeptManager {
		
		public static SqlSessionFactory sqlSessionFactory;
	
		static {
			try {
			String resource = "com/example/demo/db/sqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory =	 new SqlSessionFactoryBuilder().build(inputStream);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}//이게 무슨역할?
		public static List<DeptVo> findAll(){
		List<DeptVo> list = null;
		//왜 어레이리스트는 안됐지?
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("dept.selectAll");
		session.close();
		return list;
	}
		
		public static int insert(DeptVo d) {
			int re= -1;
			SqlSession session = sqlSessionFactory.openSession();
			re = session.insert("dept.insert", d);
			session.close();
			return re;
		}
		
}
