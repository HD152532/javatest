package org.diy.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.diy.vo.BoardVO;

public class BoardDao {

	private Connection conn = null;

	public BoardDao(Connection conn) {
		this.conn = conn;
	}

	public int total(int num) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String SQL = null;

		if (num == 0)
			SQL = "SELECT COUNT(*) FROM diy.boardr";
		if (num == 1)
			SQL = "SELECT COUNT(*) FROM diy.boardq";
		int total = 0;

		try {

			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				total = rs.getInt(1);
			}
			return total;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("db접근중 에러 발생");
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		}
	}

	public int atotal(int id) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String SQL = null;

		SQL = "SELECT COUNT(*) FROM diy.answerq where qid=?";
		int total = 0;

		try {

			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				total = rs.getInt(1);
			}
			return total;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("db접근중 에러 발생");
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		}
	}

	public int ctotal(int id) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String SQL = null;

		SQL = "SELECT COUNT(*) FROM diy.commentr where rid=?";
		int total = 0;

		try {

			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				total = rs.getInt(1);
			}
			return total;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("db접근중 에러 발생");
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
		}
	}

	public List<BoardVO> searchBoardList(String rorq, String type, String searchcontent) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		if (rorq.equals("recipe")) {
			sql = "SELECT * from diy.boardr";
			if(searchcontent!=null) {
				System.out.println(searchcontent);
				sql+=" where rtitle like ? or rcontent like ?";
			}
		}
		if (rorq.equals("question")) {
			sql = "SELECT * from diy.boardq";
			if(searchcontent!=null) {
				sql+=" where qtitle like ? or qcontent like ?";
			}
		}
		try {
			
			pstmt = conn.prepareStatement(sql);
			if(searchcontent!=null) {
				pstmt.setString(1,'%'+searchcontent+'%');
				pstmt.setString(2,'%'+searchcontent+'%');
			}

			rs = pstmt.executeQuery();

			BoardVO result = null;
			List<BoardVO> list = new ArrayList<>();
			while (rs.next()) {
				result = new BoardVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8));
				System.out.println(result.getBdTitle());
				if (rorq.equals("recipe"))
					result.setCnt(ctotal(result.getBdID()));
				if (rorq.equals("question"))
					result.setCnt(atotal(result.getBdID()));
				list.add(result);
			}
			if ("l".equals(type)) {
				Collections.sort(list, new CompareIdDesc());
			}
			if ("c".equals(type)) {
				Collections.sort(list, new CompareCntsDesc());
			}
			if ("v".equals(type)) {
				Collections.sort(list, new CompareViewDesc());
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

	static class CompareIdDesc implements Comparator<BoardVO> {

		@Override
		public int compare(BoardVO o1, BoardVO o2) {
			// TODO Auto-generated method stub
			return o1.getBdID() > o2.getBdID() ? -1 : o1.getBdID() < o2.getBdID() ? 1 : 0;
		}
	}

	static class CompareViewDesc implements Comparator<BoardVO> {

		@Override
		public int compare(BoardVO o1, BoardVO o2) {
			// TODO Auto-generated method stub
			return o1.getBdViews() > o2.getBdViews() ? -1 : o1.getBdViews() < o2.getBdViews() ? 1 : 0;
		}
	}

	static class CompareCntsDesc implements Comparator<BoardVO> {

		@Override
		public int compare(BoardVO o1, BoardVO o2) {
			// TODO Auto-generated method stub
			return o1.getCnt() > o2.getCnt() ? -1 : o1.getCnt() < o2.getCnt() ? 1 : 0;
		}
	}

	public BoardVO searchBoardById(int id, String rorq) throws Exception {
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		String sql = null;
		if (rorq.equals("recipe"))
			sql = "SELECT * from diy.boardr where rid=?";
		if (rorq.equals("question"))
			sql = "SELECT * from diy.boardq where qid=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			System.out.println(id);
			BoardVO result = null;
			if (rs.next()) {
				result = new BoardVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7), rs.getInt(8));
				result.setBdViews(result.getBdViews() + 1);
			}
			if (rorq.equals("recipe"))
				sql = "UPDATE diy.boardr SET rview = ? where rid=?";
			if (rorq.equals("question"))
				sql = "UPDATE diy.boardq SET qview = ? where qid=?";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.setInt(1, result.getBdViews());
			pstmt2.setInt(2, id);
			pstmt2.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("db접근중 오류가 발생");
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (pstmt2 != null)
				pstmt2.close();
		}
	}

	public int write(BoardVO board, String rorq) throws Exception {
		PreparedStatement pstmt = null;
		String SQL = null;
		if (rorq.equals("recipe"))
			SQL = "INSERT INTO DIY.BOARDR(rtitle, ruserid, rcontent, rok) VALUES(?,?,?,?)";
		if (rorq.equals("question"))
			SQL = "INSERT INTO DIY.BOARDQ(qtitle, quserid, qcontent, qok) VALUES(?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, board.getBdTitle());
			pstmt.setString(2, board.getUserID());
			pstmt.setString(3, board.getBdContent());
			pstmt.setInt(4, 1);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (pstmt != null)
				pstmt.close();
		}
		return -1;
	}
	
	public int delete(int id, String rorq) throws Exception {
		PreparedStatement pstmt = null;
		String SQL = null;
		if (rorq.equals("recipe"))
			SQL = "DELETE from diy.boardr where rid=?";
		if (rorq.equals("question"))
			SQL = "DELETE from diy.boardq where qid=?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (pstmt != null)
				pstmt.close();
		}
		return -1;
	}

}
