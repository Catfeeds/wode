/**
 * 
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Patient;
import com.bean.Record;
import com.bean.User;
import com.bean.Zhuyi;
import com.dao.PatientDao;
import com.dao.RecordDao;
import com.dao.ZhuyiDao;
import com.dao.impl.PatientDaoImpl;
import com.dao.impl.RecordDaoImpl;
import com.dao.impl.ZhuyiDaoImpl;

/**
 * @author 石可旺
 *
 */
public class RecordShowServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		doPost(request,response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取系统时间
		Date dt=new Date();//如果不需要格式,可直接用dt,dt就是当前系统时间
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置显示格式
		String nowTime="";
		nowTime= df.format(dt);//用DateFormat的format()方法在dt中获取并以yyyy/MM/dd HH:mm:ss格式显示
		System.out.println(nowTime);
		PrintWriter out=response.getWriter();
		
		String pid=request.getParameter("pid");
		String rid=request.getParameter("rid");
		Object us=request.getSession().getAttribute("user");
		User user=(User)us;
		int ipid=0;
		if(user != null){
			
			if(pid != null){
				ipid=Integer.parseInt(pid);
			Patient pient= new Patient();
			//从patient表和record表中查询结果页的所需字段
			PatientDao patientdao=new PatientDaoImpl();
			RecordDao recorddao=new RecordDaoImpl();
			Patient paentlist=patientdao.getPatientById(ipid);
			Record  recordlist=recorddao.getRecordsShow(rid);
			ZhuyiDao zhuyiDao=new ZhuyiDaoImpl();
			String zhuyis=recordlist.getDyzy();
			Zhuyi zhuyi=zhuyiDao.getZhuyi(zhuyis);
			
			String pname=paentlist.getPname();
			String chufang=recordlist.getDycf();
			String shoufa=recordlist.getDysf();
			String str2=recordlist.getDyzz();
			String pborn=recordlist.getCtime();
			String hulizhuyi=zhuyi.getZhuyi();
			String age=paentlist.getPage();
			
			request.getSession().setAttribute("pid",pid);
			request.getSession().setAttribute("pname",pname);
			request.getSession().setAttribute("chufang",chufang);
			request.getSession().setAttribute("shoufa",shoufa);
			request.getSession().setAttribute("str2",str2);
			request.getSession().setAttribute("pborn",pborn);
			request.getSession().setAttribute("hulizhuyi",hulizhuyi);
			request.getSession().setAttribute("nowTime",nowTime);
			request.getSession().setAttribute("age",age);
			
			
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
				zzxw=xuewei[0].toString().trim();
				miansexw=xuewei[1].toString().trim();
			}
			
			if(xuewei.length==3){
				zzxw=xuewei[0].toString().trim();
				miansexw=xuewei[1].toString().trim();
				xydxw=xuewei[2].toString().trim();
			}
			
			if(xuewei.length==4){
				zzxw=xuewei[0].toString().trim();
				miansexw=xuewei[1].toString().trim();
				xydxw=xuewei[2].toString().trim();
				chunsexw=xuewei[3].toString().trim();
			}
			
			if(xuewei.length==5){
				zzxw=xuewei[0].toString().trim();
				miansexw=xuewei[1].toString().trim();
				xydxw=xuewei[2].toString().trim();
				chunsexw=xuewei[3].toString().trim();
				shetixw=xuewei[4].toString().trim();
			}
			
			if(xuewei.length==6){
				zzxw=xuewei[0].toString().trim();
				miansexw=xuewei[1].toString().trim();
				xydxw=xuewei[2].toString().trim();
				chunsexw=xuewei[3].toString().trim();
				shetixw=xuewei[4].toString().trim();
				shezhixw=xuewei[5].toString().trim();
			}
			
			if(xuewei.length==7){
				zzxw=xuewei[0].toString().trim();
				miansexw=xuewei[1].toString().trim();
				xydxw=xuewei[2].toString().trim();
				chunsexw=xuewei[3].toString().trim();
				shetixw=xuewei[4].toString().trim();
				shezhixw=xuewei[5].toString().trim();
				shetaixw=xuewei[6].toString().trim();
			}
			
			String xwqingbu1="";
			String xwqingbu2="";
			String xwqingbu3="";
			
			String cishu1="";
			String cishu2="";
			String cishu3="";
			
			
			//判断穴位1
			if(zzxw != null||zzxw!=""||zzxw!=" "){
				
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
		            String item2st=String.valueOf(item2);
		            String item3st=String.valueOf(item3);
		            String item4st=String.valueOf(item4);
		            
		            sumitem1=item0st+item1st;
		            cishu1=item2st+item3st+item4st;
		            xwqingbu1="揉";
					
		            request.getSession().setAttribute("cishu1", cishu1);
		            request.getSession().setAttribute("xwqingbu1", xwqingbu1);
		            request.getSession().setAttribute("sumitem1", sumitem1);
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
					char  item5= zzxw .charAt(5);
					System.out.println("item5---------"+item5);
					
					String item1st=String.valueOf(item1);
		            String item2st=String.valueOf(item2);
		            String item3st=String.valueOf(item3);
		            String item4st=String.valueOf(item4);
		            String item5st=String.valueOf(item5);
		            
		            String fuhao1=String.valueOf(item0);
		            sumitem1=item1st+item2st;
		            cishu1=item3st+item4st+item5st;
		            
		            if(fuhao1=="+"||fuhao1.equals("+")){
		            	xwqingbu1="补";
		            }else{
		            	xwqingbu1="清";
		            }
		            
		            request.getSession().setAttribute("cishu1", cishu1);
		            request.getSession().setAttribute("xwqingbu1", xwqingbu1);
					 request.getSession().setAttribute("sumitem1", sumitem1);
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
					char  item5= zzxw .charAt(5);
					System.out.println("item5---------"+item5);
					char  item6= zzxw .charAt(6);
					System.out.println("item6---------"+item6);
					
					String item2st=String.valueOf(item2);
		            String item3st=String.valueOf(item3);
		            String item4st=String.valueOf(item4);
		            String item5st=String.valueOf(item5);
		            String item6st=String.valueOf(item6);
		            sumitem1=item2st+item3st;
		            cishu1=item4st+item5st+item6st;
					
		            xwqingbu1="清补";
		            
		            request.getSession().setAttribute("cishu1", cishu1);
		            request.getSession().setAttribute("xwqingbu1", xwqingbu1);
					 request.getSession().setAttribute("sumitem1", sumitem1);
					}
				}
			
//			判断穴位2
			if(miansexw != null||miansexw!=""||miansexw!=" "){
			
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
	            String item2st=String.valueOf(item2);
	            String item3st=String.valueOf(item3);
	            String item4st=String.valueOf(item4);
	            sumitem2=item0st+item1st;
	            cishu2=item2st+item3st+item4st;
				
	            xwqingbu2="揉";
	            request.getSession().setAttribute("cishu2", cishu2);
	            request.getSession().setAttribute("xwqingbu2", xwqingbu2);
				request.getSession().setAttribute("sumitem2", sumitem2);
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
				char  item5= miansexw .charAt(5);
				System.out.println("item5---------"+item5);
				
				String item1st=String.valueOf(item1);
	            String item2st=String.valueOf(item2);
	            String item3st=String.valueOf(item3);
	            String item4st=String.valueOf(item4);
	            String item5st=String.valueOf(item5);
	            sumitem2=item1st+item2st;
	            cishu2=item3st+item4st+item5st;
				
	            String fuhao2=String.valueOf(item0);
	            if(fuhao2=="+"||fuhao2.equals("+")){
	            	xwqingbu2="补";
	            }else{
	            	xwqingbu2="清";
	            }
	            request.getSession().setAttribute("cishu2", cishu2);
	            request.getSession().setAttribute("xwqingbu2", xwqingbu2);
				 request.getSession().setAttribute("sumitem2", sumitem2);
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
				char  item5= miansexw .charAt(5);
				System.out.println("item5---------"+item5);
				char  item6= miansexw .charAt(6);
				System.out.println("item6---------"+item6);
				
				String item2st=String.valueOf(item2);
	            String item3st=String.valueOf(item3);
	            String item4st=String.valueOf(item4);
	            String item5st=String.valueOf(item5);
	            String item6st=String.valueOf(item6);
	            sumitem2=item2st+item3st;
	            cishu2=item4st+item5st+item6st;
				
	            xwqingbu2="清补";
	            request.getSession().setAttribute("cishu2", cishu2);
	            request.getSession().setAttribute("xwqingbu2", xwqingbu2);
				request.getSession().setAttribute("sumitem2", sumitem2);
			}
			}
			
