package parking.refactored;

import parking.refactored.tariffmanager.TariffManager;

public class Vehicle {
    private final String plate;
    private final TariffManager type;      // "CAR", "MOTORBIKE" or "TRUCK"

    public Vehicle(String plate, TariffManager applicableTariff) {
        this.plate = plate;
        this.type = applicableTariff;
    }

    public String getPlate() { return plate; }

    public TariffManager getType() {
        return type;
    }

    public String getTariff()  { return type.toString(); }
}
