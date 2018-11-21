/**
 * 
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Fenbu;
import com.bean.Patient;
import com.bean.Richang;
import com.bean.User;
import com.dao.FenbuDao;
import com.dao.PatientDao;
import com.dao.ZhuyiDao;
import com.dao.impl.FenbuDaoImpl;
import com.dao.impl.PatientDaoImpl;
import com.dao.impl.ZhuyiDaoImpl;

public class SearchAgentServlet extends HttpServlet{


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int  zw=2;
		String w;
		       w=request.getParameter("w");
		System.out.println("zw为1"+zw);
		if(w!=null){
			 zw=Integer.parseInt(w);
		}
		System.out.println("zw为2"+zw);
		String name;
		String phone;     
	    String upower;
	          name= request.getParameter("name");
              phone= request.getParameter("phone");
              upower= request.getParameter("upower");
		if(zw!=1){
			
		System.out.println("zw为3"+zw);
		if(name!=null){
			request.getSession().setAttribute("name", name);
		}
		if(name==null){
		    name=(String)request.getSession().getAttribute("name");
		}
		
		if(phone!=null){
			request.getSession().setAttribute("phone", phone);
		}
		if(phone==null){
			phone=(String)request.getSession().getAttribute("phone");
		}
		
		if(upower!=null){
			request.getSession().setAttribute("upower", upower);
		}
		if(upower==null){
			upower=(String)request.getSession().getAttribute("upower");
		}
		 }
		Object obj = request.getSession().getAttribute("user");
		User user = null;
		FenbuDao fenbuDao = new FenbuDaoImpl();
		
		int rc=1;
		Richang rcsh=new Richang();
		ZhuyiDao zhuyidao=new ZhuyiDaoImpl();
		Richang richang=zhuyidao.getRichang(rc);
		request.getSession().setAttribute("richang", richang);

		if (obj != null) {
			user = (User) obj;
			int uid=user.getUserid();
			List<User> list = fenbuDao.getFenbuList(uid,name, phone,upower, user,1);
			int totalCount = fenbuDao.getfenbuCount(uid,name, phone,upower, user);
			System.out.println("totalCount---------"+totalCount);
			for (int i = 0; i < list.size(); i++) {
				User usr = list.get(i);
				int number = fenbuDao.getMoneynmb(usr.getUserid());
				usr.setNumbers(number);
			}
			List fengbuListPara = new ArrayList();
			fengbuListPara.add(name);
			fengbuListPara.add(phone);
			fengbuListPara.add(upower);
			fengbuListPara.add(user);
			request.getSession().setAttribute("fengbuListPara",fengbuListPara);
			request.getSession().setAttribute("i", 1);
			if(totalCount==0){
				request.getSession().setAttribute("i", 0);
			} 
			if (totalCount % 20 == 0) {
				totalCount /= 20;
			} else {
				totalCount = totalCount / 20 + 1;
			}
			request.getSession().setAttribute("totalcount", totalCount);
			request.getSession().setAttribute("xiajiList", list);
			request.getRequestDispatcher("searchagent.jsp").forward(request,
					response);
		} else {
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('重新登录！');");	
			out.println("window.location.href=\"login.jsp\"");
			out.println("</script>");
		}
		out.close();
	}
}
