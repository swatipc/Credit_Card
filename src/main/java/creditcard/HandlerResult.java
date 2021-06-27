package creditcard;

public class HandlerResult {
	
	private boolean valid;
	
	private CreditCard creditCard;

	public HandlerResult(boolean isValid, CreditCard creditCard) {
		this.valid = isValid;
		this.creditCard = creditCard;
	}

	public boolean isValid() {
		return valid;
	}
	
	public CreditCard getCreditCard() {
		return creditCard;
	}
}
