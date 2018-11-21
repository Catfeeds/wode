/**
 * 
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Patient;
import com.bean.User;
import com.dao.PatientDao;
import com.dao.impl.PatientDaoImpl;

public class SavePatientXinxiServlet extends  HttpServlet  {
	
	public  void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		this.doPost(request, response);
		
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 获取系统时间
		Date dt = new Date();// 如果不需要格式,可直接用dt,dt就是当前系统时间
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置显示格式
//		DateFormat ddf= new SimpleDateFormat("yyyy-MM-dd");
		String pborn = df.format(dt);// 用DateFormat的format()方法在dt中获取并以yyyy/MM/dd
								// HH:mm:ss格式显示
//		String pborn= ddf.format(dt);
		Object obj = request.getSession().getAttribute("user");
		String pname = request.getParameter("pname");
		String pxb = request.getParameter("pxb");
		String page = request.getParameter("page");
		String pphone = request.getParameter("pphone");
		String ppname = request.getParameter("ppname");
		String paddress = request.getParameter("paddress");
		String qq = request.getParameter("weixin");
		String weixin = request.getParameter("weixin");
		
		
		//开始
		request.getSession().setAttribute("pname", pname);
		request.getSession().setAttribute("pborn", pborn);
		//结束
		if(pname==null) {
			response.sendRedirect("inputxinxi.jsp");
			return;
		}
		try {
			
			User user = null;
			if (obj != null) {
				user = (User) obj;
				//判断是否有重复的宝宝开始
				int userid=user.getUserid();
				PatientDao patientDao = new PatientDaoImpl();
				int selpnamechongfu=patientDao.selPnameChongfu(pname, userid);
				System.out.println("此宝宝共有"+selpnamechongfu);
				if(selpnamechongfu>1){
					out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
					out.println("<script>");
					out.println("alert('此宝宝您已经添加过多次！');");
					out.println("window.location.href=\"inputxinxi.jsp\"");
					out.println("</script>");
				}else{
					int selnameponchongfu=patientDao.selPnPoChongfu(pname, userid,pphone);
					if(selnameponchongfu>1){
						out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
						out.println("<script>");
						out.println("alert('此宝宝您已经添加过了，不能再次添加！');");
						out.println("window.location.href=\"inputxinxi.jsp\"");
						out.println("</script>");
					}}

				//判断是否有重复的宝宝结束
				Patient p = new Patient();
				p.setPname(pname);
				p.setPxb(pxb);
				p.setPborn(pborn);
				p.setPpname(ppname);
				p.setPphone(pphone);
				p.setPaddress(paddress);
				p.setPage(page);
				p.setCrid(user.getUserid());
				p.setFid(user.getFid());
				p.setQq(qq);
				p.setWeixin(weixin);

				User u = (User) obj;
				String pid = "";

//				if (u.getUpower() == 0 || u.getUpower() == 1 || u.getUpower() == 2)
					pid = patientDao.save(p);
				System.out.println( "----------------------------------  after-----------"+pid);
				int pidd=Integer.parseInt(pid);
				p.setPid(pidd);
				request.getSession().setAttribute("pid", pid);
				request.getSession().setAttribute("patient", p);
//				request.getSession().getAttribute(pid);
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("alert('添加成功！');");
				out.println("window.location.href=\"xuanzejiemian.jsp\"");
				out.println("</script>");
//				}
//				}
			} else {
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("window.location.href=\"xuanzejiemian.jsp\"");
				out.println("</script>");
			}
			
		} catch(Exception e) {
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("window.location.href=\"xuanzejiemian.jsp\"");
			out.println("</script>");
		}
		out.close();
	
	}

}
