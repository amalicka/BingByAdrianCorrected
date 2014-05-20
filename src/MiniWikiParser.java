
public class MiniWikiParser {
	String m_fileName;
	public MiniWikiParser(String file) {
		m_fileName = file;
	}
	public void parse2(){
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
	public void parse(){
		BigFile miniwiki = new BigFile("../miniwiki.xml");
	       String pattern = "<page>(.+?)</page>";
	      String s = miniwiki.match(pattern);
	      int matches = 0;
	      FileHandler xmlWrite = new FileHandler("../Data/Miniwiki.xml",false);
	        while(s  != null){
	        	

	        	xmlWrite.write("<DOC>\n");
	        	xmlWrite.write("<DOCNO>"+matches+"</DOCNO>\n");
	        	String title = TextMatcher.match(s, "<title>(.+?)</title>");
	        	String text = TextMatcher.match(s, "<text.+?>(.+?)</text>");	
	        	xmlWrite.write("<TITLE>"+title.trim()+"</TITLE>\n");
	        
	        	xmlWrite.write("<TEXT>");
	        		text = text.replaceAll("[\n\r]", "");
	        		xmlWrite.write(text.trim());
	        	xmlWrite.write("</TEXT>\n");
	        	        	
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
