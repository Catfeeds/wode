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

public class EditUserServlet extends HttpServlet {

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
		if(userid==null) {
			response.sendRedirect("UserManagerServlet");
			return;
		}
		String uname = request.getParameter("uname");
		String loginName = request.getParameter("loginName");
		String post = request.getParameter("post");
		String fid = request.getParameter("fid");
		User user = new User();
		user.setUserid(Integer.parseInt(userid));
		user.setUname(uname);
		user.setLoginName(loginName);
		user.setFid(Integer.parseInt(fid));
		user.setUpower(Integer.parseInt(post));
		UserDao userDao = new UserDaoImpl();
		User u=(User) obj;
		if(u.getUpower()==0||u.getUpower()==1)
		userDao.update(user);
		out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
		out.println("<script>");
		out.println("alert('添加成功！');");
		out.println("window.location.href=\"UserManagerServlet\"");
		out.println("</script>");
		out.close();
	}

}
