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

public class InputSymptom extends HttpServlet {

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
//		Date dt = new Date();// 如果不需要格式,可直接用dt,dt就是当前系统时间
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置显示格式
//		DateFormat ddf= new SimpleDateFormat("yyyy-MM-dd");
//		String nowTime = "";
//		nowTime = df.format(dt);// 用DateFormat的format()方法在dt中获取并以yyyy/MM/dd
//								// HH:mm:ss格式显示
//		String ddfTime= ddf.format(dt);
//		System.out.println(nowTime);
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
			
		String bisai = request.getParameter("bisai");
			if(bisai==null || bisai == ""){
				bisai="01_不鼻塞";
				System.out.println("bisai--------"+bisai);
				request.getSession().setAttribute("bisai", bisai);
			}
		System.out.println("1---------"+bisai);
		String liuti = request.getParameter("liuti");
			if(liuti==null || liuti == ""){
				liuti="01_不流涕";
				System.out.println("liuti--------"+liuti);
				request.getSession().setAttribute("liuti", liuti);
			}
		System.out.println("2---------"+liuti);
		String dapenti = request.getParameter("dapenti");
			if(dapenti==null || dapenti == ""){
				dapenti="01_不打喷嚏";
				System.out.println("dapenti--------"+dapenti);
				request.getSession().setAttribute("dapenti", dapenti);
			}
		System.out.println("3---------"+dapenti);
		String yantong = request.getParameter("yantong");
			if(yantong==null || yantong == ""){
				yantong="01_不咽痛";
				System.out.println("yantong--------"+yantong);
				request.getSession().setAttribute("yantong", yantong);
			}
		System.out.println("4---------"+yantong);
		String yanshi = request.getParameter("");
			if(yanshi==null || yanshi == ""){
				yanshi="01_不厌食";
				System.out.println("yanshi--------"+yanshi);
				request.getSession().setAttribute("yanshi", yanshi);
			}
		System.out.println("5---------"+yanshi);
		String outu = request.getParameter("outu");
			if(outu==null || outu == ""){
				outu="01_不呕吐";
				System.out.println("outu--------"+outu);
				request.getSession().setAttribute("outu", outu);
			}
		System.out.println("6---------"+outu);
		String fuxie = request.getParameter("fuxie");
			if(fuxie==null || fuxie == ""){
				fuxie="01_不腹泻";
				System.out.println("fuxie--------"+fuxie);
				request.getSession().setAttribute("fuxie", fuxie);
			}
		String futong = request.getParameter("futong");
			if(futong==null || futong == ""){
				futong="01_不腹痛";
				System.out.println("futong--------"+futong);
				request.getSession().setAttribute("futong", futong);
			}
		String toutong = request.getParameter("toutong");
			if(toutong==null || toutong == ""){
				toutong="01_不头痛";
				System.out.println("toutong--------"+toutong);
				request.getSession().setAttribute("toutong", toutong);
			}
		String touyun = request.getParameter("touyun");
			if(touyun==null || touyun == ""){
				touyun="01_不头晕";
				System.out.println("touyun--------"+touyun);
				request.getSession().setAttribute("touyun", touyun);
			}
		String bttzd = request.getParameter("bttzd");
			if(bttzd==null || bttzd == ""){
				bttzd="01_扁桃体不肿大";
				System.out.println("bttzd--------"+bttzd);
				request.getSession().setAttribute("bttzd", bttzd);
			}
		String sheti = "01_否";
//		String sheti = request.getParameter("sheti");
//			if(sheti==null || sheti == ""){
//				sheti="01_正常_10";
//				System.out.println("sheti--------"+sheti);
//				request.getSession().setAttribute("sheti", sheti);
//			}
//		System.out.println("感冒的体征的全部-------------------"+fuxie+"***"+futong+"***"+toutong+"***"+sheti+"***"+touyun+"***"+bttzd);

		String[] strbisai = bisai.split("_");
		String[] strliuti = liuti.split("_");
		String[] strdapenti = dapenti.split("_");
		String[] stryantong = yantong.split("_");
		String[] stryanshi = yanshi.split("_");
		String[] stroutu = outu.split("_");
		String[] strfuxie = fuxie.split("_");
		String[] strtoutong = toutong.split("_");
		String[] strfutong = futong.split("_");
		String[] strtouyun = touyun.split("_");
		String[] strbttzd = bttzd.split("_");
		
