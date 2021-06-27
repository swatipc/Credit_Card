package creditcard;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

import com.opencsv.CSVReader;

public class CsvReadingStrategy implements FileParsingStrategy {
	
	@Override
	public void parseFile(File inputFile, File opFile, String opFile_name) {
		try { 
			// Create an object of filereader 
	        // class with CSV file as a parameter. 
	        FileReader filereader = new FileReader(inputFile); 
	        FileWriter csvwriter = new FileWriter(opFile_name);
	        // create csvReader object passing 
	        // file reader as a parameter 
	        CSVReader csvReader = new CSVReader(filereader);
	        
	        String[] nextRecord;
	  
	        System.out.println("Inside CSV Strategy");
	        // we are going to read data line by line 
	        while ((nextRecord = csvReader.readNext()) != null) {
	        	if (nextRecord.length >= 3) {
	        		HashMap<String, String> record = new HashMap<String, String>();
	        		record.put("CardNumber", nextRecord[0]);
	        		record.put("ExpiryDate", nextRecord[1]);
	        		record.put("NameOfCardHolder", nextRecord[2]);
	        		System.out.println(record);
                    
					HandlerResult result = validCardHandler.handle(record);
					if (result.isValid()) {
						// output
		        		System.out.println("Time to write in file");
			            csvwriter.append("CardNumber");
			            csvwriter.append(",");
			            csvwriter.append("CardType");
			            csvwriter.append(",");
			            csvwriter.append("Error");
			            csvwriter.append(",");
			            csvwriter.append("\n");

			            csvwriter.append("Narayana");
			            csvwriter.append(",");
			            csvwriter.append("Ragi");
			            csvwriter.append(",");
			            csvwriter.append("300000000000");
			            csvwriter.append(",");
			            csvwriter.append("\n");
			            csvwriter.close();
			            System.out.println("CSV file created succesfully.");
					}
					else {
						
					}
	        	}
	        }
	        } 
	    	catch (Exception e) { 
	    		e.printStackTrace(); 
	    	} 

	}
}