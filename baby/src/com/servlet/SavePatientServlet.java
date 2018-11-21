package com.servlet;

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

import com.bean.Money;
import com.bean.Patient;
import com.bean.Record;
import com.bean.Richang;
import com.bean.User;
import com.bean.Zhuyi;
import com.dao.FenbuDao;
import com.dao.PatientDao;
import com.dao.RecordDao;
import com.dao.ZhuyiDao;
import com.dao.impl.FenbuDaoImpl;
import com.dao.impl.PatientDaoImpl;
import com.dao.impl.RecordDaoImpl;
import com.dao.impl.ZhuyiDaoImpl;

public class SavePatientServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 获取系统时间
		Date dt = new Date();// 如果不需要格式,可直接用dt,dt就是当前系统时间
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置显示格式
//		DateFormat ddf= new SimpleDateFormat("yyyy-MM-dd");
		String pborn = df.format(dt);// 用DateFormat的format()方法在dt中获取并以yyyy/MM/dd
								// HH:mm:ss格式显示
//		String pborn= ddf.format(dt);
		Object obj = request.getSession().getAttribute("user");
		String pname = request.getParameter("pname");
		String pxb = request.getParameter("pxb");
		String page = request.getParameter("page");
		String pphone = request.getParameter("pphone");
		String ppname = request.getParameter("ppname");
		String paddress = request.getParameter("paddress");
		String qq = request.getParameter("weixin");
		String weixin = request.getParameter("weixin");
		
		String str = request.getParameter("str"); 
		String str2 = request.getParameter("str2"); 
		String chufang = request.getParameter("chufang"); 
		String shoufa = request.getParameter("shoufa"); 
		String zhuyibh = request.getParameter("zhuyibh");
		
		
		//开始
		request.getSession().setAttribute("pname", pname);
		request.getSession().setAttribute("age", page);
		request.getSession().setAttribute("pborn", pborn);
		request.getSession().setAttribute("str", str);
		request.getSession().setAttribute("str2", str2);
		request.getSession().setAttribute("chufang", chufang);
		request.getSession().setAttribute("shoufa", shoufa);
		request.getSession().setAttribute("zhuyibh", zhuyibh);
		request.getSession().setAttribute("nowTime", pborn);
		//结束
		if(pname==null) {
			response.sendRedirect("inputinfor.jsp");
			return;
		}
		try {
			
			User user = null;
			if (obj != null) {
				user = (User) obj;
				//判断是否有重复的宝宝开始
				int userid=user.getUserid();
				PatientDao patientDao = new PatientDaoImpl();
				int selpnamechongfu=patientDao.selPnameChongfu(pname, userid);
				System.out.println("此宝宝共有"+selpnamechongfu);
				if(selpnamechongfu>1){
					out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
					out.println("<script>");
					out.println("alert('此宝宝您已经添加过多次！');");
					out.println("window.location.href=\"inputinfor.jsp\"");
					out.println("</script>");
				}else{
					int selnameponchongfu=patientDao.selPnPoChongfu(pname, userid,pphone);
					if(selnameponchongfu>1){
						out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
						out.println("<script>");
						out.println("alert('此宝宝您已经添加过了，不能再次添加！');");
						out.println("window.location.href=\"inputinfor.jsp\"");
						out.println("</script>");
					}}

				//判断是否有重复的宝宝结束


				Patient p = new Patient();
				p.setPname(pname);
				p.setPxb(pxb);
				p.setPborn(pborn);
				p.setPpname(ppname);
				p.setPphone(pphone);
				p.setPaddress(paddress);
				p.setPage(page);
				p.setCrid(user.getUserid());
				p.setFid(user.getFid());
				p.setQq(qq);
				p.setWeixin(weixin);

//				User u = (User) obj;
				String pid = "";

//				if (u.getUpower() == 0 || u.getUpower() == 1 || u.getUpower() == 2)
				pid = patientDao.save(p);
				int pidd=Integer.parseInt(pid);
				p.setPid(pidd);
				request.getSession().setAttribute("pid", pid);
				request.getSession().setAttribute("patient", p);
				
				ZhuyiDao zhuyiDao=new ZhuyiDaoImpl();
				Zhuyi zhuyi=zhuyiDao.getZhuyi(zhuyibh);
				
				String hulizhuyi=zhuyi.getZhuyi();
				request.getSession().setAttribute("hulizhuyi", hulizhuyi);
				//开始
				Record rd = new Record();
				
				rd.setCtime(pborn);
				rd.setPid(pidd);
				rd.setUserid(userid);
				rd.setFid(user.getFid());
				rd.setDyzz(str2);
				rd.setDycf(chufang);
				rd.setDysf(shoufa);
				rd.setDyzy(zhuyibh);
				RecordDao recordDao = new RecordDaoImpl();
				recordDao.save(rd);
				//结束
				
				//截取结果中的穴位代码开始
				String sumitem1="";
				String sumitem2="";
				String sumitem3="";
				String sumitem4="";
				String sumitem5="";
				String sumitem6="";
				String sumitem7="";
				
				request.getSession().setAttribute("sumitem1", sumitem1);
				request.getSession().setAttribute("sumitem2", sumitem2);
				request.getSession().setAttribute("sumitem3", sumitem3);
				request.getSession().setAttribute("sumitem4", sumitem4);
				request.getSession().setAttribute("sumitem5", sumitem5);
				request.getSession().setAttribute("sumitem5", sumitem5);
				request.getSession().setAttribute("sumitem6", sumitem6);
				request.getSession().setAttribute("sumitem7", sumitem7);
				
				String[] xuewei=shoufa.split(" ");
				String zzxw="";
				String miansexw="";
				String xydxw="";
				String chunsexw="";
				String shetixw="";
				String shezhixw="";
				String shetaixw="";
				if(xuewei.length==2){
					zzxw=xuewei[0].toString();
					miansexw=xuewei[1].toString();
				}
				
				if(xuewei.length==3){
					zzxw=xuewei[0].toString();
					miansexw=xuewei[1].toString();
					xydxw=xuewei[2].toString();
				}
				
				if(xuewei.length==4){
					zzxw=xuewei[0].toString();
					miansexw=xuewei[1].toString();
					xydxw=xuewei[2].toString();
					chunsexw=xuewei[3].toString();
				}
				
				if(xuewei.length==5){
					zzxw=xuewei[0].toString();
					miansexw=xuewei[1].toString();
					xydxw=xuewei[2].toString();
					chunsexw=xuewei[3].toString();
					shetixw=xuewei[4].toString();
				}
				
				if(xuewei.length==6){
					zzxw=xuewei[0].toString();
					miansexw=xuewei[1].toString();
					xydxw=xuewei[2].toString();
					chunsexw=xuewei[3].toString();
					shetixw=xuewei[4].toString();
					shezhixw=xuewei[5].toString();
				}
				
				if(xuewei.length==7){
					zzxw=xuewei[0].toString();
					miansexw=xuewei[1].toString();
					xydxw=xuewei[2].toString();
					chunsexw=xuewei[3].toString();
					shetixw=xuewei[4].toString();
					shezhixw=xuewei[5].toString();
					shetaixw=xuewei[6].toString();
				}
				
				//判断穴位1
				if(zzxw != null||zzxw!=""){
					
					if(zzxw.length()==5){
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
			            sumitem1=item0st+item1st;
						
						 request.getSession().setAttribute("sumitem1", sumitem1);
					}else if(zzxw.length()==6){
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
			            sumitem1=item1st+item2st;
						
						 request.getSession().setAttribute("sumitem1", sumitem1);
					}else if(zzxw.length()==7){
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
			            sumitem1=item2st+item3st;
						
						 request.getSession().setAttribute("sumitem1", sumitem1);
						}
					}
				
				//判断穴位2
				if(miansexw != null||miansexw!=""){
				
				if(miansexw.length()==5){
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
		            sumitem2=item0st+item1st;
					
					 request.getSession().setAttribute("sumitem2", sumitem2);
				}else if(miansexw.length()==6){
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
		            sumitem2=item1st+item2st;
					
					 request.getSession().setAttribute("sumitem2", sumitem2);
				}else if(miansexw.length()==7){
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
		            sumitem2=item2st+item3st;
					
					 request.getSession().setAttribute("sumitem2", sumitem2);
				}
				}
				
				//判断穴位3
				if(xydxw != null||xydxw!=""){
					if(xydxw.length()==5){
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
			            sumitem3=item0st+item1st;
						
						 request.getSession().setAttribute("sumitem3", sumitem3);
						 System.out.println("穴位==5--------------"+sumitem3);
					}else if(xydxw.length()==6){
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
			            sumitem3=item1st+item2st;
						
						 request.getSession().setAttribute("sumitem3", sumitem3);
					}else if(xydxw.length()==7){
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
			            sumitem3=item2st+item3st;
						 request.getSession().setAttribute("sumitem3", sumitem3);
					}
				}
					//判断穴位4
					if(chunsexw != null||chunsexw!=""){
					if(chunsexw.length()==5){
						char  item0= chunsexw.charAt(0);
						System.out.println("item0---------"+item0);
						char  item1= chunsexw.charAt(1);
						System.out.println("item1---------"+item1);
						char  item2= chunsexw.charAt(2);
						System.out.println("item2---------"+item2);
						char  item3= chunsexw.charAt(3);
						System.out.println("item3---------"+item3);
						char  item4= chunsexw.charAt(4);
						System.out.println("item4---------"+item4);
						
						String item0st=String.valueOf(item0);
			            String item1st=String.valueOf(item1);
			            sumitem4=item0st+item1st;
						
						 request.getSession().setAttribute("sumitem4", sumitem4);
					}else if(chunsexw.length()==6){
						char  item0= chunsexw.charAt(0);
						System.out.println("item0---------"+item0);
						char  item1= chunsexw.charAt(1);
						System.out.println("item1---------"+item1);
						char  item2= chunsexw.charAt(2);
						System.out.println("item2---------"+item2);
						char  item3= chunsexw.charAt(3);
						System.out.println("item3---------"+item3);
						char  item4= chunsexw.charAt(4);
						System.out.println("item4---------"+item4);
						
						String item1st=String.valueOf(item1);
			            String item2st=String.valueOf(item2);
			            sumitem4=item1st+item2st;
						
						 request.getSession().setAttribute("sumitem4", sumitem4);
					}else if(chunsexw.length()==7){
						char  item0= chunsexw.charAt(0);
						System.out.println("item0---------"+item0);
						char  item1= chunsexw.charAt(1);
						System.out.println("item1---------"+item1);
						char  item2= chunsexw.charAt(2);
						System.out.println("item2---------"+item2);
						char  item3= chunsexw.charAt(3);
						System.out.println("item3---------"+item3);
						char  item4= chunsexw.charAt(4);
						System.out.println("item4---------"+item4);
						
						String item2st=String.valueOf(item2);
			            String item3st=String.valueOf(item3);
			            sumitem4=item2st+item3st;
						
						 request.getSession().setAttribute("sumitem4", sumitem4);
					}
				}
					//判断穴位5
				if(shetixw != null||shetixw!=""){
					if(shetixw.length()==5){
						char  item0= shetixw.charAt(0);
						System.out.println("item0---------"+item0);
						char  item1= shetixw.charAt(1);
						System.out.println("item1---------"+item1);
						char  item2= shetixw.charAt(2);
						System.out.println("item2---------"+item2);
						char  item3= shetixw.charAt(3);
						System.out.println("item3---------"+item3);
						char  item4= shetixw.charAt(4);
						System.out.println("item4---------"+item4);
						
						String item0st=String.valueOf(item0);
			            String item1st=String.valueOf(item1);
			            sumitem5=item0st+item1st;
						
						 request.getSession().setAttribute("sumitem5", sumitem5);
					}else if(shetixw.length()==6){
						char  item0= shetixw.charAt(0);
						System.out.println("item0---------"+item0);
						char  item1= shetixw.charAt(1);
						System.out.println("item1---------"+item1);
						char  item2= shetixw.charAt(2);
						System.out.println("item2---------"+item2);
						char  item3= shetixw.charAt(3);
						System.out.println("item3---------"+item3);
						char  item4= shetixw.charAt(4);
						System.out.println("item4---------"+item4);
						
						String item1st=String.valueOf(item1);
			            String item2st=String.valueOf(item2);
			            sumitem5=item1st+item2st;
						
						 request.getSession().setAttribute("sumitem5", sumitem5);
					}else if(shetixw.length()==7){
						char  item0= shetixw.charAt(0);
						System.out.println("item0---------"+item0);
						char  item1= shetixw.charAt(1);
						System.out.println("item1---------"+item1);
						char  item2= shetixw.charAt(2);
						System.out.println("item2---------"+item2);
						char  item3= shetixw.charAt(3);
						System.out.println("item3---------"+item3);
						char  item4= shetixw.charAt(4);
						System.out.println("item4---------"+item4);
						
						String item2st=String.valueOf(item2);
			            String item3st=String.valueOf(item3);
			            sumitem5=item2st+item3st;
						
						 request.getSession().setAttribute("sumitem5", sumitem5);
					}
				}
					//判断穴位6
				if(shezhixw != null||shezhixw!=""){
					if(shezhixw.length()==5){
						char  item0= shezhixw.charAt(0);
						System.out.println("item0---------"+item0);
						char  item1= shezhixw.charAt(1);
						System.out.println("item1---------"+item1);
						char  item2= shezhixw.charAt(2);
						System.out.println("item2---------"+item2);
						char  item3= shezhixw.charAt(3);
						System.out.println("item3---------"+item3);
						char  item4= shezhixw.charAt(4);
						System.out.println("item4---------"+item4);
						
						String item0st=String.valueOf(item0);
			            String item1st=String.valueOf(item1);
			            sumitem6=item0st+item1st;
						
						 request.getSession().setAttribute("sumitem6", sumitem6);
					}else if(shezhixw.length()==6){
						char  item0= shezhixw.charAt(0);
						System.out.println("item0---------"+item0);
						char  item1= shezhixw.charAt(1);
						System.out.println("item1---------"+item1);
						char  item2= shezhixw.charAt(2);
						System.out.println("item2---------"+item2);
						char  item3= shezhixw.charAt(3);
						System.out.println("item3---------"+item3);
						char  item4= shezhixw.charAt(4);
						System.out.println("item4---------"+item4);
						
						String item1st=String.valueOf(item1);
			            String item2st=String.valueOf(item2);
			            sumitem6=item1st+item2st;
						
						 request.getSession().setAttribute("sumitem6", sumitem6);
					}else if(shezhixw.length()==7){
						char  item0= shezhixw.charAt(0);
						System.out.println("item0---------"+item0);
						char  item1= shezhixw.charAt(1);
						System.out.println("item1---------"+item1);
						char  item2= shezhixw.charAt(2);
						System.out.println("item2---------"+item2);
						char  item3= shezhixw.charAt(3);
						System.out.println("item3---------"+item3);
						char  item4= shezhixw.charAt(4);
						System.out.println("item4---------"+item4);
						
						String item2st=String.valueOf(item2);
			            String item3st=String.valueOf(item3);
			            sumitem6=item2st+item3st;
						
						 request.getSession().setAttribute("sumitem6", sumitem6);
					}
				}
					//判断穴位7
				if(shetaixw != null||shetaixw!=""){
					if(shetaixw.length()==5){
						char  item0= shetaixw.charAt(0);
						System.out.println("item0---------"+item0);
						char  item1= shetaixw.charAt(1);
						System.out.println("item1---------"+item1);
						char  item2= shetaixw.charAt(2);
						System.out.println("item2---------"+item2);
						char  item3= shetaixw.charAt(3);
						System.out.println("item3---------"+item3);
						char  item4= shetaixw.charAt(4);
						System.out.println("item4---------"+item4);
						
						String item0st=String.valueOf(item0);
			            String item1st=String.valueOf(item1);
			            sumitem7=item0st+item1st;
						
						 request.getSession().setAttribute("sumitem7", sumitem7);
					}else if(shetaixw.length()==6){
						char  item0= shetaixw.charAt(0);
						System.out.println("item0---------"+item0);
						char  item1= shetaixw.charAt(1);
						System.out.println("item1---------"+item1);
						char  item2= shetaixw.charAt(2);
						System.out.println("item2---------"+item2);
						char  item3= shetaixw.charAt(3);
						System.out.println("item3---------"+item3);
						char  item4= shetaixw.charAt(4);
						System.out.println("item4---------"+item4);
						
						String item1st=String.valueOf(item1);
			            String item2st=String.valueOf(item2);
			            sumitem7=item1st+item2st;
						
						 request.getSession().setAttribute("sumitem7", sumitem7);
					}else if(shetaixw.length()==7){
						char  item0= shetaixw.charAt(0);
						System.out.println("item0---------"+item0);
						char  item1= shetaixw.charAt(1);
						System.out.println("item1---------"+item1);
						char  item2= shetaixw.charAt(2);
						System.out.println("item2---------"+item2);
						char  item3= shetaixw.charAt(3);
						System.out.println("item3---------"+item3);
						char  item4= shetaixw.charAt(4);
						System.out.println("item4---------"+item4);
						
						String item2st=String.valueOf(item2);
			            String item3st=String.valueOf(item3);
			            sumitem7=item2st+item3st;
						
						 request.getSession().setAttribute("sumitem7", sumitem7);
					}
				}
				
				//截取穴位结束

				
	    		//根据穴位判断用哪些视频开始
	    		
				//第一个视频和图片
				
	    		if(sumitem1.equals("01")){
	    			String shipin1="video/v1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/01.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("02")){
	    			String shipin1="video/v2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/02.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("03")){
	    			String shipin1="video/v3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/03.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("04")){
	    			String shipin1="video/v4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/04.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("05")){
	    			String shipin1="video/v5.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/05.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("06")){
	    			String shipin1="video/v6.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/06.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("07")){
	    			String shipin1="video/v7.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/07.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("08")){
	    			String shipin1="video/v8.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/08.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("09")){
	    			String shipin1="video/v9.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/09.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("10")){
	    			String shipin1="video/v10.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/10.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("11")){
	    			String shipin1="video/v11.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/11.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("12")){
	    			String shipin1="video/v12.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/12.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("13")){
	    			String shipin1="video/v13.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/13.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("14")){
	    			String shipin1="video/v14.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/14.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("15")){
	    			String shipin1="video/v15.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/15.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("16")){
	    			String shipin1="video/v16.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/16.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("17")){
	    			String shipin1="video/v17.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/17.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("18")){
	    			String shipin1="video/v18.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/18.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("19")){
	    			String shipin1="video/v19.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/19.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("20")){
	    			String shipin1="video/v20.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/20.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("21")){
	    			String shipin1="video/v21.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/21.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("22")){
	    			String shipin1="video/v22.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/22.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("23")){
	    			String shipin1="video/v23.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/23.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("24")){
	    			String shipin1="video/v24.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/24.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("25")){
	    			String shipin1="video/v25.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/25.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("26")){
	    			String shipin1="video/v26.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/26.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("27")){
	    			String shipin1="video/v27.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/27.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("28")){
	    			String shipin1="video/v28.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/28.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("29")){
	    			String shipin1="video/v29.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/29.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("30")){
	    			String shipin1="video/v30.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/30.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("31")){
	    			String shipin1="video/v31.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/31.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("32")){
	    			String shipin1="video/v32.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/32.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("33")){
	    			String shipin1="video/v33.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/33.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("34")){
	    			String shipin1="video/v34.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/34.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("35")){
	    			String shipin1="video/v35.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/35.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("36")){
	    			String shipin1="video/v36.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/36.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("37")){
	    			String shipin1="video/v37.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/37.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("38")){
	    			String shipin1="video/v38.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/38.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("39")){
	    			String shipin1="video/v39.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/39.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("40")){
	    			String shipin1="video/v40.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/40.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("41")){
	    			String shipin1="video/v41.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/41.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("42")){
	    			String shipin1="video/v42.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/42.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("43")){
	    			String shipin1="video/v43.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/43.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("44")){
	    			String shipin1="video/v44.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/44.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("45")){
	    			String shipin1="video/v45.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/45.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("46")){
	    			String shipin1="video/v46.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/46.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("47")){
	    			String shipin1="video/v47.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/47.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("48")){
	    			String shipin1="video/v48.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/48.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("49")){
	    			String shipin1="video/v49.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/49.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("50")){
	    			String shipin1="video/v50.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/50.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("51")){
	    			String shipin1="video/v51.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/51.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("52")){
	    			String shipin1="video/v52.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/52.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("53")){
	    			String shipin1="video/v53.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/53.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("54")){
	    			String shipin1="video/v54.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/54.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("55")){
	    			String shipin1="video/v55.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/55.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("56")){
	    			String shipin1="video/v56.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/56.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("57")){
	    			String shipin1="video/v57.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/57.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("58")){
	    			String shipin1="video/v58.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/58.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("59")){
	    			String shipin1="video/v59.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/59.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("60")){
	    			String shipin1="video/v60.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/60.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("61")){
	    			String shipin1="video/v61.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/61.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		if(sumitem1.equals("62")){
	    			String shipin1="video/v62.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/62.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
	    		
	    		if(sumitem1.equals("63")){
	    			String shipin1="video/v63.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
	    			String img1="img/video-fm/63.jpg";
	    			request.getSession().setAttribute("img1", img1);
	    		}
			
			
			//第二个视频和图片
	    		if(sumitem2.equals("01")){
	    			String shipin2="video/v1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/01.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("02")){
	    			String shipin2="video/v2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/02.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("03")){
	    			String shipin2="video/v3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/03.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("04")){
	    			String shipin2="video/v4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/04.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("05")){
	    			String shipin2="video/v5.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/05.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("06")){
	    			String shipin2="video/v6.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/06.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("07")){
	    			String shipin2="video/v7.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/07.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("08")){
	    			String shipin2="video/v8.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/08.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("09")){
	    			String shipin2="video/v9.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/09.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("10")){
	    			String shipin2="video/v10.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/10.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("11")){
	    			String shipin2="video/v11.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/11.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("12")){
	    			String shipin2="video/v12.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/12.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("13")){
	    			String shipin2="video/v13.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/13.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("14")){
	    			String shipin2="video/v14.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/14.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("15")){
	    			String shipin2="video/v15.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/15.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("16")){
	    			String shipin2="video/v16.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/16.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("17")){
	    			String shipin2="video/v17.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/17.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("18")){
	    			String shipin2="video/v18.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/18.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("19")){
	    			String shipin2="video/v19.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/19.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("20")){
	    			String shipin2="video/v20.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/20.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("21")){
	    			String shipin2="video/v21.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/21.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("22")){
	    			String shipin2="video/v22.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/22.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("23")){
	    			String shipin2="video/v23.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/23.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("24")){
	    			String shipin2="video/v24.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/24.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("25")){
	    			String shipin2="video/v25.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/25.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("26")){
	    			String shipin2="video/v26.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/26.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("27")){
	    			String shipin2="video/v27.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/27.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("28")){
	    			String shipin2="video/v28.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/28.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("29")){
	    			String shipin2="video/v29.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/29.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("30")){
	    			String shipin2="video/v30.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/30.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("31")){
	    			String shipin2="video/v31.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/31.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("32")){
	    			String shipin2="video/v32.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/32.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("33")){
	    			String shipin2="video/v33.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/33.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("34")){
	    			String shipin2="video/v34.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/34.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("35")){
	    			String shipin2="video/v35.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/35.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("36")){
	    			String shipin2="video/v36.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/36.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("37")){
	    			String shipin2="video/v37.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/37.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("38")){
	    			String shipin2="video/v38.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/38.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("39")){
	    			String shipin2="video/v39.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/39.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("40")){
	    			String shipin2="video/v40.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/40.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("41")){
	    			String shipin2="video/v41.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/41.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("42")){
	    			String shipin2="video/v42.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/42.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("43")){
	    			String shipin2="video/v43.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/43.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("44")){
	    			String shipin2="video/v44.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/44.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("45")){
	    			String shipin2="video/v45.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/45.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("46")){
	    			String shipin2="video/v46.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/46.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("47")){
	    			String shipin2="video/v47.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/47.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("48")){
	    			String shipin2="video/v48.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/48.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("49")){
	    			String shipin2="video/v49.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/49.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("50")){
	    			String shipin2="video/v50.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/50.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("51")){
	    			String shipin2="video/v51.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/51.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("52")){
	    			String shipin2="video/v52.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/52.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("53")){
	    			String shipin2="video/v53.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/53.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("54")){
	    			String shipin2="video/v54.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/54.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("55")){
	    			String shipin2="video/v55.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/55.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("56")){
	    			String shipin2="video/v56.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/56.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("57")){
	    			String shipin2="video/v57.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/57.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("58")){
	    			String shipin2="video/v58.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/58.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("59")){
	    			String shipin2="video/v59.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/59.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("60")){
	    			String shipin2="video/v60.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/60.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("61")){
	    			String shipin2="video/v61.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/61.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("62")){
	    			String shipin2="video/v62.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/62.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
	    		if(sumitem2.equals("63")){
	    			String shipin2="video/v63.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
	    			String img2="img/video-fm/63.jpg";
	    			request.getSession().setAttribute("img2", img2);
	    		}
			
			
			//第三个视频和图片
			if(sumitem3 != null){
			
	    		if(sumitem3.equals("01")){
	    			String shipin3="video/v1.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/01.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("02")){
	    			String shipin3="video/v2.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/02.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("03")){
	    			String shipin3="video/v3.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/03.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("04")){
	    			String shipin3="video/v4.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/04.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("05")){
	    			String shipin3="video/v5.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/05.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("06")){
	    			String shipin3="video/v6.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/06.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("07")){
	    			String shipin3="video/v7.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/07.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("08")){
	    			String shipin3="video/v8.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/08.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("09")){
	    			String shipin3="video/v9.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/09.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("10")){
	    			String shipin3="video/v10.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/10.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("11")){
	    			String shipin3="video/v11.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/11.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("12")){
	    			String shipin3="video/v12.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/12.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("13")){
	    			String shipin3="video/v13.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/13.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("14")){
	    			String shipin3="video/v14.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/14.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("15")){
	    			String shipin3="video/v15.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/15.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("16")){
	    			String shipin3="video/v16.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/16.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("17")){
	    			String shipin3="video/v17.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/17.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("18")){
	    			String shipin3="video/v18.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/18.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("19")){
	    			String shipin3="video/v19.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/19.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("20")){
	    			String shipin3="video/v20.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/20.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("21")){
	    			String shipin3="video/v21.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/21.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("22")){
	    			String shipin3="video/v22.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/22.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("23")){
	    			String shipin3="video/v23.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/23.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("24")){
	    			String shipin3="video/v24.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/24.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("25")){
	    			String shipin3="video/v25.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/25.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("26")){
	    			String shipin3="video/v26.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/26.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("27")){
	    			String shipin3="video/v27.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/27.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("28")){
	    			String shipin3="video/v28.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/28.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("29")){
	    			String shipin3="video/v29.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/29.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("30")){
	    			String shipin3="video/v30.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/30.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("31")){
	    			String shipin3="video/v31.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/31.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("32")){
	    			String shipin3="video/v32.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/32.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("33")){
	    			String shipin3="video/v33.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/33.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("34")){
	    			String shipin3="video/v34.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/34.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("35")){
	    			String shipin3="video/v35.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/35.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("36")){
	    			String shipin3="video/v36.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/36.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("37")){
	    			String shipin3="video/v37.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/37.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("38")){
	    			String shipin3="video/v38.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/38.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("39")){
	    			String shipin3="video/v39.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/39.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("40")){
	    			String shipin3="video/v40.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/40.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("41")){
	    			String shipin3="video/v41.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/41.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("42")){
	    			String shipin3="video/v42.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/42.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("43")){
	    			String shipin3="video/v43.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/43.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("44")){
	    			String shipin3="video/v44.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/44.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("45")){
	    			String shipin3="video/v45.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/45.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("46")){
	    			String shipin3="video/v46.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/46.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("47")){
	    			String shipin3="video/v47.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/47.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("48")){
	    			String shipin3="video/v48.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/48.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("49")){
	    			String shipin3="video/v49.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/49.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("50")){
	    			String shipin3="video/v50.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/50.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("51")){
	    			String shipin3="video/v51.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/51.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("52")){
	    			String shipin3="video/v52.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/52.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("53")){
	    			String shipin3="video/v53.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/53.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("54")){
	    			String shipin3="video/v54.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/54.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("55")){
	    			String shipin3="video/v55.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/55.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("56")){
	    			String shipin3="video/v56.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/56.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("57")){
	    			String shipin3="video/v57.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/57.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("58")){
	    			String shipin3="video/v58.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/58.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("59")){
	    			String shipin3="video/v59.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/59.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("60")){
	    			String shipin3="video/v60.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/60.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("61")){
	    			String shipin3="video/v61.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/61.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("62")){
	    			String shipin3="video/v62.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/62.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
	    		if(sumitem3.equals("63")){
	    			String shipin3="video/v63.mp4";
	    			request.getSession().setAttribute("shipin3", shipin3);
	    			String img3="img/video-fm/63.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    		}
			}
			//第四个视频和图片
			if(sumitem4 != null){
				
	    		if(sumitem4.equals("01")){
	    			String shipin4="video/v1.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/01.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("02")){
	    			String shipin4="video/v2.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/02.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("03")){
	    			String shipin4="video/v3.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/03.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("04")){
	    			String shipin4="video/v4.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/04.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("05")){
	    			String shipin4="video/v5.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/05.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("06")){
	    			String shipin4="video/v6.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/06.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("07")){
	    			String shipin4="video/v7.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/07.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("08")){
	    			String shipin4="video/v8.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/08.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("09")){
	    			String shipin4="video/v9.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/09.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("10")){
	    			String shipin4="video/v10.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/10.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("11")){
	    			String shipin4="video/v11.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/11.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("12")){
	    			String shipin4="video/v12.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/12.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("13")){
	    			String shipin4="video/v13.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/13.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("14")){
	    			String shipin4="video/v14.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/14.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("15")){
	    			String shipin4="video/v15.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/15.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("16")){
	    			String shipin4="video/v16.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/16.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("17")){
	    			String shipin4="video/v17.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/17.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("18")){
	    			String shipin4="video/v18.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/18.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("19")){
	    			String shipin4="video/v19.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/19.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("20")){
	    			String shipin4="video/v20.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/20.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("21")){
	    			String shipin4="video/v21.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/21.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("22")){
	    			String shipin4="video/v22.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/22.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("23")){
	    			String shipin4="video/v23.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/23.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("24")){
	    			String shipin4="video/v24.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/24.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("25")){
	    			String shipin4="video/v25.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/25.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("26")){
	    			String shipin4="video/v26.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/26.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("27")){
	    			String shipin4="video/v27.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/27.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("28")){
	    			String shipin4="video/v28.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/28.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("29")){
	    			String shipin4="video/v29.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/29.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("30")){
	    			String shipin4="video/v30.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/30.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("31")){
	    			String shipin4="video/v31.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/31.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("32")){
	    			String shipin4="video/v32.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/32.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("33")){
	    			String shipin4="video/v33.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/33.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("34")){
	    			String shipin4="video/v34.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/34.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("35")){
	    			String shipin4="video/v35.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/35.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("36")){
	    			String shipin4="video/v36.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/36.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("37")){
	    			String shipin4="video/v37.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/37.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("38")){
	    			String shipin4="video/v38.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/38.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("39")){
	    			String shipin4="video/v39.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/39.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("40")){
	    			String shipin4="video/v40.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/40.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("41")){
	    			String shipin4="video/v41.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/41.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("42")){
	    			String shipin4="video/v42.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/42.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("43")){
	    			String shipin4="video/v43.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/43.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("44")){
	    			String shipin4="video/v44.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/44.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("45")){
	    			String shipin4="video/v45.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/45.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("46")){
	    			String shipin4="video/v46.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/46.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("47")){
	    			String shipin4="video/v47.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/47.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("48")){
	    			String shipin4="video/v48.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/48.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("49")){
	    			String shipin4="video/v49.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/49.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("50")){
	    			String shipin4="video/v50.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/50.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("51")){
	    			String shipin4="video/v51.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/51.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("52")){
	    			String shipin4="video/v52.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/52.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("53")){
	    			String shipin4="video/v53.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/53.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("54")){
	    			String shipin4="video/v54.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/54.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("55")){
	    			String shipin4="video/v55.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/55.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("56")){
	    			String shipin4="video/v56.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/56.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("57")){
	    			String shipin4="video/v57.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/57.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("58")){
	    			String shipin4="video/v58.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/58.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("59")){
	    			String shipin4="video/v59.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/59.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("60")){
	    			String shipin4="video/v60.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/60.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("61")){
	    			String shipin4="video/v61.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/61.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("62")){
	    			String shipin4="video/v62.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/62.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
	    		if(sumitem4.equals("63")){
	    			String shipin4="video/v63.mp4";
	    			request.getSession().setAttribute("shipin4", shipin4);
	    			String img4="img/video-fm/63.jpg";
	    			request.getSession().setAttribute("img4", img4);
	    		}
			}
			//--第五个视频和图片
			if(sumitem5 != null){
				
	    		if(sumitem5.equals("01")){
	    			String shipin5="video/v1.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/01.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("02")){
	    			String shipin5="video/v2.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/02.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("03")){
	    			String shipin5="video/v3.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/03.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("04")){
	    			String shipin5="video/v4.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/04.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("05")){
	    			String shipin5="video/v5.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/05.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("06")){
	    			String shipin5="video/v6.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/06.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("07")){
	    			String shipin5="video/v7.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/07.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("08")){
	    			String shipin5="video/v8.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/08.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("09")){
	    			String shipin5="video/v9.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/09.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("10")){
	    			String shipin5="video/v10.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/10.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("11")){
	    			String shipin5="video/v11.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/11.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("12")){
	    			String shipin5="video/v12.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/12.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("13")){
	    			String shipin5="video/v13.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/13.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("14")){
	    			String shipin5="video/v14.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/14.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("15")){
	    			String shipin5="video/v15.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/15.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("16")){
	    			String shipin5="video/v16.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/16.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("17")){
	    			String shipin5="video/v17.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/17.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("18")){
	    			String shipin5="video/v18.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/18.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("19")){
	    			String shipin5="video/v19.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/19.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("20")){
	    			String shipin5="video/v20.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/20.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("21")){
	    			String shipin5="video/v21.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/21.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("22")){
	    			String shipin5="video/v22.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/22.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("23")){
	    			String shipin5="video/v23.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/23.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("24")){
	    			String shipin5="video/v24.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/24.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("25")){
	    			String shipin5="video/v25.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/25.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("26")){
	    			String shipin5="video/v26.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/26.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("27")){
	    			String shipin5="video/v27.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/27.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("28")){
	    			String shipin5="video/v28.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/28.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("29")){
	    			String shipin5="video/v29.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/29.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("30")){
	    			String shipin5="video/v30.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/30.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("31")){
	    			String shipin5="video/v31.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/31.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("32")){
	    			String shipin5="video/v32.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/32.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("33")){
	    			String shipin5="video/v33.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/33.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("34")){
	    			String shipin5="video/v34.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/34.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("35")){
	    			String shipin5="video/v35.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/35.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("36")){
	    			String shipin5="video/v36.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/36.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("37")){
	    			String shipin5="video/v37.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/37.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("38")){
	    			String shipin5="video/v38.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/38.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("39")){
	    			String shipin5="video/v39.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/39.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("40")){
	    			String shipin5="video/v40.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/40.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("41")){
	    			String shipin5="video/v41.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/41.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("42")){
	    			String shipin5="video/v42.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/42.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("43")){
	    			String shipin5="video/v43.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/43.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("44")){
	    			String shipin5="video/v44.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/44.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("45")){
	    			String shipin5="video/v45.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/45.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("46")){
	    			String shipin5="video/v46.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/46.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("47")){
	    			String shipin5="video/v47.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/47.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("48")){
	    			String shipin5="video/v48.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/48.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("49")){
	    			String shipin5="video/v49.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/49.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("50")){
	    			String shipin5="video/v50.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/50.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("51")){
	    			String shipin5="video/v51.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/51.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("52")){
	    			String shipin5="video/v52.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/52.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("53")){
	    			String shipin5="video/v53.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/53.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("54")){
	    			String shipin5="video/v54.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/54.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("55")){
	    			String shipin5="video/v55.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/55.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("56")){
	    			String shipin5="video/v56.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/56.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("57")){
	    			String shipin5="video/v57.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/57.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("58")){
	    			String shipin5="video/v58.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/58.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("59")){
	    			String shipin5="video/v59.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/59.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("60")){
	    			String shipin5="video/v60.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/60.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("61")){
	    			String shipin5="video/v61.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/61.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("62")){
	    			String shipin5="video/v62.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/62.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
	    		if(sumitem5.equals("63")){
	    			String shipin5="video/v63.mp4";
	    			request.getSession().setAttribute("shipin5", shipin5);
	    			String img5="img/video-fm/63.jpg";
	    			request.getSession().setAttribute("img5", img5);
	    		}
		}
			//--第六个视频和图片
			if(sumitem6 != null){
				
	    		if(sumitem6.equals("01")){
	    			String shipin6="video/v1.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/01.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("02")){
	    			String shipin6="video/v2.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/02.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("03")){
	    			String shipin6="video/v3.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/03.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("04")){
	    			String shipin6="video/v4.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/04.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("05")){
	    			String shipin6="video/v5.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/05.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("06")){
	    			String shipin6="video/v6.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/06.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("07")){
	    			String shipin6="video/v7.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/07.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("08")){
	    			String shipin6="video/v8.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/08.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("09")){
	    			String shipin6="video/v9.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/09.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("10")){
	    			String shipin6="video/v10.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/10.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("11")){
	    			String shipin6="video/v11.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/11.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("12")){
	    			String shipin6="video/v12.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/12.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("13")){
	    			String shipin6="video/v13.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/13.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("14")){
	    			String shipin6="video/v14.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/14.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("15")){
	    			String shipin6="video/v15.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/15.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("16")){
	    			String shipin6="video/v16.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/16.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("17")){
	    			String shipin6="video/v17.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/17.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("18")){
	    			String shipin6="video/v18.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/18.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("19")){
	    			String shipin6="video/v19.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/19.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("20")){
	    			String shipin6="video/v20.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/20.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("21")){
	    			String shipin6="video/v21.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/21.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("22")){
	    			String shipin6="video/v22.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/22.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("23")){
	    			String shipin6="video/v23.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/23.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("24")){
	    			String shipin6="video/v24.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/24.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("25")){
	    			String shipin6="video/v25.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/25.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("26")){
	    			String shipin6="video/v26.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/26.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("27")){
	    			String shipin6="video/v27.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/27.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("28")){
	    			String shipin6="video/v28.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/28.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("29")){
	    			String shipin6="video/v29.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/29.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("30")){
	    			String shipin6="video/v30.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/30.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("31")){
	    			String shipin6="video/v31.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/31.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("32")){
	    			String shipin6="video/v32.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/32.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("33")){
	    			String shipin6="video/v33.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/33.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("34")){
	    			String shipin6="video/v34.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/34.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("35")){
	    			String shipin6="video/v35.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/35.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("36")){
	    			String shipin6="video/v36.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/36.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("37")){
	    			String shipin6="video/v37.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/37.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("38")){
	    			String shipin6="video/v38.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/38.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("39")){
	    			String shipin6="video/v39.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/39.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("40")){
	    			String shipin6="video/v40.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/40.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("41")){
	    			String shipin6="video/v41.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/41.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("42")){
	    			String shipin6="video/v42.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/42.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("43")){
	    			String shipin6="video/v43.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/43.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("44")){
	    			String shipin6="video/v44.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/44.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("45")){
	    			String shipin6="video/v45.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/45.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("46")){
	    			String shipin6="video/v46.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/46.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("47")){
	    			String shipin6="video/v47.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/47.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("48")){
	    			String shipin6="video/v48.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/48.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("49")){
	    			String shipin6="video/v49.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/49.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("50")){
	    			String shipin6="video/v50.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/50.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("51")){
	    			String shipin6="video/v51.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/51.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("52")){
	    			String shipin6="video/v52.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/52.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("53")){
	    			String shipin6="video/v53.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/53.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("54")){
	    			String shipin6="video/v54.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/54.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("55")){
	    			String shipin6="video/v55.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/55.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("56")){
	    			String shipin6="video/v56.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/56.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("57")){
	    			String shipin6="video/v57.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/57.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("58")){
	    			String shipin6="video/v58.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/58.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("59")){
	    			String shipin6="video/v59.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/59.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("60")){
	    			String shipin6="video/v60.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/60.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("61")){
	    			String shipin6="video/v61.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/61.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("62")){
	    			String shipin6="video/v62.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/62.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
	    		if(sumitem6.equals("63")){
	    			String shipin6="video/v63.mp4";
	    			request.getSession().setAttribute("shipin6", shipin6);
	    			String img6="img/video-fm/63.jpg";
	    			request.getSession().setAttribute("img6", img6);
	    		}
		}
			//--第七个视频和图片
			if(sumitem7 != null){
				
	    		if(sumitem7.equals("01")){
	    			String shipin7="video/v1.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/01.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("02")){
	    			String shipin7="video/v2.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/02.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("03")){
	    			String shipin7="video/v3.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/03.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("04")){
	    			String shipin7="video/v4.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/04.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("05")){
	    			String shipin7="video/v5.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/05.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("06")){
	    			String shipin7="video/v6.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/06.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("07")){
	    			String shipin7="video/v7.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/07.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("08")){
	    			String shipin7="video/v8.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/08.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("09")){
	    			String shipin7="video/v9.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/09.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("10")){
	    			String shipin7="video/v10.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/10.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("11")){
	    			String shipin7="video/v11.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/11.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("12")){
	    			String shipin7="video/v12.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/12.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("13")){
	    			String shipin7="video/v13.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/13.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("14")){
	    			String shipin7="video/v14.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/14.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("15")){
	    			String shipin7="video/v15.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/15.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("16")){
	    			String shipin7="video/v16.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/16.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("17")){
	    			String shipin7="video/v17.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/17.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("18")){
	    			String shipin7="video/v18.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/18.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("19")){
	    			String shipin7="video/v19.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/19.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("20")){
	    			String shipin7="video/v20.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/20.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("21")){
	    			String shipin7="video/v21.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/21.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("22")){
	    			String shipin7="video/v22.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/22.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("23")){
	    			String shipin7="video/v23.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/23.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("24")){
	    			String shipin7="video/v24.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/24.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("25")){
	    			String shipin7="video/v25.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/25.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("26")){
	    			String shipin7="video/v26.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/26.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("27")){
	    			String shipin7="video/v27.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/27.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("28")){
	    			String shipin7="video/v28.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/28.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("29")){
	    			String shipin7="video/v29.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/29.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("30")){
	    			String shipin7="video/v30.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/30.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("31")){
	    			String shipin7="video/v31.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/31.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("32")){
	    			String shipin7="video/v32.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/32.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("33")){
	    			String shipin7="video/v33.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/33.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("34")){
	    			String shipin7="video/v34.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/34.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("35")){
	    			String shipin7="video/v35.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/35.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("36")){
	    			String shipin7="video/v36.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/36.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("37")){
	    			String shipin7="video/v37.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/37.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("38")){
	    			String shipin7="video/v38.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/38.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("39")){
	    			String shipin7="video/v39.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/39.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("40")){
	    			String shipin7="video/v40.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/40.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("41")){
	    			String shipin7="video/v41.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/41.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("42")){
	    			String shipin7="video/v42.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/42.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("43")){
	    			String shipin7="video/v43.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/43.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("44")){
	    			String shipin7="video/v44.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/44.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("45")){
	    			String shipin7="video/v45.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/45.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("46")){
	    			String shipin7="video/v46.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/46.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("47")){
	    			String shipin7="video/v47.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/47.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("48")){
	    			String shipin7="video/v48.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/48.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("49")){
	    			String shipin7="video/v49.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/49.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("50")){
	    			String shipin7="video/v50.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/50.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("51")){
	    			String shipin7="video/v51.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/51.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("52")){
	    			String shipin7="video/v52.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/52.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("53")){
	    			String shipin7="video/v53.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/53.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("54")){
	    			String shipin7="video/v54.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/54.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("55")){
	    			String shipin7="video/v55.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/55.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("56")){
	    			String shipin7="video/v56.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/56.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("57")){
	    			String shipin7="video/v57.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/57.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("58")){
	    			String shipin7="video/v58.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/58.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("59")){
	    			String shipin7="video/v59.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/59.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("60")){
	    			String shipin7="video/v60.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/60.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("61")){
	    			String shipin7="video/v61.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/61.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("62")){
	    			String shipin7="video/v62.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/62.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
	    		if(sumitem7.equals("63")){
	    			String shipin7="video/v63.mp4";
	    			request.getSession().setAttribute("shipin7", shipin7);
	    			String img7="img/video-fm/63.jpg";
	    			request.getSession().setAttribute("img7", img7);
	    		}
		}
	    			//根据穴位判断用哪些视频结束
				//截取结果中的穴位代码结束
			//余额判断开始
			int uid=user.getUserid();
			FenbuDao fenbu=new FenbuDaoImpl();
			List<Money> usidlist=fenbu.getUserid(uid);
			int numbers=usidlist.get(0).getNumbers();
			request.getSession().setAttribute("numbers", numbers);
			if(numbers>0){
				numbers=numbers-1;
				int intnumb=fenbu.updateNumber(uid,numbers);
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("alert('添加成功！');");
				out.println("window.location.href=\"planDetial.jsp\"");
				out.println("</script>");
			}else{
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("alert('余额不足，请及时充值！');");
				out.println("window.location.href=\"login.jsp\"");
				out.println("</script>");
			}
			//余额判断结束
				
//				}
//				}
			} else {
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("window.location.href=\"xuanzejiemian.jsp\"");
				out.println("</script>");
			}
			
		} catch(Exception e) {
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("window.location.href=\"xuanzejiemian.jsp\"");
			out.println("</script>");
		}
		out.close();
	}

}
