package servlet;

import java.io.IOException;
import java.util.Random;

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
		
		// characterId分岐
		int characterId = 0;
		Random rand = new Random();
		
		if(body >= 70 && body <= 100 && mind >= 0 && mind <= 35) {
			characterId = 1;
		}else if(body >= 0 && body <= 20 && mind >= 30 && mind <= 60) {
			characterId = 2;
		}else if(body >= 0 && body <= 20 && mind >= 15 && mind <= 30) {
			characterId = 3;
		}else if(body >= 40 && body <= 60 && mind >= 40 && mind <= 60) {
			characterId = 7;
		}else if(body >= 65 && body <= 100 && mind >= 35 && mind <= 65) {
			characterId = 8;
		}else if(body >= 40 && body <= 70 && mind >= 85 && mind <= 100) {
			characterId = 9;
		}else if(body >= 90 && body <= 100 && mind >= 90 && mind <= 100) {
			characterId = 10;
		}else if(body >= 70 && body <= 90 && mind >= 70 && mind <= 100) {
			characterId = 11;
		}else if(body >= 0 && body <= 40 && mind >= 85 && mind <= 100) {
			characterId = 12;
		}else if(body >= 40 && body <= 60 && mind >= 15 && mind <= 30) {
			characterId = 13;
		}else if(body >= 20 && body <= 35 && mind >= 20 && mind <= 40) {
			characterId = 14;
		}else if(body >= 60 && body <= 70 && mind >= 10 && mind <= 30) {
			characterId = 15;
		}else if(body >= 0 && body <= 10 && mind >= 20 && mind <= 70) {
			characterId = 16;
		}else if(body >= 0 && body <= 10 && mind >= 0 && mind <= 10) {
			characterId = 17;
		}else {
			characterId = rand.nextInt(3) + 4;
		}
		
		Daily_record record = new Daily_record();
		record.setBody(body);
		record.setMind(mind);
		
		// DAO呼び出し
		Daily_recordsDAO dao = new Daily_recordsDAO();
		dao.insert(record, userId, characterId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/HomeServlet");
		dispatcher.forward(request, response);
		

	}

}