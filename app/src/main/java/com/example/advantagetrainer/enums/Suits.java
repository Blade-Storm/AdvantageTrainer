package com.example.advantagetrainer.enums;

import androidx.annotation.NonNull;

public enum Suits {
    CLUB ("c"),
    SPADE ("s"),
    HEART ("h"),
    DIAMOND ("d");

    private final String name;

    Suits(String s) {
        name = s;
    }

    @NonNull
    public String toString() {
        return this.name;
    }
}