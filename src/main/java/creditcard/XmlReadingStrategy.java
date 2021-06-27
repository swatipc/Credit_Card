package creditcard;
import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;  

public class XmlReadingStrategy implements FileParsingStrategy {
	
	@Override
	public void parseFile(File inputFile, File opFile,String opFile_name) {
		
		try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("row");
            
            for (int itr = 0; itr < nList.getLength(); itr++) {
            	Node node = nList.item(itr);
            	if (node.getNodeType() == Node.ELEMENT_NODE)  {
            		Element eElement = (Element) node; 
            		HashMap<String, String> record = new HashMap<String, String>();
	        		record.put("CardNumber", eElement.getElementsByTagName("CardNumber").item(0).getTextContent());
	        		record.put("ExpiryDate", eElement.getElementsByTagName("ExpirationDate").item(0).getTextContent());
	        		record.put("NameOfCardHolder", eElement.getElementsByTagName("NameOfCardholder").item(0).getTextContent());
	        		System.out.println(record);
                    validCardHandler.handle(record);
            	}
            }
	    }
		catch (Exception e)   
		{  
		    e.printStackTrace();  
		}  
	}
	
	

}
