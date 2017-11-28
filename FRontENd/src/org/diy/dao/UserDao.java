package org.diy.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.diy.vo.UserVO;

public class UserDao {
private Connection conn = null;
	
	public UserDao(Connection conn){
		this.conn = conn;
	}
	
	public UserVO SearchUser(UserVO vo) throws Exception{
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM diy.USER WHERE ID=? AND PWD=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			
			rs = pstmt.executeQuery();
		
			UserVO result = null;
			if(rs.next()){
				result = new UserVO();
				result.setId(rs.getString(1));
				result.setPwd(rs.getString(2));
				result.setName(rs.getString(3));
				result.setNickname(rs.getString(4));
			}
				
			return result;
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("db접근에 오류가 발생");
		}finally{
			if(rs != null) rs.close();
			if(pstmt !=null) pstmt.close();
		}
	}
	public List<UserVO> searchUserList() throws Exception{
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ID, NAME, NICKNAME FROM diy.USER";
		try{
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
		
			UserVO result = null;
			List<UserVO> list = new ArrayList<>();
			while(rs.next()){
				result = new UserVO();
				result.setId(rs.getString(1));
				result.setName(rs.getString(2));
				result.setNickname(rs.getString(3));
				list.add(result);
			}
				
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("db접근중 오류가 발생");
		}finally{
			if(rs != null) rs.close();
			if(pstmt !=null) pstmt.close();
		}
	}
	public UserVO searchUserById(UserVO vo) throws Exception{
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM diy.USER WHERE ID=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			
			rs = pstmt.executeQuery();
		
			UserVO result = null;
			if(rs.next()){
				result = new UserVO();
				result.setId(rs.getString(1));
				result.setName(rs.getString(3));
				result.setNickname(rs.getString(4));
			}
				
			return result;
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("db접근중 오류 발생");
		}finally{
			if(rs != null) rs.close();
			if(pstmt !=null) pstmt.close();
		}
	}
	public void InsertUser(UserVO vo) throws Exception{
		PreparedStatement  pstmt = null;
		String sql = "INSERT INTO diy.USER VALUES(?, ?, ?, ?)";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4,  vo.getNickname());
			
			//executeQuery: SELECT
			//executeUpdate : INSERT / UPDATE / DELETE
			int cnt = pstmt.executeUpdate();
		
			if(cnt == 0) throw new Exception("db접근중 오류 발생함");
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("계정 생성 실패");
		}finally{
			if(pstmt !=null) pstmt.close();
		}
	}
	public void UpdateUser(UserVO vo) throws Exception{
		PreparedStatement  pstmt = null;
		String sql = "UPDATE diy.User Set pwd=?, name=?, nickname=? where id=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(4, vo.getId());
			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3,  vo.getNickname());
			
			//executeQuery: SELECT
			//executeUpdate : INSERT / UPDATE / DELETE
			int cnt = pstmt.executeUpdate();
		
			if(cnt == 0) throw new Exception("db접근중 오류 발생함");
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("계정 변경 실패");
		}finally{
			if(pstmt !=null) pstmt.close();
		}
	}
	public void DeleteUser(String id) throws Exception{
		PreparedStatement  pstmt = null;
		String sql = "Delete from diy.User where id=?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			//executeQuery: SELECT
			//executeUpdate : INSERT / UPDATE / DELETE
			int cnt = pstmt.executeUpdate();
		
			if(cnt == 0) throw new Exception("db접근중 오류 발생함");
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("계정 삭제 실패");
		}finally{
			if(pstmt !=null) pstmt.close();
		}
	}
}
