package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Daily_recordsDAO;
import dto.Daily_record;
import dto.LoginUser;

/**
 * Servlet implementation class SliderServlet
 */
@WebServlet("/SliderServlet")
public class SliderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SliderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/slider.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser) session.getAttribute("id");

		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
			return;
		}
		
		// userId取得（QRに組み込むため）
        String userId = user.getUserId();
		int body = Integer.parseInt(request.getParameter("body"));
		int mind = Integer.parseInt(request.getParameter("mind"));
		
		Daily_record record = new Daily_record();
		record.setBody(body);
		record.setMind(mind);
		// DAO呼び出し
		Daily_recordsDAO dao = new Daily_recordsDAO();
		dao.insert(record, userId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/HomeServlet");
		dispatcher.forward(request, response);
		

	}

}