package dictionaryDB;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class divideMain {
    public void divideMain(Element document){
        Elements paragraphs = document.getElementsByClass("entry-body");
        for (Element paragraph : paragraphs) {
            enteryBody e= new enteryBody();
            e.divideEntryBody(paragraph);
        }
    }
}
