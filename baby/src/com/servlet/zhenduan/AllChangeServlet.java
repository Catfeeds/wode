/**
 * 
 */
package com.servlet.zhenduan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Plan;
import com.bean.Record;
import com.bean.Zhuyi;
import com.dao.ZhuyiDao;
import com.dao.impl.PlanDaoImpl;
import com.dao.impl.ZhuyiDaoImpl;

public class AllChangeServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AllChangeServlet() {
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
		Record r=new Record();
		Plan p=new Plan();
		PlanDaoImpl plan=new PlanDaoImpl();
		String change_i=request.getParameter("change_i");
		System.out.println("change_i=="+change_i);
		String str=request.getParameter("str");
		System.out.println("str=="+str);
		
		String cid=request.getParameter("cid");
		
		String zhenduan=request.getParameter("zhenduan");
		String shoufa=request.getParameter("shoufa");
		if(zhenduan==null) {
			zhenduan=(String) request.getSession().getAttribute("zhenduan");
			shoufa=(String) request.getSession().getAttribute("shoufa");
		} else {
			request.getSession().setAttribute("zhenduan", zhenduan);
			request.getSession().setAttribute("shoufa", shoufa);
		}
		try {
			p.setZzbh(str);	
			p.setChufang(zhenduan);
			p.setShoufa(shoufa);
			r.setCid(Integer.parseInt(cid));
			r.setDycf(zhenduan);
			r.setDysf(shoufa);
			int wwww=plan.updateRecord(r);	
		} catch (Exception e) {
			
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");   
	       	out.println("<script>");
	    	out.println("window.location.href=\"planDetial.jsp");
	       	out.println("</script>");
		}
			//留用
			/*request.getSession().setAttribute("zhenduan", zhenduan);
			request.getSession().setAttribute("shoufa", shoufa);*/
			System.out.println(change_i+"修改标识");
			System.out.println(str+"对应条件");
			if(change_i!=null){
			if(change_i.equals("01"))	 {
				plan.updatePlan01(p);
			}
			if(change_i.equals("02"))	
				plan.updatePlan02(p);
			if(change_i.equals("03"))	
				plan.updatePlan03(p);
			if(change_i.equals("04"))	
				plan.updatePlan04(p);
			if(change_i.equals("05"))	
				plan.updatePlan05(p);
			if(change_i.equals("06"))	
				plan.updatePlan06(p);
			if(change_i.equals("07"))	
				plan.updatePlan07(p);
			if(change_i.equals("11"))	
				
				plan.updatePlan21(p);
			if(change_i.equals("12"))	
				plan.updatePlan22(p);
			if(change_i.equals("13"))	
				plan.updatePlan23(p);
			if(change_i.equals("14"))	
				plan.updatePlan24(p);
			if(change_i.equals("2"))	
				plan.updatePlanzenzi(p);
			if(change_i.equals("3"))	
				plan.updatePlanqita(p);
			
			if(change_i.equals("4"))	
				plan.updatePlanbaojian(p);
				
			
			}
			else{
				//此位置为预留，当标识为空时看如何处理，后期完善
			}
			String zybh=(String) request.getSession().getAttribute("zybh");
			ZhuyiDao zhuyiDao=new ZhuyiDaoImpl();
			Zhuyi zhuyi=zhuyiDao.getZhuyi(zybh);
			if(zhuyi!=null)
			p.setZhuyi(zhuyi.getZhuyi());
			request.getSession().setAttribute("plan", p);
			
			System.out.println(p.getChufang()+"  00000000000000000000000000");
			System.out.println(p.getShoufa()+"   11111111111111111111111111");
			request.getRequestDispatcher("planDetial.jsp").forward(
					request, response);
			out.flush();
			out.close();
			
	}


	public void init() throws ServletException {
		// Put your code here
	}

}
