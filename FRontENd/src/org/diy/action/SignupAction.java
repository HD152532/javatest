package org.diy.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.diy.util.CommonUtil;
import org.diy.service.UserService;
import org.diy.vo.UserVO;

public class SignupAction implements IAction{
	private void validate(UserVO vo) throws Exception{
		if(org.diy.util.CommonUtil.isEmpty(vo.getId()))
				throw new Exception("id를 입력하시오");
		if(CommonUtil.isEmpty(vo.getPwd()))
				throw new Exception("pwd를 입력하시오");
		if(CommonUtil.isEmpty(vo.getName()))
			throw new Exception("이름을 입력하시오");
		if(CommonUtil.isEmpty(vo.getNickname()))
			throw new Exception("닉네임을 입력하시오");
	}
	/* (non-Javadoc)
	 * @see org.dimigo.action.IAction#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
				request.setCharacterEncoding("utf-8");
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String name = request.getParameter("name");
				String nickname = request.getParameter("nickname");
				System.out.println("아이디: " + id);
				System.out.println("비밀번호: " + pwd);
				System.out.println("이름: " + name);
				System.out.println("닉네임: " + nickname);
				
				UserVO user = new UserVO(id, pwd, name, nickname);
				
				validate(user);
				
				UserService service = new UserService();
				service.signup(user);
				
				RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
				rd.forward(request, response);
				
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/signup.jsp");
			rd.forward(request, response);
		}
		
	}
}
