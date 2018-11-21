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

/**
 * @author 杜欢  Email：huandu01@163.com
 *
 */
public class XuanzeServlet_change extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public XuanzeServlet_change() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String pid = request.getParameter("pid");
		request.getSession().setAttribute("pid", pid);
		String leibie = request.getParameter("leibie");
		if(pid==null){
			pid=(String) request.getSession().getAttribute("pid");
			leibie=(String) request.getSession().getAttribute("leibie");
			response.sendRedirect("xuanzejiemian_change.jsp");
			return;
		}
		String []leibieNames=leibie.split("_");
		leibie=leibieNames[0];
		String leibieName=leibieNames[1];
		request.getSession().setAttribute("leibieName", leibieName);
		System.out.println("选择后跳转到servlet中pid=" + pid);
		System.out.println("选择后跳转到servlet中leibie=" + leibie);
		
		if (leibie.equals("01")) {
			request.getRequestDispatcher("changezhenduanyi.jsp").forward(request,
					response);
		}
		if (leibie.equals("012")) {
			request.getRequestDispatcher("changeweichang.jsp").forward(request,
					response);
		}
		if (leibie.equals("021")) {
			request.getRequestDispatcher("changezhenduaner1.jsp").forward(request,
					response);
		}
		if (leibie.equals("022")) {
			request.getRequestDispatcher("changezhenduaner2.jsp").forward(request,
					response);
		}
		if (leibie.equals("023")) {
			request.getRequestDispatcher("changezhenduaner3.jsp").forward(request,
					response);
		}
		if (leibie.equals("024")) {
			request.getRequestDispatcher("changezhenduaner4.jsp").forward(request,
					response);
		}
		
		if (leibie.equals("03")) {
			request.getRequestDispatcher("changezhenduanzenzi.jsp").forward(
					request, response);
		}
		if (leibie.equals("04")) {
			request.getRequestDispatcher("changezhenduanqita.jsp").forward(
					request, response);
		}
		if (leibie.equals("05")) {
			request.getRequestDispatcher("changebaojian.jsp").forward(
					request, response);
		}
		
	}
		

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
