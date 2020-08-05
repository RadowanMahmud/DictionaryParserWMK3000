package dictionaryDB;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static int id=44285;
    public static String word="";
    public static String pos="";
    public static int submeaning_id=54245;

    static int catchcount=0;

    public static void main(String[] args){

        String baseUrl = "https://dictionary.cambridge.org/dictionary/english/";
        File file = new File("src/words.txt");
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        }
        System.out.println("File reading");
        while (scanner.hasNext())
        {
            String input=scanner.next();
            if(input.contains("-")) continue;
            else{
                word = input.toLowerCase();

                String url = baseUrl + word;
                Document document;
                try {
                    document = Jsoup.connect(url).get();
                    //System.out.println(document.title());
                    //Elements paragraphs = document.getElementsByTag("div");

                    Elements paragraphs = document.getElementsByClass("pr dictionary");
                    for (Element paragraph : paragraphs) {
                        divideMain e= new divideMain();
                        e.divideMain(paragraph);
                        break;
                    }
                } catch (IOException e) {
                    System.out.println("ERROR: " + url + " does not exist");
                    System.out.println(input);
                    catchcount++;
                    if(catchcount==100)return;
                }
                //System.out.println(i);
                //i++;
            }
        }


        /*Document document = Jsoup.connect(url).get();
        System.out.println(document.title());
        //Elements paragraphs = document.getElementsByTag("div");
        Elements paragraphs = document.getElementsByClass("ddef_h");
        for (Element paragraph : paragraphs) {
            System.out.println(paragraph.text());
        }*/
    }
}



