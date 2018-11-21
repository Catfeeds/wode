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
import com.dao.UserDao;
import com.dao.impl.FenbuDaoImpl;
import com.dao.impl.UserDaoImpl;

public class UserManagerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		String post = request.getParameter("post");
		String fname = request.getParameter("fid");
		List userListPara = new ArrayList();
		userListPara.add(name);
		userListPara.add(post);
		userListPara.add(fname);
		request.getSession().setAttribute("userListPara", userListPara);
		UserDao userDao = new UserDaoImpl();
		FenbuDao fenbuDao = new FenbuDaoImpl();
		request.getSession().setAttribute("i", 1);
//		List<Fenbu> fenbuList = fenbuDao.getFenbuList();
//		request.setAttribute("fenbuList", fenbuList);
		System.out.println();
		List<User> userList = userDao.getUserList(name, post, fname, 1);
		int totalCount = userDao.getUserList(name, post, fname);
		for (int i = 0; i < userList.size(); i++) {
			User u = userList.get(i);
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
//			String createName = userDao.getUserNameById(u.getCrid());
//			u.setCreateName(createName);
		}
		request.setAttribute("userList", userList);
		if (totalCount % 5 == 0) {
			totalCount /= 5;
		} else {
			totalCount = totalCount / 5 + 1;
		}
		request.getSession().setAttribute("totalcount", totalCount);
		request.getRequestDispatcher("userManager.jsp").forward(request,
				response);
	}

}
