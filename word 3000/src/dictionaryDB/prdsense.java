package dictionaryDB;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class prdsense {

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

    public void insert(String word, int id,String meaning,String partsOfSpeech) {
        String sql = "INSERT INTO Word(word,id,parts_of_speech,meaning) VALUES(?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, word);
            pstmt.setInt(2, id);
            pstmt.setString(3,partsOfSpeech);
            pstmt.setString(4, meaning);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void divideprdense(Element taken){

        String meaningstring="";
        //taking meaning from dense_h
        Elements meaningelsment= taken.getElementsByClass("guideword dsense_gw");
        if(meaningelsment.isEmpty()){
            insert(Main.word,Main.id,meaningstring,Main.pos);
        }
        for(Element me: meaningelsment){
            meaningstring=me.text();
            //insertion in word table
            insert(Main.word,Main.id,meaningstring,Main.pos);
        }

        Elements paragraphs = taken.getElementsByClass("sense-body dsense_b");
        sensebodydsense_b sense=new sensebodydsense_b();
        for (Element paragraph : paragraphs) {
            sense.dividesensebodysense_b(paragraph);
        }

        Elements synonyms = taken.getElementsByClass("smartt daccord");
        smarttdacord smart=new smarttdacord();
        for(Element synonym: synonyms){
            smart.dividesmarttdacord(synonym);
        }

        Main.id++;
    }

}
