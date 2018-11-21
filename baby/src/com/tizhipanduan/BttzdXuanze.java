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
public class BttzdXuanze extends HttpServlet{
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
		String bttzd=request.getParameter("bttzd");
		
		if(bttzd==null || bttzd == ""){
			bttzd="01_扁桃体不肿大";
		}
		
		String[] strbttzd = bttzd.split("_");
		String str2bttzd = strbttzd[1];
		 if(xuanze==null||xuanze==""){
			  	out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("window.location.href=\"xuanzejiemian.jsp\"");
				out.println("</script>");
		  }else{
			  	if(xuanze.equals("0")){
					request.getSession().setAttribute("bttzd", bttzd);
					request.getSession().setAttribute("str2bttzd", str2bttzd);
					response.sendRedirect("/addzhenduanshanghuxidao.jsp");
					return;
				}else if(xuanze.equals("1")){
					request.getSession().setAttribute("bttzd", bttzd);
					request.getSession().setAttribute("str2bttzd", str2bttzd);
					response.sendRedirect("/addzhenduanganmaofashao.jsp");
					return;
				}else if(xuanze.equals("2")){
					request.getSession().setAttribute("bttzd", bttzd);
					request.getSession().setAttribute("str2bttzd", str2bttzd);
					response.sendRedirect("/addzhenduanganmaokesou.jsp");
					return;
				}else if(xuanze.equals("3")){
					request.getSession().setAttribute("bttzd", bttzd);
					request.getSession().setAttribute("str2bttzd", str2bttzd);
					response.sendRedirect("/addzhenduanfuxie.jsp");
					return;
				}else if(xuanze.equals("4")){
					request.getSession().setAttribute("bttzd", bttzd);
					request.getSession().setAttribute("str2bttzd", str2bttzd);
					response.sendRedirect("/addzhenduanbianmi.jsp");
					return;
				}else if(xuanze.equals("5")){
					request.getSession().setAttribute("bttzd", bttzd);
					request.getSession().setAttribute("str2bttzd", str2bttzd);
					response.sendRedirect("/addzhenduanjishi.jsp");
					return;
				}else if(xuanze.equals("6")){
					request.getSession().setAttribute("bttzd", bttzd);
					request.getSession().setAttribute("str2bttzd", str2bttzd);
					response.sendRedirect("/addzhenduanbaojian.jsp");
					return;
				}else if(xuanze.equals("7")){
					request.getSession().setAttribute("bttzd", bttzd);
					request.getSession().setAttribute("str2bttzd", str2bttzd);
					response.sendRedirect("/addzhenduantigaomianyili.jsp");
					return;
				}else if(xuanze.equals("8")){
					request.getSession().setAttribute("bttzd", bttzd);
					request.getSession().setAttribute("str2bttzd", str2bttzd);
					response.sendRedirect("/addzhenduanqidongzhihui.jsp");
					return;
				}else if(xuanze.equals("9")){
					request.getSession().setAttribute("bttzd", bttzd);
					request.getSession().setAttribute("str2bttzd", str2bttzd);
					response.sendRedirect("/addzhenduanqidongzhihui.jsp");
					return;
				}
		  }
			out.close();
	}

}
