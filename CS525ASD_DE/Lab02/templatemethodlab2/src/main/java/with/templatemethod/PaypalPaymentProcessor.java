package with.templatemethod;

import without.templatemethod.VisaCard;

public class PaypalPaymentProcessor implements PaymentProcessor {
	String paypalAddress;

	public PaypalPaymentProcessor(String paypalAddress) {
		this.paypalAddress = paypalAddress;
	}

	public String getPaypalAddress() {
		return paypalAddress;
	}

	public void setPaypalAddress(String paypalAddress) {
		this.paypalAddress = paypalAddress;
	}

	public void processPayment(double amount, String currency, Customer customer) {
		double dollarAmount = getDollorAmount(amount, currency);

		boolean validation = validate();
		if (validation) {
			// logic to perform paypal payment
			System.out.println("Perform payment with paypal address "+paypalAddress+" and amount $"+dollarAmount);

			// logic to notify customer
			System.out.println("Notify customer "+customer.getName()+" with email "+customer.getEmail()+" about paypal payment to address "+paypalAddress);
		}

	}

	public boolean validate() {
		// logic to validate paypal address
		System.out.println("Validate paypal address "+paypalAddress);
		return true;
	}
}
