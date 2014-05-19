
import java.util.regex.Pattern;
import java.nio.CharBuffer;

import java.util.regex.Matcher;
public class XmlMatcher<T> {
	private T stream;
	public XmlMatcher(T s){
		setStream(s);
	}

	public void setStream (T s){
		stream = s;
	}
	
	public Matcher match(String reg) throws Exception{
        Pattern p = Pattern.compile( reg);
        if (stream instanceof String){
        	return p.matcher((String)stream);		
        }
        if (stream instanceof CharBuffer){
        	return p.matcher((String)stream);		
        }  
        throw new Exception("Only String and CharBuffer is suppoerted.");
	}
	public static String match(String contet, String reg){
        Pattern p = Pattern.compile( reg,Pattern.DOTALL);
        Matcher m =  p.matcher(contet);
        if (m.find())
        	return m.group(1);	
        
        return "Nothing found";

	}

	public String matchSingleTag(String tagName){
         Matcher m = matchTag(tagName);
         if(m.find())
        	 return (String)m.group(1);
        
         return "";
	}
	public Matcher matchTag(String tagName, boolean inline){
		try{
			if (!inline)
				return match("<"+tagName+".+?>(.+?)</"+tagName+">");
			else
				return match("<"+tagName+"(.+?)/>");
		}catch (Exception e){
			System.out.print(e.getMessage());
			return null;
		}
		
	}
	public Matcher matchTag(String tagName){
			return matchTag(tagName, false);
	}
}
