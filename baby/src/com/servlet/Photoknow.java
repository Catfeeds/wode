/**
 * 
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Richang;
import com.dao.ZhuyiDao;
import com.dao.impl.ZhuyiDaoImpl;

/**
 *
 */
public class Photoknow extends HttpServlet {

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
		
		int rc=1;
		Richang rcsh=new Richang();
		ZhuyiDao zhuyidao=new ZhuyiDaoImpl();
		Richang richang=zhuyidao.getRichang(rc);
		request.getSession().setAttribute("richang", richang);
		
		out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
		out.println("<script>");
		out.println("window.location.href=\"photoknow.jsp\"");
		out.println("</script>");
		out.close();
	}
}
