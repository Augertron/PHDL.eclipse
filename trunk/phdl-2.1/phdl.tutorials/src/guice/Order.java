package guice;
import com.google.inject.Inject;

public class Order {
	@Inject
	private @Cash
	Payment payment;

	public void finishOrder() {
		this.payment.pay();
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}
