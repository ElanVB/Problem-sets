import java.net.URL;
import java.io.*;
import java.util.Scanner;
public class Weather
{
  public static void getForcast()
  {
    try{
    InputStream webStream = new URL("http://weather.sun.ac.za/").openConnection().getInputStream();
    Scanner webStreamScanner = new Scanner(new BufferedInputStream(webStream), "UTF-8").useDelimiter("\\A");
    //webStreamScanner.useLocale(Locale.US);
    String webData = webStreamScanner.next();
    
    int tokenGreater;
    int tokenStart;
    int tokenEnd;
    int start = 0;
      
    do
    {
    tokenGreater = webData.indexOf("<div align=\"center\">Outside Temperature:<br><span class=\"style6\">", start);
    tokenStart = webData.indexOf("<span id=\"temperature\">", tokenGreater);
    tokenEnd = webData.indexOf("</span>", tokenStart);
    
    start = tokenEnd;
    
    System.out.println(webData.substring(tokenStart + 26, tokenEnd));
    System.out.println();
    }while(tokenEnd < webData.length() - 1);
    }
    catch (Exception e)
    {
      System.out.println("Some error occured");
    }
  }
  
  public static void main(String[] args)
  {
    getForcast();
  }
}