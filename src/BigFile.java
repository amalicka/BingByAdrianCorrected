import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.*;
import java.util.Scanner;
import java.io.File;
import java.util.regex.Pattern;

public class BigFile {
	Scanner m_scanner;

	public BigFile(String file){
		
		try{
		m_scanner = new Scanner( new FileInputStream(file),"UTF-8");  
		}catch(IOException e){
			System.out.print(e.getMessage());
		}
	}
	public Scanner getScanner(){
		return m_scanner;
	}
	public String match(String pattern){
		Pattern pat = Pattern.compile(pattern,Pattern.DOTALL);  
		String ret = m_scanner.findWithinHorizon(pat, 1024*1000*32);
		
		return ret;
	}
	public boolean hasMatches(String pattern){
		return m_scanner.hasNext();
	
	}
	public String next(String pattern){
		if (m_scanner.hasNext())
		return m_scanner.next();
		return null;
		
	}

}
