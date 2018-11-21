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

import com.bean.Zhuyi;
import com.dao.ZhuyiDao;
import com.dao.impl.ZhuyiDaoImpl;

/**
 * @author 杜欢  Email：huandu01@163.com
 *
 */
public class XuanzehuliServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String bh=request.getParameter("leibie");
		if(bh!=null) {
			request.getSession().setAttribute("bh", bh);
		} else {
			Object o=request.getSession().getAttribute("bh");
			if(o!=null) {
				bh=(String)o;
			} else {
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("alert('重新登录！');");
				out.println("window.location.href=\"index.jsp\"");
				out.println("</script>");
				return ;
			}
			
		}
		
		ZhuyiDao zhuyiDao=new ZhuyiDaoImpl();
		if(bh==null||bh.equals("")) {
			bh=(String) request.getSession().getAttribute("bh");
		}
		Zhuyi zhuyi=zhuyiDao.getZhuyi(bh);
		
		//System.out.println(zhuyi.getBingzheng()+"zhuyi.getBingzheng()");
		String bz=zhuyi.getBingzheng();
		String zy=zhuyi.getZhuyi();
		request.getSession().setAttribute("bh", bh);
		request.getSession().setAttribute("bz", bz);
		request.getSession().setAttribute("zy", zy);
		request.getRequestDispatcher("changehuli.jsp").forward(request,response);
		
	}

}
