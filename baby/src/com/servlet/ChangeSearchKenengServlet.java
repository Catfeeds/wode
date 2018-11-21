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

import com.bean.Keneng;
import com.bean.User;
import com.dao.impl.KenengDaoImpl;

/**
 * @author 杜欢  Email：huandu01@163.com
 *
 */
public class ChangeSearchKenengServlet extends HttpServlet {

	
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
		User user = null;
		
		String bh=request.getParameter("keneng");
		
		if(bh!=null) {
			request.getSession().setAttribute("bh", bh);
		} else {
			Object o=request.getSession().getAttribute("bh");
			if(o!=null) {
				bh=(String)o;
			} else {
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("alert('重新登录！');");
				out.println("window.location.href=\"index.jsp\"");
				out.println("</script>");
				return ;
			}
			
		}
		KenengDaoImpl kenengDao=new KenengDaoImpl();
		Keneng kn=kenengDao.getKeneng(bh);
		//request.getSession().setAttribute("bh", bh);
		request.getSession().setAttribute("bz", kn.getBingzheng());
		request.getSession().setAttribute("qk", kn.getQingkuang());
		if (obj != null) {
			user = (User) obj;
			request.setAttribute("kn", kn);

			request.getRequestDispatcher("changekeneng.jsp").forward(request,
					response);
		} else {
			
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('重新登录！');");
			out.println("window.location.href=\"index.jsp\"");
			out.println("</script>");
		}
		out.close();
		
	}

}
