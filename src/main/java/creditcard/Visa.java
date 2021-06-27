package creditcard;

import java.util.Date;

public class Visa implements CreditCard {

	private String cardHolderName;
	private String cardNumber;
	private String expiryDate;
	
	
	public Visa(String cardHolderName, String cardNumber, String expiryDate) {
		super();
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		System.out.println("Created Visa object");
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
		return "Visa";
	}

}
