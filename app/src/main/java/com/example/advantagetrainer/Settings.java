package com.example.advantagetrainer;

import java.util.HashMap;
import java.util.Map;

public class Settings {
    // Constants
    public final static String SETTINGS_FILE_LOCATION = "com.example.advantagetrainer";
    public final static String CARD_FLASH_SPEED = "cardFlashSpeed";
    public final static String USE_SPANISH_DECK = "useSpanishDeck";
    public final static String NUM_CARDS_TO_FLASH = "numCardsToFlash";
    public final static String NUM_DECKS_TO_COUNT = "numDecksToCount";


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
}
