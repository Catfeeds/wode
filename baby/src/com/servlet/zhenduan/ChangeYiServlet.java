package com.servlet.zhenduan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Plan;
import com.bean.User;
import com.dao.impl.PlanDaoImpl;

public class ChangeYiServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(null, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Object obj = request.getSession().getAttribute("user");
		
		String xg=request.getParameter("xg");//获得编号确定修改那个病症的处方
		System.out.println(xg+"xg对应病情的处方");
		
		String zzbh = request.getParameter("zzbh");
		String dyzz = request.getParameter("dyzz");
		String chufang = request.getParameter("chufang");
		String shoufa = request.getParameter("shoufa");

		Plan plan = new Plan();
		plan.setZzbh(zzbh);
		plan.setChufang(chufang);
		plan.setShoufa(shoufa);

		PlanDaoImpl plandaoimpl = new PlanDaoImpl();
		User u=(User) obj;
		if(chufang==null){
			response.sendRedirect("changejmyi.jsp");
			return;
		}
	
		
		if(xg.equals("01")){
			if(u.getUpower()==0)
				plandaoimpl.updatePlan1(plan);
			request.getSession().setAttribute("plan", plan);
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('修改成功，请继续修改!');");
			out.println("window.location.href=\"changezhenduanyi.jsp\"");
			out.println("</script>");
		}
		
		if(xg.equals("012")){
			if(u.getUpower()==0)
				plandaoimpl.updatePlan1(plan);
			request.getSession().setAttribute("plan", plan);
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('修改成功，请继续修改!');");
			out.println("window.location.href=\"changeweichang.jsp\"");
			out.println("</script>");
		}

		if(xg.equals("021")){
			if(u.getUpower()==0)
				plandaoimpl.updatePlan21(plan);
			request.getSession().setAttribute("plan", plan);
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('修改成功，请继续修改!');");
			out.println("window.location.href=\"changezhenduaner1.jsp\"");
			out.println("</script>");
		}

		if(xg.equals("022")){
			if(u.getUpower()==0)
				plandaoimpl.updatePlan22(plan);
			request.getSession().setAttribute("plan", plan);
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('修改成功，请继续修改!');");
			out.println("window.location.href=\"changezhenduaner2.jsp\"");
			out.println("</script>");
		}

		if(xg.equals("023")){
			if(u.getUpower()==0)
				plandaoimpl.updatePlan23(plan);
			request.getSession().setAttribute("plan", plan);
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('修改成功，请继续修改!');");
			out.println("window.location.href=\"changezhenduaner3.jsp\"");
			out.println("</script>");
		}

		if(xg.equals("024")){
			if(u.getUpower()==0)
				plandaoimpl.updatePlan24(plan);
			request.getSession().setAttribute("plan", plan);
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('修改成功，请继续修改!');");
			out.println("window.location.href=\"changezhenduaner4.jsp\"");
			out.println("</script>");
		}

		if(xg.equals("03")){
			if(u.getUpower()==0)
				plandaoimpl.updatePlanqita(plan);
			request.getSession().setAttribute("plan", plan);
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('修改成功，请继续修改!');");
			out.println("window.location.href=\"changezhenduanqita.jsp\"");
			out.println("</script>");
		}

		if(xg.equals("04")){
			if(u.getUpower()==0)
				plandaoimpl.updatePlanzenzi(plan);
			request.getSession().setAttribute("plan", plan);
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('修改成功，请继续修改!');");
			out.println("window.location.href=\"changezhenduanzenzi.jsp\"");
			out.println("</script>");
		}
		if(xg.equals("05")){
			if(u.getUpower()==0)
				plandaoimpl.updatePlan4(plan);
			request.getSession().setAttribute("plan", plan);
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('修改成功，请继续修改!');");
			out.println("window.location.href=\"changebaojian.jsp\"");
			out.println("</script>");
		}
		
		
		out.flush();
		out.close();
	}

}
