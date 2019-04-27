package com.codecool;

public class GasStation implements Tanking {
    private int amountOfFuel;
    private int pricePerLiter;


    GasStation(int amountOfFuel, int pricePerLiter){
        this.amountOfFuel=amountOfFuel;
        this.pricePerLiter=pricePerLiter;

    }
    public boolean isEnoughFuel(int fuelNeeded){
        return amountOfFuel >= fuelNeeded;
    }

    public void takingFuelFromGasStation(int amountOfTaken){
     amountOfFuel-= amountOfTaken;
    }

    public int getPricePerLiter() {
        return pricePerLiter;
    }

    public int getAmountOfFuel(){
        return amountOfFuel;
    }
}
