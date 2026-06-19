package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CharactersDAO;
import dto.Character;
/**
 * Servlet implementation class DailyCharacterServlet
 */
@WebServlet("/DailyCharacterServlet")
public class DailyCharacterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DailyCharacterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		
		//リクエストパラメータを取得する
		int karada = Integer.parseInt(request.getParameter("karada"));
		int kibun = Integer.parseInt(request.getParameter("kibun"));
		
		int characterId = 0;
		Random rand = new Random();
		
		if(karada >= 70 && karada <= 100 && kibun >= 0 && kibun <= 35) {
			characterId = 1;
		}else if(karada >= 0 && karada <= 20 && kibun >= 30 && kibun <= 60) {
			characterId = 2;
		}else if(karada >= 0 && karada <= 20 && kibun >= 15 && kibun <= 30) {
			characterId = 3;
		}else if(karada >= 40 && karada <= 60 && kibun >= 40 && kibun <= 60) {
			characterId = 7;
		}else if(karada >= 65 && karada <= 100 && kibun >= 35 && kibun <= 65) {
			characterId = 8;
		}else if(karada >= 40 && karada <= 70 && kibun >= 85 && kibun <= 100) {
			characterId = 9;
		}else if(karada >= 90 && karada <= 100 && kibun >= 90 && kibun <= 100) {
			characterId = 10;
		}else if(karada >= 70 && karada <= 90 && kibun >= 70 && kibun <= 100) {
			characterId = 11;
		}else if(karada >= 0 && karada <= 40 && kibun >= 85 && kibun <= 100) {
			characterId = 12;
		}else if(karada >= 40 && karada <= 60 && kibun >= 15 && kibun <= 30) {
			characterId = 13;
		}else if(karada >= 20 && karada <= 35 && kibun >= 20 && kibun <= 40) {
			characterId = 14;
		}else if(karada >= 60 && karada <= 70 && kibun >= 10 && kibun <= 30) {
			characterId = 15;
		}else if(karada >= 0 && karada <= 10 && kibun >= 20 && kibun <= 70) {
			characterId = 16;
		}else if(karada >= 0 && karada <= 10 && kibun >= 0 && kibun <= 10) {
			characterId = 17;
		}else {
			characterId = rand.nextInt(3) + 4;
			
		}
		
		
		CharactersDAO charaDao= new CharactersDAO();
		List<Character> characterList = charaDao.select(characterId);
		
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("characterList", characterList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		dispatcher.forward(request, response);
	}

}
