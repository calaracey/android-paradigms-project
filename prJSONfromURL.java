// example with 2 types of read shown
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.Reader;
import org.json.simple.*;
import org.json.simple.parser.*;

public class prJSONfromURL {
	
	public static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while((cp = rd.read()) != -1) {
			sb.append((char) cp);
		} // end of while
		
		return sb.toString();
	}	// end of method
	

	public static JSONObject readJsonFromURL(String urlString) throws IOException, Exception {
		String jsonText = "";
		URL url = new URL(urlString);
		InputStream is = url.openStream();
		try {
			//buffered read
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader rd = new BufferedReader(isr);
			String jsonText = readAll(rd); // reads using StringBuilder and reader
			
			 Object obj = new JSONParser().parse(jsonText); 
			json = (JSONObject) obj;	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			is.close();
		}
		return json;
	}	// end of method
	
	//converts url info to String using Scanner
	public static String readStringFromURL(String urlString) throws IOException {
	    String allString = "";
	    try {
	    	URL url = new URL(urlString);
	    	InputStream is = url.openStream();
		 
	    	Scanner scanner = new Scanner(is);
	    
	        scanner.useDelimiter("\\A"); // start of string delimiter
	        allString = scanner.hasNext() ? scanner.next() : ""; // now next takes all of it
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
		return allString;
	}	// end of method
	
	
	public static void main(String[] args) throws Exception {
		String urlString = "http://api.openweathermap.org/data/2.5/weather?q=new%20york&APPID=f56113b7642a7b4074a4cb058700750f";
		JSONObject json = readJsonFromURL(urlString);
		System.out.println(json.toString());
		
		//String urlText = readStringFromURL(urlString);
		//System.out.println(urlText);
	}	// end of main
}
