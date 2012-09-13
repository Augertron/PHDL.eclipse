package guice;
public class PaymentCashImpl implements Payment {

	@Override
	public void pay() {
		System.out.println("I'll pay in cash.");
	}

}
