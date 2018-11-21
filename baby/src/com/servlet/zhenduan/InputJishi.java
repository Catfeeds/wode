
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

public class InputJishi extends HttpServlet {

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
		
		String shiyucha = request.getParameter("shiyucha");
			if(shiyucha==null || shiyucha == ""){
				shiyucha="01_食欲差";
				System.out.println("shiyucha--------"+shiyucha);
				request.getSession().setAttribute("shiyucha", shiyucha);
			}
		String tiaoshi = request.getParameter("tiaoshi");
			if(tiaoshi==null || tiaoshi == ""){
				tiaoshi="01_挑食";
				System.out.println("tiaoshi--------"+tiaoshi);
				request.getSession().setAttribute("tiaoshi", tiaoshi);
			}
		String yanshi = request.getParameter("yanshi");
			if(yanshi==null || yanshi == ""){
				yanshi="01_厌食";
				System.out.println("yanshi--------"+yanshi);
				request.getSession().setAttribute("yanshi", yanshi);
			}
		String youkouqi = request.getParameter("youkouqi");
			if(youkouqi==null || youkouqi == ""){
				youkouqi="01_有口气";
				System.out.println("youkouqi--------"+youkouqi);
				request.getSession().setAttribute("youkouqi", youkouqi);
			}
		String shetaihou = request.getParameter("shetaihou");
		if(shetaihou==null || shetaihou == ""){
			shetaihou="01_舌苔厚";
			System.out.println("shetaihou--------"+shetaihou);
			request.getSession().setAttribute("shetaihou", shetaihou);
			}
		
		String[] strshiyucha = shiyucha.split("_");
		String[] strtiaoshi = tiaoshi.split("_");
		String[] stryanshi = yanshi.split("_");
		String[] stryoukouqi = youkouqi.split("_");
		String[] strshetaihou = shetaihou.split("_");
		
