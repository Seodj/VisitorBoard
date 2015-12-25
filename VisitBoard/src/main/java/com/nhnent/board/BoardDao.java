package com.nhnent.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.nhnent.mybatis.SqlMapClient;

public class BoardDao {
	private SqlSessionFactory sqlSessionFactory;
	
	public BoardDao(){
		sqlSessionFactory = SqlMapClient.getSqlSession();
	}
	
	// board write
	public boolean write(Board board){
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();
			int isInsert = session.insert("sqlMapper.writeBoard", board);
			session.commit();
			if(isInsert > 0){
				return true;
			} else{
				return false;
			}
		} finally{
			if(session!=null)
				session.close();
		}
	}
	
	public List<Board> getList(){
		SqlSession session = null;
		try{
			session = sqlSessionFactory.openSession();
			return session.selectList("getBoard");
		} finally{
			if(session!=null)
				session.close();
		}
	}
	
	// board update
	public boolean update(Board board){
		return false;
	}

}
