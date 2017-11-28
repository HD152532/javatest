package org.diy.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.diy.service.AnswerService;
import org.diy.service.BoardService;
import org.diy.service.CommentService;
import org.diy.vo.AnswerVO;
import org.diy.vo.BoardVO;
import org.diy.vo.CommentVO;

public class PostAction implements IAction {

	@SuppressWarnings("unchecked")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String rorq = request.getParameter("rorq");
			BoardService service1 = new BoardService();
			BoardVO result = service1.searchBoardById(id, rorq);
			
			CommentService cservice = new CommentService();
			List<CommentVO> clist = new ArrayList<CommentVO>();
			clist = cservice.searchCommentList(rorq, id);
			int cnt=0;
			AnswerService aservice = new AnswerService();
			List<AnswerVO> alist = new ArrayList<AnswerVO>();
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			map = aservice.searchAnswerList(id);
			alist = (List<AnswerVO>) map.get("alist");
			cnt = (int) map.get("cnt");
			System.out.println(cnt);
			request.setAttribute("post", result);
			request.setAttribute("alist", alist);
			request.setAttribute("clist", clist);
			request.setAttribute("cnt", cnt);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/post"+rorq.substring(0, 1)+".jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/view.do?rorq="+request.getParameter("rorq"));
			rd.forward(request, response);
		}
	}

}
