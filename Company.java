package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Car> cars= new ArrayList<>();
    private int numOfCars = 5;      //Tried with cars.size(), not working
    private GasStation gasStation = new GasStation(100, 1);

    void addingCars(){
        cars.add(new Car("Gazsi", 50,gasStation));
        cars.add(new Car("Jozsi", 50,gasStation));
        cars.add(new Car("Laci", 50,gasStation));
        cars.add(new Car("Matyi", 50,gasStation));
        cars.add(new Car("Bori", 50,gasStation));

    }

    public void ProcessSimulation(){
        while (!isAllBrokeDown()){
            for(Car car:cars){
                car.setDistanceToGo(Boss.getRouteDistance());
                car.executingTask();
                car.getData();
                System.out.println("The gas station has "+ gasStation.getAmountOfFuel()+" fuel left.");
            }
        }

    }

    private boolean isAllBrokeDown(){
        int brokeCounter=0;
        for(Car car: cars){
            if(!car.isWorking()) brokeCounter++;
        }
        return brokeCounter == numOfCars;
    }
}
