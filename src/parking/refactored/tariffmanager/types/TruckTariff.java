package parking.refactored.tariffmanager.types;

import parking.refactored.tariffmanager.TariffManager;

public class TruckTariff implements TariffManager {
    @Override
    public double calculateFee(int hours) {
        return 20 + hours*10;
    }

    public String toString() {
        return "TRUCK";
    }
}