		Plan plan=new Plan();
		String str = strshiyucha[0] + strtiaoshi[0] + stryanshi[0] + stryoukouqi[0] + strshetaihou[0];
		System.out.println("str----------"+ str);
		PlanDao planDao=new PlanDaoImpl(); 
		plan=planDao.getJishiPlanZzbh(str);
		String zzxwt=plan.getShoufa();
		String zzxw=zzxwt+" ";
		String miansexw="+03100";
		String xydxw="";
//		//体征单独穴位开始
//		Plan plan=new Plan();
//		PlanDao planDao = new PlanDaoImpl();
//		String shiyuchaxw=null;
//		String tiaoshixw=null;
//		String yanshixw=null;
//		String youkouqixw=null;
//		String shetaihouxw=null;
//		
//		Tizheng tz=new Tizheng();
//		tz=planDao.seljishixw(strshiyucha[01]);
//		kouqiangxw=tz.getTzxw();
//		
//		tz=planDao.seljishixw(strmianse[2]);
//		 miansexw=tz.getTzxw();
//		
//		tz=planDao.seljishixw(strxiayandai[2]);
//		xydxw=tz.getTzxw();
//		
//		tz=planDao.seljishixw(strchunse[2]);
//		chunsexw=tz.getTzxw();
//		
//		tz=planDao.seljishixw(strsheti[2]);
//		shetixw=tz.getTzxw();
//		
//		tz=planDao.seljishixw(strshezhi[2]);
//		shezhixw=tz.getTzxw();
//		
//		tz=planDao.seljishixw(strshetai[2]);
//		shetaixw=tz.getTzxw();
//	
//		String dkouqiangxw=null;
//		String dmiansexw=null;
//		String dxydxw=null;
//		String dchunsexw=null;
//		String dshetixw=null;
//		String dshezhixw=null;
//		String dshetaixw=null;
//		
//		//穴位1
//		if(kouqiangxw.trim().length()==5){
//			char  item0= kouqiangxw.charAt(0);
//			System.out.println("item0---------"+item0);
//			char  item1= kouqiangxw .charAt(1);
//			System.out.println("item1---------"+item1);
//			char  item2= kouqiangxw .charAt(2);
//			System.out.println("item2---------"+item2);
//			char  item3= kouqiangxw .charAt(3);
//			System.out.println("item3---------"+item3);
//			char  item4= kouqiangxw .charAt(4);
//			System.out.println("item4---------"+item4);
//			
//			String item0st=String.valueOf(item0);
//            String item1st=String.valueOf(item1);
//            dkouqiangxw=item0st+item1st;
//			
//		}else if(kouqiangxw.trim().length()==6){
//			char  item0= kouqiangxw .charAt(0);
//			System.out.println("item0---------"+item0);
//			char  item1= kouqiangxw .charAt(1);
//			System.out.println("item1---------"+item1);
//			char  item2= kouqiangxw .charAt(2);
//			System.out.println("item2---------"+item2);
//			char  item3= kouqiangxw .charAt(3);
//			System.out.println("item3---------"+item3);
//			char  item4= kouqiangxw .charAt(4);
//			System.out.println("item4---------"+item4);
//			
//			String item1st=String.valueOf(item1);
//            String item2st=String.valueOf(item2);
//            dkouqiangxw=item1st+item2st;
//			
//		}else if(kouqiangxw.trim().length()==7){
//			char  item0= kouqiangxw .charAt(0);
//			System.out.println("item0---------"+item0);
//			char  item1= kouqiangxw .charAt(1);
//			System.out.println("item1---------"+item1);
//			char  item2= kouqiangxw .charAt(2);
//			System.out.println("item2---------"+item2);
//			char  item3= kouqiangxw .charAt(3);
//			System.out.println("item3---------"+item3);
//			char  item4= kouqiangxw .charAt(4);
//			System.out.println("item4---------"+item4);
//			
//			String item2st=String.valueOf(item2);
//            String item3st=String.valueOf(item3);
//            dkouqiangxw=item2st+item3st;
//			
//			}
//		
//		//穴位2
//		if(miansexw.trim().length()==5){
//			char  item0= miansexw.charAt(0);
//			System.out.println("item0---------"+item0);
//			char  item1= miansexw .charAt(1);
//			System.out.println("item1---------"+item1);
//			char  item2= miansexw .charAt(2);
//			System.out.println("item2---------"+item2);
//			char  item3= miansexw .charAt(3);
//			System.out.println("item3---------"+item3);
//			char  item4= miansexw .charAt(4);
//			System.out.println("item4---------"+item4);
//			
//			String item0st=String.valueOf(item0);
//            String item1st=String.valueOf(item1);
//            dmiansexw=item0st+item1st;
//		}else if(miansexw.trim().length()==6){
//			char  item0= miansexw .charAt(0);
//			System.out.println("item0---------"+item0);
//			char  item1= miansexw .charAt(1);
//			System.out.println("item1---------"+item1);
//			char  item2= miansexw .charAt(2);
//			System.out.println("item2---------"+item2);
//			char  item3= miansexw .charAt(3);
//			System.out.println("item3---------"+item3);
//			char  item4= miansexw .charAt(4);
//			System.out.println("item4---------"+item4);
//			
//			String item1st=String.valueOf(item1);
//            String item2st=String.valueOf(item2);
//            dmiansexw=item1st+item2st;
//		}else if(miansexw.trim().length()==7){
//			char  item0= miansexw .charAt(0);
//			System.out.println("item0---------"+item0);
//			char  item1= miansexw .charAt(1);
//			System.out.println("item1---------"+item1);
//			char  item2= miansexw .charAt(2);
//			System.out.println("item2---------"+item2);
//			char  item3= miansexw .charAt(3);
//			System.out.println("item3---------"+item3);
//			char  item4= miansexw .charAt(4);
//			System.out.println("item4---------"+item4);
//			
//			String item2st=String.valueOf(item2);
//            String item3st=String.valueOf(item3);
//            dmiansexw=item2st+item3st;
//		}
//		
//		//穴位3
//		if(xydxw != null||xydxw!=""||xydxw!=" "){
//			if(xydxw.trim().length()==5){
//				char  item0= xydxw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= xydxw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= xydxw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= xydxw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= xydxw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item0st=String.valueOf(item0);
//	            String item1st=String.valueOf(item1);
//	            dxydxw=item0st+item1st;
//			}else if(xydxw.trim().length()==6){
//				char  item0= xydxw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= xydxw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= xydxw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= xydxw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= xydxw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item1st=String.valueOf(item1);
//	            String item2st=String.valueOf(item2);
//	            dxydxw=item1st+item2st;
//			}else if(xydxw.trim().length()==7){
//				char  item0= xydxw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= xydxw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= xydxw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= xydxw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= xydxw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item2st=String.valueOf(item2);
//	            String item3st=String.valueOf(item3);
//	            dxydxw=item2st+item3st;
//			}
//		}
//			//穴位4
//			if(chunsexw != null||chunsexw!=""||chunsexw!=" "){
//			if(chunsexw.trim().length()==5){
//				char  item0= chunsexw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= chunsexw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= chunsexw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= chunsexw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= chunsexw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item0st=String.valueOf(item0);
//	            String item1st=String.valueOf(item1);
//	            dchunsexw=item0st+item1st;
//			}else if(chunsexw.trim().length()==6){
//				char  item0= chunsexw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= chunsexw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= chunsexw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= chunsexw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= chunsexw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item1st=String.valueOf(item1);
//	            String item2st=String.valueOf(item2);
//	            dchunsexw=item1st+item2st;
//			}else if(chunsexw.trim().length()==7){
//				char  item0= chunsexw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= chunsexw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= chunsexw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= chunsexw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= chunsexw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item2st=String.valueOf(item2);
//	            String item3st=String.valueOf(item3);
//	            dchunsexw=item2st+item3st;
//			}
//		}
//			//判断穴位5
//		if(shetixw != null||shetixw!=""||shetixw!=" "){
//			if(shetixw.trim().length()==5){
//				char  item0= shetixw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= shetixw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= shetixw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= shetixw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= shetixw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item0st=String.valueOf(item0);
//	            String item1st=String.valueOf(item1);
//	            dshetixw=item0st+item1st;
//			}else if(shetixw.trim().length()==6){
//				char  item0= shetixw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= shetixw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= shetixw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= shetixw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= shetixw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item1st=String.valueOf(item1);
//	            String item2st=String.valueOf(item2);
//	            dshetixw=item1st+item2st;
//			}else if(shetixw.trim().length()==7){
//				char  item0= shetixw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= shetixw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= shetixw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= shetixw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= shetixw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item2st=String.valueOf(item2);
//	            String item3st=String.valueOf(item3);
//	            dshetixw=item2st+item3st;
//			}
//		}
//			//判断穴位6
//		if(shezhixw != null||shezhixw!=""||shezhixw!=" "){
//			if(shezhixw.trim().length()==5){
//				char  item0= shezhixw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= shezhixw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= shezhixw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= shezhixw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= shezhixw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item0st=String.valueOf(item0);
//	            String item1st=String.valueOf(item1);
//	            dshezhixw=item0st+item1st;
//			}else if(shezhixw.trim().length()==6){
//				char  item0= shezhixw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= shezhixw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= shezhixw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= shezhixw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= shezhixw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item1st=String.valueOf(item1);
//	            String item2st=String.valueOf(item2);
//	            dshezhixw=item1st+item2st;
//			}else if(shezhixw.trim().length()==7){
//				char  item0= shezhixw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= shezhixw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= shezhixw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= shezhixw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= shezhixw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item2st=String.valueOf(item2);
//	            String item3st=String.valueOf(item3);
//	            dshezhixw=item2st+item3st;
//			}
//		}
//			//判断穴位7
//		if(shetaixw != null||shetaixw!=""||shetaixw!=" "){
//			if(shetaixw.trim().length()==5){
//				char  item0= shetaixw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= shetaixw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= shetaixw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= shetaixw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= shetaixw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item0st=String.valueOf(item0);
//	            String item1st=String.valueOf(item1);
//	            dshetaixw=item0st+item1st;
//			}else if(shetaixw.trim().length()==6){
//				char  item0= shetaixw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= shetaixw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= shetaixw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= shetaixw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= shetaixw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item1st=String.valueOf(item1);
//	            String item2st=String.valueOf(item2);
//	            dshetaixw=item1st+item2st;
//			}else if(shetaixw.trim().length()==7){
//				char  item0= shetaixw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= shetaixw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= shetaixw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= shetaixw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= shetaixw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item2st=String.valueOf(item2);
//	            String item3st=String.valueOf(item3);
//	            dshetaixw=item2st+item3st;
//			}
//		}
//		
//		
//		//症状和其他比较
//		if(dkouqiangxw.equals(dmiansexw)){
//			miansexw="";
//		}
//		if(dkouqiangxw.equals(dxydxw)){
//			xydxw="";
//		}
//		if(dkouqiangxw.equals(dchunsexw)){
//			chunsexw="";
//		}
//		if(dkouqiangxw.equals(dshetixw)){
//			shetixw="";
//		}
//		if(dkouqiangxw.equals(dshezhixw)){
//			shezhixw="";
//		}
//		if(dkouqiangxw.equals(dshetaixw)){
//			shetaixw="";
//		}
//		//面色和其他比较
//		if(dmiansexw.equals(dxydxw)){
//			xydxw="";
//		}
//		if(dmiansexw.equals(dchunsexw)){
//			chunsexw="";
//		}
//		if(dmiansexw.equals(dshetixw)){
//			shetixw="";
//		}
//		if(dmiansexw.equals(dshezhixw)){
//			shezhixw="";
//		}
//		if(dmiansexw.equals(dshetaixw)){
//			shetaixw="";
//		}
//		//下眼袋和其他比较
//		if(dxydxw.equals(dchunsexw)){
//			chunsexw="";
//		}
//		if(dxydxw.equals(dshetixw)){
//			shetixw="";
//		}
//		if(dxydxw.equals(dshezhixw)){
//			shezhixw="";
//		}
//		if(dxydxw.equals(dshetaixw)){
//			shetaixw="";
//		}
//		//唇色和其他比较
//		if(dchunsexw.equals(dshetixw)){
//			shetixw="";
//		}
//		if(dchunsexw.equals(dshezhixw)){
//			shezhixw="";
//		}
//		if(dchunsexw.equals(dshetaixw)){
//			shetaixw="";
//		}
//		//舌体和其他比较
//		if(dshetixw.equals(dshezhixw)){
//			shezhixw="";
//		}
//		if(dshetixw.equals(dshetaixw)){
//			shetaixw="";
//		}
//		//舌质和其他比较
//		if(dshezhixw.equals(dshetaixw)){
//			shetaixw="";
//		}
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
//		String xuewei =kouqiangxw+" "+ miansexw+" "+xydxw+" "+chunsexw+" "+shetixw+" "+shezhixw+" "+shetaixw;
//		request.getSession().setAttribute("miansexw", miansexw);
//		request.getSession().setAttribute("xydxw", xydxw);
//		request.getSession().setAttribute("chunsexw", chunsexw);
//		request.getSession().setAttribute("shetixw", shetixw);
//		request.getSession().setAttribute("shezhixw", shezhixw);
//		request.getSession().setAttribute("shetaixw", shetaixw);
//		
		
