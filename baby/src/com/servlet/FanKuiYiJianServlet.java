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

import com.bean.Fankuiyijian;
import com.dao.PatientDao;
import com.dao.impl.PatientDaoImpl;

/**
 * @author 石可旺
 *
 */
public class FanKuiYiJianServlet extends HttpServlet{

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
		String userid=request.getParameter("userid");
		String uname=request.getParameter("uname");
		String fankuiyijian=request.getParameter("fankuiyijian");
		String email=request.getParameter("email");
		int uid=Integer.parseInt(userid);
		
		if(fankuiyijian.equals("")){
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('请输入反馈意见！');");
			out.println("window.location.href=\"Fankuiyijian.jsp\"");
			out.println("</script>");
		}
		if(email.equals("")){
			request.getSession().setAttribute("fankuiyijian", fankuiyijian);
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('请输入邮箱！');");
			out.println("window.location.href=\"Fankuiyijian.jsp\"");
			out.println("</script>");
		}
		
		Fankuiyijian fkyijian=new Fankuiyijian();
		fkyijian.setUserid(uid);
		fkyijian.setUname(uname);
		fkyijian.setFankuiyijian(fankuiyijian);
		fkyijian.setEmail(email);
		
		PatientDao patientDao = new PatientDaoImpl();
		String fid=patientDao.saveFankuiyijian(fkyijian);
		System.out.println("反馈意见编号-------"+fid);
		if(fid != null){
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("alert('反馈成功！');");
				out.println("window.location.href=\"Fankuiyijian.jsp\"");
				out.println("</script>");
			}
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
