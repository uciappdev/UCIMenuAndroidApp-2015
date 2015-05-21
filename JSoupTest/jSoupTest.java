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
        // this works fine
        for (Element el : doc.select("a"))
            System.out.println(el.text());
        // works in jsoup demo but not here
	// follows correct syntax from jsoup documentation
        for (Element el : doc.select("div#menu-name > a"))
            System.out.println(el.text());
        } catch(IOException e){}
    }
}
