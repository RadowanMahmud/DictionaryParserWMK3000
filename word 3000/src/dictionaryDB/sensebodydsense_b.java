package dictionaryDB;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class sensebodydsense_b {

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

    public void insert(int  id,String more_example) {
        String sql = "INSERT INTO MoreExample(id,more_example) VALUES(?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, more_example);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void dividesensebodysense_b(Element taken){

        Elements paragraphs=taken.getElementsByClass("def-block ddef_block ");
        defblockddefblock def=new defblockddefblock();
        for (Element paragraph : paragraphs) {
            def.dividedefblockddefblock(paragraph);
           // Main.meaningid++;
        }


        Elements moreexampple=taken.getElementsByClass("eg dexamp hax");
        for(Element p: moreexampple){
            insert(Main.id,p.text());
        }
    }
}
       //  Elements phraase=taken.getElementsByClass("pr phrase-block dphrase-block");

