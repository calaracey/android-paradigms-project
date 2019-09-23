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
		JSONObject json = null;
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
	
	
	public static void main(String[] args) throws Exception {
		String cityName = "London";
		String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&APPID=f56113b7642a7b4074a4cb058700750f";
		JSONObject json = readJsonFromURL(urlString);
		System.out.println(json);
		JSONObject main = (JSONObject) json.get("main");
		double temp = (double) main.get("temp");
		long pressure = (long) main.get("pressure");
		long humidity = (long) main.get("humidity");
		long visibility = (long) json.get("visibility");
		JSONObject wind = (JSONObject) json.get("wind");
		double windSpeed = (double) wind.get("speed");
		JSONObject sys = (JSONObject) json.get("sys");
		long sunrise = (long) sys.get("sunrise");
		long sunset = (long) sys.get("sunset");
		JSONArray weatherJSON = (JSONArray) json.get("weather");
		JSONObject weather1 = (JSONObject) weatherJSON.get(0);
		String cloudDescription = (String) weather1.get("description");

		Weather weather = new Weather(cityName, temp, cloudDescription, humidity, pressure, visibility, windSpeed, sunrise,sunset);
		System.out.println(weather.toString());
		
		//String urlText = readStringFromURL(urlString);
		//System.out.println(urlText);
	}	// end of main
}
