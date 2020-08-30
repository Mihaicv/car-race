package com.codecool.car_race.vehicles;

import com.codecool.car_race.Race;
import com.codecool.car_race.util.RandomHelper;

public class Car extends  Vehicle{

    protected static final int YELLOW_FLAG_SPEED = 75;

    private static final String[] POSSIBLE_NAMES = {
            "Epiphany",
            "Parallel",
            "Blitz",
            "Eos",
            "Evolution",
            "Wolf",
            "Union",
            "Empyrean",
            "Curiosity",
            "Gallop"
    };


    public Car() {
        super(calculateNormalSpeed());
    }
    private static int calculateNormalSpeed(){
        return RandomHelper.nextInt(80,110);
    }

    @Override
    protected String generateName() {
        String firstName = RandomHelper.chooseOne(POSSIBLE_NAMES);
        String lastName = RandomHelper.chooseOne(POSSIBLE_NAMES);
        return firstName + " " + lastName;
    }

    @Override
    public void prepareForLap(Race race) {
        if(race.isYellowFlagActive()) actualSpeed = YELLOW_FLAG_SPEED;
        else actualSpeed = normalSpeed;
    }
}