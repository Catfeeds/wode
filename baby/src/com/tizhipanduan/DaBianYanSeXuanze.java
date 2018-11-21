/**
 * 
 */
package com.tizhipanduan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 石可旺
 *
 */
public class DaBianYanSeXuanze extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		
		String xuanze=request.getParameter("xuanze");
		String dabianyanse=request.getParameter("dabianyanse");
		
		if(dabianyanse==null || dabianyanse == ""){
			dabianyanse="01_否";
		}
		String[] strdabianyanse = dabianyanse.split("_");
		String str2dabianyanse = strdabianyanse[1];
		 if(xuanze==null||xuanze==""){
			  	out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("window.location.href=\"xuanzejiemian.jsp\"");
				out.println("</script>");
		  }else{
				if(xuanze.equals("1")){
					request.getSession().setAttribute("dabianyanse", dabianyanse);
					request.getSession().setAttribute("str2dabianyanse", str2dabianyanse);
					response.sendRedirect("/addzhenduanganmaofashao.jsp");
					return;
				}else if(xuanze.equals("2")){
					request.getSession().setAttribute("dabianyanse", dabianyanse);
					request.getSession().setAttribute("str2dabianyanse", str2dabianyanse);
					response.sendRedirect("/addzhenduanganmaokesou.jsp");
					return;
				}else if(xuanze.equals("3")){
					request.getSession().setAttribute("dabianyanse", dabianyanse);
					request.getSession().setAttribute("str2dabianyanse", str2dabianyanse);
					response.sendRedirect("/addzhenduanfuxie.jsp");
					return;
				}else if(xuanze.equals("4")){
					request.getSession().setAttribute("dabianyanse", dabianyanse);
					request.getSession().setAttribute("str2dabianyanse", str2dabianyanse);
					response.sendRedirect("/addzhenduanbianmi.jsp");
					return;
				}else if(xuanze.equals("5")){
					request.getSession().setAttribute("dabianyanse", dabianyanse);
					request.getSession().setAttribute("str2dabianyanse", str2dabianyanse);
					response.sendRedirect("/addzhenduanjishi.jsp");
					return;
				}else if(xuanze.equals("6")){
					request.getSession().setAttribute("dabianyanse", dabianyanse);
					request.getSession().setAttribute("str2dabianyanse", str2dabianyanse);
					response.sendRedirect("/addzhenduanbaojian.jsp");
					return;
				}else if(xuanze.equals("7")){
					request.getSession().setAttribute("dabianyanse", dabianyanse);
					request.getSession().setAttribute("str2dabianyanse", str2dabianyanse);
					response.sendRedirect("/addzhenduantigaomianyili.jsp");
					return;
				}else if(xuanze.equals("8")){
					request.getSession().setAttribute("dabianyanse", dabianyanse);
					request.getSession().setAttribute("str2dabianyanse", str2dabianyanse);
					response.sendRedirect("/addzhenduanqidongzhihui.jsp");
					return;
				}else if(xuanze.equals("9")){
					request.getSession().setAttribute("dabianyanse", dabianyanse);
					request.getSession().setAttribute("str2dabianyanse", str2dabianyanse);
					response.sendRedirect("/addzhenduanqidongzhihui.jsp");
					return;
				}
				  }
			out.close();
		
	}

}
