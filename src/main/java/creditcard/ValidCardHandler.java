package creditcard;

import java.io.FileWriter;
import java.util.Map;

public class ValidCardHandler implements CardHandler {
	
	CardHandler successor = new InvalidCardHandler();
	CardFactory cardFactory = new CardFactory();

	@Override
	public HandlerResult handle(Map<String, String> cardDetails, FileWriter csvwriter ) {
		String cardNumber = cardDetails.get("CardNumber");
		if (isValid(cardNumber)) {
			try {
				CreditCard creditCard = cardFactory.getCreditCard(cardDetails);
				System.out.println("Valid card found: " + creditCard);
				return new HandlerResult(true, creditCard);
			}
			catch (Exception e) {
				return successor.handle(cardDetails,csvwriter);
			}
			
		}
		else {
			return successor.handle(cardDetails, csvwriter);
		}
	}
	
	private boolean isValid(String cardNumber) {
		return cardNumber != null && cardNumber.length() <= 19;
	}

}
