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
public class ChongZhiPsswordServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		String uid = request.getParameter("uid");
		FenbuDao fenbu=new FenbuDaoImpl();
		if(uid!=null){
			int inuid=Integer.parseInt(uid);
			int intnumb=fenbu.updatePass(inuid);
			if(intnumb>=1){
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("alert('密码重置成功，重置后的密码为123');");
				out.println("window.location.href=\"SearchAgentServlet?w=1\"");
				out.println("</script>");
			}
		}
		
		out.close();
	}
}
