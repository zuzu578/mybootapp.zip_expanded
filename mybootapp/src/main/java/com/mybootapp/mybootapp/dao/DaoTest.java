package com.mybootapp.mybootapp.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybootapp.mybootapp.dto.Insert;
import com.mybootapp.mybootapp.dto.TestDto;
import com.mybootapp.mybootapp.dto.Update;


@Repository
public class DaoTest {
	@Autowired
	private SqlSession sqlSession;
	protected static final String NAMESPACE = "com.mybootapp.mybootapp.dao.";
	
	public List<TestDto> getList(HashMap<String, Object> paramMap) {
		return sqlSession.selectList(NAMESPACE + "getList",paramMap);
	}
	
	public int getCount() {
		return sqlSession.selectOne(NAMESPACE+"getCount");
	}
	public void delete(String boardNum) {
		 sqlSession.delete(NAMESPACE + "delete", boardNum);
	}

	public void insert(Insert insertParams) {
		sqlSession.insert(NAMESPACE+"insert",insertParams);
		
	}

	public void update(Update updateParams) {
		sqlSession.update(NAMESPACE+"update", updateParams);
		
	}	

}
