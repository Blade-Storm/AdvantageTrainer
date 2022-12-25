package com.example.advantagetrainer;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public class Settings {
    public enum Strategy{
        SPANISH21_SECRET (R.raw.sp21secretmonkeycount),
        BJA_H17 (R.raw.bjah17),
        BJA_S17 (R.raw.bjas17);

        public final int rawId;
        Strategy(int id) {
            this.rawId = id;
        }
    }

    public enum StrategyDeviationSign{
        GREATER ("greaterThan"),
        GREATER_OR_EQUAL("greaterThanOrEqual"),
        LESS ("lessThan"),
        LESS_OR_EQUAL("lessThanOrEqual");

        public final String sign;
        StrategyDeviationSign(String sign){
            this.sign = sign;
        }

        @NonNull
        public String toString() {
            return this.sign;
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

    // Constants
    public final static String SETTINGS_FILE_LOCATION = "com.example.advantagetrainer";
    public final static String CARD_FLASH_SPEED = "cardFlashSpeed";
    public final static String USE_SPANISH_DECK = "useSpanishDeck";
    public final static String NUM_CARDS_TO_FLASH = "numCardsToFlash";
    public final static String NUM_DECKS_TO_COUNT = "numDecksToCount";
    public final static String NUM_CARDS_IN_HAND = "numCardsInHand";
    public final static String STRATEGY = "strategy";
    public final static String USE_DEVIATIONS = "useDeviations";


    // Maps the index from the settings selection to the value
    public final static Map<Integer, Long> cardFlashSpeedMapper;

    static{
        cardFlashSpeedMapper = new HashMap<>();
        cardFlashSpeedMapper.put(0, 250L);
        cardFlashSpeedMapper.put(1, 500L);
        cardFlashSpeedMapper.put(2, 1000L);
        cardFlashSpeedMapper.put(3, 1500L);
        cardFlashSpeedMapper.put(4, 2000L);
    }

    // Maps the index from the settings selection to the value
    public final static Map<Integer, Integer> numCardToFlashMapper;

    static{
        numCardToFlashMapper = new HashMap<>();
        numCardToFlashMapper.put(0, 1);
        numCardToFlashMapper.put(1, 2);
        numCardToFlashMapper.put(2, 3);

    }

    // Maps the index from the settings selection to the value
    public final static Map<Integer, Integer> numDecksToCountMapper;

    static{
        numDecksToCountMapper = new HashMap<>();
        numDecksToCountMapper.put(0, 1);
        numDecksToCountMapper.put(1, 2);
        numDecksToCountMapper.put(2, 4);
        numDecksToCountMapper.put(3, 6);
        numDecksToCountMapper.put(4, 8);
    }

    // Maps the index from the settings selection to the value
    public final static Map<Integer, Integer> numCardInHandMapper;

    static{
        numCardInHandMapper = new HashMap<>();
        numCardInHandMapper.put(0, 2);
        numCardInHandMapper.put(1, 3);
    }

    // Maps the index from the settings selection to the value
    public final static Map<Integer, Strategy> strategyMapper;

    static{
        strategyMapper = new HashMap<>();
        strategyMapper.put(0, Strategy.SPANISH21_SECRET);
        strategyMapper.put(1, Strategy.BJA_H17);
        strategyMapper.put(2, Strategy.BJA_S17);
    }
}
