/**
 * 
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Money;
import com.bean.User;
import com.dao.FenbuDao;
import com.dao.impl.FenbuDaoImpl;


public class JieSuan extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String uid = request.getParameter("uid");
		String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		int intuid=1;
		if(uid!=null){
			intuid=Integer.parseInt(uid);
		}
		FenbuDao fenbuDao = new FenbuDaoImpl();
		List<User> xjlist = fenbuDao.getXjList(intuid);
		int sumclick=0;
		int  xjsize=xjlist.size();
		for(int i=0;i<xjlist.size();++i){
			sumclick=sumclick+xjlist.get(i).getUclick();
		}
		System.out.println("sumclick---------"+sumclick);
		System.out.println("name---------"+name);
		int summoney=sumclick*3;
		request.getSession().setAttribute("xjsize",xjsize);
		request.getSession().setAttribute("sumclick",sumclick);
		request.getSession().setAttribute("summoney",summoney);
		request.getSession().setAttribute("name",name);
		request.getSession().setAttribute("intuid",intuid);
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("window.location.href=\"searchmoney.jsp\"");
			out.println("</script>");
		
		out.close();
	}

}
