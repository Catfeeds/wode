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

import com.bean.Shipin;
import com.dao.ZhuyiDao;
import com.dao.impl.ZhuyiDaoImpl;

/**
 * @author 石可旺
 *
 */
public class ShiPinChuFangServlet extends HttpServlet{

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
		String shipinbh=request.getParameter("shipinbh");
		int spid=Integer.parseInt(shipinbh);
		ZhuyiDao zhuyiDao=new ZhuyiDaoImpl();
		Shipin shipin=zhuyiDao.getShipin(spid);
		
		
		int shipiid=shipin.getSpid();
		String spname=shipin.getSpname();
		String spneirong=shipin.getSpneirong();
		String sptime=shipin.getSptime();
		String splujing=shipin.getSplujing();
		String tplujing=shipin.getTplujing();
		String xwweizhi=shipin.getXwweizhi();
		String xwzuoyong=shipin.getXwzuoyong();
		
		request.getSession().setAttribute("shipiid", shipiid);
		request.getSession().setAttribute("spname", spname);
		request.getSession().setAttribute("spneirong", spneirong);
		request.getSession().setAttribute("sptime", sptime);
		request.getSession().setAttribute("splujing", splujing);
		request.getSession().setAttribute("tplujing", tplujing);
		request.getSession().setAttribute("xwweizhi", xwweizhi);
		request.getSession().setAttribute("xwzuoyong", xwzuoyong);
		// 设置处方错误
		response.sendRedirect("/Shipinshowpage.jsp");
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
