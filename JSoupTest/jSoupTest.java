import org.jsoup.*;
import org.jsoup.select.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.*;
import org.jsoup.examples.*;
import org.jsoup.safety.*;
import java.io.File;
import java.io.IOException;

public class jSoupTest{
    public static void main(String[] args){
        try {
        File input = new File("./input.html");
        Document doc = Jsoup.connect("http://uci.campusdish.com/Commerce/Catalog/Menus.aspx?LocationId=3078").get();
        System.out.println("Created Document...");
        System.out.println(doc.select("a").text());
        for (Element el : doc.select("div#menu-name > a"))
            System.out.println(el.text());
        } catch(IOException e){}
    }
}
