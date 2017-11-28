package org.diy.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.diy.service.UserService;
import org.diy.vo.UserVO;

public class DeleteUserAction implements IAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		try {
			request.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			UserVO user = (UserVO) session.getAttribute("user");
			String id = user.getId();
			
			UserService service = new UserService();
			service.delete(id);
			session.invalidate();
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			rd.forward(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/userInfo.jsp");
			rd.forward(request, response);
		}
	}

}
