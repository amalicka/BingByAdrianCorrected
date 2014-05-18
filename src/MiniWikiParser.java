
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
}
