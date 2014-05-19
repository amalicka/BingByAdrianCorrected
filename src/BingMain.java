import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.codec.binary.Base64;
import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.nio.CharBuffer;

public class BingMain {
    /**
     * @param args
     */
	public static String AZURE_APPID = "xic29BHExQOPIPAbviyY9yB7Rl7I9UoXpEq51LFk0kg";
	
	public static String query(String what){
		
		 
        // TODO Auto-generated method stub
        //--------------------------------------Bing search------------------------------
        String searchText = "";
        searchText = what.replaceAll(" ", "%20");
        String accountKey=AZURE_APPID;
      
        byte[] accountKeyBytes = Base64.encodeBase64((accountKey + ":" + accountKey).getBytes());
        String accountKeyEnc = new String(accountKeyBytes);
        URL url;
        try{
            url = new URL(
                    "https://api.datamarket.azure.com/Data.ashx/Bing/Search/v1/Web?Query=%27" + searchText + "%27&$top=50&$format=Atom");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Authorization", "Basic " + accountKeyEnc);
	        //conn.setRequestProperty("Accept", "application/json");
	        BufferedReader br = new BufferedReader(new InputStreamReader(
	                (conn.getInputStream())));
	        StringBuilder sb = new StringBuilder();
	        String output;
	        System.out.println("Output from Server .... \n");
	        char[] buffer = new char[4096];
	        while ((output = br.readLine()) != null) {
        	
            sb.append("\n"+output);
                //text.append(link + "\n\n\n");//Will print the google search links
            //}    
        }

        conn.disconnect();
        int find = sb.indexOf("<d:Description");
        int total = find + 1000;
        System.out.println("Find index: " + find);
        System.out.println("Total index: " + total);
        sb.getChars(find+35, total, buffer, 0);
        String str = new String(buffer);
       
        int find2 = str.indexOf("</d:Description>");
        int total2 = find2 + 400;
        System.out.println("Find index: " + find);
        System.out.println("Total index: " + total);
        char[] buffer2 = new char[1024];
        

        str.getChars(0, find2, buffer2 , 0);
        String str2 = new String(buffer2);
        //Get rid of tags;	
        return sb.toString();
    } catch (MalformedURLException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
        return "Nothing";
	}
        
    public static void main(String[] args) {
 
        
        String doc = BingMain.query("Led Zeppelin");

        XmlMatcher matcher = new XmlMatcher<String>(doc);
        Matcher m = matcher.matchTag("entry");
        System.out.println(doc);
        //Writing mode file handler.
        FileHandler f = new FileHandler("output.txt", false);
        while(m.find()){
        	 System.out.println("Match .... \n");
        	 XmlMatcher m1 = new XmlMatcher<String>(m.group(1));
        	

        	 String title = m1.matchSingleTag("d:Title");
        	 String description = m1.matchSingleTag("d:Description");
        	 String url = m1.matchSingleTag("d:DisplayUrl");
        	 
        
        	 f.writeln(title);
        	 f.writeln(description);
        	 f.writeln(url);
        	 f.writeln("");      	
        	 System.out.println(title);
        	 System.out.println(description);
        	 System.out.println(url);    
        	 System.out.println("\n");   
        }
        f.endwrite();
       
        MiniWikiParser miniwiki = new MiniWikiParser("miniwiki.xml");
        miniwiki.parse();
        
     }
   
}

