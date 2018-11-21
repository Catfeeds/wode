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

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;

/**
 * @author 石可旺
 *
 */
public class XiuGaiZhujiaoServlet extends HttpServlet {

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
		String zhujiao = request.getParameter("zhujiao");
		String[] strzhujiao=zhujiao.split("_");
		int zhujiaoid=26;
		String zhujiaoname=strzhujiao[1];
		if(strzhujiao[0]!=null){
			zhujiaoid=Integer.parseInt(strzhujiao[0]);
		}
		int upowers=1;
		if(uid!=null){
			int inuid=Integer.parseInt(uid);
			UserDao userdao=new UserDaoImpl();
			int jsnum=userdao.updateZhujiao(inuid,zhujiaoid,zhujiaoname);
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
