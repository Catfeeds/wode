/**
 * 
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Patient;
import com.bean.User;
import com.dao.impl.UserDaoImpl;
import com.mysql.jdbc.PreparedStatement;

/**
 * @author 杜欢  Email：huandu01@163.com
 *
 */
public class CheckAddUserServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String loginname=request.getParameter("loginName");
		UserDaoImpl userdao=new UserDaoImpl();
        List<User> user=userdao.checklogname(loginname);
       
        if(user!=null&&user.size()>0)
        {
        	request.getSession().setAttribute("checkAddUser", "yes");
        }else{
        	
        	request.getSession().setAttribute("checkAddUser", "no");
           }
        out.close();
	}
}
		
