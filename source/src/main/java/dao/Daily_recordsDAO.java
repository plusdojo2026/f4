package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Daily_record;

public class Daily_recordsDAO {
	// スライダー入力飛ばし　&　各画面遷移時にキャラ表示用
	public Daily_record select(String userId) {
    Connection conn = null;
    Daily_record record = null;

    try {
        // JDBCドライバ読み込み
        Class.forName("com.mysql.cj.jdbc.Driver");

        // DB接続
		// データベースに接続する
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f4?"
				+ "characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
				"f4", "WmWxqN4QXsS7srCL");


        // 今日のデータ取得
        String sql = "SELECT * FROM daily_records WHERE user_id = ? AND create_date = CURRENT_DATE";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        pStmt.setString(1, userId);

        ResultSet rs = pStmt.executeQuery();

        // 1件だけ取得
        if (rs.next()) {
            record = new Daily_record(
                rs.getString("user_id"),
                rs.getInt("character_id"),
                rs.getInt("body"),
                rs.getInt("mind"),
                rs.getDate("create_date"),
                rs.getString("default_screenshot"),
                rs.getString("edit_screenshot")
            );
        }

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try { if (conn != null) conn.close(); } catch (Exception e) {}
    }

    return record;
}

	public boolean insert(Daily_record record, String userId, int characterId) {

		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f4?"
					+ "characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"f4", "WmWxqN4QXsS7srCL");

			// SQL文を準備する（character_id削除）
			String sql = "INSERT INTO daily_records (user_id, body, mind, character_id, create_date) VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, userId);
			pStmt.setInt(2, record.getBody());
			pStmt.setInt(3, record.getMind());
			pStmt.setInt(4, characterId);
			
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
	
	
	public boolean delete(String userId) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f4?"
					+ "characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"f4", "WmWxqN4QXsS7srCL");

			// SQL文を準備する
			String sql = "DELETE FROM daily_records WHERE user_id = ? AND create_date = CURRENT_DATE";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, userId); // 引数そのまま受け渡し→削除処理

			// SQL文を実行する
			if (pStmt.executeUpdate() > 0) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		// 結果を返す
		return result;
	}
}

