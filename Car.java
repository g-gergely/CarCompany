package com.codecool;

class Car {
    private String name;
    private int money;
    private int tankSize;
    private int actualFuel;
    private int comsuntation;
    private int distanceToGo;
    private boolean isWorking = true;
    private Tanking tanking;
    
    Car(String name, int tankSize, GasStation gasStation){
        this.name=name;
        this.tankSize =tankSize;
        money=generateMoney();
        comsuntation= generateComsuntation();
        tanking= gasStation;
        actualFuel=tankSize;
    }

    private int generateComsuntation() {
        int min= 5;
        int max = 10;
        return MyRandom.between(min, max);
    }

    private int generateMoney() {
        int max=150;
        return MyRandom.nextInt(max);
    }

    void executingTask(){
        System.out.println("Car "+name+" has "+money+" money");
        System.out.println("Car "+name+" has "+actualFuel+" fuel");
        fuelManager();
        go();
        System.out.println("Car "+name+" left "+money+" money");
        System.out.println("Car "+name+" left "+actualFuel+" fuel");
    }

    private void go(){
        if(isWorking) {
            actualFuel -= (comsuntation * distanceToGo);
            System.out.println("Car "+name+" has traveled: "+ distanceToGo+ " distance.");
        }
        else System.out.println("Car "+name+" has stoped working");
    }

    private void fuelManager(){
        if(actualFuel==0|| actualFuel< distanceToGo*comsuntation){  // check for need of fuel
            int missingFuel = distanceToGo*comsuntation -actualFuel;
            int fuelPrice = tanking.getPricePerLiter();
            int cost = missingFuel*fuelPrice;
            if(isEnoughMoney(cost)){                                // checking coverage
                if(tanking.isEnoughFuel(missingFuel)) {             //checking gas station gas level
                    money-=cost;
                    tanking.takingFuelFromGasStation(missingFuel);
                    actualFuel += missingFuel;
                }
                else isWorking= false;
            }
            else isWorking=false;

        }
    }

    private boolean isEnoughMoney(int money){
        return this.money>= money;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setDistanceToGo(int distanceToGo) {
        this.distanceToGo = distanceToGo;
    }


    String getData() {
        return "Distance traveled is "+ distanceToGo+" :" +" Actual fuel is: "+actualFuel;
    }
}
