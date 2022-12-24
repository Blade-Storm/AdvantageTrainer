package com.example.advantagetrainer;

import org.json.JSONException;
import org.json.JSONObject;

public class ActionResolver {
    private static JSONObject strategyObject = null;
    private final String actionKey = "action";
    private final String altActionKey = "altaction";
    private final String deviationKey = "deviation";
    private final String countKey = "count";
    private final String deviationSignKey = "sign";
    private JSONObject handTypeObject;
    private JSONObject dealerHandObject;
    private JSONObject playerActionObject;
    private JSONObject deviationActionObject;
    public Actions action = null;
    public Actions altAction = null;
    public Actions deviationAction = null;
    public Settings.StrategyDeviationSign deviationSign = null;
    public int deviationCount = 0;

    ActionResolver(JSONObject strategy){
        strategyObject = strategy;
    }

    public Actions getActionFromStrategy(Hand playerHand, Hand dealerHand, int count, boolean useDeviations) throws JSONException{
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

    public Actions checkSurrender(Hand playerHand, Hand dealerHand, int count, boolean useDeviations) throws JSONException {
        if(playerHand.canSurrender() && playerHand.getHandType() != Hand.HandType.SOFT){
            handTypeObject = strategyObject.getJSONObject("surrender");
            dealerHandObject = handTypeObject.getJSONObject(dealerHand.getDealerUpCard().getName().toString());
            playerActionObject = dealerHandObject.getJSONObject(String.valueOf(playerHand.getHandTotal()));

            // Check for deviations first, against the count if we are using deviations
            if(playerActionObject.has(deviationKey) && useDeviations){
                deviationAction = checkDeviations(playerActionObject, count);
                if (deviationAction != null && deviationAction == Actions.SURRENDER && playerHand.canSurrender()){
                    return Actions.SURRENDER;
                }else if (deviationAction != null){
                    return deviationAction;
                }
            }

            if(playerActionObject.has(actionKey)) {
                return Actions.stringToAction(playerActionObject.get(actionKey).toString());
            }else{
                return null;
            }
        }
        return null;
    }

    private Actions checkDeviations(JSONObject playerActionObject, int count) throws JSONException {
        deviationActionObject = playerActionObject.getJSONObject(deviationKey);
        deviationCount = (int) deviationActionObject.get(countKey);
        deviationAction = Actions.stringToAction(deviationActionObject.get(actionKey).toString());
        deviationSign = Settings.StrategyDeviationSign.stringToDeviationSign(deviationActionObject.get(deviationSignKey).toString());

        if(deviationSign == Settings.StrategyDeviationSign.GREATER){
            if(count > deviationCount ){
                return deviationAction;
            }
        }else if(deviationSign == Settings.StrategyDeviationSign.GREATER_OR_EQUAL){
            if(count >= deviationCount ){
                return deviationAction;
            }
        }else if(deviationSign == Settings.StrategyDeviationSign.LESS){
            if(count < deviationCount ){
                return deviationAction;
            }
        }else if(deviationSign == Settings.StrategyDeviationSign.LESS_OR_EQUAL){
            if(count <= deviationCount ){
                return deviationAction;
            }
        }

        return null;
    }

    public Actions checkSplit(Hand playerHand, Hand dealerHand, int count, boolean useDeviations) throws JSONException {
        if(playerHand.canSplit()){
            handTypeObject = strategyObject.getJSONObject("split");
            dealerHandObject = handTypeObject.getJSONObject(dealerHand.getDealerUpCard().getName().toString());
            playerActionObject = dealerHandObject.getJSONObject(playerHand.getCards().get(0).getName().toString());

            if(playerActionObject.has(deviationKey) && useDeviations){
                deviationAction = checkDeviations(playerActionObject, count);
                if (deviationAction != null && deviationAction == Actions.SPLIT) {
                    return Actions.SPLIT;
                }
            }

            if(playerActionObject.has(actionKey)) {
                return Actions.stringToAction(playerActionObject.get(actionKey).toString());
            }else{
                return null;
            }
        }
        return null;
    }

    public Actions checkHardOrSoft(Hand playerHand, Hand dealerHand, int count, boolean useDeviations) throws JSONException {
        if(playerHand.getHandType() == Hand.HandType.HARD) {
            handTypeObject = strategyObject.getJSONObject(Hand.HandType.HARD.toString());
        } else if (playerHand.getHandType() == Hand.HandType.SOFT){
            handTypeObject = strategyObject.getJSONObject(Hand.HandType.SOFT.toString());
        }

        dealerHandObject = handTypeObject.getJSONObject(dealerHand.getDealerUpCard().getName().toString());
        playerActionObject = dealerHandObject.getJSONObject(String.valueOf(playerHand.getHandTotal()));
        action = Actions.stringToAction(playerActionObject.get(actionKey).toString());

        if(playerActionObject.has(altActionKey)){
            altAction = Actions.stringToAction(playerActionObject.get(altActionKey).toString());
        }

        if(playerActionObject.has(deviationKey)) {
            deviationAction = checkDeviations(playerActionObject, count);
        }

        if(useDeviations && deviationAction != null){
            if (deviationAction == Actions.DOUBLE_DOWN && playerHand.canDoubleDown()) {
                return Actions.DOUBLE_DOWN;
            } else if(deviationAction == Actions.DOUBLE_DOWN && !playerHand.canDoubleDown()){
                if(action == Actions.DOUBLE_DOWN) {
                    if(altAction != null) {
                        // Action and altAction should never be the same. Sanity check here.
                        if(altAction == Actions.DOUBLE_DOWN){
                            return null;
                        }

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
                if (altAction == Actions.DOUBLE_DOWN) {
                    return null;
                }

                return altAction;
            }
        } else{
            return action;
        }

        return null;
    }
}
