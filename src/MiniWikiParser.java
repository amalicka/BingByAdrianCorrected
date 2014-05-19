
public class MiniWikiParser {
	String m_fileName;
	public MiniWikiParser(String file) {
		m_fileName = file;
	}
	public void parse(){
		//Parse a miniwiki file in seperate class.
        BigFile miniwiki = new BigFile(m_fileName);

        System.out.println("Loading wikipedia xml.");


       int matches = 0;
       String s = "";
       String patter = "<page>(.+?)</page>";
      s = miniwiki.match(patter);
       while(s  != null){
       	
       		matches = matches + 1;
       			s = miniwiki.match(patter);
       }
       
       System.out.println("Ended parsing xml. Matches:"+matches);		
	}
	public void test(){
		BigFile miniwiki = new BigFile("miniwiki.xml");
	       String pattern = "<page>(.+?)</page>";
	      String s = miniwiki.match(pattern);
	      int matches = 0;
	        while(s  != null && matches < 20){
	        	System.out.println("<DOC>");
	        	System.out.println(" <DOC NO>"+matches+" </DOC NO>");
	  	        
	        	String title = XmlMatcher.match(s, "<title>(.+?)</title>");
	        	String text = XmlMatcher.match(s, "<text.+?>(.+?)</text>");	
	        	System.out.println(" <TITLE>"+title+" </TITLE>");
	        
	        	System.out.println(" <TEXT>");
	        		text = text.replaceAll("[\n\r]", "");
	        		System.out.println(text.trim());
	        	System.out.println(" </TEXT>");
	        	        	
	        	//System.out.println(title);
	        		matches = matches + 1;
	        		s = miniwiki.match(pattern);
	        		//System.out.println(s);
	        		
	        	System.out.println("</DOC>");
	        }	
	}
}
