package org.diy.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.diy.dao.AnswerDao;
import org.diy.dao.BoardDao;
import org.diy.vo.AnswerVO;

public class AnswerService extends AbstractService {
	public void write(AnswerVO post) throws Exception {
		Connection conn = null;
		try {
			conn = getConnection();

			AnswerDao dao = new AnswerDao(conn);
			dao.write(post);

		} finally {
			if (conn != null)
				conn.close();
		}
	}

	public HashMap<String, Object> searchAnswerList(int id) throws Exception {
		Connection conn = null;
		try {
			conn = getConnection();

			AnswerDao dao = new AnswerDao(conn);
			BoardDao dao2 = new BoardDao(conn);
			int cnt= dao2.atotal(id);

			 HashMap<String, Object> map = new HashMap<String, Object>();
			 map.put("alist", dao.searchAnswerList(id));
			 map.put("cnt", cnt);
			return map;
		} finally {
			if (conn != null)
				conn.close();
		}
	}
}
