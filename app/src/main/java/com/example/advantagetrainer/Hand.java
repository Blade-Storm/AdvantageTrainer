package com.example.advantagetrainer;

import androidx.annotation.NonNull;

import com.example.advantagetrainer.enums.CardNames;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    public enum HandType {
        HARD ("hard"),
        SOFT ("soft");

        private final String name;

        HandType(String s) {
            name = s;
        }

        @NonNull
        public String toString() {
            return this.name;
        }
    }

    private final ArrayList<Card> cards;
    private HandType handType = null;
    private int handTotal = 0;
    public int splitCount = 0;

    public Hand(){
        cards = new ArrayList<>();
    }

    /**
     * Adds up the total values of the cards in a players hands
     * 1. If there are Aces add up all of the non Ace values first then determine values of Aces.
     * 2. If there are no Aces add up all of the card values.
     */
    private void calcHandTotal(){
        int numOfAces = 0;
        handTotal = 0;

        // First check for a blackjack.
        if(!isBlackjack()){
            // Add up all of the non Ace value cards
            for (Card card : cards) {
                if(card.getName().equals(CardNames.ACE)){
                    numOfAces += 1;
                }else{
                    handTotal += card.getValue();
                    if(numOfAces == 0){
                        setHandType(HandType.HARD);
                    }
                }
            }

            /*
             * If the non Ace hand total is == 10 and there are multiple Aces the Aces are worth 1 each
             * If the non Ace hand total is > 10 then each Ace is worth 1
             * If the non Ace hand total is < 10 and there is only one Ace then the Ace is worth 11
             * If the non Ace hand total is < 10 and there are multiple Aces then calculate the value of the Aces to be either 1 or 11, whichever makes the hand larger
             */
            if(handTotal == 10 && numOfAces == 1){
                handTotal = 21;
                setHandType(HandType.SOFT);
            }else if(handTotal > 10 && numOfAces == 1){
                for(int i = 0; i < numOfAces; i++){
                    handTotal += 1;
                    setHandType(HandType.HARD);
                }
            }else if(handTotal >= 10 && numOfAces > 1){
                for(int i = 0; i < numOfAces; i++){
                    handTotal += 1;
                    setHandType(HandType.HARD);
                }
            }else if(handTotal < 10 && numOfAces == 1){
                setHandType(HandType.SOFT);
                handTotal += 11;
            }else if(handTotal < 10 && numOfAces > 1){
                // If the number of Aces + the hand tota is over 11 then its a hard hand and each Ace is worth 1
                if(handTotal + numOfAces > 11){
                    setHandType(HandType.HARD);
                    handTotal += numOfAces;
                }else{
                    for(int i = 0; i < numOfAces - 1; i++){
                        // Count the first Ace as an 11 and the others as 1
                        if(i == 0){
                            handTotal += 11;

                        }
                        handTotal += 1;
                    }
                    setHandType(HandType.SOFT);
                }
            }
        }
    }

    /**
     * Checks a hand for blackjack.
     */
    public boolean isBlackjack(){
        if(cards.size() != 2){
            return false;
        }else{
            if(splitCount == 0 && (cards.get(0).isTenValue() && cards.get(1).isAceValue() || (cards.get(1).isTenValue() && cards.get(0).isAceValue()))){
                handTotal = 21;
                setHandType(HandType.SOFT);
                return true;
            }
        }
        return false;
    }

    /**
     * For testing purposes only. Calculates the hand total
     */
    public int getHandTotal(){
        calcHandTotal();
        return handTotal;
    }

    public boolean didBust(){
        // The player or dealer busts if their hand total is greater than 21
        return handTotal > 21;
    }

    public void addCard(Card card){
        cards.add(card);

        // Calculate the hand total to determine if its a soft hand: total < 12 with an Ace
        calcHandTotal();
    }

    private void setHandType(HandType handtype){
        handType = handtype;
    }

    public HandType getHandType(){
        return handType;
    }

    public ArrayList<Card> getCards(){
        return cards;
    }

    public boolean canSplit(){
        // Player can only split on their first two cards
        // If both cards are Aces or both cards have the same value return true
        return cards.size() == 2 && cards.get(0).getValue().equals(cards.get(1).getValue());
    }

    public boolean canSurrender(){
        return cards.size() == 2;
    }

    public boolean canDoubleDown(){
        if(!Game.isSpanishGame){
            return cards.size() == 2;
        }else {
            return true;
        }

    }

    public Card getDealerUpCard(){
        return getCards().get(0);
    }

    public Hand withCards(List<Card> cards){
        for(int i = 0; i < cards.size(); i++){
            addCard(cards.get(i));
        }

        return this;
    }
}
