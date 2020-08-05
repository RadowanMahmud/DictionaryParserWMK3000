package dictionaryDB;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class enterposbody {


    public void divideposbody(Element taken){
        Elements paragraphs = taken.getElementsByClass("pr dsense ");
        prdsense pd=new prdsense();
        for (Element paragraph : paragraphs) {
            pd.divideprdense(paragraph);
        }

        Elements paragraphstwo = taken.getElementsByClass("pr dsense dsense-noh");
        for (Element paragraph : paragraphstwo) {
            pd.divideprdense(paragraph);
        }

        Elements idiomselement = taken.getElementsByClass("xref idioms hax dxref-w lmt-25 lmb-25");
        for (Element paragraph : idiomselement) {
            idioms Idioms=new idioms();
            Idioms.getIdiom(paragraph);
        }

        Elements phraseelements= taken.getElementsByClass("xref phrasal_verb hax dxref-w lmt-25 lmb-25");
        if (phraseelements.isEmpty()){
            Elements otherPhraseelements= taken.getElementsByClass("xref phrasal_verbs hax dxref-w lmt-25 lmb-25");

            for(Element pharse: otherPhraseelements){
                phrases Phrase= new phrases();
                Phrase.getPhrase(pharse);
            }
        }
        else{
            for(Element pharse: phraseelements){
                phrases Phrase= new phrases();
                Phrase.getPhrase(pharse);
            }
        }
    }
}
