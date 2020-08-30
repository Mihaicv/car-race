package com.codecool.car_race;

import com.codecool.car_race.vehicles.Car;
import com.codecool.car_race.vehicles.Truck;
import com.codecool.car_race.vehicles.Vehicle;

import java.util.LinkedList;
import java.util.List;

public class Race {
        private final List<Vehicle> vehicles=new LinkedList<>();
    static final int NUM_OF_LAPS = 50;
    private boolean brokenTruck;
    /**
     * Simulates the passing of time by advancing the weather and
     * moving the vehicles for the duration of a whole race.
     */
    public void simulateRace() {
        for (int i = 0; i < NUM_OF_LAPS; i++) {
            for (Vehicle vehicle : vehicles) {
                vehicle.prepareForLap(this);
                vehicle.moveForAnHour();
            }

            // change weather and update broken truck status after the movement done
            weather.randomize();
            // TODO: check if a yellow flag should be active
        }

        for (int i = 0; i < NUM_OF_LAPS; i++) {

            // change weather and update broken truck status after the movement done
            weather.randomize();
            brokenTruck = getBrokenTruckStatus(); // <-- this is what we add in this method
        }


    }
    private boolean getBrokenTruckStatus() {
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Truck) {
                Truck truck = (Truck) vehicle;
                if (truck.isBrokenDown()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Prints the state of all vehicles. Called at the end of the
     * race.
     */
    public void printRaceResults() {
        System.out.println("Race results");
        vehicles.forEach(System.out::println);
    }

    public void registerRacer(Vehicle racer) {
        vehicles.add(racer);
    }
    private Weather weather = new Weather();
    public boolean isRaining() {
        return weather.isRaining();
    }
    public boolean isYellowFlagActive() {
        return brokenTruck;
    }

}
