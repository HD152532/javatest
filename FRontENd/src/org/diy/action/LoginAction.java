package org.diy.action;

import javax.servlet.RequestDispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.diy.util.CommonUtil;
import org.diy.service.UserService;
import org.diy.vo.UserVO;

public class LoginAction implements IAction{
	private void validate(String id, String pwd) throws Exception{
		if(CommonUtil.isEmpty(id))
				throw new Exception("ID를 작성해주세요");
		if(CommonUtil.isEmpty(pwd))
				throw new Exception("Password를 작성해주세요");
	}
	/* (non-Javadoc)
	 * @see org.dimigo.action.IAction#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String path = request.getParameter("path");
			System.out.printf("id : %s, pwd: %s\n", id, pwd);

			validate(id,pwd);
			
			UserVO user = new UserVO();
			user.setId(id);;
			user.setPwd(pwd);
			
			UserService service = new UserService();
			UserVO result = service.login(user);

			HttpSession session = request.getSession();
			session.setAttribute("user", result);
			
			request.setAttribute("path", path);
			RequestDispatcher rd = request.getRequestDispatcher("session.do");
			rd.forward(request, response);
				
		}catch(Exception e){
			e.printStackTrace();
//			request.setAttribute("msg", "error");
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
			rd.forward(request, response);
		}

	}
}
