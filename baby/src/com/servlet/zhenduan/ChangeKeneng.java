/**
 * 
 */
package com.servlet.zhenduan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.KenengDao;
import com.dao.ZhuyiDao;
import com.dao.impl.KenengDaoImpl;
import com.dao.impl.ZhuyiDaoImpl;

/**
 * @author  
 *
 */
public class ChangeKeneng extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String bh=request.getParameter("bh");	
		String bz=request.getParameter("bingzheng");
		String qk=request.getParameter("qingkuang");
		if(bz==null){
			response.sendRedirect("changekeneng.jsp");
			return ;
		}
		System.out.println(bh+"bh");
		System.out.println(bz+"bz");
		System.out.println(qk+"zy");
		
		KenengDaoImpl keneng=new KenengDaoImpl();
		keneng.updateKeneng(bh, bz, qk);
		out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
		out.println("<script>");
		out.println("alert('修改成功，请继续修改!');");
		out.println("window.location.href=\"changekeneng.jsp\"");
		out.println("</script>");
		out.flush();
		out.close();
	}

}
