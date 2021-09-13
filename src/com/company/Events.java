package com.company;

import java.util.Random;

public enum Events {
    TypicalDay,
    Rain,
    GoodRoad,
    BreakWheel,
    River,
    MeetTheStranger,
    ThiefOnTheRoad,
    Brawl,
    BadNews;

    static Events getRandomEvent(){
        Integer maxValue = Events.values().length;
        Random random = new Random();
        Integer randomValueIndex = random.nextInt(maxValue);
        return Events.values()[randomValueIndex];
    }
}
