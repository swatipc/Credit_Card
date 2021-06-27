package creditcard;
import java.io.File;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;

public class Client {

	public static void main(String[] args) {
		// reading arguments from command line
		File inFile = null;
		File opFile = null;
		String opFile_name = args[1];
		if (0 < args.length) {
		   inFile = new File(args[0]);
		   opFile = new File(args[1]);
		} else {
		   System.err.println("Invalid arguments count:" + args.length);
		   System.exit(0);
		}
		String extension = "";
		String fileName = inFile.getName();
		int f = fileName.lastIndexOf('.');
		if (f >= 0) { 
			extension = fileName.substring(f+1);
		}
		System.out.print(extension);
		if (extension.equals("csv")) {
			CsvReadingStrategy csvr = new CsvReadingStrategy();
			csvr.parseFile(inFile, opFile, opFile_name);
		}
		if (extension.equals("xml")) {
			XmlReadingStrategy xmlr = new XmlReadingStrategy();
			xmlr.parseFile(inFile, opFile,opFile_name);
		}
		if (extension.equals("json")) {
			JsonReadingStrategy jsonr = new JsonReadingStrategy();
			jsonr.parseFile(inFile, opFile,opFile_name);
		}
	
	}

}
	


