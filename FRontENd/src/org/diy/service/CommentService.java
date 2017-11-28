package org.diy.service;

import java.sql.Connection;
import java.util.List;

import org.diy.dao.CommentDao;
import org.diy.vo.CommentVO;

public class CommentService extends AbstractService {
	public void write(CommentVO post, String rorq) throws Exception {
		Connection conn = null;
		try {
			conn = getConnection();

			CommentDao dao = new CommentDao(conn);
			dao.write(post, rorq);

		} finally {
			if (conn != null)
				conn.close();
		}
	}
	
	public List<CommentVO> searchCommentList(String rorq, int id) throws Exception {
		Connection conn = null;
		try {
			conn = getConnection();

			CommentDao dao = new CommentDao(conn);

			return dao.searchCommentList(rorq, id);
		} finally {
			if (conn != null)
				conn.close();
		}
	}
}
