package com.example.advantagetrainer;

import androidx.annotation.NonNull;

public enum StrategyDeviationSign {
    GREATER ("greaterThan"),
    GREATER_OR_EQUAL("greaterThanOrEqual"),
    LESS ("lessThan"),
    LESS_OR_EQUAL("lessThanOrEqual");

    public final String name;
    StrategyDeviationSign(String s){ name = s; }

    @NonNull
    public String toString() {
        return this.name;
    }
    public static StrategyDeviationSign stringToDeviationSign(String sign){
        switch(sign){
            case "greaterThan": return GREATER;
            case "greaterThanOrEqual": return GREATER_OR_EQUAL;
            case "lessThan": return LESS;
            case "lessThanOrEqual": return LESS_OR_EQUAL;
            default: throw new IllegalArgumentException();
        }
    }
}