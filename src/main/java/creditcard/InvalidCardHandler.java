package creditcard;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class InvalidCardHandler implements CardHandler {

	@Override
	public HandlerResult handle(Map<String, String> cardDetails, FileWriter csvwriter) {
		try {
			String cardNumber = cardDetails.get("CardNumber");	
			csvwriter.append(cardNumber);
			csvwriter.append(",");
			csvwriter.append("Invalid");
			csvwriter.append(",");
			csvwriter.append("InvalidCardNumber");
			csvwriter.append(",");
			csvwriter.append("\n");
			System.out.println("Invalid card found: " + cardDetails);
			return new HandlerResult(false, null);
			}
	    catch (IOException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
	       }

}
}
