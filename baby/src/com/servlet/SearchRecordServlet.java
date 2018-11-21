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
import com.bean.Record;
import com.bean.User;
import com.dao.PatientDao;
import com.dao.RecordDao;
import com.dao.impl.PatientDaoImpl;
import com.dao.impl.RecordDaoImpl;

public class SearchRecordServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("pname");
		String phone = request.getParameter("phone");
		String isdo = request.getParameter("isdo");
		Object obj = request.getSession().getAttribute("user");
		User user = null;
		RecordDao precordDao = new RecordDaoImpl();
		PatientDao pdDao = new PatientDaoImpl();
		if (obj != null) {
			user = (User) obj;
			List l = new ArrayList();
			l.add(name);
			l.add(phone);
			l.add(isdo);
			l.add(user);
			request.getSession().setAttribute("recordListPara", l);

			List<Record> list = precordDao.getRecords(name, phone, isdo, user, 1);
			int totalCount = precordDao.getRecordCount(name, phone, isdo, user);
			request.getSession().setAttribute("i", 1);
			for (int i = 0; i < list.size(); i++) {
				Record rd = list.get(i);
				String pname = pdDao.getPnameByPid(rd.getPid());
				rd.setPname(pname);
			}
			if(totalCount==0){
				request.getSession().setAttribute("i", 0);
			}
			request.setAttribute("recordList", list);
			if (totalCount % 5 == 0) {
				totalCount /= 5;
			} else {
				totalCount = totalCount / 5 + 1;
			}
			request.getSession().setAttribute("totalcount", totalCount);
			request.getRequestDispatcher("patientRecords.jsp").forward(request,
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
