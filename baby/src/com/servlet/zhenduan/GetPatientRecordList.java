package com.servlet.zhenduan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Patient;
import com.bean.Record;
import com.dao.PatientDao;
import com.dao.RecordDao;
import com.dao.impl.PatientDaoImpl;
import com.dao.impl.RecordDaoImpl;

public class GetPatientRecordList extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pid = request.getParameter("pid");
		System.out.println("PID-----------"+pid);
		int ipid=0;
		if(pid!=null){
			ipid=Integer.parseInt(pid);
		}
		RecordDao recordDao = new RecordDaoImpl();
		PatientDao patientDao = new PatientDaoImpl();
		Patient patient = patientDao.getPatientById(ipid);
		List<Record> list = recordDao.getRecordsByPid(ipid);
		request.setAttribute("recordList", list);
		request.setAttribute("patient", patient);
		request.getRequestDispatcher("patientRecordsByPid.jsp").forward(
				request, response);
	}

}
