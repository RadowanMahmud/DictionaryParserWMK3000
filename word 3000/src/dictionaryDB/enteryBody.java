package dictionaryDB;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
public class enteryBody {
    public void divideEntryBody(Element taken){
        Elements paragraphs = taken.getElementsByClass("pr entry-body__el");
        for (Element paragraph : paragraphs) {
            divideprEntryBody__el p=new divideprEntryBody__el();
            p.divideprEntryBody(paragraph);
        }
    }
}
