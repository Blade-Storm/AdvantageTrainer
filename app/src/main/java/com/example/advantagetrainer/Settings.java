package com.example.advantagetrainer;

import java.util.HashMap;
import java.util.Map;

public class Settings {
    public enum CountingStrategy {
        SPANISH21_SECRET (R.raw.sp21secretmonkeycount),
        BJA_H17 (R.raw.bjah17),
        BJA_S17 (R.raw.bjas17);

        public final int rawId;
        CountingStrategy(int id) {
            this.rawId = id;
        }
    }

    public enum HoleCardStrategy {
        BLACKJACK_WIZARD_BASIC(R.raw.wizardofoddsholecardbasic),
        SP21_BASIC(R.raw.sp21holecardbasic);

        public final int rawId;
        HoleCardStrategy(int id) {
            this.rawId = id;
        }
    }

    public enum Deck{
        BLACKJACK ("Blackjack"),
        BLACKJACK_HARD ("Blackjack Hard Mode"),
        SPANISH ("Spanish 21");

        public final String name;
        Deck(String name) {
            this.name = name;
        }
    }

    public enum CountingTest{
        NO_TEST ("No test"),
        END_OF_DRILL ("Single card removed, tested at end of drill"),
        RANDOM ("Randomly tested throughout the drill");

        public final String name;
        CountingTest(String name) {
            this.name = name;
        }
    }

    // Constants
    public final static String SETTINGS_FILE_LOCATION = "com.example.advantagetrainer";
    public final static String CARD_FLASH_SPEED = "cardFlashSpeed";
    public final static String DEALER_CARD_FLASH_SPEED = "dealerCardFlashSpeed";
    public final static String DEALER_PEEK_POSITION = "dealerPeekPosition";
    public final static String DECK_TYPE = "deckTypeToUse";
    public final static String NUM_CARDS_TO_FLASH = "numCardsToFlash";
    public final static String NUM_DECKS_TO_COUNT = "numDecksToCount";
    public final static String NUM_CARDS_IN_HAND = "numCardsInHand";
    public final static String NUM_CARDS_IN_HAND_HOLE_CARD = "numCardsInHandHoleCard";
    public final static String COUNTING_STRATEGY = "countingStrategy";
    public final static String USE_DEVIATIONS = "useDeviations";
    public final static String COUNTING_SYSTEM = "countingSystem";
    public final static String COUNTING_TEST = "countingTest";
    public final static String HOLE_CARD_STRATEGY = "holeCardStrategy";

    // Maps the index from the settings selection to the value
    public final static Map<Integer, Deck> deckTypeMapper;

    static{
        deckTypeMapper = new HashMap<>();
        deckTypeMapper.put(0, Deck.BLACKJACK);
        deckTypeMapper.put(1, Deck.BLACKJACK_HARD);
        deckTypeMapper.put(2, Deck.SPANISH);
    }

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
        numCardToFlashMapper.put(3, 4);
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
        numCardInHandMapper.put(2, 4);
        numCardInHandMapper.put(3, 5);
    }

    // Maps the index from the settings selection to the value
    public final static Map<Integer, CountingStrategy> countingStrategyMapper;

    static {
        countingStrategyMapper = new HashMap<>();
        countingStrategyMapper.put(0, CountingStrategy.SPANISH21_SECRET);
        countingStrategyMapper.put(1, CountingStrategy.BJA_H17);
        countingStrategyMapper.put(2, CountingStrategy.BJA_S17);
    }

    // Maps the index from the settings selection to the value
    public final static Map<Integer, HoleCardStrategy> holeCardStrategyMapper;

    static {
        holeCardStrategyMapper = new HashMap<>();
        holeCardStrategyMapper.put(0, HoleCardStrategy.BLACKJACK_WIZARD_BASIC);
        holeCardStrategyMapper.put(1, HoleCardStrategy.SP21_BASIC);
    }

    // Maps the index from the settings selection to the value
    public final static Map<Integer, CountingTest> countingTestMapper;

    static {
        countingTestMapper = new HashMap<>();
        countingTestMapper.put(0, CountingTest.NO_TEST);
        countingTestMapper.put(1, CountingTest.END_OF_DRILL);
        countingTestMapper.put(2, CountingTest.RANDOM);
    }

}
