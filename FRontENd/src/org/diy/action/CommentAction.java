package org.diy.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.diy.service.CommentService;
import org.diy.util.CommonUtil;
import org.diy.vo.CommentVO;
import org.diy.vo.UserVO;

public class CommentAction implements IAction{

	private void validate(String content, int id) throws Exception{
		if(CommonUtil.isEmpty(content))
				throw new Exception("내용을 작성해주세요");
		if(CommonUtil.isEmpty(id))
			throw new Exception("해당 글이 없습니다.");
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
			String content = request.getParameter("content");
			int id = Integer.parseInt(request.getParameter("id"));
			String rorq = request.getParameter("rorq");
			System.out.printf("content: %s, id= %d userid=%s rorq=%s\n",content,id, user.getId(), rorq);
			String userid = user.getId();

			System.out.printf("content: %s, id= %d userid=%s\n",content,id, userid);

			validate(content,id);
			
			CommentVO cmt = new CommentVO();
			cmt.setContent(content);
			cmt.setUserid(userid);
			cmt.setFkid(id);
			
			CommentService service = new CommentService();
			service.write(cmt, rorq);

			RequestDispatcher rd = request.getRequestDispatcher("post.do?id="+id+"&rorq="+rorq);
			rd.forward(request, response);
				
		}catch(Exception e){
			e.printStackTrace();
//			request.setAttribute("msg", "error");
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("post.do?id="+request.getParameter("id")+"&rorq="+request.getParameter("rorq"));
			rd.forward(request, response);
		}
		
	}

}
