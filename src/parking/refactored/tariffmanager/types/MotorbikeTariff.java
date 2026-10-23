package parking.refactored.tariffmanager.types;

import parking.refactored.tariffmanager.TariffManager;

public class MotorbikeTariff implements TariffManager {
    @Override
    public double calculateFee(int hours) {
        return hours*2.0;
    }

    public String toString() {
        return "MOTORBIKE";
    }
}
