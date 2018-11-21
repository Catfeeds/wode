/**
 * 
 */
package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Fenbu;
import com.bean.User;
import com.dao.FenbuDao;
import com.dao.impl.FenbuDaoImpl;


public class SearchAgentPageServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	public SearchAgentPageServlet(){
		super();
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		FenbuDao fenbuDao = new FenbuDaoImpl();
		List fengbuListPara = (List) request.getSession().getAttribute("fengbuListPara");

		if(fengbuListPara==null) {
			response.sendRedirect("SearchAgentServlet");
			return;
		}
		int i = Integer.parseInt(request.getParameter("i"));
		String name = (String) fengbuListPara.get(0);
		String phone = (String) fengbuListPara.get(1);
		String upower = (String) fengbuListPara.get(2);
//		String sex = (String) agentListPara.get(2);

		User user = (User) fengbuListPara.get(3);
		int uid=user.getUserid();
		List<User> list = fenbuDao.getFenbuList(uid,name, phone,upower, user, i);
		for (int j = 0; j < list.size(); j++) {
			User usr = list.get(j);
			int number = fenbuDao.getMoneynmb(usr.getUserid());
			usr.setNumbers(number);
		}
		if(i==-1){
			request.getSession().setAttribute("i", 0);
		}else{
			request.getSession().setAttribute("i", i);
		}
		request.getSession().setAttribute("xiajiList", list);
		request.getRequestDispatcher("searchagent.jsp").forward(request,
				response);
	}
}
