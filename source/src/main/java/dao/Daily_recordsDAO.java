package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Daily_record;

public class Daily_recordsDAO {
	public List<Daily_record> select(Daily_record record) {
		Connection conn = null;
		List<Daily_record> recordList = new ArrayList<Daily_record>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f4?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT user_id, character_id, body, mind, create_date, "
					+ "default_screenshot, edit_screenshot "
					+ "FROM daily_records "
					+ "WHERE user_id =? AND character_id =? AND body =? "
					+ "AND mind =? AND create_date LIKE ? AND default_screenshot LIKE ? AND edit_screenshot LIKE ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
				pStmt.setString(1, "%" + record.getUserId() + "%");
				pStmt.setString(2, "%" + record.getCharacterId() + "%");
			if (record.getBody() >= 0 && record.getBody() <= 100) {
				pStmt.setString(3, "%" + record.getBody() + "%");
			} else {
				pStmt.setString(3, "%");
			}
			if (record.getMind() >= 0 && record.getMind() <= 100) {
				pStmt.setString(4, "%" + record.getMind() + "%");
			} else {
				pStmt.setString(4, "%");
			}
			if (record.getCreateDate() != null) {
				pStmt.setString(5, "%" + record.getCreateDate() + "%");
			} else {
				pStmt.setString(5, "%");
			}
			if (record.getDefaultScreenShot() != null) {
				pStmt.setString(6, "%" + record.getDefaultScreenShot() + "%");
			} else {
				pStmt.setString(6, "%");
			}
			if (record.getEditScreenShot() != null) {
				pStmt.setString(7, "%" + record.getEditScreenShot() + "%");
			} else {
				pStmt.setString(7, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Daily_record daily_records = new Daily_record(
						rs.getInt("user_id"), 
						rs.getInt("character_id"),
						rs.getInt("body"),
						rs.getInt("mind"),
						rs.getDate("create_date"),
						rs.getString("default_screenshot"),
						rs.getString("edit_screenshot")
						);
				recordList.add(daily_records);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			recordList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			recordList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					recordList = null;
				}
			}
		}

		// 結果を返す
		return recordList;
	}
	public boolean insert(Daily_record record, String userId) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f4?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する（character_id削除）
			String sql = "INSERT INTO daily_records (user_id, body, mind, create_date) VALUES (?, ?, ?, CURRENT_TIMESTAMP)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, userId);
			pStmt.setInt(2, record.getBody());
			pStmt.setInt(3, record.getMind());
	        
			
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
}

