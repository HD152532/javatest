package org.diy.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionAction implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");
		String path = request.getParameter("path");
		request.setAttribute("path", path);
		if (user == null) {
			
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			rd.forward(request, response);
		} else {
			Object patho = request.getAttribute("path");
			System.out.println(patho.toString());
			if (patho.toString().equals("null")) {
				System.out.println(patho+"3");
					RequestDispatcher rd = request.getRequestDispatcher("view.do?rorq=question");
					rd.forward(request, response);
				
			} else {
				
				RequestDispatcher rd = request.getRequestDispatcher((String)patho);
				rd.forward(request, response);
			}
		}
	}

}
