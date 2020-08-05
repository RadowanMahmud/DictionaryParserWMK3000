package dictionaryDB;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class idioms {
    public Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/WMK3000.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(String word,String idioms) {
        String sql = "INSERT INTO idioms(word,idioms) VALUES(?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, word);
            pstmt.setString(2, idioms);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getIdiom(Element taken){
        Elements idiomsList=taken.getElementsByClass("x-h dx-h");
        for(Element idiom : idiomsList){
              insert(Main.word,idiom.text());
        }
    }
}
