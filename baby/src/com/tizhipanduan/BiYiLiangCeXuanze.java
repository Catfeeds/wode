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
public class BiYiLiangCeXuanze extends HttpServlet{
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
		String biyiliangce=request.getParameter("biyiliangce");
		
		if(biyiliangce==null || biyiliangce == ""){
			biyiliangce="01_正常";
		}
		String[] strbiyiliangce = biyiliangce.split("_");
		String str2biyiliangce = strbiyiliangce[1];
	 if(xuanze==null||xuanze==""){
		  	out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("window.location.href=\"xuanzejiemian.jsp\"");
			out.println("</script>");
	  }else{
		if(xuanze=="1"){
			request.getSession().setAttribute("biyiliangce", biyiliangce);
			request.getSession().setAttribute("str2biyiliangce", str2biyiliangce);
			response.sendRedirect("/addzhenduanshanghuxidao.jsp");
			return;
		}else if(xuanze=="2"){
			request.getSession().setAttribute("biyiliangce", biyiliangce);
			request.getSession().setAttribute("str2biyiliangce", str2biyiliangce);
			response.sendRedirect("/addzhenduanganmaofashao.jsp");
			return;
		}else if(xuanze=="3"){
			request.getSession().setAttribute("biyiliangce", biyiliangce);
			request.getSession().setAttribute("str2biyiliangce", str2biyiliangce);
			response.sendRedirect("/addzhenduanganmaokesou.jsp");
			return;
		}else if(xuanze=="4"){
			request.getSession().setAttribute("biyiliangce", biyiliangce);
			request.getSession().setAttribute("str2biyiliangce", str2biyiliangce);
			response.sendRedirect("/addzhenduanjishi.jsp");
			return;
		}else if(xuanze=="5"){
			request.getSession().setAttribute("biyiliangce", biyiliangce);
			request.getSession().setAttribute("str2biyiliangce", str2biyiliangce);
			response.sendRedirect("/addzhenduanfuxie.jsp");
			return;
		}else if(xuanze=="6"){
			request.getSession().setAttribute("biyiliangce", biyiliangce);
			request.getSession().setAttribute("str2biyiliangce", str2biyiliangce);
			response.sendRedirect("/addzhenduanbianmi.jsp");
			return;
		}else if(xuanze=="7"){
			request.getSession().setAttribute("biyiliangce", biyiliangce);
			request.getSession().setAttribute("str2biyiliangce", str2biyiliangce);
			response.sendRedirect("/addzhenduanbaojian.jsp");
			return;
		}else if(xuanze=="8"){
			request.getSession().setAttribute("biyiliangce", biyiliangce);
			request.getSession().setAttribute("str2biyiliangce", str2biyiliangce);
			response.sendRedirect("/addzhenduantigaomianyili.jsp");
			return;
		}else if(xuanze=="9"){
			request.getSession().setAttribute("biyiliangce", biyiliangce);
			request.getSession().setAttribute("str2biyiliangce", str2biyiliangce);
			response.sendRedirect("/addzhenduanqidongzhihui.jsp");
			return;
		}
	  }
		out.close();
	}

}
