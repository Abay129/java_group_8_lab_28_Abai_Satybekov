package com.company;

import java.util.Random;

public enum Towns {


    Damascus("Дамаск"),
    Acre("Акра"),
    Jerusalem("Иерусалим"),
    Masiaf("Масиаф"),
    Arsuf("Арсуф");


public final String name;
public  Integer distance;
    Random random = new Random();
    Towns(String name){
        this.name = name;
        this.distance = getDistance();
    }
    static Towns getRandomTown(){
        Integer maxValue = Towns.values().length;
        Random random = new Random();
        Integer randomValueIndex = random.nextInt(maxValue);
        return Towns.values()[randomValueIndex];
    }

    public Integer getDistance() {
        distance = random.nextInt(50) + 50;
        return distance;
    }

    @Override
    public String toString() {
        return "Towns{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }
}
