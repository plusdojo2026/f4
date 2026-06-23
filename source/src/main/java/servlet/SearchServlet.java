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

import dao.SearchDAO;
import dto.Daily_record;
import dto.LoginUser;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/dailySearch.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/searchResult_all.jsp");
		
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser) session.getAttribute("id");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
			return;
		}
		//文字コードの設定。
		request.setCharacterEncoding("UTF-8");
		// ログイン中のユーザーIDを取得
//		int userId = (int) session.getAttribute("id");
//		int userId = 1;
		
		
		Daily_record search = new Daily_record();
		String userId = user.getUserId();
	    
		String date = request.getParameter("create_date");
		//deteがnullでもなく空文字でもない(入力時)
		if (date != null && !date.isEmpty()) {
		    search.setCreateDate(java.sql.Date.valueOf(date));
		}
	    
	    //日付（create_date）を取得する
//	    java.sql.Date date = java.sql.Date.valueOf(request.getParameter("create_date"));
	    //if (date == null) date = "";
		SearchDAO recordDAO = new SearchDAO();
		List<Daily_record> recordList  = recordDAO.select(search,userId);
//		List<Daily_record> recordList  = recordDAO.select(new Daily_record(date));
		
		request.setAttribute("recordList", recordList);
		
		//画面遷移の分岐
		//deteがnullまたは空文字(未入力)
		if(date == null || date.isEmpty()){
			//	未入力時の結果画面に遷移		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/searchResult_all.jsp");
			dispatcher.forward(request, response);
		}else{
			//日別検索結果画面に遷移			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/searchResult_one.jsp");
			dispatcher.forward(request, response);
		}
	}

}
