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

import com.bean.Patient;
import com.bean.User;
import com.dao.PatientDao;
import com.dao.impl.PatientDaoImpl;


public class SearchPatientXinxiServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		doPost(request,response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
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
	    String sex;
	    String uid;
	    int uidd=0;
	          name= request.getParameter("name");
              phone= request.getParameter("phone");
		      sex= request.getParameter("sex");
		      uid=request.getParameter("uid");
	      if(uid!=null){
				System.out.println("xin客户的uid-----------"+uid);
			      uidd=Integer.parseInt(uid);
				request.getSession().setAttribute("uid", uid);
			}
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
		if(uid==null){
			uid=(String)request.getSession().getAttribute("uid");
		}
		 }
		Object obj = request.getSession().getAttribute("user");
		User user = null;
		PatientDao patientDao = new PatientDaoImpl();
		
//		int rc=1;
//		Richang rcsh=new Richang();
//		ZhuyiDao zhuyidao=new ZhuyiDaoImpl();
//		Richang richang=zhuyidao.getRichang(rc);
//		request.getSession().setAttribute("richang", richang);

		if (obj != null) {
			user = (User) obj;
			List<Patient> list = patientDao.getpatients(name, phone, sex, user,1,uidd);
			int totalCount = patientDao.getpatientCount(name, phone, sex, user,uidd);
			List patientListPara = new ArrayList();
			patientListPara.add(name);
			patientListPara.add(phone);
			patientListPara.add(sex);
			patientListPara.add(user);
			patientListPara.add(uid);
			request.getSession().setAttribute("patientListPara",patientListPara);
			request.getSession().setAttribute("i", 1);
			if(totalCount==0){
				request.getSession().setAttribute("i", 0);
			} 
			if (totalCount % 5 == 0) {
				totalCount /= 5;
			} else {
				totalCount = totalCount / 5 + 1;
			}
			request.getSession().setAttribute("totalcount", totalCount);
			request.setAttribute("patientList", list);
			request.getRequestDispatcher("searchpatientxinxi.jsp").forward(request,
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
