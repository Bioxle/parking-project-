package parking.refactored.tariffmanager.types;

import parking.refactored.tariffmanager.TariffManager;

public class CarTariff implements TariffManager {
    @Override
    public double calculateFee(int hours) {
        return hours*5.0;
    }

    public String toString() {
        return "CAR";
    }
}
