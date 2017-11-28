package org.diy.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.diy.service.UserService;
import org.diy.util.CommonUtil;
import org.diy.vo.UserVO;

public class UserUpdateAction implements IAction {
	private void validate(UserVO vo) throws Exception {
		if (CommonUtil.isEmpty(vo.getPwd()))
			throw new Exception("pwd를 입력하시오");
		if (CommonUtil.isEmpty(vo.getName()))
			throw new Exception("이름을 입력하시오");
		if (CommonUtil.isEmpty(vo.getNickname()))
			throw new Exception("닉네임을 입력하시오");
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		try {
			request.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			UserVO suser = (UserVO) session.getAttribute("user");
			String id = suser.getId();
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String nickname = request.getParameter("nickname");
			UserVO user = new UserVO(id, pwd, name, nickname);
			validate(user);

			UserService service = new UserService();
			service.update(user);
			request.removeAttribute("user");
			request.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/userInfo.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/userInfo.jsp");
			rd.forward(request, response);
		}
	}

}
