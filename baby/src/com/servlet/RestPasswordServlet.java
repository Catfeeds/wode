package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;

public class RestPasswordServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Object obj = request.getSession().getAttribute("user");
		String userid = request.getParameter("userid");
		UserDao userDao = new UserDaoImpl();
		User u=(User) obj;
		//if(u.getUpower()==0)
		  userDao.resetPassword(userid);
		out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
		out.println("<script>");
		out.println("alert('重置成功！');");
		out.println("window.location.href=\"UserManagerServlet\"");
		out.println("</script>");
		out.close();
	}

}
