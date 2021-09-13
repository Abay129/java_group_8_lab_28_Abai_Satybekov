package com.company;

public class MoneyException extends Exception{



    public MoneyException(int money){
        if (money < 0){
            throw new IllegalArgumentException("Так нельзя ");
        }
    }
}
