package guice;
import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;

public class MyModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(Payment.class).annotatedWith(Names.named("Cash")).to(PaymentCashImpl.class);
		binder.bind(Payment.class).annotatedWith(Names.named("Card")).to(PaymentCardImpl.class);
	}

}
