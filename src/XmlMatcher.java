
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class XmlMatcher {
	private String stream;
	public XmlMatcher(String s){
		setStream(s);
	}
	public void setStream (String s){
		stream = s;
	}
	
	public Matcher match(String reg){
        Pattern p = Pattern.compile( reg);
        return p.matcher(stream);		
	}
	public String matchSingleTag(String tagName){
         Matcher m = matchTag(tagName);
         if(m.find())
        	 return (String)m.group(1);
        
         return "";
	}
	public Matcher matchTag(String tagName, boolean inline){
		if (!inline)
			return match("<"+tagName+".+?>(.+?)</"+tagName+">");
		else
			return match("<"+tagName+"(.+?)/>");
		
	}
	public Matcher matchTag(String tagName){
			return matchTag(tagName, false);
	}
}