//			判断穴位3
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
		            String item2st=String.valueOf(item2);
		            String item3st=String.valueOf(item3);
		            String item4st=String.valueOf(item4);
		            sumitem3=item0st+item1st;
		            cishu3=item2st+item3st+item4st;
					
		            xwqingbu3="揉";
		            request.getSession().setAttribute("cishu3", cishu3);
		            request.getSession().setAttribute("xwqingbu3", xwqingbu3);
					request.getSession().setAttribute("sumitem3", sumitem3);
					 System.out.println("穴位==5--------------"+sumitem3);
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
					char  item5= xydxw.charAt(5);
					System.out.println("item5---------"+item5);
					
					String item1st=String.valueOf(item1);
		            String item2st=String.valueOf(item2);
		            String item3st=String.valueOf(item3);
		            String item4st=String.valueOf(item4);
		            String item5st=String.valueOf(item5);
		            
		            sumitem3=item1st+item2st;
		            cishu3=item3st+item4st+item5st;
					
		            String fuhao3=String.valueOf(item0);
		            if(fuhao3=="+"||fuhao3.equals("+")){
		            	xwqingbu3="补";
		            }else{
		            	xwqingbu3="清";
		            }
		            request.getSession().setAttribute("cishu3", cishu3);
		            request.getSession().setAttribute("xwqingbu3", xwqingbu3);
					request.getSession().setAttribute("sumitem3", sumitem3);
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
					char  item5= xydxw.charAt(5);
					System.out.println("item5---------"+item5);
					char  item6= xydxw.charAt(6);
					System.out.println("item6---------"+item6);
					
					String item2st=String.valueOf(item2);
		            String item3st=String.valueOf(item3);
		            String item4st=String.valueOf(item4);
		            String item5st=String.valueOf(item5);
		            String item6st=String.valueOf(item6);
		            sumitem3=item2st+item3st;
		            cishu3=item4st+item5st+item6st;
		            
		            xwqingbu3="清补";
		            
		            request.getSession().setAttribute("cishu3", cishu3);
		            request.getSession().setAttribute("xwqingbu3", xwqingbu3);
					request.getSession().setAttribute("sumitem3", sumitem3);
				}
			}
				//判断穴位4
//				if(chunsexw != null||chunsexw!=""||chunsexw!=" "){
//				if(chunsexw.trim().length()==5){
//					char  item0= chunsexw.charAt(0);
//					System.out.println("item0---------"+item0);
//					char  item1= chunsexw.charAt(1);
//					System.out.println("item1---------"+item1);
//					char  item2= chunsexw.charAt(2);
//					System.out.println("item2---------"+item2);
//					char  item3= chunsexw.charAt(3);
//					System.out.println("item3---------"+item3);
//					char  item4= chunsexw.charAt(4);
//					System.out.println("item4---------"+item4);
//					
//					String item0st=String.valueOf(item0);
//		            String item1st=String.valueOf(item1);
//		            sumitem4=item0st+item1st;
//					
//					 request.getSession().setAttribute("sumitem4", sumitem4);
//				}else if(chunsexw.trim().length()==6){
//					char  item0= chunsexw.charAt(0);
//					System.out.println("item0---------"+item0);
//					char  item1= chunsexw.charAt(1);
//					System.out.println("item1---------"+item1);
//					char  item2= chunsexw.charAt(2);
//					System.out.println("item2---------"+item2);
//					char  item3= chunsexw.charAt(3);
//					System.out.println("item3---------"+item3);
//					char  item4= chunsexw.charAt(4);
//					System.out.println("item4---------"+item4);
//					
//					String item1st=String.valueOf(item1);
//		            String item2st=String.valueOf(item2);
//		            sumitem4=item1st+item2st;
//					
//					 request.getSession().setAttribute("sumitem4", sumitem4);
//				}else if(chunsexw.trim().length()==7){
//					char  item0= chunsexw.charAt(0);
//					System.out.println("item0---------"+item0);
//					char  item1= chunsexw.charAt(1);
//					System.out.println("item1---------"+item1);
//					char  item2= chunsexw.charAt(2);
//					System.out.println("item2---------"+item2);
//					char  item3= chunsexw.charAt(3);
//					System.out.println("item3---------"+item3);
//					char  item4= chunsexw.charAt(4);
//					System.out.println("item4---------"+item4);
//					
//					String item2st=String.valueOf(item2);
//		            String item3st=String.valueOf(item3);
//		            sumitem4=item2st+item3st;
//					
//					 request.getSession().setAttribute("sumitem4", sumitem4);
//				}
//			}
				//判断穴位5
