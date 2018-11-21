/**
 * 
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.FenbuDao;
import com.dao.UserDao;
import com.dao.impl.FenbuDaoImpl;
import com.dao.impl.UserDaoImpl;

/**
 * @author 石可旺
 * 
 */
public class AddZhuceServlet extends HttpServlet {

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
		
		Date dt2 = new Date();
		Calendar cal=new GregorianCalendar();
		cal.setTime(dt2);
		cal.add(Calendar.DATE, 3);
		dt2=cal.getTime();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置显示格式
		// DateFormat ddf= new SimpleDateFormat("yyyy-MM-dd");
		String starttime = df.format(dt);// 用DateFormat的format()方法在dt中获取并以yyyy/MM/dd
		// HH:mm:ss格式显示
		// String jieshutime=df.format(dt.getTime() + (long)3 * 24 * 60 * 60 *
		// 1000);
		String zhucetime = starttime;
		String jieshutime = df.format(dt2);
		System.out.println("自动开通3天系统使用，到期时间为："+jieshutime);
		String uname = request.getParameter("uname");
		String phone = request.getParameter("phone");
		// String upower = request.getParameter("upower");
		String qqweixin = request.getParameter("phone");
		// String money=request.getParameter("moneys");
		String sjid = request.getParameter("sjid");
		String address =  request.getParameter("paddress");
		// String jieshutime = request.getParameter("jieshutime");
		// System.out.println("upower------------"+upower);
		int sjuid = 1;
		int upowers = 2;
		String zhujiaoname = "总部";
		int course = 0;
		String coursestart = starttime;
		String courseend = starttime;

		// if(sjid!=null){
		// sjuid=Integer.parseInt(sjid);
		// }

		String upassword = request.getParameter("password");
		int fid = 1;
		String haslogin = "1";
		String clientip1 = " ";
		String diaming = "健康宝";
		String name = uname;
		int xjclick = 0;
		int sumuclick = 0;
		int uclick = 0;

		UserDao usdao = new UserDaoImpl();
		FenbuDao fbdao = new FenbuDaoImpl();
		List<User> phlist = usdao.getUserPhone(phone);
		if (phlist.size() <= 0) {

			String uid = usdao.save(uname, upassword, fid, sjuid, upowers,
					phone, haslogin, jieshutime, clientip1, diaming, name,
					xjclick, sumuclick, uclick, address, qqweixin, qqweixin,
					starttime, zhujiaoname, zhucetime, course, coursestart,
					courseend);
			System.out.println("uid------------" + uid);
			if (uid != null) {
				int userid = Integer.parseInt(uid);
				int moneys = 5;
				List<User> uslist = usdao.getUserNameById(userid);
				String fphone = uslist.get(0).getLoginName();
				String fname = uslist.get(0).getUname();
				// int moneys=365;
				fbdao.moneysave(fname, fphone, moneys, userid);
			}

			if (uid != null) {

				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("alert('恭喜您，注册成功！已为您开通3天系统取穴功能。');");
				out.println("window.location.href=\"login.jsp\"");
				out.println("</script>");

			} else {
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("alert('添加失败！');");
				out.println("window.location.href=\"addzhuce.jsp\"");
				out.println("</script>");
			}
		} else {
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('你已经是普通会员，可以输入手机号码进行登录！');");
			out.println("window.location.href=\"login.jsp\"");
			out.println("</script>");
		}
		out.close();
	}

}
