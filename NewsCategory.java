import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
public class NewsCategory {
    private String url;
    private String title;
    
    
    public NewsCategory(String url) throws IOException{
        
        this.url = url;
        title = getTitle(url);
    }

    private String getTitle(String link) throws IOException{
        Document doc = Jsoup.connect(link).get();  
        String title = doc.title();  
        return title;
    }

    public String getTitle(){
        return title;
    }

    public String getURL(){
        return url;
    }

    public String toString(){
        return getTitle() + " " + getURL();
    }
}
