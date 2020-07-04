package with.templatemethod;

import without.templatemethod.VisaCard;

public class VisaCardPaymentProcessor implements PaymentProcessor {
	VisaCard visaCard;

	public VisaCardPaymentProcessor(VisaCard visaCard) {
		this.visaCard = visaCard;
	}

	public VisaCard getVisaCard() {
		return visaCard;
	}

	public void setVisaCard(VisaCard visaCard) {
		this.visaCard = visaCard;
	}

	public void processPayment(double amount, String currency, Customer customer) {
		double dollarAmount = getDollorAmount(amount, currency);

		boolean validation = validate();
		if (validation) {
			// logic to perform payment visa card
			System.out.println("Perform payment with visa card with card number " + visaCard.getCreditCardNumber()
				+ " and amount $" + dollarAmount);

			// logic to notify customer
			System.out.println("Notify customer " + customer.getName() + " with email " + customer.getEmail()
				+ " about visa credit card payment with card number " + visaCard.getCreditCardNumber());
		}

	}
	
	public boolean validate() {
		// logic to validate visa card
		System.out.println("Validate visa card with card number " + visaCard.getCreditCardNumber());
        return true;
	}
}
