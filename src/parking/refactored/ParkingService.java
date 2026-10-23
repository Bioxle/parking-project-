package parking.refactored;

import parking.refactored.logsmanager.ReceiptLog;
import parking.refactored.paymentmanager.PaymentMethod;
import parking.refactored.paymentmanager.RefundablePayment;
import parking.refactored.reportmanager.ReportFormatter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParkingService {

    private final List<String> receipts = new ArrayList<>();
    private ReceiptLog receiptLog;
    private ReportFormatter reportFormatter;
    private double total;

    public ParkingService(ReceiptLog receiptLog, ReportFormatter reportFormatter) {
        this.receiptLog = receiptLog;
        this.reportFormatter = reportFormatter;
    }

    public void checkout(Vehicle vehicle, int hours, PaymentMethod method)
            throws IOException {
        double amount = vehicle.getType().calculateFee(hours);
        method.pay(amount);
        total += amount;

        String receipt = vehicle.getPlate() + " | " + vehicle.getType() + " | "
                + hours + " h | " + amount + " MAD | " + method.name();
        receipts.add(receipt);
        receiptLog.log(receipt);
    }

    public void cancel(Vehicle vehicle, int hours) {
        double amount = vehicle.getType().calculateFee(hours);
        System.out.println("Refund " + amount + " MAD at the desk for "
                + vehicle.getPlate());
        total -= amount;
    }

    public void cancel(Vehicle vehicle, int hours, RefundablePayment payment) throws IOException {
        double amount = vehicle.getType().calculateFee(hours);
        payment.refund(amount);
        receiptLog.log("Refund " + amount + " MAD for " + vehicle.getPlate());
        total -= amount;
    }

    public String dailyReport() {
        return reportFormatter.format(receipts, total);
    }

}
