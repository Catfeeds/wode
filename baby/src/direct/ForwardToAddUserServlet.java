package direct;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Fenbu;
import com.dao.FenbuDao;
import com.dao.impl.FenbuDaoImpl;

public class ForwardToAddUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FenbuDao fenbuDao = new FenbuDaoImpl();
//		List<Fenbu> fenbuList = fenbuDao.getFenbuList();
//		request.setAttribute("fenbuList", fenbuList);
		request.getRequestDispatcher("addUser.jsp").forward(request, response);

	}

}
