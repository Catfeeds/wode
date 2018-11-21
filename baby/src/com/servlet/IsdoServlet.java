package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.RecordDao;
import com.dao.impl.RecordDaoImpl;

public class IsdoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object obj = request.getSession().getAttribute("user");
		String flag = request.getParameter("flag");
		if(flag==null) {
			response.sendRedirect("SearchRecordServlet");
			return ;
		}
		String id = request.getParameter("id");
		RecordDao recordDao = new RecordDaoImpl();
		User u=(User) obj;
			if (flag.equals("0")) {
				recordDao.update(id, 0);
			} else {
				recordDao.update(id, 1);
			}
		response.sendRedirect("SearchRecordServlet");
	}

}
