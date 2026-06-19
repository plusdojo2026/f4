package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Character;

public class CharactersDAO {
	public List<Character> select(int characterId){
		List<Character> characterList = new ArrayList<Character>();
		Connection conn = null;
		
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f4?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			// SQL文を準備する
			String sql = "SELECT * "
					+ "FROM characters "
					+ "WHERE character_id = ?";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SQL文を完成させる
			pStmt.setInt(1, characterId);
			
			
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表をコレクションにコピーする
			if(rs.next()) {
				Character c = new Character(
						rs.getInt("character_id"),
						rs.getString("character_name"),
						rs.getString("character_main_img")
						);
				characterList.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			characterList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			characterList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					characterList = null;
				}
			}
		}
		
		return characterList;
	}

}
