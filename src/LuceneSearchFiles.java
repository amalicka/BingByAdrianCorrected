
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.*;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.search.*;
import org.apache.lucene.store.*;
import org.apache.lucene.util.Version;
import org.apache.lucene.document.*;
import org.apache.lucene.queryparser.classic.*;
import org.apache.lucene.index.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class LuceneSearchFiles {
	
	public static void main(String[] arg){
		try {
	    Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_40);

	    // Store the index in memory:
	    Directory directory = new RAMDirectory();
	    // To store an index on disk, use this instead:
	    //Directory directory = FSDirectory.open("/tmp/testindex");
	    IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40, analyzer);
	    IndexWriter iwriter = new IndexWriter(directory, config);
	    Document doc = new Document();
	    String text = "This is the text to be indexed.";
	    doc.add(new Field("fieldname", text, TextField.TYPE_STORED));
	    iwriter.addDocument(doc);
	    iwriter.close();
	    
	    // Now search the index:
	    DirectoryReader ireader = DirectoryReader.open(directory);
	    IndexSearcher isearcher = new IndexSearcher(ireader);
	    // Parse a simple query that searches for "text":
	    QueryParser parser = new QueryParser(Version.LUCENE_40, "fieldname", analyzer);
	    Query query = parser.parse("Warsaw");
	    ScoreDoc[] hits = isearcher.search(query, null, 1000).scoreDocs;
	    //assertEquals(1, hits.length);
	    // Iterate through the results:
	    for (int i = 0; i < hits.length; i++) {
	      Document hitDoc = isearcher.doc(hits[i].doc);
	      System.out.println("This is the text to be indexed.-"+ hitDoc.get("fieldname"));
	    }
	    ireader.close();
	    directory.close();	
		} catch (IOException e){
			 System.out.println(e.getMessage());
		} catch(ParseException e){
			System.out.println(e.getMessage());
		}
	}
	
	
}
