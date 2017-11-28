package org.diy.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.diy.service.AnswerService;
import org.diy.util.CommonUtil;
import org.diy.vo.AnswerVO;
import org.diy.vo.UserVO;

public class AnswerAction implements IAction{
	
	private void validate(String content, String title) throws Exception{
		if(CommonUtil.isEmpty(content))
				throw new Exception("내용을 작성해주세요");
		if(CommonUtil.isEmpty(title))
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
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			int id = Integer.parseInt(request.getParameter("id"));
			String userid=user.getId();
			System.out.printf("content: %s, title= %s userid=%s id=%d\n",content,title, user.getId(),id);

			validate(content,title);
			
			AnswerVO ans = new AnswerVO();
			ans.setTitle(title);
			ans.setContent(content);
			ans.setUserid(userid);
			ans.setFkid(id);
			
			AnswerService service = new AnswerService();
			service.write(ans);

			RequestDispatcher rd = request.getRequestDispatcher("post.do?rorq=question&id="+id);
			rd.forward(request, response);
				
		}catch(Exception e){
			e.printStackTrace();
//			request.setAttribute("msg", "error");
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("post.do?rorq=question&id="+request.getParameter("id"));
			rd.forward(request, response);
		}
		
	}
}
