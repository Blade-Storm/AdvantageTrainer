package com.example.advantagetrainer;

import androidx.annotation.NonNull;

import com.example.advantagetrainer.enums.Actions;
import com.example.advantagetrainer.enums.CardNames;
import com.example.advantagetrainer.enums.StrategyDeviationSign;

import java.util.ArrayList;

public class StrategyCombinatorial{
    public ArrayList<Hand> hard;
    public ArrayList<Hand> soft;
    public ArrayList<Hand> split;
    public ArrayList<Hand> surrender;
    public ArrayList<Hand> forfeit;


    StrategyCombinatorial(
            ArrayList<Hand> hard,
            ArrayList<Hand> soft,
            ArrayList<Hand> split,
            ArrayList<Hand> surrender,
            ArrayList<Hand> forfeit
    ){
        this.hard = hard;
        this.soft = soft;
        this.split = split;
        this.surrender = surrender;
        this.forfeit = forfeit;

        validateHands();
    }

    public void validateHands(){
            /*
                dealerCard must exist
                playerHandTotal must exist
                deviationAction is surrender don't allow a playerAction
                deviationAction exists we must have deviationCount and deviationSign
                deviationCount exists we must have deviationAction and deviationSign
             */
        if(this.hard != null){
            for(int i = 0; i < this.hard.size(); i++){
                checkDealerCardInformation(hard.get(i));
                checkPlayerHandTotalInformation(hard.get(i));
                checkDeviationInformation(hard.get(i));
                checkActionInformation(hard.get(i));
                checkHandTypeInformation(hard.get(i), "hard");
            }
        }

            /*
                dealerCard must exist
                playerHandTotal must exist
                deviationAction is surrender don't allow a playerAction
                deviationAction exists we must have deviationCount and deviationSign
                deviationCount exists we must have deviationAction and deviationSign
             */
        if(this.soft != null){
            for(int i = 0; i < this.soft.size(); i++){
                checkDealerCardInformation(soft.get(i));
                checkPlayerHandTotalInformation(soft.get(i));
                checkDeviationInformation(soft.get(i));
                checkActionInformation(soft.get(i));
                checkHandTypeInformation(soft.get(i), "soft");
            }
        }

            /*
                dealerCard must exist
                playerCard must exist
                deviationAction is surrender don't allow a playerAction
                deviationAction exists we must have deviationCount and deviationSign
                deviationCount exists we must have deviationAction and deviationSign
             */
        if(this.split != null){
            for(int i = 0; i < this.split.size(); i++){
                checkPlayerCardInformation(split.get(i));
                checkDealerCardInformation(split.get(i));
                checkDeviationInformation(split.get(i));
                checkHandTypeInformation(split.get(i), "split");
            }
        }

            /*
                dealerCard must exist
                playerHandTotal must exist
                deviationAction is surrender don't allow a playerAction
                deviationAction exists we must have deviationCount and deviationSign
                deviationCount exists we must have deviationAction and deviationSign
             */
        if(this.surrender != null) {
            for (int i = 0; i < this.surrender.size(); i++) {
                checkDealerCardInformation(surrender.get(i));
                checkPlayerHandTotalInformation(surrender.get(i));
                checkDeviationInformation(surrender.get(i));
                // checkActionInformation(surrender.get(i));
                checkHandTypeInformation(surrender.get(i), "surrender");
            }
        }
    }

    private void checkDeviationInformation(Hand hand){
        if(hand.deviationAction != null){
            if(hand.deviationCount == null || hand.deviationSign == null){
                throw new IllegalArgumentException("deviationAction exists but we are missing other deviation information: " + hand);
            }
        }
        if(hand.deviationCount != null){
            if(hand.deviationSign == null){
                throw new IllegalArgumentException("deviationCount exists but we are missing other deviation information: " + hand);
            }
        }
        if(hand.deviationSign != null){
            if(hand.deviationCount == null){
                throw new IllegalArgumentException("deviationSign exists but we are missing other deviation information: " + hand);
            }
        }
    }

    private void checkPlayerCardInformation(Hand hand){
        if(hand.playerCard == null){
            throw new IllegalArgumentException("Hand missing playerCard: " + hand);
        }
    }

    private void checkDealerCardInformation(Hand hand){
        if(hand.dealerCard == null && hand.dealerHandTotal == null){
            throw new IllegalArgumentException("Hand missing dealerCard information: " + hand);
        }
    }

    private void checkPlayerHandTotalInformation(Hand hand){
        if(hand.playerHandTotal == null){
            throw new IllegalArgumentException("Hand missing playerHandTotal: " + hand);
        }
    }

    private void checkActionInformation(Hand hand){
        if(hand.playerAction == null){
            throw new IllegalArgumentException("Hand missing playerAction: " + hand);
        }
        if(hand.playerAction == Actions.DOUBLE_DOWN && hand.playerAltAction == null){
            throw new IllegalArgumentException("Hand missing playerAltAction: " + hand);
        }
    }

    private void checkHandTypeInformation(Hand hand, String expectedHandType){
        if(!hand.handType.equals(expectedHandType)){
            throw new IllegalArgumentException("Incorrect handType: " + hand);
        }
    }

    public static class Hand {
        public String handType;
        public String dealerHandType;
        public CardNames dealerCard;
        public CardNames playerCard;
        public Integer dealerHandTotal;
        public Integer playerHandTotal;
        public Actions playerAction;
        public Actions playerAltAction;
        public Actions deviationAction;
        public Integer deviationCount;
        public StrategyDeviationSign deviationSign;

        Hand(
                String handType,
                String dealerHandType,
                CardNames dealerCard,
                CardNames playerCard,
                Integer dealerHandTotal,
                Integer playerHandTotal,
                Actions playerAction,
                Actions playerAltAction,
                Actions deviationAction,
                Integer deviationCount,
                StrategyDeviationSign deviationSign
        ){
            this.handType = handType;
            this.dealerHandType = dealerHandType;
            this.playerCard = playerCard;
            this.dealerCard =  dealerCard;
            this.dealerHandTotal = dealerHandTotal;
            this.playerHandTotal = playerHandTotal;
            this.playerAction = playerAction;
            this.playerAltAction = playerAltAction;
            this.deviationAction = deviationAction;
            this.deviationCount = deviationCount;
            this.deviationSign = deviationSign;
        }

        @NonNull
        public String toString(){
            String string = "\n";

            string += "handType: " + this.handType + "\n";
            string += "dealerHandType: " + this.dealerHandType + "\n";
            string += "dealerCard: " + this.dealerCard + "\n";
            string += "playerCard: " + this.playerCard + "\n";
            string += "dealerHandTotal" + this.dealerHandTotal + "\n";
            string += "playerHandTotal: " + this.playerHandTotal + "\n";
            string += "playerAction: " + this.playerAction + "\n";
            string += "playerAltAction: " + this.playerAltAction + "\n";
            string += "deviationAction: " + this.deviationAction + "\n";
            string += "deviationCount: " + this.deviationCount + "\n";
            string += "deviationSign: " + this.deviationSign + "\n";

            return string;
        }
    }
}