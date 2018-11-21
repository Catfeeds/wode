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

import com.bean.Plan;
import com.bean.User;
import com.dao.impl.PlanDaoImpl;
import com.dao.impl.UserDaoImpl;

/**
 *
 */
public class ChangePassServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String newpass=request.getParameter("newpassword");
		UserDaoImpl userdao=new UserDaoImpl();
//		User user=userdao.getUserById(userid);
		Object object=request.getSession().getAttribute("user");
		if(object==null){
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('请重新登录！');");
			out.println("window.location.href=\"login.jsp\"");
			out.println("</script>");
			return;
		}
		User user=(User)object;
		int useridd=user.getUserid();
		
		if(user.getUpassword().equals(password)){
			userdao.changePass(useridd, newpass);
			user.setUpassword(newpass);
			request.getSession().getAttribute("user");
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('修改成功！');");
			out.println("window.location.href=\"personal-center.jsp\"");
			out.println("</script>");
			
		}else{
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('原密码不正确！');");
			out.println("window.location.href=\"changepass.jsp\"");
			out.println("</script>");
		}
		
		out.close();
	}

}
