/**
 * 
 */
package com.servlet.zhenduan;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Plan;
import com.dao.PlanDao;
import com.dao.impl.PlanDaoImpl;

/**
 *
 */
public class ChangeWeichang extends HttpServlet{
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取系统时间
		Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置显示格式
		String nowTime="";
		nowTime= df.format(dt);//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
		System.out.println(nowTime);

		PrintWriter out=response.getWriter();
		
		String xg="05";//用于判断修改了那个病症的处方
		request.getSession().setAttribute("xg", xg);
		
		String shxdao = request.getParameter("shxdao");
		String fare = request.getParameter("fare");
		String dushu = request.getParameter("dushu");
		String chuzhen = request.getParameter("chuzhen");
		String tingzhen = request.getParameter("tingzhen");
		String chun = request.getParameter("chun");
		String shezhi = request.getParameter("shezhi");
		String shetai = request.getParameter("shetai");
//		String yanhou = request.getParameter("yanhou");
		String[] strshxdao = shxdao.split("_");
		String[] strfare = fare.split("_");
		String[] strchuzhen = chuzhen.split("_");
		String[] strtingzhen = tingzhen.split("_");
		String[] strchun = chun.split("_");
		String[] strshezhi = shezhi.split("_");
		String[] strshetai = shetai.split("_");
//		String[] stryanhou = yanhou.split("_");
		
		// 1、获得诊断编号
		String str = strshxdao[0] + strfare[0] + strchuzhen[0]
				   + strtingzhen[0] + strchun[0]+ strshezhi[0] 
				   + strshetai[0];
		// 1、获得诊断处方
		 String	 str2= "上呼吸道症状："+strshxdao[1] +" 发热："+ strfare[1] +"度数："+dushu+"°C"+" 触诊："+ strchuzhen[1]
					   +"听诊："+ strtingzhen[1] + " 唇色："+strchun[1]+ " 舌质："+strshezhi[1] 
					   + "  舌苔："+strshetai[1];
		System.out.println(str+"tiaojian");
		System.out.println("编号为："+str);
        System.out.println("处方为："+str2);
        
		PlanDao planDao=new PlanDaoImpl(); 
		Plan plan=planDao.getTigaoMianYiliPlanZzbh(str);
		try {
			request.getSession().setAttribute("plan", plan);
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('请修改处方');");
			out.println("window.location.href=\"changejmyi.jsp\"");
			out.println("</script>");
		} catch (Exception e) {
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('暂无处方');");
			out.println("window.location.href=\"changeweichang.jsp\"");
			out.println("</script>");
		}
		out.flush();
		out.close();
	}
}
