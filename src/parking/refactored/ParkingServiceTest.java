package parking.refactored;

import parking.refactored.logsmanager.ReceiptLog;
import parking.refactored.paymentmanager.types.CardPayment;
import parking.refactored.reportmanager.ReportFormatter;
import parking.refactored.reportmanager.types.StandardReportFormatter;
import parking.refactored.tariffmanager.types.TruckTariff;

import java.io.IOException;

public class ParkingServiceTest {
    public static void main(String[] args) throws IOException {
        ReceiptLog mockLogger = message -> System.out.println("TEST LOG: " + message);
        ReportFormatter mockFormatter = new StandardReportFormatter();

        ParkingService service = new ParkingService(mockLogger, mockFormatter);

        Vehicle truck = new Vehicle("24680-D-8", new TruckTariff());
        service.checkout(truck, 4, new CardPayment("4242"));

        System.out.println(service.dailyReport());
    }
}
