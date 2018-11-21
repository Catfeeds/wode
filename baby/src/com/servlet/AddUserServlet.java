package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;

public class AddUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Object obj = request.getSession().getAttribute("user");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		if(uname==null) {
			response.sendRedirect("UserManagerServlet");
			return ;
		}
		String loginName = request.getParameter("loginName");
		String ystime = request.getParameter("ystime");
		System.out.println(uname + " " + loginName);
		String post = request.getParameter("post");
		String fid = request.getParameter("fid");
		User userCreate = (User) request.getSession().getAttribute("user");
		User user = new User();
		user.setUname(uname);
		user.setLoginName(loginName);
		user.setYstime(ystime);
		user.setFid(Integer.parseInt(fid));
		user.setUpower(Integer.parseInt(post));
		user.setCrid(userCreate.getUserid());
		user.setUpassword("123");
		user.setHasLogin("0");
		UserDao userDao = new UserDaoImpl();
		User u=(User) obj;
		List<User> list=userDao.checklogname(loginName);
		if(list!=null&&list.size()>0) {
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('账号已存在！');");
			out.println("window.location.href=\"ForwardToAddUserServlet\"");
			out.println("</script>");
			out.close();
		} else {
			if(obj != null) {
				if(u.getUpower()==0||u.getUpower()==1)
					
//					userDao.save(user);
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("alert('添加成功！');");
				out.println("window.location.href=\"UserManagerServlet\"");
				out.println("</script>");
				out.close();
			}
			}
	}

}
