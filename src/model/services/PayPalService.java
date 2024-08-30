package model.services;

public class PayPalService implements OnlinePaymentService{
	@Override
	public double paymentFee(double amount) {
		return amount += amount * 0.02;
	}

	@Override
	public double interest(double amount, int months) {
		return amount += amount * 0.01 * months;
	}

}
