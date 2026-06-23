package test;

import java.sql.Date;
import java.util.List;

import dao.SearchDAO;
import dto.Daily_record;

public class SearchDAOTest {

    public static void main(String[] args) {

        // 検索条件（日付だけ）
        Daily_record search = new Daily_record();
        search.setCreateDate(Date.valueOf("2026-06-23")); // ←ここ変えてテスト

        String userId = "papa";

        // DAO実行
        SearchDAO dao = new SearchDAO();
        List<Daily_record> result = dao.select(search, userId);

        // 結果確認
        if (result == null) {
            System.out.println("検索失敗");
            return;
        }

        System.out.println("取得件数：" + result.size());

        for (Daily_record r : result) {
            System.out.println("user_id: " + r.getUserId());
            System.out.println("create_date: " + r.getCreateDate());
            System.out.println("-------------------");
        }
    }
}

