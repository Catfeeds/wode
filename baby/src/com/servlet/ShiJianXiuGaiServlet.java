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

import com.dao.FenbuDao;
import com.dao.impl.FenbuDaoImpl;

/**
 * @author 石可旺
 *
 */
public class ShiJianXiuGaiServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//	    注销用户，使session失效。
		//	    每次登录时先将session清掉，以防止在此之前没有正常退出，导致第二次再登录时登录不上
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		String uid = request.getParameter("uid");
		String jieshutime = request.getParameter("jieshutime");
		String upower = request.getParameter("upower");
		String starttime = request.getParameter("starttime");
		System.out.println("jieshutime----------------"+jieshutime);
		int upowers=1;
		if(uid!=null){
				int inuid=Integer.parseInt(uid);
			if(upower!=null){
				upowers=Integer.parseInt(upower);
			}
			FenbuDao fenbu=new FenbuDaoImpl();
			int jsnum=fenbu.updateJieShuDate(jieshutime, inuid,upowers,starttime);
			response.sendRedirect("SearchAgentServlet?w=1");
			}else{
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("window.location.href=\"xuanzejiemian.jsp\"");
				out.println("</script>");
			}
		
				out.close();
	}
}
