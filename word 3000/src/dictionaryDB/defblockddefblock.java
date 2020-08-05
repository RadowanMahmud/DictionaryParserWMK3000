package dictionaryDB;

import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class defblockddefblock {

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

    public void insertsubMeaning(int id,int submeaning_id,String submeaning) {
        String sql = "INSERT INTO SubMeaning(id,submeaning_id,submeaning) VALUES(?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, submeaning_id);
            pstmt.setString(3,submeaning);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertExample(int submeaning_id,String example) {
        String sql = "INSERT INTO Example(submeaning_id,example) VALUES(?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, submeaning_id);
            pstmt.setString(2,example);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dividedefblockddefblock(Element taken){
        Elements meaninghead=taken.getElementsByClass("def ddef_d db");
        for(Element p: meaninghead){
            insertsubMeaning(Main.id,Main.submeaning_id,p.text());
        }

        Elements example=taken.getElementsByClass("examp dexamp");
        for(Element p: example){
            insertExample(Main.submeaning_id,p.text());
        }
        Main.submeaning_id++;
    }

}
