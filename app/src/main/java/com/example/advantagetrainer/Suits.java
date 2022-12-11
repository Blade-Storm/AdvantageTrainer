package com.example.advantagetrainer;

public enum Suits {
    CLUB ("c"),
    SPADE ("s"),
    HEART ("h"),
    DIAMOND ("d");

    private final String name;

    Suits(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return this.name;
    }
}