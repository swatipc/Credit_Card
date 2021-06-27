package creditcard;

import java.util.Date;
import java.util.Map;

public class MasterCard implements CreditCard {

	private String cardHolderName;
	private String cardNumber;
	private String expiryDate;
	
	
	public MasterCard(String cardHolderName, String cardNumber, String expiryDate) {
		super();
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		System.out.println("Created MasterCard Object");
	}

	@Override
	public String getCardHolderName() {
		return cardHolderName;
	}

	@Override
	public String getCardNumber() {
		return cardNumber;
	}

	@Override
	public String getExpiryDate() {
		return expiryDate;
	}
	
	
	public String toString() {
		return new StringBuilder().append("CardNumber: ").append(cardNumber).
				append("CardHolderName: ").append(cardHolderName).
				append("ExpiryDate: ").append(expiryDate).toString();
	}

	@Override
	public String getCardType() {
		return "MasterCard";
	}
}
