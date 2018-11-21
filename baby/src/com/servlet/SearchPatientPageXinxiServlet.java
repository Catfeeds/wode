/**
 * 
 */
package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Patient;
import com.bean.User;
import com.dao.PatientDao;
import com.dao.impl.PatientDaoImpl;

public class SearchPatientPageXinxiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public SearchPatientPageXinxiServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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
		String uid = (String) patientListPara.get(3);
		int uidd=Integer.parseInt(uid);
		User user = (User) patientListPara.get(3);
		List<Patient> list = patientDao.getpatients(name, phone, sex, user, i,uidd);
		if(i==-1){
			request.getSession().setAttribute("i", 0);
		}else{
			request.getSession().setAttribute("i", i);
		}
		System.out.println(i);
		request.setAttribute("patientList", list);
		request.getRequestDispatcher("searchpatientxinxi.jsp").forward(request,
				response);
	}

}
