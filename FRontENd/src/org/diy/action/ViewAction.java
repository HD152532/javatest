package org.diy.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.diy.service.BoardService;
import org.diy.vo.BoardVO;

public class ViewAction implements IAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		try {
			BoardService service=  new BoardService();
			String type = request.getParameter("align");
			String rorq = request.getParameter("rorq");
			String searchcontent = request.getParameter("searchcontent");
			System.out.println(rorq);
			List<BoardVO> list = new ArrayList<BoardVO>();
			list = service.searchBoardList(rorq, type, searchcontent);
			request.setAttribute("posts", list);
			request.setAttribute("searchcontent",searchcontent);
			StringBuffer ourl = request.getRequestURL();
			String url = ourl.toString();
			RequestDispatcher rd = request.getRequestDispatcher("jsp/"+rorq+".jsp");
			if(url.contains("jsp/"))
				rd = request.getRequestDispatcher(rorq+".jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/error.jsp");
			rd.forward(request, response);
		}
		
	}

}
