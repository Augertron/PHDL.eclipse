package guice;
public class PaymentVisaCard extends PaymentCardImpl {
	@Override
	public void pay() {
		System.out.println("I'll pay with a visa card.");
	}
}