		//体征单独穴位开始
		String change_i=null;
		Plan plan=new Plan();
		String str = strbisai[0] + strliuti[0]+strdapenti[0]+ stryantong[0]+stryanshi[0]+stroutu[0]+
				strfuxie[0] + strtoutong[0]+strfutong[0]+ strtouyun[0]+strbttzd[0];
		PlanDao planDao = new PlanDaoImpl();
		plan = planDao.getGanmaoPlanZzbh(str);
		 change_i="01";
		String zzxwt=plan.getShoufa();
		String zzxw=zzxwt+" ";
		String miansexw="+03100";
		String xydxw="";
//		String toutongxw=null;
//		String shetixw=null;
//		String touyunxw=null;
//		String bttzdxw=null;
//		
//		String dzzxw=null;
//		String dfuxiexw=null;
//		String dxydxw=null;
//		String dtoutongxw=null;
//		String dshetixw=null;
//		String dtouyunxw=null;
//		String dbttzdxw=null;
		
//		Tizheng tz=new Tizheng();
//		tz=planDao.selganmaoxw(strfuxie[2]);
//		 fuxiexw=tz.getTzxw();
//		
//		tz=planDao.selganmaoxw(strfutong[2]);
//		xydxw=tz.getTzxw();
//		
//		tz=planDao.selganmaoxw(strtoutong[2]);
//		toutongxw=tz.getTzxw();
//		
//		
//		tz=planDao.selganmaoxw(strtouyun[2]);
//		touyunxw=tz.getTzxw();
//		
//		tz=planDao.selganmaoxw(strbttzd[2]);
//		bttzdxw=tz.getTzxw();
//	
//		System.out.println("体征的全部1-------------------"+fuxiexw+"***"+xydxw+"**"+toutongxw+"***"+shetixw+"***"+touyunxw+"***"+bttzdxw);
//		
		//穴位1
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
//		if(fuxiexw.trim().length()==5){
//			char  item0= fuxiexw.charAt(0);
//			System.out.println("item0---------"+item0);
//			char  item1= fuxiexw .charAt(1);
//			System.out.println("item1---------"+item1);
//			char  item2= fuxiexw .charAt(2);
//			System.out.println("item2---------"+item2);
//			char  item3= fuxiexw .charAt(3);
//			System.out.println("item3---------"+item3);
//			char  item4= fuxiexw .charAt(4);
//			System.out.println("item4---------"+item4);
//			
//			String item0st=String.valueOf(item0);
//            String item1st=String.valueOf(item1);
//            dfuxiexw=item0st+item1st;
//		}else if(fuxiexw.trim().length()==6){
//			char  item0= fuxiexw .charAt(0);
//			System.out.println("item0---------"+item0);
//			char  item1= fuxiexw .charAt(1);
//			System.out.println("item1---------"+item1);
//			char  item2= fuxiexw .charAt(2);
//			System.out.println("item2---------"+item2);
//			char  item3= fuxiexw .charAt(3);
//			System.out.println("item3---------"+item3);
//			char  item4= fuxiexw .charAt(4);
//			System.out.println("item4---------"+item4);
//			
//			String item1st=String.valueOf(item1);
//            String item2st=String.valueOf(item2);
//            dfuxiexw=item1st+item2st;
//		}else if(fuxiexw.trim().length()==7){
//			char  item0= fuxiexw .charAt(0);
//			System.out.println("item0---------"+item0);
//			char  item1= fuxiexw .charAt(1);
//			System.out.println("item1---------"+item1);
//			char  item2= fuxiexw .charAt(2);
//			System.out.println("item2---------"+item2);
//			char  item3= fuxiexw .charAt(3);
//			System.out.println("item3---------"+item3);
//			char  item4= fuxiexw .charAt(4);
//			System.out.println("item4---------"+item4);
//			
//			String item2st=String.valueOf(item2);
//            String item3st=String.valueOf(item3);
//            dfuxiexw=item2st+item3st;
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
//			if(toutongxw != null||toutongxw!=""||toutongxw!=" "){
//			if(toutongxw.trim().length()==5){
//				char  item0= toutongxw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= toutongxw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= toutongxw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= toutongxw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= toutongxw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item0st=String.valueOf(item0);
//	            String item1st=String.valueOf(item1);
//	            dtoutongxw=item0st+item1st;
//			}else if(toutongxw.trim().length()==6){
//				char  item0= toutongxw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= toutongxw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= toutongxw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= toutongxw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= toutongxw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item1st=String.valueOf(item1);
//	            String item2st=String.valueOf(item2);
//	            dtoutongxw=item1st+item2st;
//			}else if(toutongxw.trim().length()==7){
//				char  item0= toutongxw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= toutongxw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= toutongxw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= toutongxw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= toutongxw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item2st=String.valueOf(item2);
//	            String item3st=String.valueOf(item3);
//	            dtoutongxw=item2st+item3st;
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
//		if(touyunxw != null||touyunxw!=""||touyunxw!=" "){
//			if(touyunxw.trim().length()==5){
//				char  item0= touyunxw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= touyunxw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= touyunxw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= touyunxw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= touyunxw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item0st=String.valueOf(item0);
//	            String item1st=String.valueOf(item1);
//	            dtouyunxw=item0st+item1st;
//			}else if(touyunxw.trim().length()==6){
//				char  item0= touyunxw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= touyunxw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= touyunxw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= touyunxw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= touyunxw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item1st=String.valueOf(item1);
//	            String item2st=String.valueOf(item2);
//	            dtouyunxw=item1st+item2st;
//			}else if(touyunxw.trim().length()==7){
//				char  item0= touyunxw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= touyunxw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= touyunxw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= touyunxw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= touyunxw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item2st=String.valueOf(item2);
//	            String item3st=String.valueOf(item3);
//	            dtouyunxw=item2st+item3st;
//			}
//		}
//			//判断穴位7
//		if(bttzdxw != null||bttzdxw!=""||bttzdxw!=" "){
//			if(bttzdxw.trim().length()==5){
//				char  item0= bttzdxw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= bttzdxw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= bttzdxw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= bttzdxw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= bttzdxw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item0st=String.valueOf(item0);
//	            String item1st=String.valueOf(item1);
//	            dbttzdxw=item0st+item1st;
//			}else if(bttzdxw.trim().length()==6){
//				char  item0= bttzdxw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= bttzdxw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= bttzdxw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= bttzdxw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= bttzdxw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item1st=String.valueOf(item1);
//	            String item2st=String.valueOf(item2);
//	            dbttzdxw=item1st+item2st;
//			}else if(bttzdxw.trim().length()==7){
//				char  item0= bttzdxw.charAt(0);
//				System.out.println("item0---------"+item0);
//				char  item1= bttzdxw.charAt(1);
//				System.out.println("item1---------"+item1);
//				char  item2= bttzdxw.charAt(2);
//				System.out.println("item2---------"+item2);
//				char  item3= bttzdxw.charAt(3);
//				System.out.println("item3---------"+item3);
//				char  item4= bttzdxw.charAt(4);
//				System.out.println("item4---------"+item4);
//				
//				String item2st=String.valueOf(item2);
//	            String item3st=String.valueOf(item3);
//	            dbttzdxw=item2st+item3st;
//			}
//		}
//		
//		//症状和其他比较
//		if(dzzxw.equals(dfuxiexw)){
//			fuxiexw="";
//		}
//		if(dzzxw.equals(dxydxw)){
//			xydxw="";
//		}
//		if(dzzxw.equals(dtoutongxw)){
//			toutongxw="";
//		}
//		if(dzzxw.equals(dshetixw)){
//			shetixw="";
//		}
//		if(dzzxw.equals(dtouyunxw)){
//			touyunxw="";
//		}
//		if(dzzxw.equals(dbttzdxw)){
//			bttzdxw="";
//		}
//		//面色和其他比较
//		if(dfuxiexw.equals(dxydxw)){
//			xydxw="";
//		}
//		if(dfuxiexw.equals(dtoutongxw)){
//			toutongxw="";
//		}
//		if(dfuxiexw.equals(dshetixw)){
//			shetixw="";
//		}
//		if(dfuxiexw.equals(dtouyunxw)){
//			touyunxw="";
//		}
//		if(dfuxiexw.equals(dbttzdxw)){
//			bttzdxw="";
//		}
//		//下眼袋和其他比较
//		if(dxydxw.equals(dtoutongxw)){
//			toutongxw="";
//		}
//		if(dxydxw.equals(dshetixw)){
//			shetixw="";
//		}
//		if(dxydxw.equals(dtouyunxw)){
//			touyunxw="";
//		}
//		if(dxydxw.equals(dbttzdxw)){
//			bttzdxw="";
//		}
//		//唇色和其他比较
//		if(dtoutongxw.equals(dshetixw)){
//			shetixw="";
//		}
//		if(dtoutongxw.equals(dtouyunxw)){
//			touyunxw="";
//		}
//		if(dtoutongxw.equals(dbttzdxw)){
//			bttzdxw="";
//		}
//		//舌体和其他比较
//		if(dshetixw.equals(dtouyunxw)){
//			touyunxw="";
//		}
//		if(dshetixw.equals(dbttzdxw)){
//			bttzdxw="";
//		}
//		//舌质和其他比较
//		if(dtouyunxw.equals(dbttzdxw)){
//			bttzdxw="";
//		}
//		System.out.println("体征的全部2-------------------"+fuxiexw+"***"+xydxw+"***"+toutongxw+"***"+shetixw+"***"+touyunxw+"***"+bttzdxw);
		// 1、获得诊断编号
//		String str = strbisai[0] + strliuti[0]+strdapenti[0]
//				   + stryantong[0]+stryanshi[0]+stroutu[0]+ "01"+ "01" +"01"+strfuxie[0]+strtoutong[0]+strfutong[0]+strtouyun[0]+strbttzd[0]+strsheti[0];
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
//		request.getSession().setAttribute("toutongxw", toutongxw);
//		request.getSession().setAttribute("shetixw", shetixw);
//		request.getSession().setAttribute("touyunxw", touyunxw);
//		request.getSession().setAttribute("bttzdxw", bttzdxw);
//		//体征单独穴位结束
		// 1、获得诊断处方
		 String	 str2= "从体质上看，孩子"+strbisai[1]+"、"+strliuti[1]+"、"+strdapenti[1]+"、"+stryantong[1]+"、"+stryanshi[1]+"、"+stroutu[1]+
				 		strfuxie[1]+"、"+strfutong[1]+strtoutong[1]+"、"+strtouyun[1]+strbttzd[1]+"、";
//				 "；" +"面色："+strfuxie[1]+"  ；唇色："+strtoutong[1]+"  ；下眼袋："+strfutong[1]+"  ；舌质："+strtouyun[1]+"  ；舌体："+strsheti[1]
//				 +"  ；舌苔："+strbttzd[1];
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

}
