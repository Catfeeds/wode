package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FenbuDao;
import com.dao.impl.FenbuDaoImpl;

/**
 * Servlet implementation class AddFenbuServlet
 */
public class AddFenbuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFenbuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String fname=request.getParameter("fname");
		String fid=request.getParameter("fid");
		if(fname==null) {
			response.sendRedirect("DistrictManagerServlet");
			return ;
		}
		System.out.println(fid+"   fid");
		FenbuDao fenbuDao=new FenbuDaoImpl();
		if(fid==null||fid.equals(""))  {
			String res=fenbuDao.check(fname.trim());
			if(!res.equals("yes")) {
//				fenbuDao.save(fname.trim(),"");
				request.getRequestDispatcher("DistrictManagerServlet").forward(request, response);
			} else {
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("alert('分部名重复 ！');");
				out.println("window.location.href=\"DistrictManagerServlet\"");
				out.println("</script>");
				out.close();
			}
		} else {
			fenbuDao.update(fid,fname.trim());
			request.getRequestDispatcher("DistrictManagerServlet").forward(request, response);
		}
	}

}
