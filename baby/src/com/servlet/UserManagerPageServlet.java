package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Record;
import com.bean.User;
import com.dao.FenbuDao;
import com.dao.PatientDao;
import com.dao.UserDao;
import com.dao.impl.FenbuDaoImpl;
import com.dao.impl.PatientDaoImpl;
import com.dao.impl.UserDaoImpl;

public class UserManagerPageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		try{
			
			UserDao userDao = new UserDaoImpl();
			FenbuDao fenbuDao = new FenbuDaoImpl();
			List userListPara = (List) request.getSession().getAttribute(
					"userListPara");
			int i = Integer.parseInt(request.getParameter("i"));
			String name = (String) userListPara.get(0);
			String post = (String) userListPara.get(1);
			String fname = (String) userListPara.get(2);
			request.getSession().setAttribute("i", i);
			List<User> userList = userDao.getUserList(name, post, fname, i);
			for (int j = 0; j < userList.size(); j++) {
				User u = userList.get(j);
				String postName = "";
				if (u.getUpower() == 0) {
					u.setPostName("超级管理员");
				}
				if (u.getUpower() == 1) {
					u.setPostName("分部管理员");
				}
				if (u.getUpower() == 2) {
					u.setPostName("医生");
				}
				if (u.getUpower() == 3) {
					u.setPostName("按摩师");
				}
				if (u.getUpower() == 4) {
					u.setPostName("医生&按摩师");
				}
				String fenbuName = fenbuDao.getFenbuNameById(u.getFid());
				u.setFenbuName(fenbuName);
//				String createName = userDao.getUserNameById(u.getCrid());
//				u.setCreateName(createName);
			}
//			request.setAttribute("fenbuList", fenbuDao.getFenbuList());
			request.setAttribute("userList", userList);
			request.getRequestDispatcher("userManager.jsp").forward(request,
					response);
			
		} catch(Exception e) {
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("window.location.href=\"addUser.jsp\"");
			out.println("</script>");
		}
		out.close();
	}

}
