package com.example.advantagetrainer;

import com.example.advantagetrainer.enums.CardNames;
import com.example.advantagetrainer.enums.Suits;

/**
 * Represents a single card out of the deck
 */
public final class Card {
    private final Suits suit;
    private final CardNames name;
    private final Integer value; // Nullable because the value of an Ace is determined at play time.
    private final int resId; // ResourceId for the drawable folder

    /**
     * Creates a new card
     * @param  suit of the card
     * @param  name of the card - ACE
     * @param  value of the card
     */
    public Card(Suits suit, CardNames name, Integer value, Integer id){
        if(value != null && !value.equals(CardValueMapper.cardValueMapper.get(name))){
            throw new IllegalArgumentException();
        }

        this.suit = suit;
        this.name = name;
        this.value = value;
        this.resId = id;

    }

    /**
     * Get the suit of the card
     */
    public Suits getSuit(){
        return suit;
    }

    /**
     * Get the card's numerical value
     */
    public Integer getValue(){
        if(isAceValue()){
            return 11;
        }
        return value;
    }

    public boolean isTenValue(){
        return name.equals(CardNames.TEN) || name.equals(CardNames.JACK) || name.equals(CardNames.QUEEN) || name.equals(CardNames.KING);
    }

    public boolean isAceValue(){
        return name.equals(CardNames.ACE);
    }

    /**
     * Gets the name of the card. IE: A, J, 2...
     */
    public CardNames getName(){
        return name;
    }

    public Integer getCardImageId(){
        return resId;
    }
}
