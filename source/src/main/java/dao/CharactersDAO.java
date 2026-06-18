package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Character;

public class CharactersDAO {
	public List<Character> select(Character character){
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
			
			// SQL文を完成させる
			
			// SQL文を実行し、結果表を取得する
			
			// 結果表をコレクションにコピーする
			
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
