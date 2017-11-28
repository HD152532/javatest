package org.diy.action;

import javax.servlet.RequestDispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.diy.service.BoardService;
import org.diy.util.CommonUtil;
import org.diy.vo.UserVO;
import org.diy.vo.BoardVO;

public class WriteAction implements IAction{

	private void validate(String title, String content) throws Exception{
		if(CommonUtil.isEmpty(title))
				throw new Exception("제목을 작성해주세요");
		if(CommonUtil.isEmpty(content))
				throw new Exception("내용을 작성해주세요");
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try{
			HttpSession session = request.getSession();
			UserVO user = (UserVO) session.getAttribute("user");
			if(user==null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("jsp/login.jsp");
				rd.forward(request, response);
			}
			
			request.setCharacterEncoding("utf-8");
			String title = request.getParameter("bdTitle");
			String content = request.getParameter("bdContent");
			String rorq = request.getParameter("rorq");
			System.out.println(rorq+"writeAction");
			validate(title,content);
			
			BoardVO post = new BoardVO();
			post.setBdTitle(title);
			post.setBdContent(content);
			post.setUserID(user.getId());
			
			BoardService service = new BoardService();
			service.write(post, rorq);

			RequestDispatcher rd = request.getRequestDispatcher("view.do?rorq="+rorq);
			rd.forward(request, response);
				
		}catch(Exception e){
			e.printStackTrace();
//			request.setAttribute("msg", "error");
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/write"+request.getParameter("rorq").substring(0,1)+".jsp");
			rd.forward(request, response);
		}
		
	}

}
