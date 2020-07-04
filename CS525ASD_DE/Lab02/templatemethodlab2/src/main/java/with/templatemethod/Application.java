package with.templatemethod;

import without.templatemethod.VisaCard;

public class Application {

	public static void main(String[] args) {
		Customer customer1 = new Customer("Frank Brown", "fbrown@gmail.com");
		VisaCard visaCard = new VisaCard("1111 2222 3333 4444", "Frank Brown", "09/2026",112);
		PaymentProcessor visaCardPaymentProcessor = new VisaCardPaymentProcessor(visaCard);
		visaCardPaymentProcessor.processPayment(125.75, "USD", customer1);
		
		System.out.println("------------------------------------");
		
		Customer customer2 = new Customer("John Doe", "jdoe@gmail.com");
		PaymentProcessor paypalPaymentProcessor = new PaypalPaymentProcessor("jdoe@gmail.com");
		paypalPaymentProcessor.processPayment(175000.0, "INR", customer2);

	}
}
