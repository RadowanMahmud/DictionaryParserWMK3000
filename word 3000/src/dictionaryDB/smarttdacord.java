package dictionaryDB;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class smarttdacord {

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

    public void insert(int id,String synonyms) {
        String sql = "INSERT INTO Synonyms(id,synonyms) VALUES(?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, synonyms);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void dividesmarttdacord(Element taken){
       // System.out.println();
      //  System.out.println("Synonyms for meaning "+Main.meaningid);
        Elements paragraphs = taken.getElementsByClass("daccord_lt");
        for (Element paragraph : paragraphs) {
            insert(Main.id,paragraph.text());
        }
        //System.out.println();

        Elements synonyms = taken.getElementsByClass("lc lc1 lc-xs6-12 lpb-5 lpr-10");
        for (Element synonym : synonyms) {
            insert(Main.id,synonym.text());
        }


    }
}
