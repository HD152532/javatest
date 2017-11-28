package org.diy.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.diy.vo.AnswerVO;

public class AnswerDao {
	private Connection conn = null;

	public AnswerDao(Connection conn) {
		this.conn = conn;
	}

	
	
	public int write(AnswerVO cmt) throws Exception {
		PreparedStatement pstmt = null;
		String SQL = null;
			SQL = "INSERT INTO DIY.ANSWERQ(aqtitle,aqcontent,aquserid, qid) VALUES(?,?,?,?)";
			
		try {
			pstmt = conn.prepareStatement(SQL);
			System.out.println(cmt.getContent());
			pstmt.setString(1, cmt.getTitle());
			pstmt.setString(2, cmt.getContent());
			pstmt.setString(3, cmt.getUserid());
			pstmt.setInt(4, cmt.getFkid());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (pstmt != null)
				pstmt.close();
		}
		return -1;
	}

	public List<AnswerVO> searchAnswerList(int id) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		sql = "SELECT * from diy.answerq where qid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			AnswerVO result = null;
			List<AnswerVO> list = new ArrayList<>();
			while (rs.next()) {
				result = new AnswerVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6),rs.getInt(7),rs.getInt(8));
				list.add(result);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("db접근중 오류가 발생");
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		}
	}
	
}
