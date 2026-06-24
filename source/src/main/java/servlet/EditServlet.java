package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.EditDAO;
import dto.Daily_record;
import dto.LoginUser;
/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
@MultipartConfig
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
		
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser) session.getAttribute("id");

		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
			return;
		}
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
		
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser) session.getAttribute("id");
		
		// もしユーザーID取得なし、つまり、うまくログインできていないなら、ログイン画面へ帰ってもらう。
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
			return;
		}
		
		// userId取得（QRに組み込むため）
		String userId = user.getUserId();
	
		//西暦年月日
		String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		Part part = request.getPart("image");

        InputStream in = part.getInputStream();
        
        //保存先を取得 //ユーザーでファイルを分ける必要がある。/images_screenshotの下の階層に
        String base = "C:/plusdojo2026/f4/source/src/main/webapp/images_screenshot";
        
        // ユーザーIDのフォルダ
        Path userFolder = Paths.get(base, userId);

        // フォルダがなければ作成
        Files.createDirectories(userFolder);
        
        //ファイルの名前を指定
        String fileName = userId + "_" + date + ".png";
        System.out.println("sample2で保存します");

        // 保存先
        Path savePath = userFolder.resolve(fileName);

        Files.copy(
                in,
                savePath,
                StandardCopyOption.REPLACE_EXISTING);

        System.out.println("画像を保存");

        //DAOに接続（INSERT処理）
        try {

            request.setCharacterEncoding("UTF-8");

            Daily_record dto = new Daily_record();

            dto.setEditScreenShot(fileName);
            
            EditDAO dao = new EditDAO();
            dao.update(dto,userId);

        } catch(Exception e) {

            e.printStackTrace();
        }
        

        // ホーム画面にフォワードする
     	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
     	dispatcher.forward(request, response);
		
	}
}