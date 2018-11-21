/**
 * 
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Money;
import com.dao.FenbuDao;
import com.dao.impl.FenbuDaoImpl;


public class ChaKanYuEServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//	    注销用户，使session失效。
		//	    每次登录时先将session清掉，以防止在此之前没有正常退出，导致第二次再登录时登录不上
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		String uid = request.getParameter("uid");
		if(uid!=null){
			int inuid=Integer.parseInt(uid);
		
		FenbuDao fenbu=new FenbuDaoImpl();
		List<Money> usidlist=fenbu.getUserid(inuid);
		int numbers=usidlist.get(0).getNumbers();
		if(numbers>0){
			numbers=numbers*5;
			request.getSession().setAttribute("numbers", numbers);
		}
			}
		request.getRequestDispatcher("Chakanyue.jsp").forward(request, response);
		
		out.close();
	}

}
