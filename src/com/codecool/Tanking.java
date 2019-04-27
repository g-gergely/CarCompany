package com.codecool;

public interface Tanking {
    boolean isEnoughFuel(int fuelNeeded);
    void takingFuelFromGasStation(int amountOfTaken);
    int getPricePerLiter();
}
