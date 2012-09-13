package guice;
public class PaymentCardImpl implements Payment {

	@Override
	public void pay() {
		System.out.println("I'll pay with a credit card.");
	}

}
