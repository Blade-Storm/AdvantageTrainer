package com.example.advantagetrainer;

import com.example.advantagetrainer.enums.Actions;
import com.example.advantagetrainer.enums.StrategyDeviationSign;
import java.util.Objects;

public class ActionResolver {
    public Actions action = null;
    public Actions altAction = null;
    public Actions deviationAction = null;
    private final StrategyCombinatorial strategy;

    public ActionResolver(StrategyCombinatorial strategy){
        this.strategy = strategy;
    }

    public Actions getActionFromStrategy(Hand playerHand, Hand dealerHand, int count, boolean useDeviations){
        // Check for actions to take
        if(Game.isSpanishGame){
            action = checkSurrender(playerHand, dealerHand, count, useDeviations);
            action = action == null ? checkSplit(playerHand, dealerHand, count, useDeviations) : action;
        }else{
            action = checkSplit(playerHand, dealerHand, count, useDeviations);
            action = action == null ? checkSurrender(playerHand, dealerHand, count, useDeviations) : action;
        }

        action = action == null ? checkHardOrSoft(playerHand, dealerHand, count, useDeviations) : action;
        return action;
    }

    public Actions checkSurrender(Hand playerHand, Hand dealerHand, int count, boolean useDeviations) {
        StrategyCombinatorial.Hand currentStrategyHand;

        if(playerHand.canSurrender() && playerHand.getHandType() != Hand.HandType.SOFT && strategy.surrender != null){
            // Get the surrender hands from the strategy
            for (int i = 0; i < strategy.surrender.size(); i++){
                action = strategy.surrender.get(i).playerAction;
                deviationAction = strategy.surrender.get(i).deviationAction;
                currentStrategyHand = strategy.surrender.get(i);

                if(dealerHand.getDealerUpCard().getName() == currentStrategyHand.dealerCard && playerHand.getHandTotal() == currentStrategyHand.playerHandTotal){
                    // Check for deviation action
                    if(useDeviations && deviationAction != null){
                        if (checkDeviations(currentStrategyHand, count) != null) {
                            return deviationAction;
                        }
                    }

                    if(action == Actions.SURRENDER){
                        return Actions.SURRENDER;
                    }else{
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public Actions checkSplit(Hand playerHand, Hand dealerHand, int count, boolean useDeviations) {
        StrategyCombinatorial.Hand currentStrategyHand;

        if(playerHand.canSplit() && strategy.split != null){
            // Get the splits hands from the strategy
            for (int i = 0; i < strategy.split.size(); i++){
                currentStrategyHand = strategy.split.get(i);

                // dealerHandTotal in the strategy is not null for hole card strategy
                if(currentStrategyHand.dealerHandTotal != null){
                    // Check to make sure the hand types for both players are the same as the strategy
                    if(Objects.equals(currentStrategyHand.handType, Hand.HandType.SPLIT.toString())
                            && dealerHand.getHandType() == Hand.HandType.stringToHandType(currentStrategyHand.dealerHandType)
                    ){
                        if(playerHand.getCards().get(0).getName() == currentStrategyHand.playerCard && dealerHand.getHandTotal() == currentStrategyHand.dealerHandTotal){
                            if(currentStrategyHand.playerAction == Actions.SPLIT){
                                return Actions.SPLIT;
                            }else{
                                return null;
                            }
                        }
                    }
                }else if(dealerHand.getDealerUpCard().getName() == currentStrategyHand.dealerCard && playerHand.getCards().get(0).getName() == currentStrategyHand.playerCard){
                    // Check for deviation action
                    if(useDeviations && currentStrategyHand.deviationAction != null){
                        deviationAction = checkDeviations(currentStrategyHand, count);
                        if (deviationAction != null) {
                            return deviationAction;
                        }
                    }

                    if(currentStrategyHand.playerAction == Actions.SPLIT){
                        return Actions.SPLIT;
                    }else{
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public Actions checkHardOrSoft(Hand playerHand, Hand dealerHand, int count, boolean useDeviations) {
        if(playerHand.getHandType() == Hand.HandType.HARD){
            for (int i = 0; i < strategy.hard.size(); i++) {
                if(action == null){
                    action = checkHardOrSoftInner(strategy.hard.get(i), playerHand, dealerHand, count, useDeviations);
                }else{
                    break;
                }
            }
        }

        if(playerHand.getHandType() == Hand.HandType.SOFT){
            for (int i = 0; i < strategy.soft.size(); i++) {
                if (action == null) {
                    action = checkHardOrSoftInner(strategy.soft.get(i), playerHand, dealerHand, count, useDeviations);
                } else {
                    break;
                }
            }
        }

        return action;
    }

    public Actions checkHardOrSoftInner(StrategyCombinatorial.Hand strategyHand, Hand playerHand, Hand dealerHand, int count, boolean useDeviations){
        action = strategyHand.playerAction;
        altAction = strategyHand.playerAltAction;
        deviationAction = strategyHand.deviationAction;


        // Hole card strategies don't have a dealer card. Instead they have a dealerHandTotal
        if(strategyHand.dealerHandTotal != null){
            // Check to make sure the hand types for both players are the same as the strategy
            if(playerHand.getHandType() == Hand.HandType.stringToHandType(strategyHand.handType)
                    && dealerHand.getHandType() == Hand.HandType.stringToHandType(strategyHand.dealerHandType)
            ){
                if(playerHand.getHandTotal() == strategyHand.playerHandTotal && dealerHand.getHandTotal() == strategyHand.dealerHandTotal){
                    if(altAction != null && altAction == Actions.DOUBLE_DOWN){
                        if(playerHand.canDoubleDown()){
                            return Actions.DOUBLE_DOWN;
                        }else{
                            return action;
                        }
                    }else{
                        return action;
                    }
                }
            }
            // Counting strategies have a dealerCard
        }else if(playerHand.getHandTotal() == strategyHand.playerHandTotal && dealerHand.getDealerUpCard().getName() == strategyHand.dealerCard){
            if(useDeviations && checkDeviations(strategyHand, count) != null){
                if(deviationAction == Actions.DOUBLE_DOWN && playerHand.canDoubleDown()){
                    return Actions.DOUBLE_DOWN;
                }else if(deviationAction == Actions.DOUBLE_DOWN && !playerHand.canDoubleDown()){
                    if(action == Actions.DOUBLE_DOWN){
                        if(altAction != null){
                            return altAction;
                        }
                    }else{
                        return action;
                    }
                }else{
                    return deviationAction;
                }
            }else if(action == Actions.DOUBLE_DOWN && playerHand.canDoubleDown()) {
                return Actions.DOUBLE_DOWN;
            }else if(action == Actions.DOUBLE_DOWN && !playerHand.canDoubleDown()) {
                if(altAction != null) {
                    // Action and altAction should never be the same. Sanity check here.
                    if (altAction  == Actions.DOUBLE_DOWN) {
                        return null;
                    }

                    return altAction;
                }
            } else{
                return action ;
            }
        }
        return null;
    }

    private Actions checkDeviations(StrategyCombinatorial.Hand hand, int count) {
        if(hand.deviationSign == StrategyDeviationSign.GREATER){
            if(count > hand.deviationCount ){
                return hand.deviationAction;
            }
        }else if(hand.deviationSign == StrategyDeviationSign.GREATER_OR_EQUAL){
            if(count >= hand.deviationCount ){
                return hand.deviationAction;
            }
        }else if(hand.deviationSign == StrategyDeviationSign.LESS){
            if(count < hand.deviationCount ){
                return hand.deviationAction;
            }
        }else if(hand.deviationSign == StrategyDeviationSign.LESS_OR_EQUAL){
            if(count <= hand.deviationCount ){
                return hand.deviationAction;
            }
        }

        return null;
    }
}
