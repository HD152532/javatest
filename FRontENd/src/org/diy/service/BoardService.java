package org.diy.service;

import java.sql.Connection;

import java.util.List;

import org.diy.dao.BoardDao;
import org.diy.vo.BoardVO;

public class BoardService extends AbstractService {
	public void write(BoardVO post, String rorq) throws Exception{
		Connection conn = null;
		try{
			conn = getConnection();
			
			BoardDao dao = new BoardDao(conn);
			dao.write(post, rorq);
			
		}finally{
			if(conn != null) conn.close();
		}
	}
	public List<BoardVO> searchBoardList(String rorq, String type,String searchcontent) throws Exception{
		Connection conn = null;
		try{
			conn = getConnection();
			
			BoardDao dao = new BoardDao(conn);
			
			return dao.searchBoardList(rorq,type,searchcontent);
		}finally{
			if(conn != null) conn.close();
		}
	}
	public BoardVO searchBoardById(int id, String rorq) throws Exception{
		Connection conn = null;
		try{
			conn = getConnection();
			
			BoardDao dao = new BoardDao(conn);
			
			
			BoardVO result = dao.searchBoardById(id, rorq);
			System.out.println(result);
			if(result == null)
				throw new Exception("해당 글이 없습니다.");
			
			return result;
			
		}finally{
			if(conn != null) conn.close();
		}
	}
	public void delete(int id, String rorq) throws Exception{
		Connection conn = null;
		try{
			conn = getConnection();
			
			BoardDao dao = new BoardDao(conn);
			dao.delete(id, rorq);
			
		}finally{
			if(conn != null) conn.close();
		}
	}
}
