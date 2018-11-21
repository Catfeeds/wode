package direct;

import java.io.IOException;
import java.io.PrintWriter;
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

public class ForwardToEditUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("userid");
		UserDao userDao = new UserDaoImpl();
		User user = userDao.getUserById(userid);
		request.setAttribute("editUser", user);
		FenbuDao fenbuDao = new FenbuDaoImpl();
//		List<Fenbu> fenbuList = fenbuDao.getFenbuList();
//		request.setAttribute("fenbuList", fenbuList);
		request.getRequestDispatcher("editUser.jsp").forward(request, response);
	}

}
