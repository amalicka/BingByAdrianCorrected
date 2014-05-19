
public class Main {
    public static void main(String[] args) {
    	 
        
 
    	
        System.out.println("Loading big xml file");
         MiniWikiParser miniwiki = new MiniWikiParser("miniwiki.xml");
        // miniwiki.parse();
         miniwiki.parse();
         System.out.println("Ended parsing");
         
    	
      }
}
