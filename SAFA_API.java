import java.io.IOException;  
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.InputStreamReader;  
import java.net.HttpURLConnection;  
import java.io.BufferedReader;  

public class SAFA_API{

    public String getRequest() throws IOException{
        String res = null;
        String ans;
        String urlName  = "https://safa-api.herokuapp.com";
        URL url = new URL(urlName);
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.setRequestMethod("GET");
        int code = httpConnection.getResponseCode();
        if(code == httpConnection.HTTP_OK){
            InputStreamReader reader = new InputStreamReader(httpConnection.getInputStream());
            BufferedReader bf = new BufferedReader(reader);
            StringBuffer responseStr = new StringBuffer();
            while((res = bf.readLine()) != null){
                responseStr.append(res);
            }
            bf.close();
            httpConnection.disconnect();
            ans = responseStr.toString();
            return ans;
        }
        else{
            System.out.println("Heroku does not work");
            return "";
        }
        


    }

    public ArrayList<String> extractUrls(String text){

        ArrayList<String> containedUrls = new ArrayList<String>();
        String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(text);
    
        while (urlMatcher.find())
        {
            containedUrls.add(text.substring(urlMatcher.start(0),
                    urlMatcher.end(0)));
        }
    
        return containedUrls;
    }

    
}
