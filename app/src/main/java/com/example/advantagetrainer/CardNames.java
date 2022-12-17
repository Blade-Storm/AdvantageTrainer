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
}
