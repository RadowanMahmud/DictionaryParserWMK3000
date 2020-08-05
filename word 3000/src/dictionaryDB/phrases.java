package dictionaryDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class phrases {
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

    public void insert(String  word,String phrases) {
        String sql = "INSERT INTO phrases(word,phrases) VALUES(?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, word);
            pstmt.setString(2, phrases);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getPhrase(Element taken){
        Elements pharse=taken.getElementsByClass("item lc lc1 lpb-10 lpr-10");
        for(Element phrasea: pharse){
            insert(Main.word,phrasea.text());
        }
    }
}
