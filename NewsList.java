import java.io.IOException;
import java.util.ArrayList;
public class NewsList{


    private ArrayList<NewsCategory> list;

    public NewsList() throws IOException{
        SAFA_API s = new SAFA_API();
        String ans = s.getRequest();
        ArrayList<String> str = s.extractUrls(ans);
        list = new ArrayList<>();
        for(int i = 0 ; i < str.size(); i++){
            list.add(new NewsCategory(str.get(i)));
        }
    }

    public ArrayList<NewsCategory> getList(){
        return list;
    }

}