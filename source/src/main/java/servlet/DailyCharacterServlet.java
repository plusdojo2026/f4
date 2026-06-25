package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Character_subsDAO;
import dao.CharactersDAO;
import dao.Daily_recordsDAO;
import dto.Character;
import dto.Character_sub;
import dto.Daily_record;
import dto.LoginUser; 
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
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser) session.getAttribute("id");
		
		// Qrで入ってくる人のため
		String qrUserId = request.getParameter("userId");	
		if (user == null && qrUserId != null) {
			LoginUser qrUser = new LoginUser();
			qrUser.setUserId(qrUserId);
			session.setAttribute("id",qrUser);
			user = qrUser;
		}
		
		// もしユーザーID取得なし、つまり、うまくログインできていないなら、ログイン画面へ帰ってもらう。
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
			return;
		}
		
		
		// userId取得
		String userId = user.getUserId();

		// characterId検索
		Daily_recordsDAO dao = new Daily_recordsDAO();
		Daily_record record = dao.select(userId);
		
		int characterId = record.getCharacterId();
		System.out.println(characterId);
		
		CharactersDAO charaDao= new CharactersDAO();
		List<Character> characterList = charaDao.select(characterId);
		
		// 検索結果をリクエストスコープに格納する
		//request.setAttribute("characterList", characterList);
		session.setAttribute("characterList", characterList);
		
		Character_subsDAO subDao = new Character_subsDAO();
		List<Character_sub> characterSubList = subDao.select(characterId);
		
		request.setAttribute("characterSubList",characterSubList);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser) session.getAttribute("id");
		
		// もしユーザーID取得なし、つまり、うまくログインできていないなら、ログイン画面へ帰ってもらう。
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
			return;
		}
		
		// userId取得（QRに組み込むため）
		String userId = user.getUserId();
		
		// characterId検索
		Daily_recordsDAO dao = new Daily_recordsDAO();
		Daily_record record = dao.select(userId);
		
		int characterId = record.getCharacterId();
		System.out.println(characterId);
		
		CharactersDAO charaDao= new CharactersDAO();
		List<Character> characterList = charaDao.select(characterId);
		
		// 検索結果をリクエストスコープに格納する
		//request.setAttribute("characterList", characterList);
		session.setAttribute("characterList", characterList);
		
		Character_subsDAO subDao = new Character_subsDAO();
		List<Character_sub> characterSubList = subDao.select(characterId);
		
		request.setAttribute("characterSubList",characterSubList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		dispatcher.forward(request, response);
	}

}
