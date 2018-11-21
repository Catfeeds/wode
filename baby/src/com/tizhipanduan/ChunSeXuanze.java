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
public class ChunSeXuanze extends HttpServlet{
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
		String chunse=request.getParameter("chunse");
		
		if(chunse==null || chunse == ""){
			chunse="01_淡红";
		}
		String[] strchunse = chunse.split("_");
		String str2chunse = strchunse[1];
		 if(xuanze==null||xuanze==""){
			  	out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("window.location.href=\"xuanzejiemian.jsp\"");
				out.println("</script>");
		  }else{
		if(xuanze.equals("1")){
			request.getSession().setAttribute("chunse", chunse);
			request.getSession().setAttribute("str2chunse", str2chunse);
			response.sendRedirect("/addzhenduanshanghuxidao.jsp");
			return;
		}else if(xuanze.equals("2")){
			request.getSession().setAttribute("chunse", chunse);
			request.getSession().setAttribute("str2chunse", str2chunse);
			response.sendRedirect("/addzhenduanganmaofashao.jsp");
			return;
		}else if(xuanze.equals("3")){
			request.getSession().setAttribute("chunse", chunse);
			request.getSession().setAttribute("str2chunse", str2chunse);
			response.sendRedirect("/addzhenduanganmaokesou.jsp");
			return;
		}else if(xuanze.equals("4")){
			request.getSession().setAttribute("chunse", chunse);
			request.getSession().setAttribute("str2chunse", str2chunse);
			response.sendRedirect("/addzhenduanjishi.jsp");
			return;
		}else if(xuanze.equals("5")){
			request.getSession().setAttribute("chunse", chunse);
			request.getSession().setAttribute("str2chunse", str2chunse);
			response.sendRedirect("/addzhenduanfuxie.jsp");
			return;
		}else if(xuanze.equals("6")){
			request.getSession().setAttribute("chunse", chunse);
			request.getSession().setAttribute("str2chunse", str2chunse);
			response.sendRedirect("/addzhenduanbianmi.jsp");
			return;
		}else if(xuanze.equals("7")){
			request.getSession().setAttribute("chunse", chunse);
			request.getSession().setAttribute("str2chunse", str2chunse);
			response.sendRedirect("/addzhenduanbaojian.jsp");
			return;
		}else if(xuanze.equals("8")){
			request.getSession().setAttribute("chunse", chunse);
			request.getSession().setAttribute("str2chunse", str2chunse);
			response.sendRedirect("/addzhenduantigaomianyili.jsp");
			return;
		}else if(xuanze.equals("9")){
			request.getSession().setAttribute("chunse", chunse);
			request.getSession().setAttribute("str2chunse", str2chunse);
			response.sendRedirect("/addzhenduanqidongzhihui.jsp");
			return;
		}
		  }
			out.close();
	}

}
