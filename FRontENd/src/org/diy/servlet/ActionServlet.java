package org.diy.servlet;

import java.io.IOException;




import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.diy.action.AnswerAction;
import org.diy.action.CommentAction;
import org.diy.action.DeletePostAction;
import org.diy.action.DeleteUserAction;
import org.diy.action.IAction;
import org.diy.action.LoginAction;
import org.diy.action.LogoutAction;
import org.diy.action.PostAction;
import org.diy.action.SessionAction;
import org.diy.action.SignupAction;
import org.diy.action.UserUpdateAction;
import org.diy.action.ViewAction;
import org.diy.action.WriteAction;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("*.do")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map<String, IAction> actions = new HashMap<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        super();
    }

    /* (non-Javadoc)
     * @see javax.servlet.GenericServlet#init()
     */
    @Override
    public void init() throws ServletException {
    	actions.put("login", new LoginAction());
    	actions.put("logout", new LogoutAction());
    	actions.put("signup", new SignupAction());
    	actions.put("write", new WriteAction());
    	actions.put("view", new ViewAction());
    	actions.put("post", new PostAction());
    	actions.put("session", new SessionAction());
    	actions.put("comment", new CommentAction());
    	actions.put("answer", new AnswerAction());
    	actions.put("userUpdate", new UserUpdateAction());
    	actions.put("userDelete", new DeleteUserAction());
    	actions.put("deletePost", new DeletePostAction());
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			// 1. uri (/login.do)
			String uri = request.getRequestURI();
			System.out.println("uri : " + uri);
			
			String actionName = uri.substring(uri.lastIndexOf("/") + 1); 
			actionName = actionName.substring(0, actionName.indexOf("."));
			System.out.println(actionName);
			
			IAction action = actions.get(actionName);
			
			if(action == null){
				throw new Exception(actionName +  "Action 접근 못함");
			}
			
			//XXAction�쓽 execute()
			action.execute(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("jsp/error.jsp");
			rd.forward(request, response);
		}
	}

}