//			if(shetixw != null||shetixw!=""||shetixw!=" "){
//				if(shetixw.trim().length()==5){
//					char  item0= shetixw.charAt(0);
//					System.out.println("item0---------"+item0);
//					char  item1= shetixw.charAt(1);
//					System.out.println("item1---------"+item1);
//					char  item2= shetixw.charAt(2);
//					System.out.println("item2---------"+item2);
//					char  item3= shetixw.charAt(3);
//					System.out.println("item3---------"+item3);
//					char  item4= shetixw.charAt(4);
//					System.out.println("item4---------"+item4);
//					
//					String item0st=String.valueOf(item0);
//		            String item1st=String.valueOf(item1);
//		            sumitem5=item0st+item1st;
//					
//					 request.getSession().setAttribute("sumitem5", sumitem5);
//				}else if(shetixw.trim().length()==6){
//					char  item0= shetixw.charAt(0);
//					System.out.println("item0---------"+item0);
//					char  item1= shetixw.charAt(1);
//					System.out.println("item1---------"+item1);
//					char  item2= shetixw.charAt(2);
//					System.out.println("item2---------"+item2);
//					char  item3= shetixw.charAt(3);
//					System.out.println("item3---------"+item3);
//					char  item4= shetixw.charAt(4);
//					System.out.println("item4---------"+item4);
//					
//					String item1st=String.valueOf(item1);
//		            String item2st=String.valueOf(item2);
//		            sumitem5=item1st+item2st;
//					
//					 request.getSession().setAttribute("sumitem5", sumitem5);
//				}else if(shetixw.trim().length()==7){
//					char  item0= shetixw.charAt(0);
//					System.out.println("item0---------"+item0);
//					char  item1= shetixw.charAt(1);
//					System.out.println("item1---------"+item1);
//					char  item2= shetixw.charAt(2);
//					System.out.println("item2---------"+item2);
//					char  item3= shetixw.charAt(3);
//					System.out.println("item3---------"+item3);
//					char  item4= shetixw.charAt(4);
//					System.out.println("item4---------"+item4);
//					
//					String item2st=String.valueOf(item2);
//		            String item3st=String.valueOf(item3);
//		            sumitem5=item2st+item3st;
//					
//					 request.getSession().setAttribute("sumitem5", sumitem5);
//				}
//			}
				//判断穴位6
//			if(shezhixw != null||shezhixw!=""||shezhixw!=" "){
//				if(shezhixw.trim().length()==5){
//					char  item0= shezhixw.charAt(0);
//					System.out.println("item0---------"+item0);
//					char  item1= shezhixw.charAt(1);
//					System.out.println("item1---------"+item1);
//					char  item2= shezhixw.charAt(2);
//					System.out.println("item2---------"+item2);
//					char  item3= shezhixw.charAt(3);
//					System.out.println("item3---------"+item3);
//					char  item4= shezhixw.charAt(4);
//					System.out.println("item4---------"+item4);
//					
//					String item0st=String.valueOf(item0);
//		            String item1st=String.valueOf(item1);
//		            sumitem6=item0st+item1st;
//					
//					 request.getSession().setAttribute("sumitem6", sumitem6);
//				}else if(shezhixw.trim().length()==6){
//					char  item0= shezhixw.charAt(0);
//					System.out.println("item0---------"+item0);
//					char  item1= shezhixw.charAt(1);
//					System.out.println("item1---------"+item1);
//					char  item2= shezhixw.charAt(2);
//					System.out.println("item2---------"+item2);
//					char  item3= shezhixw.charAt(3);
//					System.out.println("item3---------"+item3);
//					char  item4= shezhixw.charAt(4);
//					System.out.println("item4---------"+item4);
//					
//					String item1st=String.valueOf(item1);
//		            String item2st=String.valueOf(item2);
//		            sumitem6=item1st+item2st;
//					
//					 request.getSession().setAttribute("sumitem6", sumitem6);
//				}else if(shezhixw.trim().length()==7){
//					char  item0= shezhixw.charAt(0);
//					System.out.println("item0---------"+item0);
//					char  item1= shezhixw.charAt(1);
//					System.out.println("item1---------"+item1);
//					char  item2= shezhixw.charAt(2);
//					System.out.println("item2---------"+item2);
//					char  item3= shezhixw.charAt(3);
//					System.out.println("item3---------"+item3);
//					char  item4= shezhixw.charAt(4);
//					System.out.println("item4---------"+item4);
//					
//					String item2st=String.valueOf(item2);
//		            String item3st=String.valueOf(item3);
//		            sumitem6=item2st+item3st;
//					
//					 request.getSession().setAttribute("sumitem6", sumitem6);
//				}
//			}
				//判断穴位7
