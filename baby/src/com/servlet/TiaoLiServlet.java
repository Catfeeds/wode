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

import com.bean.Tiaoli;
import com.bean.Zhuyi;
import com.dao.ZhuyiDao;
import com.dao.impl.ZhuyiDaoImpl;

/**
 * @author 石可旺
 *
 */
public class TiaoLiServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取系统时间
		PrintWriter out=response.getWriter();
		
		try {
		String tiaolibh=request.getParameter("tiaolibh");
		int tlid=Integer.parseInt(tiaolibh);
		ZhuyiDao zhuyiDao=new ZhuyiDaoImpl();
		Tiaoli tiaoli=zhuyiDao.getTiaoli(tlid);
		
		int tiaolinumb=tiaoli.getTlid();
		String tiaolineirong=tiaoli.getTlneirong();
		String tiaolibiaoti=tiaoli.getBiaoti();
		String tiaolitime=tiaoli.getTltime();
		
		
		request.getSession().setAttribute("tiaolinumb", tiaolinumb);
		request.getSession().setAttribute("tiaolineirong", tiaolineirong);
		request.getSession().setAttribute("tiaolibiaoti", tiaolibiaoti);
		request.getSession().setAttribute("tiaolitime", tiaolitime);
		// 设置处方错误
		response.sendRedirect("/Tiaolishow-page.jsp");
		return;
			
		} catch (Exception e) {
			
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('错误');");
			out.println("window.location.href=\"xuanzejiemian.jsp\"");
			out.println("</script>");
		}
		
		out.close();
	}

}
