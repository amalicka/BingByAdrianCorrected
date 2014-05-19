
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
	      FileHandler xmlWrite = new FileHandler("saved.xml",false);
	        while(s  != null){
	        	
	        	xmlWrite.write("<DOC>");
	        	xmlWrite.write(" <DOC NO>"+matches+" </DOC NO>");
	        	xmlWrite.write("<DOC>");
	        	String title = XmlMatcher.match(s, "<title>(.+?)</title>");
	        	String text = XmlMatcher.match(s, "<text.+?>(.+?)</text>");	
	        	xmlWrite.write(" <TITLE>"+title+" </TITLE>");
	        
	        	xmlWrite.write(" <TEXT>");
	        		text = text.replaceAll("[\n\r]", "");
	        		xmlWrite.write(text.trim());
	        	xmlWrite.write(" </TEXT>");
	        	        	
	        	//System.out.println(title);
	        		matches = matches + 1;
	        		s = miniwiki.match(pattern);
	        		//System.out.println(s);
	        		
	        	xmlWrite.write("</DOC>");
	        	xmlWrite.write("\n");
	        }	
	        xmlWrite.endwrite();
	}
}
