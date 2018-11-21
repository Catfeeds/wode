package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;

public class InfSearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(1234545);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Object obj = request.getSession().getAttribute("user");
		User user = null;
		if (obj != null) {
			user = (User) obj;
			if (user.getUpower() == 1 || user.getUpower() == 0
					|| user.getUpower() == 2) {

				request.getRequestDispatcher("searchinfor.jsp").forward(
						request, response);
			} else {
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("alert('无权操作！');");
				out.println("window.location.href=\"top.jsp\"");
				out.println("</script>");
			}
		}else {
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('重新登录！');");
			out.println("window.location.href=\"index.jsp\"");
			out.println("</script>");
		}
		out.close();
	}

}
