package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Character_sub;

public class Character_subsDAO {
	public List<Character_sub> select(int characterId){
		List<Character_sub> characterSubList = new ArrayList<Character_sub>();
		Connection conn = null;
		
		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/f4?"
					+ "characterEncoding=utf8&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"f4", "WmWxqN4QXsS7srCL");
			
			//SQL文を準備する
			String sql = "SELECT character_id,character_sub_id,character_sub_name,character_sub_img "
					+ "FROM characters_subs "
					+ "WHERE character_id = ?";
					
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//SQL文を完成させる
			pStmt.setInt(1, characterId);
			
			//SQL文を実行し、結果表を取得する。
			ResultSet rs = pStmt.executeQuery();
			
			// 結果表をコレクションにコピーする
			while(rs.next()) {
				Character_sub c_sub = new Character_sub(
						rs.getInt("character_id"),
						rs.getInt("character_sub_id"),
						rs.getString("character_sub_name"),
						rs.getString("character_sub_img")
						);
				characterSubList.add(c_sub);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			characterSubList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			characterSubList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					characterSubList = null;
				}
			}
		}
		
		return characterSubList;
	}

}
