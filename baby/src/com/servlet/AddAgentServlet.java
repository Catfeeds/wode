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

import com.bean.Fenbu;
import com.bean.User;
import com.dao.FenbuDao;
import com.dao.UserDao;
import com.dao.impl.FenbuDaoImpl;
import com.dao.impl.UserDaoImpl;

public class AddAgentServlet extends HttpServlet{


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
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置显示格式
//				DateFormat ddf= new SimpleDateFormat("yyyy-MM-dd");
		String starttime = df.format(dt);// 用DateFormat的format()方法在dt中获取并以yyyy/MM/dd
								// HH:mm:ss格式显示
		String uname = request.getParameter("uname");
		String phone=request.getParameter("phone");
		String upower = request.getParameter("upower");
		String qqweixin = request.getParameter("qqweixin");
		String money=request.getParameter("moneys");
//		String money="30";
//		String sjid = request.getParameter("sjid");
		String address = request.getParameter("address");
		String jieshutime = request.getParameter("jieshutime");
		String zhujiao = request.getParameter("zhujiao");
		String[] strzhujiao=zhujiao.split("_");
		String zhucetime=starttime;
		/*String course=request.getParameter("course");
		String coursestart=request.getParameter("coursestart");
		String courseend=request.getParameter("courseend");*/
		String course="0";
		String coursestart=starttime;
		String courseend=starttime;
		
		System.out.println("upower------------"+upower);
		int zhujiaoid=1;
		String zhujiaoname=strzhujiao[1];
		if(strzhujiao[0]!=null){
			zhujiaoid=Integer.parseInt(strzhujiao[0]);
		}
		int sjuid=zhujiaoid;
		int upowers=1;
		if(upower!=null){
			upowers=Integer.parseInt(upower);
		}else{
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("window.location.href=\"addagent.jsp\"");
			out.println("</script>");
			return;
		}
		int courses=1;
		if(course!=null){
			courses=Integer.parseInt(course);
		}
//		if(sjid!=null){
//			sjuid=Integer.parseInt(sjid);
//		}
		
		String upassword="123";
		int fid=1;
		String haslogin="1";
		String clientip="";
		String diaming="健康宝";
		String name=uname;
		int xjclick=0;
		int sumuclick=0;
		int uclick=0;
		
		UserDao usdao=new UserDaoImpl();
		FenbuDao fbdao=new FenbuDaoImpl();
		List<User> phlist=usdao.getUserPhone(phone);
		if(phlist.size()<=0){
		
		String uid=usdao.save(uname,upassword,fid,sjuid,upowers,phone,haslogin,jieshutime,clientip,diaming,name,xjclick,sumuclick,uclick,address,qqweixin,qqweixin,starttime,zhujiaoname,zhucetime,courses,coursestart,courseend);
		System.out.println("uid------------"+uid);
		if(uid!=null){
		  int userid=Integer.parseInt(uid);
		  int moneys=Integer.parseInt(money);
		  List<User> uslist=usdao.getUserNameById(userid);
		  String fphone=uslist.get(0).getLoginName();
		  String fname=uslist.get(0).getUname();
//		  int moneys=365;
		  fbdao.moneysave(fname, fphone, moneys, userid);
		}
		Object object=request.getSession().getAttribute("user");
		if(object==null){
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('请重新登录！');");
			out.println("window.location.href=\"index.jsp\"");
			out.println("</script>");
			return;
		}
				
		if(uid!=null){
			
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('添加成功！');");
			out.println("window.location.href=\"addagent.jsp\"");
			out.println("</script>");
			
		}else{
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('添加失败！');");
			out.println("window.location.href=\"addagent.jsp\"");
			out.println("</script>");
		} 
			}else{
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("alert('此手机号已经注册！');");
				out.println("window.location.href=\"addagent.jsp\"");
				out.println("</script>");
			} 
		out.close();
	}

}
