package creditcard;

import java.util.Map;

public class CardFactory {

	public CreditCard getCreditCard(Map<String, String> cardDetails) {
		String cardNumber = cardDetails.get("CardNumber");
		String nameOfCardHolder = cardDetails.get("NameOfCardHolder");
		String expiryDate = cardDetails.get("ExpiryDate");
		
		if (cardNumber != null && cardNumber.length() == 16
				&& cardNumber.charAt(0) == '5'
				&& cardNumber.charAt(1) >= '1' && cardNumber.charAt(1) <='5') {
			return new MasterCard(nameOfCardHolder, cardNumber, expiryDate);
		}
		else if (cardNumber != null && (cardNumber.length() == 13 || cardNumber.length() == 16)
				&& cardNumber.charAt(0) == '4' ) {
			return new Visa(nameOfCardHolder, cardNumber, expiryDate);
		}
		else if (cardNumber != null && cardNumber.length() == 15
				&& cardNumber.charAt(0) == '3' 
				&& (cardNumber.charAt(1) == '4' || cardNumber.charAt(1) =='7')) {
			return new AmericanExpress(nameOfCardHolder, cardNumber, expiryDate);
		}
		else if (cardNumber != null && cardNumber.length() == 16
				&& cardNumber.charAt(0) == '6'
				&& cardNumber.charAt(1) == '0'
				&& cardNumber.charAt(2) == '1'
				&& cardNumber.charAt(3) == '1'){
			return new Discover(nameOfCardHolder, cardNumber, expiryDate);
		}
		else {
			throw new RuntimeException();
		}
	}
}
