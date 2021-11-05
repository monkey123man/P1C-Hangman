import java.net.*;
import java.io.*;
import java.util.ArrayList;
/**
 * Write a description of class Words here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Words  
{
    // instance variables - replace the example below with your own
    
    public static void readInto(ArrayList<String> list) throws Exception 
    {
        String url = "https://gist.githubusercontent.com/sirkets/7d89492826a0d245a086e8c5c56829a8/raw/307ef87315bf0360f682bf25821fdcf4fe71db8c/nouns.txt";
        URL wordsURL = new URL(url);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(wordsURL.openStream()));
        String word;
        while ((word = in.readLine()) != null)
        {
            list.add(word);
        }
        in.close();
    }
}
