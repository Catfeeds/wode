package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Patient;
import com.bean.Record;
import com.bean.User;
import com.dao.PatientDao;
import com.dao.RecordDao;
import com.dao.impl.PatientDaoImpl;
import com.dao.impl.RecordDaoImpl;

public class SearchRecordPageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RecordDao recordDao = new RecordDaoImpl();
		List recordListPara = (List) request.getSession().getAttribute(
				"recordListPara");
		if(recordListPara==null) {
			response.sendRedirect("SearchRecordServlet");
			return;
		}
		int i = Integer.parseInt(request.getParameter("i"));
		System.out.println("request.getParameter: "+request.getParameter("i"));
		
		System.out.println("recordListPara.size: "+recordListPara.size());
		String name = (String) recordListPara.get(0);
		String phone = (String) recordListPara.get(1);
		String isdo = (String) recordListPara.get(2);
		
		User user = (User)recordListPara.get(3);
		List<Record> list = recordDao.getRecords(name, phone, isdo, user, i);
		
		PatientDao pdDao = new PatientDaoImpl();
		if(i==-1){
			request.getSession().setAttribute("i", 0);
		}else{
			request.getSession().setAttribute("i", i);
		}
		System.out.println(i);
		for (int j = 0; j < list.size(); j++) {
			Record rd = list.get(j);
			String pname = pdDao.getPnameByPid(rd.getPid());
			rd.setPname(pname);
		}
		request.setAttribute("recordList", list);
		request.getRequestDispatcher("patientRecords.jsp").forward(request,
				response);
	}

}
