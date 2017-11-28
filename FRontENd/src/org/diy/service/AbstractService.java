package org.diy.service;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AbstractService {
	public Connection getConnection() throws Exception {
		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
			return dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("DB접근중 실패했습니다.");
		}
	}
}
