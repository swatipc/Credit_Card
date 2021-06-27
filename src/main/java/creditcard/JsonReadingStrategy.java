package creditcard;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JsonReadingStrategy implements FileParsingStrategy{

	@Override
	public void parseFile(File inputFile, File opFile, String opFile_name)
	{
		try {
			JSONParser parser = new JSONParser();
			String data = FileUtils.readFileToString(inputFile, "UTF-8");
			JSONArray jsonArray = (JSONArray)parser.parse(data);
        
	        for (Object o : jsonArray) {
	        	System.out.println(o);
	        	JSONObject cc = (JSONObject) o;
	        	
	        	String cardNumber = (String) cc.get("CardNumber");
	        	String expDate = (String) cc.get("ExpirationDate");
	        	String nameOfCardholder = (String) cc.get("NameOfCardholder");
	        	
	        	HashMap<String, String> record = new HashMap<String, String>();
        		record.put("CardNumber", cardNumber);
        		record.put("ExpiryDate", expDate);
        		record.put("NameOfCardHolder", nameOfCardholder);
        		System.out.println(record);
        		validCardHandler.handle(record);
	        }

		}
		catch (IOException e) {
		    e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}