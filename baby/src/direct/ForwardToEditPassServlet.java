/**
 * 
 */
package direct;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Fenbu;
import com.bean.Richang;
import com.bean.User;
import com.dao.FenbuDao;
import com.dao.UserDao;
import com.dao.ZhuyiDao;
import com.dao.impl.FenbuDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.dao.impl.ZhuyiDaoImpl;

/**
 *
 *
 */
public class ForwardToEditPassServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object obj = request.getSession().getAttribute("user");
		if(obj==null){
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		User user = (User) obj;
		int userid=user.getUserid();
		UserDao userDao = new UserDaoImpl();
		User user1 = userDao.getUserPass(userid);
		request.setAttribute("editUserPass", user1);
		
		int rc=1;
		Richang rcsh=new Richang();
		ZhuyiDao zhuyidao=new ZhuyiDaoImpl();
		Richang richang=zhuyidao.getRichang(rc);
		request.getSession().setAttribute("richang", richang);
		
		request.getRequestDispatcher("changepass.jsp").forward(request, response);
		
	}

}
