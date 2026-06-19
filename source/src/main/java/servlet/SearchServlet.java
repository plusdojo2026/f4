package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Daily_recordsDAO;
import dto.Daily_record;



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
		request.setCharacterEncoding("UTF-8");
		String date = request.getParameter("date");
		
		Daily_recordsDAO recordDAO = new Daily_recordsDAO();
		List<Daily_record> recordList  = recordDAO.select(new Daily_record(0, user_id, character_id, body, mind, create_date ,
				default_screenshot,edit_screenshot));
		
		if(date == null){
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
