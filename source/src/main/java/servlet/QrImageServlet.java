package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.LoginUser;

/**
 * Servlet implementation class QrServlet
 */
@WebServlet("/QrImageServlet")
public class QrImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QrImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser) session.getAttribute("id");
		
		// もしユーザーID取得なし、つまり、うまくログインできていないなら、ログイン画面へ帰ってもらう。
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
			return;
		}
		
		// userId取得（QRに組み込むため）
		String userId = user.getUserId();
		
	}


}
