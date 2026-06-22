package servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

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
		userId = URLEncoder.encode(userId, "UTF-8");

        try {
        	// ベースとなるURLさを作成。qrTextで、ユーザーIDをもったものを作成。
        	//　ローカルホストのURL。本番では変更（baseUrl)
        	String baseUrl = "http://localhost:8080/f4";

        	String qrText = baseUrl + "/HomeServlet?userId=" + userId;
        	
        	//　サイズの設定（任意）。
            int size = 250;
            BitMatrix matrix = new MultiFormatWriter().encode(
                    qrText,
                    BarcodeFormat.QR_CODE,
                    size, //横サイズ
                    size //縦サイズ
            );
            //　ブラウザに、画像を返す
            response.setContentType("image/png");
            //　キャッシュ無効化。
            response.setHeader("Cache-Control", "no-store");
            
            //　QRコードの設計データ、画像形式、ブラウザへの出力先。
            MatrixToImageWriter.writeToStream(
                    matrix,
                    "PNG",
                    response.getOutputStream()
            );
            System.out.println("QR URL: " + qrText);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500);
        }

	}

}
