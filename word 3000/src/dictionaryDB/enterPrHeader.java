package dictionaryDB;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class enterPrHeader {

    public void enterPrHeader_el(Element taken){

        Elements partsofSppech = taken.getElementsByClass("posgram dpos-g hdib lmr-5");
        if(partsofSppech.isEmpty()){
                partsofSppech = taken.getElementsByClass("domain ddomain");
        }
        else if(partsofSppech.isEmpty()){
                partsofSppech = taken.getElementsByClass("usage dusage");
        }

        for (Element paragraph : partsofSppech) {
            //insert(Main.word,Main.id,partsOfSpeech);
            Main.pos=paragraph.text();;
        }
    }
}
