package parking.refactored.paymentmanager;

public interface RefundablePayment extends PaymentMethod {

    void refund(double amount);

}
