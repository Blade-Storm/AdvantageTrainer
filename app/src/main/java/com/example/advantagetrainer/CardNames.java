package com.example.advantagetrainer;

import androidx.annotation.NonNull;

public enum CardNames {
    ACE ("a"),
    KING ("k"),
    QUEEN ("q"),
    JACK ("j"),
    TEN ("t"),
    NINE ("9"),
    EIGHT ("8"),
    SEVEN ("7"),
    SIX ("6"),
    FIVE ("5"),
    FOUR ("4"),
    THREE ("3"),
    TWO ("2");

    private final String name;

    CardNames(String s) {
        name = s;
    }

    @NonNull
    public String toString() {
        return this.name;
    }
    public static CardNames stringToCardNames(String sign){
        switch(sign){
            case "a": return ACE;
            case "k": return KING;
            case "q": return QUEEN;
            case "j": return JACK;
            case "t": return TEN;
            case "9": return NINE;
            case "8": return EIGHT;
            case "7": return SEVEN;
            case "6": return SIX;
            case "5": return FIVE;
            case "4": return FOUR;
            case "3": return THREE;
            case "2": return TWO;
            default: throw new IllegalArgumentException();
        }
    }
}
