
public class Main {
    public static void main(String[] args) {
    	 
        
        /* String doc = BingMain.query("Led Zeppelin");

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
         f.endwrite();*/
    	
        System.out.println("Loading big xml file");
         MiniWikiParser miniwiki = new MiniWikiParser("miniwiki.xml");
        // miniwiki.parse();
         miniwiki.test();
         System.out.println("Ended parsing");
         
    	
      }
}
