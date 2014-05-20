import java.util.*;
import au.com.bytecode.opencsv.*;

import java.util.Arrays;

public class JQuestions {
	public static String m_fileName = "../jeperdy-flat-file.csv";
	public List<String> m_questions;
	
	public JQuestions() {
		m_questions = new ArrayList<String>();
		CSV csv = CSV
			    .separator(';')  // delimiter of fields
			    .quote('"')      // quote character
			    .create();       // new instance is immutable			
		csv.read(m_fileName, new CSVReadProc() {
		    public void procRow(int rowIndex, String... values) {
		        System.out.println(rowIndex + ": " + Arrays.asList(values[1]));
		        m_questions.add(values[0]);
		    }
		});
		
	}
	public List<String> shuffle(int amount) throws Exception{
		if (m_questions.size() < amount)
			throw new Exception("You dont have enought question to shuffle that many of them");
		
		List<String> ret = new ArrayList<String>();
		Random r = new Random();
		
		for (int i = 0; i < amount; i++){
			int random = r.nextInt(m_questions.size() + 1);
			ret.add(m_questions.get(random));
			System.out.println("QUESTION SHUFFLE:"+m_questions.get(random));
		}
		
		
		return ret;
	}
}
