package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.User;

public class UsersDAO {
	// 引数で指定されたidpwでログイン成功ならtrueを返す
	public boolean isLoginOK(User user) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f4?"
					+ "characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"f4", "WmWxqN4QXsS7srCL");

			// SELECT文を準備する
			String sql = "SELECT count(*) FROM users WHERE user_id=? AND password=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getUserId());
			pStmt.setString(2, user.getPassword());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいれば結果をtrueにする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}
	// 新規登録（ユーザーのIDと、パスワードをDBへ登録。）（QRはQrServletにて生成。）
	public boolean insert(User user) {
		Connection conn = null;
		boolean registResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f4?"
					+ "characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"f4", "WmWxqN4QXsS7srCL");

			// INSERT文を準備する
			String sql = "INSERT INTO users (user_id, password) VALUES (?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getUserId());
			pStmt.setString(2, user.getPassword());

			int count = pStmt.executeUpdate();

			// 1件追加できていればTrue
			if (count == 1) {
				registResult = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			registResult = false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			registResult = false;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					registResult = false;
				}
			}
		}

		// 結果を返す
		return registResult;
	}
}