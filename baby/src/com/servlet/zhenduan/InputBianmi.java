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

public class InputBianmi extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		User user =(User)request.getSession().getAttribute("user");
		// 获取系统时间
		Date dt = new Date();// 如果不需要格式,可直接用dt,dt就是当前系统时间
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置显示格式
		DateFormat ddf= new SimpleDateFormat("yyyy-MM-dd");
		DateFormat ftm= new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String nowTime = "";
		nowTime = df.format(dt);// 用DateFormat的format()方法在dt中获取并以yyyy/MM/dd
								// HH:mm:ss格式显示
		String ddfTime= ddf.format(dt);
		System.out.println(nowTime);
		String fTime= ftm.format(dt);
		
		
		if(user==null){
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("window.location.href=\"login.jsp\"");
			out.println("</script>");
		}else if(user.getUpower()==1||user.getUpower()==2||user.getUpower()==3){
			//限制添加病例开始
			String sannowTime = ddfTime+"%";
			System.out.println("时间为："+sannowTime);
			int uid=user.getUserid();
			RecordDao recsan=new RecordDaoImpl();
			int sange=recsan.getRecord(sannowTime,uid);
			System.out.println("返回的孩子病例数"+sange);
			
			if(sange>=3){
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("alert('尊敬的用户，小宝提醒您每天最多取穴3次！');");
				out.println("window.location.href=\"xuanzejiemian.jsp\"");
				out.println("</script>");
				return;
			}
		}
		if(user.getUpower()==3){
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('你现在是普通会员，VIP会员才可以使用，想要详细了解点击进入');");
			out.println("window.location.href=\"xuanzejiemian.jsp\"");
			out.println("</script>");
		}else{
		
		String xingzhuang = request.getParameter("xingzhuang");
			if(xingzhuang==null || xingzhuang == ""){
				xingzhuang="01_正常";
				System.out.println("xingzhuang--------"+xingzhuang);
				request.getSession().setAttribute("xingzhuang", xingzhuang);
			}
		String qiwei = request.getParameter("qiwei");
			if(qiwei==null || qiwei == ""){
				qiwei="01_正常";
				System.out.println("qiwei--------"+qiwei);
				request.getSession().setAttribute("qiwei", qiwei);
			}
			
			String dabianyanse = request.getParameter("dabianyanse");

			String strdabianyanse="01";

			if(dabianyanse==null || dabianyanse == ""){
				dabianyanse="01_黄色";
				request.getSession().setAttribute("dabianyanse", dabianyanse);
			}else if(dabianyanse=="黄色"||dabianyanse.equals("黄色")){
				strdabianyanse="01";
				System.out.println("huang1----------"+strdabianyanse);
			}else if(dabianyanse=="黄褐色"||dabianyanse.equals("黄褐色")){
				strdabianyanse="02";
				System.out.println("huang2----------"+strdabianyanse);

			}else if(dabianyanse=="绿色"||dabianyanse.equals("绿色")){
				strdabianyanse="03";
				System.out.println("huang3----------"+strdabianyanse);

			}
		
		String[] strxingzhuang = xingzhuang.split("_");
		String[] strqiwei = qiwei.split("_");
//		String[] strdabianyanse = yanse.split("_");
//		String[] strmianse = mianse.split("_");
//		String[] strchunse = chunse.split("_");
//		String[] strxiayandai = xiayandai.split("_");
//		String[] strshezhi = shezhi.split("_");
//		String[] strshetai = shetai.split("_");
//		String[] strsheti = sheti.split("_");

		//体征单独穴位开始
		String change_i="11";
		Plan plan=new Plan();
		String str = strxingzhuang[0] + strqiwei[0] + strdabianyanse;
		PlanDao planDao=new PlanDaoImpl(); 
		plan=planDao.getBianmiPlanZzbh(str);
		String zzxwt=plan.getShoufa();
		String zzxw=zzxwt+" ";
		String miansexw="29500"+" ";
		String xydxw="";
//		System.out.println("便秘的数据库-----------------"+zzxw);
//		String miansexw=null;
//		String xydxw=null;
//		String chunsexw=null;
//		String shetixw=null;
//		String shezhixw=null;
//		String shetaixw=null;
		
//		Tizheng tz=new Tizheng();
//		tz=planDao.selbianmixw(strmianse[2]);
//		 miansexw=tz.getTzxw();
//		
//		tz=planDao.selbianmixw(strxiayandai[2]);
//		xydxw=tz.getTzxw();
//		
//		tz=planDao.selbianmixw(strchunse[2]);
//		chunsexw=tz.getTzxw();
//		
//		tz=planDao.selbianmixw(strsheti[2]);
//		shetixw=tz.getTzxw();
//		
//		tz=planDao.selbianmixw(strshezhi[2]);
//		shezhixw=tz.getTzxw();
//		
//		tz=planDao.selbianmixw(strshetai[2]);
//		shetaixw=tz.getTzxw();
//	
//		String dzzxw=null;
//		String dmiansexw=null;
//		String dxydxw=null;
//		String dchunsexw=null;
//		String dshetixw=null;
//		String dshezhixw=null;
//		String dshetaixw=null;
//		
//		//穴位1
//		if(zzxw.trim().length()==5){
//			char  item0= zzxw.charAt(0);
//			System.out.println("item0---------"+item0);
//			char  item1= zzxw .charAt(1);
//			System.out.println("item1---------"+item1);
//			char  item2= zzxw .charAt(2);
//			System.out.println("item2---------"+item2);
//			char  item3= zzxw .charAt(3);
//			System.out.println("item3---------"+item3);
//			char  item4= zzxw .charAt(4);
//			System.out.println("item4---------"+item4);
//			
//			String item0st=String.valueOf(item0);
//            String item1st=String.valueOf(item1);
//            dzzxw=item0st+item1st;
//			
//		}else if(zzxw.trim().length()==6){
//			char  item0= zzxw .charAt(0);
//			System.out.println("item0---------"+item0);
//			char  item1= zzxw .charAt(1);
//			System.out.println("item1---------"+item1);
//			char  item2= zzxw .charAt(2);
//			System.out.println("item2---------"+item2);
//			char  item3= zzxw .charAt(3);
//			System.out.println("item3---------"+item3);
//			char  item4= zzxw .charAt(4);
//			System.out.println("item4---------"+item4);
//			
//			String item1st=String.valueOf(item1);
//            String item2st=String.valueOf(item2);
//            dzzxw=item1st+item2st;
//			
//		}else if(zzxw.trim().length()==7){
//			char  item0= zzxw .charAt(0);
//			System.out.println("item0---------"+item0);
//			char  item1= zzxw .charAt(1);
//			System.out.println("item1---------"+item1);
//			char  item2= zzxw .charAt(2);
//			System.out.println("item2---------"+item2);
//			char  item3= zzxw .charAt(3);
//			System.out.println("item3---------"+item3);
//			char  item4= zzxw .charAt(4);
//			System.out.println("item4---------"+item4);
//			
//			String item2st=String.valueOf(item2);
//            String item3st=String.valueOf(item3);
//            dzzxw=item2st+item3st;
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
//		if(dzzxw.equals(dmiansexw)){
//			miansexw="";
//		}
//		if(dzzxw.equals(dxydxw)){
//			xydxw="";
//		}
//		if(dzzxw.equals(dchunsexw)){
//			chunsexw="";
//		}
//		if(dzzxw.equals(dshetixw)){
//			shetixw="";
//		}
//		if(dzzxw.equals(dshezhixw)){
//			shezhixw="";
//		}
//		if(dzzxw.equals(dshetaixw)){
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
//		String xuewei =zzxw+" "+miansexw+" "+xydxw+" "+chunsexw+" "+shetixw+" "+shezhixw+" "+shetaixw;
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
//		String str =strxingzhuang[0] +strqiwei[0]+strmianse[0]+strchunse[0]+strxiayandai[0]+strshezhi[0]+strshetai[0]+strsheti[0];
		// 1、获得诊断处方
//		request.getSession().setAttribute("miansexw", miansexw);
//		request.getSession().setAttribute("xydxw", xydxw);
//		request.getSession().setAttribute("chunsexw", chunsexw);
//		request.getSession().setAttribute("shetixw", shetixw);
//		request.getSession().setAttribute("shezhixw", shezhixw);
//		request.getSession().setAttribute("shetaixw", shetaixw);
		 String	 str2="从体质上看,孩子 大便性状："+strxingzhuang[1]+ "气味："+strqiwei[1]+ "  ；大便颜色："+dabianyanse;
		System.out.println("str------------------------"+str);
        
        //用于修改处方标识
        
    	request.getSession().setAttribute("change_i", change_i);
		request.getSession().setAttribute("str", str);
		request.getSession().setAttribute("str2", str2);
		//标识结束
		
		String zybh="07";
		request.getSession().setAttribute("zhuyibh", zybh);
		 String selplan="05";
		 request.getSession().setAttribute("selplan", selplan);
		ZhuyiDao zhuyiDao=new ZhuyiDaoImpl();
		Zhuyi zhuyi=zhuyiDao.getZhuyi(zybh);
		String ss=zhuyi.getZhuyi();
		plan.setZhuyi(zhuyi.getZhuyi());
		//设置处方错误
		try {
			
		plan.setZzbh(str2);
		
		request.getSession().setAttribute("plan",plan);
		//2、保存诊断记录
//		Record rd=new Record();
//		rd.setDyzz(str2);	
//		rd.setDycf(plan.getChufang());
//		rd.setDysf(plan.getShoufa());
//		rd.setDyzy(plan.getZhuyi());
		
		Object objuser=request.getSession().getAttribute("user");
		//开始
		request.getSession().setAttribute("change_i", change_i);
		request.getSession().setAttribute("str", str);
		request.getSession().setAttribute("str2", str2);
		request.getSession().setAttribute("hulizhuyi", zhuyi);
		
		String chufang=plan.getChufang();
		String shoufa=plan.getShoufa();
		
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
	       	out.println("alert('暂无处方');");
	    	out.println("window.location.href=\"xunzejiemain.jsp\"");
	       	out.println("</script>");
		}
		
		out.close();
		}
	}
}
