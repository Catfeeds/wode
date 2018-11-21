/**
 * 
 */
package com.servlet.zhenduan;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Patient;
import com.bean.Plan;
import com.bean.Record;
import com.bean.Richang;
import com.bean.Tizheng;
import com.bean.User;
import com.bean.Zhuyi;
import com.dao.PatientDao;
import com.dao.PlanDao;
import com.dao.RecordDao;
import com.dao.ZhuyiDao;
import com.dao.impl.PatientDaoImpl;
import com.dao.impl.PlanDaoImpl;
import com.dao.impl.RecordDaoImpl;
import com.dao.impl.ZhuyiDaoImpl;

/**
 * @author 石可旺  
 *
 */
public class InputQidongZhihui extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		User user =(User)request.getSession().getAttribute("user");
		if(user==null){
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("window.location.href=\"login.jsp\"");
			out.println("</script>");
		}else{
		if(user.getUpower()==3){
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('你现在是普通会员，VIP会员才可以使用，想要详细了解点击进入');");
			out.println("window.location.href=\"xuanzejiemian.jsp\"");
			out.println("</script>");
		}else{
			
			String yizhizhuzhang = request.getParameter("yizhizhuzhang");
			System.out.println("yizhizhuzhang--------"+yizhizhuzhang);
			String[] stryizhizhuzhang = yizhizhuzhang.split("_");
			
			Plan plan=new Plan();
			String str = stryizhizhuzhang[0];
			System.out.println("str----------"+ str);
			PlanDao planDao=new PlanDaoImpl(); 
			plan=planDao.getQidongZhihuiPlanZzbh(str);
			String zzxwt=plan.getShoufa();
			String zzxw=zzxwt+" ";
			String miansexw="+17100"+" ";
			String xydxw="";
//			//体征单独穴位开始
//			Plan plan=new Plan();
//			PlanDao planDao = new PlanDaoImpl();
//			String yizhizhuzhangxw=null;
//			Tizheng tz=new Tizheng();
//			tz=planDao.seltimianxw(stryizhizhuzhang[0]);
//			yizhizhuzhangxw=tz.getTzxw();
			
			
			String dzzxw=null;
			String dmiansexw=null;
			String dxydxw=null;
			
			//穴位1
			if(zzxw.trim().length()==5){
				char  item0= zzxw.charAt(0);
				System.out.println("item0---------"+item0);
				char  item1= zzxw .charAt(1);
				System.out.println("item1---------"+item1);
				char  item2= zzxw .charAt(2);
				System.out.println("item2---------"+item2);
				char  item3= zzxw .charAt(3);
				System.out.println("item3---------"+item3);
				char  item4= zzxw .charAt(4);
				System.out.println("item4---------"+item4);
				
				String item0st=String.valueOf(item0);
	            String item1st=String.valueOf(item1);
	            dzzxw=item0st+item1st;
				
			}else if(zzxw.trim().length()==6){
				char  item0= zzxw .charAt(0);
				System.out.println("item0---------"+item0);
				char  item1= zzxw .charAt(1);
				System.out.println("item1---------"+item1);
				char  item2= zzxw .charAt(2);
				System.out.println("item2---------"+item2);
				char  item3= zzxw .charAt(3);
				System.out.println("item3---------"+item3);
				char  item4= zzxw .charAt(4);
				System.out.println("item4---------"+item4);
				
				String item1st=String.valueOf(item1);
	            String item2st=String.valueOf(item2);
	            dzzxw=item1st+item2st;
				
			}else if(zzxw.trim().length()==7){
				char  item0= zzxw .charAt(0);
				System.out.println("item0---------"+item0);
				char  item1= zzxw .charAt(1);
				System.out.println("item1---------"+item1);
				char  item2= zzxw .charAt(2);
				System.out.println("item2---------"+item2);
				char  item3= zzxw .charAt(3);
				System.out.println("item3---------"+item3);
				char  item4= zzxw .charAt(4);
				System.out.println("item4---------"+item4);
				
				String item2st=String.valueOf(item2);
	            String item3st=String.valueOf(item3);
	            dzzxw=item2st+item3st;
				
				}
			
			//穴位2
			if(miansexw.trim().length()==5){
				char  item0= miansexw.charAt(0);
				System.out.println("item0---------"+item0);
				char  item1= miansexw .charAt(1);
				System.out.println("item1---------"+item1);
				char  item2= miansexw .charAt(2);
				System.out.println("item2---------"+item2);
				char  item3= miansexw .charAt(3);
				System.out.println("item3---------"+item3);
				char  item4= miansexw .charAt(4);
				System.out.println("item4---------"+item4);
				
				String item0st=String.valueOf(item0);
	            String item1st=String.valueOf(item1);
	            dmiansexw=item0st+item1st;
			}else if(miansexw.trim().length()==6){
				char  item0= miansexw .charAt(0);
				System.out.println("item0---------"+item0);
				char  item1= miansexw .charAt(1);
				System.out.println("item1---------"+item1);
				char  item2= miansexw .charAt(2);
				System.out.println("item2---------"+item2);
				char  item3= miansexw .charAt(3);
				System.out.println("item3---------"+item3);
				char  item4= miansexw .charAt(4);
				System.out.println("item4---------"+item4);
				
				String item1st=String.valueOf(item1);
	            String item2st=String.valueOf(item2);
	            dmiansexw=item1st+item2st;
			}else if(miansexw.trim().length()==7){
				char  item0= miansexw .charAt(0);
				System.out.println("item0---------"+item0);
				char  item1= miansexw .charAt(1);
				System.out.println("item1---------"+item1);
				char  item2= miansexw .charAt(2);
				System.out.println("item2---------"+item2);
				char  item3= miansexw .charAt(3);
				System.out.println("item3---------"+item3);
				char  item4= miansexw .charAt(4);
				System.out.println("item4---------"+item4);
				
				String item2st=String.valueOf(item2);
	            String item3st=String.valueOf(item3);
	            dmiansexw=item2st+item3st;
			}
			
			//穴位3
			if(xydxw != null||xydxw!=""||xydxw!=" "){
				if(xydxw.trim().length()==5){
					char  item0= xydxw.charAt(0);
					System.out.println("item0---------"+item0);
					char  item1= xydxw.charAt(1);
					System.out.println("item1---------"+item1);
					char  item2= xydxw.charAt(2);
					System.out.println("item2---------"+item2);
					char  item3= xydxw.charAt(3);
					System.out.println("item3---------"+item3);
					char  item4= xydxw.charAt(4);
					System.out.println("item4---------"+item4);
					
					String item0st=String.valueOf(item0);
		            String item1st=String.valueOf(item1);
		            dxydxw=item0st+item1st;
				}else if(xydxw.trim().length()==6){
					char  item0= xydxw.charAt(0);
					System.out.println("item0---------"+item0);
					char  item1= xydxw.charAt(1);
					System.out.println("item1---------"+item1);
					char  item2= xydxw.charAt(2);
					System.out.println("item2---------"+item2);
					char  item3= xydxw.charAt(3);
					System.out.println("item3---------"+item3);
					char  item4= xydxw.charAt(4);
					System.out.println("item4---------"+item4);
					
					String item1st=String.valueOf(item1);
		            String item2st=String.valueOf(item2);
		            dxydxw=item1st+item2st;
				}else if(xydxw.trim().length()==7){
					char  item0= xydxw.charAt(0);
					System.out.println("item0---------"+item0);
					char  item1= xydxw.charAt(1);
					System.out.println("item1---------"+item1);
					char  item2= xydxw.charAt(2);
					System.out.println("item2---------"+item2);
					char  item3= xydxw.charAt(3);
					System.out.println("item3---------"+item3);
					char  item4= xydxw.charAt(4);
					System.out.println("item4---------"+item4);
					
					String item2st=String.valueOf(item2);
		            String item3st=String.valueOf(item3);
		            dxydxw=item2st+item3st;
				}
			}
			
			//症状和其他比较
			if(dzzxw.equals(dmiansexw)){
				miansexw="";
			}
			if(dzzxw.equals(dxydxw)){
				xydxw="";
			}
			
			//面色和其他比较
			if(dmiansexw.equals(dxydxw)){
				xydxw="";
			}
			
			String xuewei =zzxw+miansexw+xydxw;
			request.getSession().setAttribute("zzxw", zzxw);
			request.getSession().setAttribute("miansexw", miansexw);
			request.getSession().setAttribute("xydxw", xydxw);
			// 1、获得诊断编号
//			String str = stryizhizhuzhang[0];
			// 1、获得诊断处方
			 String	 str2= "益智";
			System.out.println("str2------------------------"+str2);
			//用于修改处方标识
	        String change_i="4";
	    	request.getSession().setAttribute("change_i", change_i);
			request.getSession().setAttribute("str", str);
			request.getSession().setAttribute("str2", str2);
			//标识结束
//			Plan plan=planDao.getTigaoMianYiliPlanZzbh(str);
			String zybh="08";
			request.getSession().setAttribute("zhuyibh", zybh);
			String selplan="08";
			 request.getSession().setAttribute("selplan", selplan);
			ZhuyiDao zhuyiDao=new ZhuyiDaoImpl();
			Zhuyi zhuyi=zhuyiDao.getZhuyi(zybh);
			String ss=zhuyi.getZhuyi();
			plan.setZhuyi(zhuyi.getZhuyi());
			//设置处方错误
			try {	
			String chufang="助长益智";
			plan.setZzbh(str2);
			request.getSession().setAttribute("plan",plan);
				
				Object objuser=request.getSession().getAttribute("user");
				//开始
				request.getSession().setAttribute("change_i", change_i);
				request.getSession().setAttribute("str", str);
				request.getSession().setAttribute("str2", str2);
				request.getSession().setAttribute("hulizhuyi", zhuyi);
				
//				String chufang=plan.getChufang();
//				String shoufa=plan.getShoufa();
				
				request.getSession().setAttribute("shoufa", xuewei);
				request.getSession().setAttribute("chufang", chufang);
				
				if (objuser != null) {
					User u = (User) objuser;
					int uid=u.getUserid();
					String nameu=u.getLoginName();
					PatientDao patientDao = new PatientDaoImpl();
					int patinuber=patientDao.selPatientShuliang(uid);
					if(patinuber>0){
						response.sendRedirect("/SearchPatientServlet");
						return;
					}else{
						response.sendRedirect("/inputinfor.jsp");
						return;
					}
				}else {
					System.out.println("提交失败！");
					// 提交失败
				}
					//结束
			} catch (Exception e){
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");   
		       	out.println("<script>");
		       	out.println("alert('错误');");
		    	out.println("window.location.href=\"xuanzejiemian.jsp\"");
		       	out.println("</script>");
			}
			
			out.close();
			}
		}
	}

}
