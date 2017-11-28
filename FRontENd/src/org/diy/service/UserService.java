package org.diy.service;

import java.sql.Connection;
import java.util.List;

import org.diy.dao.UserDao;
import org.diy.vo.UserVO;

public class UserService extends AbstractService{
public UserVO login(UserVO user) throws Exception{
		
		Connection conn = null;
		try{
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			UserVO result = dao.SearchUser(user);
			
			if(result == null)
				throw new Exception("Invalid username or password");
			
			return result;
		}finally{
			if(conn != null) conn.close();
		}
	}

	public List<UserVO> searchUserList() throws Exception{
		Connection conn = null;
		try{
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			return dao.searchUserList();
		}finally{
			if(conn != null) conn.close();
		}
	}
	
	public void signup(UserVO user) throws Exception{
		Connection conn = null;
		try{
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			
			//�궗�슜以묒씤 �븘�씠�뵒�씤吏� 泥댄겕
			UserVO result = dao.searchUserById(user);
			System.out.println(result);
			if(result != null)
				throw new Exception("이미 해당 id의 계정이 있습니다.");
			
			//�궗�슜�옄 �벑濡�
			dao.InsertUser(user);
			
		}finally{
			if(conn != null) conn.close();
		}
	}
	
	public void update(UserVO user) throws Exception{
		Connection conn = null;
		try{
			conn = getConnection();
			
			UserDao dao = new UserDao(conn);
			
			dao.UpdateUser(user);
			
		}finally{
			if(conn != null) conn.close();
		}
	}
	
	public void delete(String id) throws Exception{
		Connection conn = null;
		try {
			conn = getConnection();
			UserDao dao = new UserDao(conn);
			
			dao.DeleteUser(id);
		}finally{
			if(conn != null) conn.close();
		}
	}
}
