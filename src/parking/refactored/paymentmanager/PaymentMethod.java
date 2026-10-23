package parking.refactored.paymentmanager;

public interface PaymentMethod {

    void pay(double amount);
    String name();

}
