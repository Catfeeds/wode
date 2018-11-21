package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Fenbu;
import com.bean.Patient;
import com.bean.User;
import com.dao.FenbuDao;
import com.dao.PatientDao;
import com.dao.impl.FenbuDaoImpl;
import com.dao.impl.PatientDaoImpl;

public class SearchPatientPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public SearchPatientPageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PatientDao patientDao = new PatientDaoImpl();
		List patientListPara = (List) request.getSession().getAttribute(
				"patientListPara");

		if(patientListPara==null) {
			response.sendRedirect("SearchPatientServlet");
			return;
		}
		
		int i = Integer.parseInt(request.getParameter("i"));
		String name = (String) patientListPara.get(0);
		String phone = (String) patientListPara.get(1);
		String sex = (String) patientListPara.get(2);
		
		User user = (User) patientListPara.get(3);
		List<Patient> list = patientDao.getpatients(name, phone, sex, user, i,0);
		if(i==-1){
			request.getSession().setAttribute("i", 0);
		}else{
			request.getSession().setAttribute("i", i);
		}
		System.out.println(i);
		request.setAttribute("patientList", list);
		request.getRequestDispatcher("searchinfor.jsp").forward(request,
				response);
	}

}
