package org.diy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.diy.vo.CommentVO;

public class CommentDao {
	
	private Connection conn = null;

	public CommentDao(Connection conn) {
		this.conn = conn;
	}
	
	public int write(CommentVO cmt, String rorq) throws Exception {
		PreparedStatement pstmt = null;
		String SQL = null;
		if (rorq.equals("recipe"))
			SQL = "INSERT INTO DIY.COMMENTR(crcontent, cruserid, rid) VALUES(?,?,?)";
		if (rorq.equals("question"))
			SQL = "INSERT INTO DIY.COMMENTQ(cqcontent, cquserid, qid) VALUES(?,?,?)";

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, cmt.getContent());
			pstmt.setString(2, cmt.getUserid());
			pstmt.setInt(3, cmt.getFkid());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (pstmt != null)
				pstmt.close();
		}
		return -1;
	}
	public List<CommentVO> searchCommentList(String rorq, int id) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		if (rorq.equals("recipe"))
			sql = "SELECT * from diy.commentr where rid=?";
		if (rorq.equals("question"))
			sql = "SELECT * from diy.commentq where qid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			CommentVO result = null;
			List<CommentVO> list = new ArrayList<>();
			while (rs.next()) {
				result = new CommentVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),rs.getInt(6));
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
