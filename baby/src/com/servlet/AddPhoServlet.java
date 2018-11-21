package com.servlet;

import javax.jms.Session;

import com.bean.Photo;
import com.bean.User;
import com.dao.*;
import com.dao.impl.*;
import com.util.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//解决在表单中加enctype="multipart/form-data" 取不到其他那么值的问题
//相关参考网站博客http://blog.csdn.net/wind00sky/article/details/2906335
import com.jspsmart.upload.*;

public class AddPhoServlet extends HttpServlet {
	private ServletConfig config;

	// 初始化Servlet
	final public void init(ServletConfig config) throws ServletException {
		this.config = config;
	}

	/**
	 * Constructor of the object.
	 */
	public AddPhoServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			response.setContentType("text/html;charset=gb2312");
			response.setCharacterEncoding("gb2312");
			PrintWriter out = response.getWriter();
			try{
			Object obj = request.getSession().getAttribute("user");
			// 获取PrintWriter对象
			
			// 新建一个SmartUpload对象
			SmartUpload su = new SmartUpload();
			// 上传初始化
			su.initialize(config, request, response);
			// 设定允许上传的文件的类型,只允许上传java,doc,txt文件
			// su.setAllowedFilesList("jpg.png");
			// 上传文件
			try {
				// su.upload("UTF-8");
				su.upload();
			} catch (SmartUploadException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("alert('图片过大或格式不正确，请重新上传');");
				out.println("window.location.href=\"addpho.jsp\"");
				out.println("</script>");
				out.close();
			}
			// 将上传文件全部保存到指定目录
			// 处理每个上传文件
			com.jspsmart.upload.File file = su.getFiles().getFile(0);
	
			// 判断用户是否选择了文件
			if (!file.isMissing()) {
				try {
	
					String filename = file.getFileName();
					file.saveAs("/images/photo/" + filename, su.SAVE_VIRTUAL);
					String paths = "images/photo/" + filename;
				} catch (SmartUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
			String ppower = su.getRequest().getParameter("ppower");
			// request.getSession().setAttribute("ppower", ppower);
			System.out.println("ppower取值为：" + ppower);
	
			String pname = su.getRequest().getParameter("pname");
			// request.getSession().setAttribute("pname", pname);
			System.out.println("pname取值为：" + pname);
			String[] s = ppower.split("_");
			String purl = "images/photo/" + file.getFileName();
			Photo p = new Photo();
			p.setPpower(s[0]);
			p.setPname(pname);
			p.setPurl(purl);
			PhotoDaoImpl photodaoimpl = new PhotoDaoImpl();
			User u=(User) obj;
			if(obj != null) {
				if(u.getUpower()==0)
					photodaoimpl.save(p);
				out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
				out.println("<script>");
				out.println("alert('添加成功！请继续添加');");
				out.println("window.location.href=\"addpho.jsp\"");
				out.println("</script>");
				out.close();
			}
		} catch(Exception e) {
			out.println("<meta   http-equiv='Content-Type'   content='text/html;   charset=UTF-8'>");
			out.println("<script>");
			out.println("window.location.href=\"addpho.jsp\"");
			out.println("</script>");
			out.close();
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
