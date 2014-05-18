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
			 m_read = null;
			}else{
			  m_read = new BufferedReader(new FileReader(path));
			  m_write = null;
			  
			}
				
				
			 m_print = new PrintWriter(m_write);
		}
		catch (IOException e){
			System.out.println(e);
		}		
	}
	
	public  void write( String s, boolean newline) throws IOException{
			if (m_write==null)
				throw new IOException("You are in reading mode.");
			if (newline){
				m_print.println(s);
				return ;
			}
			m_print.print(s);
			
	}
	
	public void write( String s){
		try { write(s, false); } catch (IOException ignore) {}
	}
	
	public  void writeln( String s){
		try { write(s, true); } catch (IOException ignore) {}
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
	public String[] readAll() throws IOException {
		int size = this.amountOfLines();
		String[] ret = new String[size];
		String line;
		int i = 0;
		while((line = this.readLine())!=null){
			i += 1;
			ret[i] = line;
		}	
		return ret;
	}
}	
