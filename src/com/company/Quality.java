package com.company;

public enum Quality {
    NORMAL(1),
    SLIGHTLYSPOILED(2),
    HALFWENTBAD(3),
    ALMOSTALLDISAPPEARED(4),
    SPOILEDINTOTRASH(5);

    private final double num;

    Quality(double num) {
        this.num = num;
    }
    static Quality Isportilsa(Quality quality){
        quality = SPOILEDINTOTRASH;
        return quality;
    }

    static Quality Uhudshenie(Quality quality){
        if (quality.equals(NORMAL)){
            quality = SLIGHTLYSPOILED;
        }else if (quality.equals(SLIGHTLYSPOILED)){
            quality = HALFWENTBAD;
        }else if (quality.equals(HALFWENTBAD)){
            quality = ALMOSTALLDISAPPEARED;
        }else if (quality.equals(ALMOSTALLDISAPPEARED)){
            quality = SPOILEDINTOTRASH;
        }
        return quality;
    }
}
