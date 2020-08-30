package com.codecool.car_race.vehicles;

import com.codecool.car_race.Race;

public abstract class Vehicle {
    protected final String name;
    protected final int normalSpeed;
    protected int actualSpeed;
    protected int distanceTravelled;

    public Vehicle(int normalSpeed) {
        this.name =generateName();
        this.normalSpeed = normalSpeed;
    }
    protected abstract String generateName();

    public abstract void prepareForLap(Race race);

    public final void moveForAnHour() {
        distanceTravelled += actualSpeed;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{")
                .append("distance travelled: ")
                .append(distanceTravelled)
                .append(",")
                .append("type: ")
                .append(getClass().getSimpleName())
                .append(", ")
                .append("name: ")
                .append(name)
                .append("}");
        return sb.toString();
    }
}

