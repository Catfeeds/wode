package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Patient;
import com.bean.Photo;
import com.bean.User;
import com.dao.PatientDao;
import com.dao.PhotoDao;
import com.dao.impl.PatientDaoImpl;
import com.dao.impl.PhotoDaoImpl;

public class SearchPhoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SearchPhoServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

		public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String ppower = request.getParameter("ppower");
		if(ppower!=null) {
			request.getSession().setAttribute("ppower", ppower);
		} else {
			Object o=request.getSession().getAttribute("ppower");
			if(o!=null) {
				ppower=(String)o;
			} else {
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("alert('重新登录！');");
				out.println("window.location.href=\"login.jsp\"");
				out.println("</script>");
				return ;
			}
			
		}
		ppower = ppower.split("_")[0];
		System.out.println("1111122222222333333333333"+ppower);
		Object obj = request.getSession().getAttribute("user");
		User user = null;
		PhotoDao photoDao = new PhotoDaoImpl();

		if (obj != null) {
			user = (User) obj;
			List<Photo> list = photoDao.getphoto(null, null, ppower);
			request.setAttribute("photoList", list);
			System.out.print("长度为：" + list.size());
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getPname());
				System.out.println(list.get(i).getPurl());

			}
			request.getRequestDispatcher("photoknow.jsp").forward(request,
					response);
		} else {
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('重新登录！');");
			out.println("window.location.href=\"index.jsp\"");
			out.println("</script>");
		}
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
