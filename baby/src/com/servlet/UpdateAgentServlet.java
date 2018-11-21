/**
 * 
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Fenbu;
import com.bean.User;
import com.dao.FenbuDao;
import com.dao.impl.FenbuDaoImpl;


public class UpdateAgentServlet extends HttpServlet{

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String checkboxid = "";   
		System.out.println("54646498316");
		FenbuDao fenbuDao = new FenbuDaoImpl();
		String[] checkboxid1 = request.getParameterValues("checkboxid");
		String checkbox =null;
		if(checkboxid1==null||checkboxid1.equals("")){
			Object obj = request.getSession().getAttribute("user");
			User user = null;
			
			user = (User) obj;
			List<User> list = fenbuDao.getFenbuList(0,null, null,null, null,1);
			int totalCount = fenbuDao.getfenbuCount(0,null, null,null, null);
			List fengbuListPara = new ArrayList();
			
			request.getSession().setAttribute("fengbuListPara",fengbuListPara);
			request.getSession().setAttribute("i", 1);
			if(totalCount==0){
				request.getSession().setAttribute("i", 0);
			} 
			if (totalCount % 5 == 0) {
				totalCount /= 5;
			} else {
				totalCount = totalCount / 5 + 1;
			}
			request.getSession().setAttribute("totalcount", totalCount);
			request.setAttribute("fenbuList", list);
			request.getRequestDispatcher("searchagent.jsp").forward(request,
					response);
		
		}else{
//		for (int i = 0; i < checkboxid1.length; i++) {  
//			checkboxid += checkboxid1[i] + ",";  
			checkbox=checkboxid1[0];
			System.out.println("checkbox==="+checkbox);
			List<Fenbu> lists = fenbuDao.getFenbuxinxi(checkbox);
			request.getSession().setAttribute("updatelist", lists);
			System.out.println("list==========="+lists);
			 for(int i = 0 ; i< lists.size();i++){   
				             System.out.println("skw========"+lists.get(i).getFname());   
				         }   
			System.out.println(checkboxid1[0]);
			request.getRequestDispatcher("updateagent.jsp").forward(request,
					response);
//		}   
		System.out.println(checkboxid1[0]);  
		}
	}
}
