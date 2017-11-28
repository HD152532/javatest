package org.diy.action;

import javax.servlet.RequestDispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.diy.service.BoardService;

public class DeletePostAction implements IAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			int id = Integer.parseInt(request.getParameter("id"));
			String rorq = request.getParameter("rorq");
			
			BoardService service = new BoardService();
			service.delete(id,rorq);
			RequestDispatcher rd = request.getRequestDispatcher("/view.do?rorq="+rorq);
			rd.forward(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/view.do?rorq="+request.getParameter("rorq"));
			rd.forward(request, response);
		}
	}
	
}
