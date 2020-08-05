package dictionaryDB;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class divideprEntryBody__el {

    public void divideprEntryBody(Element taken){
        Elements header = taken.getElementsByClass("pos-header dpos-h");
        Elements body= taken.getElementsByClass("pos-body");
        enterPrHeader head=new enterPrHeader();
        enterposbody posBody=new enterposbody();

        for (Element paragraph : header) {
            head.enterPrHeader_el(paragraph);
        }

        for (Element paragraph : body) {
            posBody.divideposbody(paragraph);
        }
    }
}
