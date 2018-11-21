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
public class XingZhuangXuanze extends HttpServlet{
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
		String xingzhuang=request.getParameter("xingzhuang");
		
		if(xingzhuang==null || xingzhuang == ""){
			xingzhuang="01_正常";
		}
		String[] strxingzhuang = xingzhuang.split("_");
		String str2xingzhuang = strxingzhuang[1];
		 if(xuanze==null||xuanze==""){
			  	out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("window.location.href=\"xuanzejiemian.jsp\"");
				out.println("</script>");
		  }else{
				if(xuanze.equals("1")){
					request.getSession().setAttribute("xingzhuang", xingzhuang);
					request.getSession().setAttribute("str2xingzhuang", str2xingzhuang);
					response.sendRedirect("/addzhenduanganmaofashao.jsp");
					return;
				}else if(xuanze.equals("2")){
					request.getSession().setAttribute("xingzhuang", xingzhuang);
					request.getSession().setAttribute("str2xingzhuang", str2xingzhuang);
					response.sendRedirect("/addzhenduanganmaokesou.jsp");
					return;
				}else if(xuanze.equals("3")){
					request.getSession().setAttribute("xingzhuang", xingzhuang);
					request.getSession().setAttribute("str2xingzhuang", str2xingzhuang);
					response.sendRedirect("/addzhenduanfuxie.jsp");
					return;
				}else if(xuanze.equals("4")){
					request.getSession().setAttribute("xingzhuang", xingzhuang);
					request.getSession().setAttribute("str2xingzhuang", str2xingzhuang);
					response.sendRedirect("/addzhenduanbianmi.jsp");
					return;
				}else if(xuanze.equals("5")){
					request.getSession().setAttribute("xingzhuang", xingzhuang);
					request.getSession().setAttribute("str2xingzhuang", str2xingzhuang);
					response.sendRedirect("/addzhenduanjishi.jsp");
					return;
				}else if(xuanze.equals("6")){
					request.getSession().setAttribute("xingzhuang", xingzhuang);
					request.getSession().setAttribute("str2xingzhuang", str2xingzhuang);
					response.sendRedirect("/addzhenduanbaojian.jsp");
					return;
				}else if(xuanze.equals("7")){
					request.getSession().setAttribute("xingzhuang", xingzhuang);
					request.getSession().setAttribute("str2xingzhuang", str2xingzhuang);
					response.sendRedirect("/addzhenduantigaomianyili.jsp");
					return;
				}else if(xuanze.equals("8")){
					request.getSession().setAttribute("xingzhuang", xingzhuang);
					request.getSession().setAttribute("str2xingzhuang", str2xingzhuang);
					response.sendRedirect("/addzhenduanqidongzhihui.jsp");
					return;
				}else if(xuanze.equals("9")){
					request.getSession().setAttribute("xingzhuang", xingzhuang);
					request.getSession().setAttribute("str2xingzhuang", str2xingzhuang);
					response.sendRedirect("/addzhenduanqidongzhihui.jsp");
					return;
				}
				  }
			out.close();
	}
}
