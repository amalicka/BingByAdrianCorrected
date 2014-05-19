import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import static java.nio.file.StandardOpenOption.*;
public class FileHandler {
	FileWriter m_write;
	PrintWriter m_print;
	BufferedReader m_read;
	public  FileHandler(String path, boolean isReading){

		try{
			if (!isReading){
			 m_write = new FileWriter( path , false);
			 m_print = new PrintWriter(m_write);
			 m_read = null;
			}else{
			  m_read = new BufferedReader(new FileReader(path));
			  m_write = null;
			  
			}
				
				
			
		}
		catch (IOException e){
			System.out.println(e);
		}		
	}
	
	public  void write( String s, boolean newline) throws IOException{
			if (m_write==null)
				throw new IOException("You are in reading mode.");
			if (newline){
				m_write.append(s);
				return ;
			}
			m_write.append(s);
			
	}
	
	public void write( String s){
		try { write(s, false); } catch (IOException ignore) {System.out.println(ignore.getMessage());}
	}
	
	public  void writeln( String s){
		try { write(s, true); } catch (IOException ignore) {System.out.println(ignore.getMessage());}
	}
	
	public void endwrite(){
		m_print.close();
	}
	
	public String readLine() throws IOException{
		if (m_read==null)
			throw new IOException("You are in writing mode.");
		

		
		return m_read.readLine();
	}
	
	public int amountOfLines()  throws IOException {
		int ret = 0;
		String line;
		while((line = this.readLine())!=null){
			ret += 1;
		}
		return ret;
	}
	public StringBuffer readAll() throws IOException {

		StringBuffer ret = new StringBuffer();
		String line;
		int i = 0;
		while((line = this.readLine())!=null){
			i += 1;
			ret.append(line).append( "\n");
		}	
		return ret;
	}
}	