		// 1、获得诊断编号
//		String str = zzxw;
		// 1、获得诊断处方
		 String	 str2= "积食";
		System.out.println("str2------------------------"+str2);
		String zybh="04";
		request.getSession().setAttribute("zybh", zybh);
		ZhuyiDao zhuyiDao=new ZhuyiDaoImpl();
		Zhuyi zhuyi=zhuyiDao.getZhuyi(zybh);
		
		//判断在哪个数据表格修改处方诊断
		String change_i=null;
//		 plan = planDao.geJishiPlanZzbh(str);
		 change_i="03";
		
		 String selplan="04";
		request.getSession().setAttribute("change_i", change_i);
		request.getSession().setAttribute("str", str);
		request.getSession().setAttribute("zhuyibh", zybh);
		request.getSession().setAttribute("selplan", selplan);
		// 设置处方错误
		try {
			String chufang="积食";
			plan.setZzbh(str2);
			plan.setZhuyi(zhuyi.getZhuyi());
			request.getSession().setAttribute("plan", plan);
			
			Object objuser = request.getSession().getAttribute("user");
			
			//开始
			request.getSession().setAttribute("str2", str2);
			request.getSession().setAttribute("hulizhuyi", zhuyi);
			
//			String chufang=plan.getChufang();
//			String shoufa=plan.getShoufa();
			
			request.getSession().setAttribute("shoufa", xuewei);
			request.getSession().setAttribute("chufang", chufang);
			
			if (objuser != null) {
				User u = (User) objuser;
				int uid=u.getUserid();
				String nameu=u.getLoginName();
				PatientDao patientDao = new PatientDaoImpl();
				int patinuber=patientDao.selPatientShuliang(uid);
				if(patinuber>0){
//					request.getRequestDispatcher("/SearchPatientServlet").forward(request, response);
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
		} catch (Exception e) {
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
