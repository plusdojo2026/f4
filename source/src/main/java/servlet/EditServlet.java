package servlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EditDAO;
import dto.Daily_record;
/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		//　落書きページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/edit.jsp");
		dispatcher.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		try {

            request.setCharacterEncoding("UTF-8");

            String imageData = request.getParameter("formData");
            
            String base64 = imageData.split(",")[1];

            byte[] imageBytes = Base64.getDecoder().decode(base64);
            
            //保存先を取得
            String path = getServletContext().getRealPath("/images");
            //ファイル名
            String fileName = "user1.png";
            //
            Path filePath = Paths.get(path, fileName);

            Files.write(filePath, imageBytes);

            //HttpSession session = request.getSession();

            //LoginUser user = (LoginUser)session.getAttribute("id");

            //String userId = user.getUserId();

            //String saveDate = LocalDate.now().toString();

            Daily_record dto = new Daily_record();

            //dto.setUserId(userId);
            //dto.setSaveDate(saveDate);
            dto.setEditScreenShot(fileName);
            
            EditDAO dao = new EditDAO();
            dao.update(dto);

        } catch(Exception e) {

            e.printStackTrace();
        }

		
	    // ホーム画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		dispatcher.forward(request, response);
				
	}
}
