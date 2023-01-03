package com.example.advantagetrainer.enums;

import androidx.annotation.NonNull;

public enum Actions {
    INSURANCE ("insurance"),
    SURRENDER ("surrender"),
    SPLIT ("split"),
    DOUBLE_DOWN ("double"),
    HIT ("hit"),
    STAND ("stand");

    private final String name;

    Actions(String s) {
        name = s;
    }

    @NonNull
    public String toString() {
        return this.name;
    }
    public static Actions stringToAction(String actionString){
        switch(actionString){
            case "insurance": return INSURANCE;
            case "surrender": return SURRENDER;
            case "split": return SPLIT;
            case "double": return DOUBLE_DOWN;
            case "hit": return HIT;
            case "stand": return STAND;
            default: throw new IllegalArgumentException();
        }
    }
}
