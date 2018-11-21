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
public class BiLiangXuanze extends HttpServlet{
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
		String biliang=request.getParameter("biliang");
		
		if(biliang==null || biliang == ""){
			biliang="01_正常";
		}
		String[] strbiliang = biliang.split("_");
		String str2biliang = strbiliang[1];
	  if(xuanze==null||xuanze==""){
		  	out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("window.location.href=\"xuanzejiemian.jsp\"");
			out.println("</script>");
	  }else{
		if(xuanze.equals("1")){
			request.getSession().setAttribute("biliang", biliang);
			request.getSession().setAttribute("str2biliang", str2biliang);
			response.sendRedirect("/addzhenduanshanghuxidao.jsp");
			return;
		}else if(xuanze.equals("2")){
			request.getSession().setAttribute("biliang", biliang);
			request.getSession().setAttribute("str2biliang", str2biliang);
			response.sendRedirect("/addzhenduanganmaofashao.jsp");
			return;
		}else if(xuanze.equals("3")){
			request.getSession().setAttribute("biliang", biliang);
			request.getSession().setAttribute("str2biliang", str2biliang);
			response.sendRedirect("/addzhenduanganmaokesou.jsp");
			return;
		}else if(xuanze.equals("4")){
			request.getSession().setAttribute("biliang", biliang);
			request.getSession().setAttribute("str2biliang", str2biliang);
			response.sendRedirect("/addzhenduanjishi.jsp");
			return;
		}else if(xuanze.equals("5")){
			request.getSession().setAttribute("biliang", biliang);
			request.getSession().setAttribute("str2biliang", str2biliang);
			response.sendRedirect("/addzhenduanfuxie.jsp");
			return;
		}else if(xuanze.equals("6")){
			request.getSession().setAttribute("biliang", biliang);
			request.getSession().setAttribute("str2biliang", str2biliang);
			response.sendRedirect("/addzhenduanbianmi.jsp");
			return;
		}else if(xuanze.equals("7")){
			request.getSession().setAttribute("biliang", biliang);
			request.getSession().setAttribute("str2biliang", str2biliang);
			response.sendRedirect("/addzhenduanbaojian.jsp");
			return;
		}else if(xuanze.equals("8")){
			request.getSession().setAttribute("biliang", biliang);
			request.getSession().setAttribute("str2biliang", str2biliang);
			response.sendRedirect("/addzhenduantigaomianyili.jsp");
			return;
		}else if(xuanze.equals("9")){
			request.getSession().setAttribute("biliang", biliang);
			request.getSession().setAttribute("str2biliang", str2biliang);
			response.sendRedirect("/addzhenduanqidongzhihui.jsp");
			return;
		}
	  }
	out.close();

	}
}
