package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Money;
import com.bean.User;
import com.dao.FenbuDao;
import com.dao.UserDao;
import com.dao.impl.FenbuDaoImpl;
import com.dao.impl.UserDaoImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//	    注销用户，使session失效。
		//	    每次登录时先将session清掉，以防止在此之前没有正常退出，导致第二次再登录时登录不上
		request.getSession().invalidate();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		String post = request.getParameter("post");// radioButton
		String username = request.getParameter("loginName");
		String userpassword = request.getParameter("userPassword");
		
		String mac = request.getParameter("mac");
		
		UserDao ud = new UserDaoImpl();
		System.out.println(username + userpassword);
		Date dt = new Date();
		
		User user = ud.checkUser(username, userpassword, dt);

		try {
				if (user != null) {
					int res = Integer.parseInt(user.getHasLogin());
					
					boolean flag = ud.checkIp(username, mac);
					if (flag == false) {
						System.out.println("flag : " + flag);
						out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
						out.println("<script>");
						out.println("alert('检测到您的账号频繁变动电脑，请联系总部！');");
						out.println("window.location.href=\"login.jsp\"");
						out.println("</script>");
					} else {
						if (res >= 0) {
//							response.sendRedirect("index.jsp");
							out.print("<meta http-equiv='Content-Type' content='text/html;  charset=UTF-8'>");
							out.print("<script>");
							out.print("alert('已经超过使用期限，请联系官方！');");
							out.print("window.location.href=\"login.jsp\"");
							out.print("</script>");
							return;
						}
						request.getSession().setAttribute("user", user);
						ServletContext application = this.getServletContext();
						List<HttpSession> loginedUser = (List<HttpSession>) application
								.getAttribute("login_user");
						if (loginedUser == null) {
							loginedUser = new ArrayList();
						}
						for (HttpSession u : loginedUser) {
							boolean b = false;
							try {
								u.isNew();
							} catch (Exception e) {
								b = true;
							}
							if (b) {
							} else {
								User sessionUser = (User) u.getAttribute("user");
								if (sessionUser.getUserid() == user.getUserid()) {
									u.invalidate();
								}
							}
						}
						HttpSession session = request.getSession();
						loginedUser.add(session);
						application.setAttribute("login_user", loginedUser);

						request.getSession().setAttribute("i", 1);
						
						int uclick=user.getUclick();
						int uid=user.getUserid();
						int sumuclick=user.getSumuclick();
						System.out.println("sumuclick-----------"+sumuclick);

						System.out.println("uclick1-----------"+uclick);
						uclick=uclick+1;
						sumuclick=sumuclick+1;
						System.out.println("uclick2-----------"+uclick);
						ud.updateUlick(uclick,sumuclick, uid);
						
						FenbuDao fenbu=new FenbuDaoImpl();
						List<Money> usidlist=fenbu.getUserid(uid);
						int numbers=usidlist.get(0).getNumbers();
						request.getSession().setAttribute("numbers", numbers);
//						if(numbers>0){
//							numbers=numbers-1;
//							int intnumb=fenbu.updateNumber(uid,numbers);
//							
//						}else{
//							out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
//							out.println("<script>");
//							out.println("alert('余额不足，请及时充值！');");
//							out.println("window.location.href=\"login.jsp\"");
//							out.println("</script>");
//						}
						response.sendRedirect("xuanzejiemian.jsp");
					}
					
				} else {
					out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
					out.println("<script>");
					out.println("alert('用户名或密码错误！');");
					out.println("window.location.href=\"login.jsp\"");
					out.println("</script>");
				}
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
