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

public class InputMxkesou extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 获取系统时间
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
			
			String hdhjulieke ="01";
			String sqxhkesou="01";
			String huanjike="01";
			String kkqingsangzi="01";
			String cijixingganke="01";
			String guominxingkesou="01";
			String dahulu="01";
			String ganke="01";
			String kesouyoutan="01";
			String zaoqike="01";
			String yejianke="01";
			
			String str2hdhjulieke="";
			String str2sqxhkesou="";
			String str2huanjike="";
			String str2kkqingsangzi="";
			String str2cijixingganke="";
			String str2guominxingkesou="";
			String str2dahulu="";
			String str2ganke="";
			String str2kesouyoutan="";
			String str2zaoqike="";
			String str2yejianke="";
			
			
		String[] ganmao=request.getParameterValues("mxkesou");
	   if(ganmao!=null&&ganmao.length>0) {
	        for(int i= 0 ;i<ganmao.length;i++)
	        {
	        	if(ganmao[i]=="活动后咳嗽剧烈"||ganmao[i].equals("活动后咳嗽剧烈")){
	        		hdhjulieke="02";
	        		str2hdhjulieke="活动后咳嗽剧烈";
	        	}
	        
		        if(ganmao[i]=="睡前咳，醒后咳"||ganmao[i].equals("睡前咳，醒后咳")){
		        	sqxhkesou="02";
	        		str2sqxhkesou="睡前咳，醒后咳";
	        	}
		        if(ganmao[i]=="换季咳嗽频繁"||ganmao[i].equals("换季咳嗽频繁")){
		        	huanjike="02";
	        		str2huanjike="换季咳嗽频繁";
	        	}
		        if(ganmao[i]=="吭吭清嗓子"||ganmao[i].equals("吭吭清嗓子")){
		        	kkqingsangzi="02";
	        		str2kkqingsangzi="吭吭清嗓子";
	        	}
		        if(ganmao[i]=="刺激性干咳"||ganmao[i].equals("刺激性干咳")){
		        	cijixingganke="02";
	        		str2cijixingganke="刺激性干咳";
	        	}
		        if(ganmao[i]=="过敏性咳嗽"||ganmao[i].equals("过敏性咳嗽")){
		        	guominxingkesou="02";
	        		str2guominxingkesou="过敏性咳嗽";
	        	}
		        if(ganmao[i]=="打呼噜"||ganmao[i].equals("打呼噜")){
		        	dahulu="02";
	        		str2dahulu="打呼噜";
	        	}
		        if(ganmao[i]=="干咳"||ganmao[i].equals("干咳")){
		        	ganke="02";
	        		str2ganke="干咳";
	        	}
	        	if(ganmao[i]=="咳嗽有痰"||ganmao[i].equals("咳嗽有痰")){
	        		kesouyoutan="02";
	        		str2kesouyoutan="咳嗽有痰";
	        	}
	        	if(ganmao[i]=="早晨咳嗽频繁"||ganmao[i].equals("早晨咳嗽频繁")){
	        		zaoqike="02";
	        		str2zaoqike="早晨咳嗽频繁";
	        	}
	        	if(ganmao[i]=="夜间咳嗽频繁"||ganmao[i].equals("夜间咳嗽频繁")){
	        		yejianke="02";
	        		str2yejianke="夜间咳嗽频繁";
	        	}
	        }
	    }
	
		//体征单独穴位开始
		String change_i=null;
		Plan plan=new Plan();
		String str = hdhjulieke+sqxhkesou+huanjike+kkqingsangzi+cijixingganke+guominxingkesou+dahulu+ganke+kesouyoutan+zaoqike+yejianke;
		PlanDao planDao = new PlanDaoImpl();
		plan = planDao.getManxingkesouPlanZzbh(str);
		 change_i="01";
		String zzxwt=plan.getShoufa();
		String zzxw=zzxwt+" ";
		String miansexw="05100"+" ";
		String xydxw="";

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
//		//体征单独穴位结束
		// 1、获得诊断处方
	
		 String	 str2= "从体质上看，孩子"+str2hdhjulieke+"、"+str2sqxhkesou+"、"+str2huanjike+"、"+str2kkqingsangzi+"、"+str2cijixingganke+"、"+str2guominxingkesou+
				 str2dahulu+"、"+str2ganke+"、"+str2kesouyoutan+"、"+str2zaoqike+"、"+str2yejianke;
		String zybh="01";
	
		ZhuyiDao zhuyiDao=new ZhuyiDaoImpl();
		Zhuyi zhuyi=zhuyiDao.getZhuyi(zybh);
		
		String shxdzhuyi=zhuyi.getZhuyi();
		//判断在哪个数据库表格里面查询
//		int i=Integer.parseInt(strshxdao[0]);
		String selplan="01";
		//判断在哪个数据表格修改处方诊断
		 
		request.getSession().setAttribute("change_i", change_i);
		request.getSession().setAttribute("str", str);
		request.getSession().setAttribute("zhuyibh", zybh);
		request.getSession().setAttribute("selplan", selplan);
		// 设置处方错误
		try {
			plan.setZzbh(str2);
			plan.setZhuyi(zhuyi.getZhuyi());
			request.getSession().setAttribute("plan", plan);
			// 2、保存诊断记录
			Record rd = new Record();
			rd.setDyzz(str2);
			//rd.setZzbh(str);
			rd.setDycf(plan.getChufang());
			rd.setDysf(plan.getShoufa());
			rd.setDyzy(zhuyi.getZhuyi());
			
			
			
			Object objuser = request.getSession().getAttribute("user");
			
			//开始
			request.getSession().setAttribute("change_i", change_i);
			request.getSession().setAttribute("str", str);
			request.getSession().setAttribute("str2", str2);
			request.getSession().setAttribute("hulizhuyi", shxdzhuyi);
			
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