package org.diy.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements IAction{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		// session.removeAttribute("user");
		session.invalidate();

		RequestDispatcher rd = request.getRequestDispatcher("view.do?rorq=question");
		rd.forward(request, response);
	}
}