//			if(shetaixw != null||shetaixw!=""||shetaixw!=" "){
//				if(shetaixw.trim().length()==5){
//					char  item0= shetaixw.charAt(0);
//					System.out.println("item0---------"+item0);
//					char  item1= shetaixw.charAt(1);
//					System.out.println("item1---------"+item1);
//					char  item2= shetaixw.charAt(2);
//					System.out.println("item2---------"+item2);
//					char  item3= shetaixw.charAt(3);
//					System.out.println("item3---------"+item3);
//					char  item4= shetaixw.charAt(4);
//					System.out.println("item4---------"+item4);
//					
//					String item0st=String.valueOf(item0);
//		            String item1st=String.valueOf(item1);
//		            sumitem7=item0st+item1st;
//					
//					 request.getSession().setAttribute("sumitem7", sumitem7);
//				}else if(shetaixw.trim().length()==6){
//					char  item0= shetaixw.charAt(0);
//					System.out.println("item0---------"+item0);
//					char  item1= shetaixw.charAt(1);
//					System.out.println("item1---------"+item1);
//					char  item2= shetaixw.charAt(2);
//					System.out.println("item2---------"+item2);
//					char  item3= shetaixw.charAt(3);
//					System.out.println("item3---------"+item3);
//					char  item4= shetaixw.charAt(4);
//					System.out.println("item4---------"+item4);
//					
//					String item1st=String.valueOf(item1);
//		            String item2st=String.valueOf(item2);
//		            sumitem7=item1st+item2st;
//					
//					 request.getSession().setAttribute("sumitem7", sumitem7);
//				}else if(shetaixw.trim().length()==7){
//					char  item0= shetaixw.charAt(0);
//					System.out.println("item0---------"+item0);
//					char  item1= shetaixw.charAt(1);
//					System.out.println("item1---------"+item1);
//					char  item2= shetaixw.charAt(2);
//					System.out.println("item2---------"+item2);
//					char  item3= shetaixw.charAt(3);
//					System.out.println("item3---------"+item3);
//					char  item4= shetaixw.charAt(4);
//					System.out.println("item4---------"+item4);
//					
//					String item2st=String.valueOf(item2);
//		            String item3st=String.valueOf(item3);
//		            sumitem7=item2st+item3st;
//					
//					 request.getSession().setAttribute("sumitem7", sumitem7);
//				}
//			}
			
			//截取穴位结束
			//根据穴位判断用哪些视频开始
			
			//第一个视频和图片
			
    		if(sumitem1.equals("01")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
		    			String shipin1="video/v1-1.mp4";
		    			request.getSession().setAttribute("shipin1", shipin1);
	    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
	    				String shipin1="video/v1-2.mp4";
		    			request.getSession().setAttribute("shipin1", shipin1);
	    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
	    				String shipin1="video/v1-3.mp4";
		    			request.getSession().setAttribute("shipin1", shipin1);
	    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
	    				String shipin1="video/v1-4.mp4";
		    			request.getSession().setAttribute("shipin1", shipin1);
	    			}
    			String img1="img/video-fm/01.jpg";
    			String xwmingcheng1="吉祥穴";
    			String xuewei1="img/tn/1.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    			request.getSession().setAttribute("img1", img1);
    		}
    		if(sumitem1.equals("02")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v2-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v2-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v2-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v2-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/02.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="如意穴";
    			String xuewei1="img/tn/2.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("03")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v3-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v3-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v3-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v3-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/03.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="一窝蜂穴";
    			String xuewei1="img/tn/3.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("04")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v4-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v4-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v4-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v4-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/04.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="新一扇门穴";
    			String xuewei1="img/tn/4.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("05")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v5-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v5-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v5-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v5-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/05.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="感冒点穴";
    			String xuewei1="img/tn/5.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("06")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v6-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v6-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v6-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v6-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/06.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="清热点穴";
    			String xuewei1="img/tn/6.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("07")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v7-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v7-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v7-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v7-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/07.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="外关穴";
    			String xuewei1="img/tn/7.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("08")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v8-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v8-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v8-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v8-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/08.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="阳明穴";
    			String xuewei1="img/tn/8.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("09")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v9-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v9-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v9-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v9-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/09.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="大肠点穴";
    			String xuewei1="img/tn/9.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("10")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v10-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v10-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v10-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v10-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/10.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="阳池穴";
    			String xuewei1="img/tn/10.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("11")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v11-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v11-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v11-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v11-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/11.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="泰山穴";
    			String xuewei1="img/tn/11.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("12")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v12-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v12-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v12-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v12-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/12.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="板门穴";
    			String xuewei1="img/tn/12.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("13")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v13-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v13-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v13-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v13-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/13.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="咽喉点穴";
    			String xuewei1="img/tn/13.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("14")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v14-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v14-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v14-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v14-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/14.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="灵泉穴";
    			String xuewei1="img/tn/14.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("15")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v15-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v15-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v15-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v15-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/15.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="大肠穴";
    			String xuewei1="img/tn/15.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("16")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v16-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v16-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v16-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v16-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/16.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="鼻出血点穴";
    			String xuewei1="img/tn/16.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("17")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v17-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v17-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v17-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v17-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/17.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="合谷穴";
    			String xuewei1="img/tn/17.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("18")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v18-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v18-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v18-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v18-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/18.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="脾经穴";
    			String xuewei1="img/tn/18.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("19")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v19-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v19-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v19-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v19-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/19.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="二马穴";
    			String xuewei1="img/tn/19.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("20")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v20-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v20-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v20-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v20-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/20.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="头痛点穴";
    			String xuewei1="img/tn/20.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("21")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v21-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v21-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v21-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v21-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/21.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="脾点穴";
    			String xuewei1="img/tn/21.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("22")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v22-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v22-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v22-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v22-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/22.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="液门穴";
    			String xuewei1="img/tn/22.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("23")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v23-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v23-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v23-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v23-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/23.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="肝点穴";
    			String xuewei1="img/tn/23.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("24")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v24-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v24-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v24-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v24-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/24.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="外劳宫穴";
    			String xuewei1="img/tn/24.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("25")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v25-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v25-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v25-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v25-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/25.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="胃经穴";
    			String xuewei1="img/tn/25.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("26")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v26-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v26-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v26-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v26-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/26.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="扁桃体点穴";
    			String xuewei1="img/tn/26.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("27")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v27-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v27-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v27-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v27-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/27.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="膈点穴";
    			String xuewei1="img/tn/27.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("28")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v28-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v28-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v28-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v28-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/28.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="总筋穴";
    			String xuewei1="img/tn/28.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("29")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v29-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v29-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v29-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v29-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/29.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="内劳宫穴";
    			String xuewei1="img/tn/29.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("30")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v30-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v30-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v30-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v30-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/30.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="掌小横纹穴";
    			String xuewei1="img/tn/30.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("31")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v31-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v31-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v31-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v31-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/31.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="小肠穴";
    			String xuewei1="img/tn/31.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("32")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v32-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v32-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v32-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v32-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/32.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="小天心穴";
    			String xuewei1="img/tn/32.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("33")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v33-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v33-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v33-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v33-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/33.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="夜尿穴";
    			String xuewei1="img/tn/33.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("34")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v34-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v34-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v34-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v34-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/34.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="上焦穴";
    			String xuewei1="img/tn/34.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("35")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v35-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v35-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v35-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v35-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/35.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="肾顶穴";
    			String xuewei1="img/tn/35.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("36")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v36-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v36-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v36-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v36-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/36.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="内关穴";
    			String xuewei1="img/tn/36.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("37")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v37-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v37-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v37-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v37-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/37.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="三焦穴";
    			String xuewei1="img/tn/37.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("38")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v38-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v38-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v38-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v38-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/38.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="小肠点穴";
    			String xuewei1="img/tn/38.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("39")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v39-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v39-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v39-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v39-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/39.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="肝经穴";
    			String xuewei1="img/tn/39.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("40")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v40-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v40-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v40-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v40-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/40.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="心经穴";
    			String xuewei1="img/tn/40.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("41")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
    				System.out.println("肺经穴位-----揉-----"+sumitem1);
	    			String shipin1="video/v41-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				System.out.println("肺经穴位-----清-----"+sumitem1);
    				String shipin1="video/v41-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				System.out.println("肺经穴位-----补-----"+sumitem1);
    				String shipin1="video/v41-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				System.out.println("肺经穴位-----清补-----"+sumitem1);
    				String shipin1="video/v41-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/41.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="肺经穴";
    			String xuewei1="img/tn/41.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("42")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v42-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v42-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v42-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v42-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/42.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="肾经穴";
    			String xuewei1="img/tn/42.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("43")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v43-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v43-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v43-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v43-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/43.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="肾纹穴";
    			String xuewei1="img/tn/43.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("44")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v44-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v44-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v44-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v44-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/44.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="四横纹穴";
    			String xuewei1="img/tn/44.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("45")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v45-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v45-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v45-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v45-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/45.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="内八卦穴";
    			String xuewei1="img/tn/45.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("46")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v46-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v46-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v46-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v46-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/46.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="运水入土穴";
    			String xuewei1="img/tn/46.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("47")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v47-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v47-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v47-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v47-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/47.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="阴池穴";
    			String xuewei1="img/tn/47.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("48")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v48-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v48-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v48-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v48-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/48.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="咳喘穴";
    			String xuewei1="img/tn/48.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("49")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v49-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v49-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v49-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v49-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/49.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="胃肠痛穴";
    			String xuewei1="img/tn/49.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("50")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v50-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v50-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v50-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v50-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/50.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="命门穴";
    			String xuewei1="img/tn/50.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("51")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v51-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v51-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v51-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v51-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/51.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="一扇门穴";
    			String xuewei1="img/tn/51.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("52")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v52-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v52-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v52-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v52-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/52.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="两扇门穴";
    			String xuewei1="img/tn/52.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("53")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v53-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v53-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v53-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v53-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/53.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="十宣穴";
    			String xuewei1="img/tn/53.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("54")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v54-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v54-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v54-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v54-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/54.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="五指节穴";
    			String xuewei1="img/tn/54.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("55")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v55-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v55-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v55-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v55-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/55.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="外八卦穴";
    			String xuewei1="img/tn/5.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("56")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v56-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v56-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v56-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v56-4.mp4";
    				String xuewei1="img/tn/56.png";
	    			request.getSession().setAttribute("xuewei1", xuewei1);
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/56.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="列缺穴";
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("57")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v57-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v57-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v57-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v57-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/57.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="三关穴";
    			String xuewei1="img/tn/57.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("58")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v58-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v58-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v58-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v58-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/58.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="六腑穴";
    			String xuewei1="img/tn/58.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("59")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v59-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v59-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v59-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v59-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/59.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="天河水穴";
    			String xuewei1="img/tn/59.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("60")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v60-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v60-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v60-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v60-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/60.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="威灵穴";
    			String xuewei1="img/tn/60.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("61")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v61-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v61-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v61-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v61-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/61.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="精宁穴";
    			String xuewei1="img/tn/61.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("62")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v62-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v62-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v62-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v62-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/62.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="运土入水穴";
    			String xuewei1="img/tn/62.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
    		if(sumitem1.equals("63")){
    			if(xwqingbu1=="揉"||xwqingbu1.equals("揉")){
	    			String shipin1="video/v63-1.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清"||xwqingbu1.equals("清")){
    				String shipin1="video/v63-2.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="补"||xwqingbu1.equals("补")){
    				String shipin1="video/v63-3.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}else if(xwqingbu1=="清补"||xwqingbu1.equals("清补")){
    				String shipin1="video/v63-4.mp4";
	    			request.getSession().setAttribute("shipin1", shipin1);
    			}
    			String img1="img/video-fm/63.jpg";
    			request.getSession().setAttribute("img1", img1);
    			String xwmingcheng1="胆经穴";
    			String xuewei1="img/tn/63.png";
    			request.getSession().setAttribute("xuewei1", xuewei1);
    			request.getSession().setAttribute("xwmingcheng1", xwmingcheng1);
    		}
		
		
		//第二个视频和图片
    		if(sumitem2.equals("01")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v1-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v1-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v1-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v1-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/01.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="吉祥穴";
    			String xuewei2="img/tn/1.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("02")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v2-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v2-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v2-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v2-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/02.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="如意穴";
    			String xuewei2="img/tn/2.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("03")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
    				System.out.println("一窝蜂穴位-----揉-----"+sumitem2);
	    			String shipin2="video/v3-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				System.out.println("一窝蜂穴位-----清-----"+sumitem2);
    				String shipin2="video/v3-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				System.out.println("一窝蜂穴位-----补-----"+sumitem2);
    				String shipin2="video/v3-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				System.out.println("一窝蜂穴位-----清补-----"+sumitem2);
    				String shipin2="video/v3-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/03.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="一窝蜂穴";
    			String xuewei2="img/tn/3.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("04")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v4-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v4-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v4-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v4-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/04.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="新一扇门穴";
    			String xuewei2="img/tn/4.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("05")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v5-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v5-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v5-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v5-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/05.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="感冒点穴";
    			String xuewei2="img/tn/5.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("06")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v6-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v6-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v6-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v6-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/06.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="清热点穴";
    			String xuewei2="img/tn/6.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("07")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v7-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v7-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v7-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v7-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/07.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="外关穴";
    			String xuewei2="img/tn/7.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("08")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v8-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v8-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v8-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v8-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/08.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="阳明穴";
    			String xuewei2="img/tn/8.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("09")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v9-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v9-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v9-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v9-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/09.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="大肠点穴";
    			String xuewei2="img/tn/9.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("10")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v10-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v10-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v10-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v10-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/10.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="阳池穴";
    			String xuewei2="img/tn/10.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("11")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v11-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v11-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v11-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v11-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/11.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="泰山穴";
    			String xuewei2="img/tn/11.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("12")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v12-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v12-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v12-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v12-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/12.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="板门穴";
    			String xuewei2="img/tn/12.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("13")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v13-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v13-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v13-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v13-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/13.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="咽喉点穴";
    			String xuewei2="img/tn/13.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("14")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v14-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v14-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v14-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v14-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/14.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="灵泉穴";
    			String xuewei2="img/tn/14.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("15")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v15-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v15-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v15-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v15-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/15.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="大肠穴";
    			String xuewei2="img/tn/15.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("16")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v16-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v16-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v16-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v16-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/16.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="鼻出血点穴";
    			String xuewei2="img/tn/16.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("17")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v17-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v17-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v17-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v17-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/17.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="合谷穴";
    			String xuewei2="img/tn/17.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("18")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v18-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v18-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v18-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v18-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/18.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="脾经穴";
    			String xuewei2="img/tn/18.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("19")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v19-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v19-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v19-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v19-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/19.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="二马穴";
    			String xuewei2="img/tn/19.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("20")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v20-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v20-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v20-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v20-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/20.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="头痛点穴";
    			String xuewei2="img/tn/20.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("21")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v21-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v21-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v21-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v21-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/21.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="脾点穴";
    			String xuewei2="img/tn/21.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("22")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v22-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v22-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v22-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v22-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/22.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="液门穴";
    			String xuewei2="img/tn/22.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("23")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v23-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v23-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v23-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v23-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/23.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="肝点穴";
    			String xuewei2="img/tn/23.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("24")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v24-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v24-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v24-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v24-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/24.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="外劳宫穴";
    			String xuewei2="img/tn/24.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("25")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v25-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v25-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v25-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v25-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/25.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="胃经穴";
    			String xuewei2="img/tn/25.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("26")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v26-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v26-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v26-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v26-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/26.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="扁桃体点穴";
    			String xuewei2="img/tn/26.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("27")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v27-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v27-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v27-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v27-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/27.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="膈点穴";
    			String xuewei2="img/tn/27.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("28")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v28-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v28-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v28-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v28-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/28.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="总筋穴";
    			String xuewei2="img/tn/28.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("29")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v29-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v29-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v29-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v29-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/29.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="内劳宫穴";
    			String xuewei2="img/tn/29.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("30")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v30-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v30-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v30-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v30-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/30.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="掌小横纹穴";
    			String xuewei2="img/tn/30.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("31")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v31-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v31-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v31-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v31-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/31.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="小肠穴";
    			String xuewei2="img/tn/31.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("32")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v32-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v32-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v32-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v32-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/32.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="小天心穴";
    			String xuewei2="img/tn/32.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("33")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v33-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v33-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v33-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v33-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/33.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="夜尿穴";
    			String xuewei2="img/tn/33.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("34")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v34-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v34-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v34-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v34-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/34.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="上焦穴";
    			String xuewei2="img/tn/34.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("35")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v35-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v35-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v35-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v35-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/35.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="肾顶穴";
    			String xuewei2="img/tn/35.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("36")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v36-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v36-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v36-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v36-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/36.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="内关穴";
    			String xuewei2="img/tn/36.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("37")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v37-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v37-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v37-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v37-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/37.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="三焦穴";
    			String xuewei2="img/tn/37.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("38")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v38-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v38-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v38-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v38-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/38.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="小肠点穴";
    			String xuewei2="img/tn/38.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("39")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v39-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v39-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v39-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v39-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/39.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="肝经穴";
    			String xuewei2="img/tn/39.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("40")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v40-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v40-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v40-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v40-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/40.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="心经穴";
    			String xuewei2="img/tn/40.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("41")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v41-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v41-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v41-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v41-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/41.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="肺经穴";
    			String xuewei2="img/tn/41.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("42")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v42-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v42-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v42-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v42-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/42.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="肾经穴";
    			String xuewei2="img/tn/42.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("43")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v43-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v43-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v43-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v43-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/43.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="肾纹穴";
    			String xuewei2="img/tn/43.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("44")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v44-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v44-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v44-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v44-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/44.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="四横纹穴";
    			String xuewei2="img/tn/44.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("45")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v45-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v45-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v45-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v45-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/45.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="内八卦穴";
    			String xuewei2="img/tn/45.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("46")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v46-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v46-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v46-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v46-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/46.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="运水入土穴";
    			String xuewei2="img/tn/46.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("47")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v47-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v47-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v47-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v47-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/47.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="阴池穴";
    			String xuewei2="img/tn/47.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("48")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v48-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v48-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v48-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v48-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/48.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="咳喘穴";
    			String xuewei2="img/tn/48.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("49")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v49-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v49-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v49-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v49-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/49.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="胃肠痛穴";
    			String xuewei2="img/tn/49.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("50")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v50-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v50-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v50-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v50-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/50.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="命门穴";
    			String xuewei2="img/tn/50.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("51")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v51-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v51-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v51-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v51-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/51.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="一扇门穴";
    			String xuewei2="img/tn/51.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("52")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v52-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v52-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v52-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v52-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/52.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="两扇门穴";
    			String xuewei2="img/tn/52.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("53")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v53-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v53-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v53-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v53-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/53.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="十宣穴";
    			String xuewei2="img/tn/53.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("54")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v54-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v54-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v54-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v54-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/54.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="五指节穴";
    			String xuewei2="img/tn/54.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("55")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v55-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v55-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v55-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v55-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/55.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="外八卦穴";
    			String xuewei2="img/tn/55.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("56")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v56-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v56-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v56-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v56-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/56.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="列缺穴";
    			String xuewei2="img/tn/56.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("57")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v57-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v57-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v57-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v57-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/57.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="三关穴";
    			String xuewei2="img/tn/57.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("58")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v58-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v58-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v58-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v58-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/58.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="六腑穴";
    			String xuewei2="img/tn/58.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("59")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v59-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v59-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v59-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v59-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/59.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="天河水穴";
    			String xuewei2="img/tn/59.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("60")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v60-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v60-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v60-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v60-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/60.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="威灵穴";
    			String xuewei2="img/tn/60.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("61")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v61-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v61-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v61-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v61-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/61.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="精宁穴";
    			String xuewei2="img/tn/61.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("62")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v62-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v62-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v62-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v62-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/62.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="运土入水穴";
    			String xuewei2="img/tn/62.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
    		if(sumitem2.equals("63")){
    			if(xwqingbu2=="揉"||xwqingbu2.equals("揉")){
	    			String shipin2="video/v63-1.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清"||xwqingbu2.equals("清")){
    				String shipin2="video/v63-2.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="补"||xwqingbu2.equals("补")){
    				String shipin2="video/v63-3.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}else if(xwqingbu2=="清补"||xwqingbu2.equals("清补")){
    				String shipin2="video/v63-4.mp4";
	    			request.getSession().setAttribute("shipin2", shipin2);
    			}
    			String img2="img/video-fm/63.jpg";
    			request.getSession().setAttribute("img2", img2);
    			String xwmingcheng2="胆经穴";
    			String xuewei2="img/tn/63.png";
    			request.getSession().setAttribute("xuewei2", xuewei2);
    			request.getSession().setAttribute("xwmingcheng2", xwmingcheng2);
    		}
			
//			//第三个视频
			if(sumitem3 != null){
				
	    		if(sumitem3.equals("01")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v1-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v1-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v1-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v1-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/01.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="吉祥穴";
	    			String xuewei3="img/tn/1.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("02")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v2-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v2-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v2-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v2-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/02.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="如意穴";
	    			String xuewei3="img/tn/2.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("03")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
	    				System.out.println("一窝蜂穴位-----揉-----"+sumitem2);
		    			String shipin3="video/v3-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				System.out.println("一窝蜂穴位-----清-----"+sumitem2);
	    				String shipin3="video/v3-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				System.out.println("一窝蜂穴位-----补-----"+sumitem2);
	    				String shipin3="video/v3-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				System.out.println("一窝蜂穴位-----清补-----"+sumitem2);
	    				String shipin3="video/v3-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/03.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="一窝蜂穴";
	    			String xuewei3="img/tn/3.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("04")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v4-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v4-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v4-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v4-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/04.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="新一扇门穴";
	    			String xuewei3="img/tn/4.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("05")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v5-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v5-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v5-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v5-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/05.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="感冒点穴";
	    			String xuewei3="img/tn/5.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("06")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v6-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v6-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v6-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v6-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/06.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="清热点穴";
	    			String xuewei3="img/tn/6.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("07")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v7-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v7-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v7-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v7-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/07.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="外关穴";
	    			String xuewei3="img/tn/7.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("08")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v8-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v8-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v8-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v8-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/08.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="阳明穴";
	    			String xuewei3="img/tn/8.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("09")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v9-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v9-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v9-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v9-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/09.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="大肠点穴";
	    			String xuewei3="img/tn/9.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("10")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v10-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v10-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v10-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v10-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/10.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="阳池穴";
	    			String xuewei3="img/tn/10.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("11")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v11-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v11-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v11-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v11-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/11.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="泰山穴";
	    			String xuewei3="img/tn/11.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("12")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v12-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v12-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v12-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v12-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/12.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="板门穴";
	    			String xuewei3="img/tn/12.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("13")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v13-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v13-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v13-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v13-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/13.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="咽喉点穴";
	    			String xuewei3="img/tn/13.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("14")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v14-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v14-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v14-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v14-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/14.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="灵泉穴";
	    			String xuewei3="img/tn/14.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("15")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v15-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v15-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v15-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v15-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/15.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="大肠穴";
	    			String xuewei3="img/tn/15.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("16")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v16-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v16-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v16-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v16-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/16.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="鼻出血点穴";
	    			String xuewei3="img/tn/16.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("17")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v17-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v17-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v17-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v17-4.mp4";
	    				request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/17.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="合谷穴";
	    			String xuewei3="img/tn/17.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("18")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v18-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v18-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v18-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v18-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/18.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="脾经穴";
	    			String xuewei3="img/tn/18.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("19")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v19-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v19-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v19-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v19-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/19.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="二马穴";
	    			String xuewei3="img/tn/19.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("20")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v20-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v20-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v20-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v20-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/20.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="头痛点穴";
	    			String xuewei3="img/tn/20.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("21")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v21-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v21-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v21-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v21-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/21.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="脾点穴";
	    			String xuewei3="img/tn/21.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("22")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v22-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v22-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v22-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v22-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/22.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="液门穴";
	    			String xuewei3="img/tn/22.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("23")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v23-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v23-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v23-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v23-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/23.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="肝点穴";
	    			String xuewei3="img/tn/23.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("24")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v24-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v24-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v24-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v24-4.mp4";
	    				request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/24.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="外劳宫穴";
	    			String xuewei3="img/tn/24.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("25")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v25-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v25-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v25-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v25-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/25.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="胃经穴";
	    			String xuewei3="img/tn/25.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("26")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v26-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v26-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v26-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v26-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/26.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="扁桃体点穴";
	    			String xuewei3="img/tn/26.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("27")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v27-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v27-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v27-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v27-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/27.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="膈点穴";
	    			String xuewei3="img/tn/27.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("28")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v28-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v28-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v28-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v28-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/28.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="总筋穴";
	    			String xuewei3="img/tn/28.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("29")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v29-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v29-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v29-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v29-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/29.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="内劳宫穴";
	    			String xuewei3="img/tn/29.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("30")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v30-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v30-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v30-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v30-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/30.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="掌小横纹穴";
	    			String xuewei3="img/tn/30.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("31")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v31-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v31-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v31-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v31-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/31.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="小肠穴";
	    			String xuewei3="img/tn/31.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("32")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v32-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v32-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v32-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v32-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/32.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="小天心穴";
	    			String xuewei3="img/tn/32.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("33")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v33-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v33-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v33-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v33-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/33.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="夜尿穴";
	    			String xuewei3="img/tn/33.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("34")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v34-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v34-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v34-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v34-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/34.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="上焦穴";
	    			String xuewei3="img/tn/34.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("35")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v35-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v35-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v35-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v35-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/35.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="肾顶穴";
	    			String xuewei3="img/tn/35.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("36")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v36-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v36-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v36-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v36-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/36.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="内关穴";
	    			String xuewei3="img/tn/36.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("37")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v37-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v37-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v37-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v37-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/37.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="三焦穴";
	    			String xuewei3="img/tn/37.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("38")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v38-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v38-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v38-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v38-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/38.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="小肠点穴";
	    			String xuewei3="img/tn/38.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("39")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v39-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v39-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v39-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v39-4.mp4";
	    			}
	    			String img3="img/video-fm/39.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="肝经穴";
	    			String xuewei3="img/tn/39.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("40")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v40-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v40-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v40-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v40-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/40.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="心经穴";
	    			String xuewei3="img/tn/40.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("41")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v41-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v41-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v41-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v41-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/41.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="肺经穴";
	    			String xuewei3="img/tn/41.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("42")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v42-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v42-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v42-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v42-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/42.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="肾经穴";
	    			String xuewei3="img/tn/42.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("43")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v43-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v43-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v43-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v43-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/43.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="肾纹穴";
	    			String xuewei3="img/tn/43.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("44")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v44-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v44-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v44-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v44-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/44.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="四横纹穴";
	    			String xuewei3="img/tn/44.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("45")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v45-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v45-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v45-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v45-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/45.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="内八卦穴";
	    			String xuewei3="img/tn/45.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("46")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v46-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v46-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v46-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v46-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/46.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="运水入土穴";
	    			String xuewei3="img/tn/46.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("47")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v47-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v47-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v47-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v47-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/47.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="阴池穴";
	    			String xuewei3="img/tn/47.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("48")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v48-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v48-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v48-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v48-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/48.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="咳喘穴";
	    			String xuewei3="img/tn/48.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("49")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v49-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v49-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v49-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v49-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/49.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="胃肠痛穴";
	    			String xuewei3="img/tn/49.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("50")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v50-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v50-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v50-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v50-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/50.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="命门穴";
	    			String xuewei3="img/tn/50.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("51")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v51-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v51-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v51-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v51-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/51.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="一扇门穴";
	    			String xuewei3="img/tn/51.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("52")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v52-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v52-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v52-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v52-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/52.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="两扇门穴";
	    			String xuewei3="img/tn/52.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("53")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v53-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v53-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v53-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v53-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/53.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="十宣穴";
	    			String xuewei3="img/tn/53.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("54")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v54-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v54-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v54-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v54-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/54.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="五指节穴";
	    			String xuewei3="img/tn/54.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("55")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v55-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v55-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v55-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v55-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/55.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="外八卦穴";
	    			String xuewei3="img/tn/55.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("56")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v56-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v56-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v56-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v56-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/56.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="列缺穴";
	    			String xuewei3="img/tn/56.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("57")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v57-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v57-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v57-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v57-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/57.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="三关穴";
	    			String xuewei3="img/tn/57.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("58")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v58-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v58-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v58-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v58-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/58.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="六腑穴";
	    			String xuewei3="img/tn/58.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("59")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v59-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v59-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v59-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v59-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/59.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="天河水穴";
	    			String xuewei3="img/tn/59.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("60")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v60-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v60-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v60-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v60-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/60.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="威灵穴";
	    			String xuewei3="img/tn/60.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("61")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v61-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v61-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v61-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v61-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/61.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="精宁穴";
	    			String xuewei3="img/tn/61.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("62")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v62-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v62-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v62-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v62-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/62.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="运土入水穴";
	    			String xuewei3="img/tn/62.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
	    		if(sumitem3.equals("63")){
	    			if(xwqingbu3=="揉"||xwqingbu3.equals("揉")){
		    			String shipin3="video/v63-1.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清"||xwqingbu3.equals("清")){
	    				String shipin3="video/v63-2.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="补"||xwqingbu3.equals("补")){
	    				String shipin3="video/v63-3.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}else if(xwqingbu3=="清补"||xwqingbu3.equals("清补")){
	    				String shipin3="video/v63-4.mp4";
		    			request.getSession().setAttribute("shipin3", shipin3);
	    			}
	    			String img3="img/video-fm/63.jpg";
	    			request.getSession().setAttribute("img3", img3);
	    			String xwmingcheng3="胆经穴";
	    			String xuewei3="img/tn/63.png";
	    			request.getSession().setAttribute("xuewei3", xuewei3);
	    			request.getSession().setAttribute("xwmingcheng3", xwmingcheng3);
	    		}
			}	
			//-第四个视频和图片
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
//				if(sumitem5 != null){}
				//--第六个视频和图片
//				if(sumitem6 != null){}
				//--第七个视频和图片
//				if(sumitem7 != null){}
				//根据穴位判断用哪些视频结束
			
			//截取结果中的穴位代码结束			
			request.getRequestDispatcher("planDetial.jsp").forward(request,
					response);
		}else{
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('错误');");
			out.println("window.location.href=\"xuanzejiemian.jsp\"");
			out.println("</script>");
		}
			}else{
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("window.location.href=\"login.jsp\"");
				out.println("</script>");
			}
		out.close();
	}
}
