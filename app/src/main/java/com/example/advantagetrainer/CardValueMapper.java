package com.example.advantagetrainer;

import java.util.HashMap;
import java.util.Map;

public class CardValueMapper {
    public static Map<CardNames, Integer> cardValueMapper;

    static{
        cardValueMapper = new HashMap<>();
        cardValueMapper.put(CardNames.ACE, null);
        cardValueMapper.put(CardNames.TWO, 2);
        cardValueMapper.put(CardNames.THREE, 3);
        cardValueMapper.put(CardNames.FOUR, 4);
        cardValueMapper.put(CardNames.FIVE, 5);
        cardValueMapper.put(CardNames.SIX, 6);
        cardValueMapper.put(CardNames.SEVEN, 7);
        cardValueMapper.put(CardNames.EIGHT, 8);
        cardValueMapper.put(CardNames.NINE, 9);
        cardValueMapper.put(CardNames.TEN, 10);
        cardValueMapper.put(CardNames.JACK, 10);
        cardValueMapper.put(CardNames.QUEEN, 10);
        cardValueMapper.put(CardNames.KING, 10);
    }
}
