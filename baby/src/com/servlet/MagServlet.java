/**
 * 
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.User;
import com.dao.FenbuDao;
import com.dao.UserDao;
import com.dao.impl.FenbuDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * @author 石可旺
 *
 */
public class MagServlet  extends HttpServlet{
	public static int randomInt(int from, int to) {
		Random r = new Random();
		return from + r.nextInt(to - from);
		}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Date dt = new Date();// 如果不需要格式,可直接用dt,dt就是当前系统时间
		DateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 设置显示格式
		String ddfTime = "";
		ddfTime = dft.format(dt);// 用DateFormat的format()方法在dt中获取并以yyyy/MM/dd
								// HH:mm:ss格式显示
		String url="http://gw.api.taobao.com/router/rest";
		String appkey="23590744";
		String secret="a51d2f6e00a9e40f26ff17fae48c022e";
		
		String myphone = request.getParameter("myphone");
		String uname=new String(request.getParameter("uname").getBytes("ISO-8859-1"),"UTF-8");
		String qqweixin=new String(request.getParameter("qqweixin").getBytes("ISO-8859-1"),"UTF-8");
		String address=new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
		String upassword = request.getParameter("upassword");
		String qrpassword = request.getParameter("qrpassword");
		String time = request.getParameter("time");
		String charValue = "";
		UserDao usdao=new UserDaoImpl();
		List<User> phlist=usdao.getUserPhone(myphone);
		if(phlist.size()>0){
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('你已经是普通会员，可以输入手机号码进行登录！');");
			out.println("window.location.href=\"login.jsp\"");
			out.println("</script>");
		}else if(ddfTime.equals(time)){
			request.getSession().setAttribute("myphone", myphone);
			request.getSession().setAttribute("uname", uname);
			request.getSession().setAttribute("qqweixin", qqweixin);
			request.getSession().setAttribute("address", address);
//			request.getSession().setAttribute("charValue", charValue);
			request.getSession().setAttribute("upassword", upassword);
			request.getSession().setAttribute("qrpassword", qrpassword);
			request.getSession().setAttribute("time", ddfTime);
			
			
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("alert('验证码已发送');");
			out.println("window.location.href=\"addzhuce.jsp\"");
			out.println("</script>");
		
		}else{

			
		for (int i = 0; i < 6; i++) {
		char c = (char) (randomInt(0, 9) + '0');
		charValue += String.valueOf(c);
		}


		String tt=charValue;
		String cds="{code:'";
		String cde=cds+tt+"'}";
		System.out.println("验证码为："+charValue);
				
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setExtend( "" );
		req.setSmsType( "normal" );
		req.setSmsFreeSignName( "辣妈小儿推拿" );
		req.setSmsParamString( cde );
		req.setRecNum( myphone);
		req.setSmsTemplateCode( "SMS_38435068" );
		AlibabaAliqinFcSmsNumSendResponse rsp = null;
		try {
			rsp = client.execute(req);
			System.out.println("rsp----------"+rsp.getErrorCode());
			if(rsp.getErrorCode()==null){
				System.out.println("验证码已发送-----"+rsp.getBody());
				request.getSession().setAttribute("myphone", myphone);
				request.getSession().setAttribute("uname", uname);
				request.getSession().setAttribute("qqweixin", qqweixin);
				request.getSession().setAttribute("address", address);
				request.getSession().setAttribute("charValue", charValue);
				request.getSession().setAttribute("upassword", upassword);
				request.getSession().setAttribute("qrpassword", qrpassword);
				request.getSession().setAttribute("time", ddfTime);
				
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("window.location.href=\"addzhuce.jsp\"");
				out.println("</script>");
			}else{
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("window.location.href=\"addzhuce.jsp\"");
				out.println("</script>");
			}
		} catch (ApiException e) {
			request.getRequestDispatcher("addzhuce.jsp").forward(request,
					response);
		}
		
		}
		out.close();
		
	}
}