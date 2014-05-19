import java.util.*;
import au.com.bytecode.opencsv.*;

import java.util.Arrays;

public class JQuestions {
	public static String m_fileName = "../jepardy-flat-file.csv";
	public List<String> m_questions;
	
	public JQuestions() {
		CSV csv = CSV
			    .separator(',')  // delimiter of fields
			    .quote('"')      // quote character
			    .create();       // new instance is immutable			
		csv.read(m_fileName, new CSVReadProc() {
		    public void procRow(int rowIndex, String... values) {
		        System.out.println(rowIndex + ": " + Arrays.asList(values));
		    }
		});
		
	}
}
