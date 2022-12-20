package com.example.advantagetrainer;

import org.json.JSONException;
import org.json.JSONObject;

public class ActionResolver {
    private static JSONObject strategyObject = null;
    private final String actionKey = "action";
    private final String deviationKey = "deviation";
    private final String countKey = "count";
    private final String deviationSignKey = "sign";
    private JSONObject handTypeObject;
    private JSONObject dealerHandObject;
    private JSONObject playerActionObject;
    private JSONObject deviationActionObject;
    public Actions action = null;
    public Actions deviationAction = null;
    public Settings.StrategyDeviationSign deviationSign = null;
    public int deviationCount = 0;

    ActionResolver(JSONObject strategy){
        strategyObject = strategy;
    }

    public Actions getActionFromStrategy(Hand playerHand, Hand dealerHand, int count, boolean useDeviations) throws JSONException{
        // Check for actions to take
        action = checkSurrender(playerHand, dealerHand, count, useDeviations);
        action = action == null ? checkSplit(playerHand, dealerHand, count, useDeviations) : action;
        action = action == null ? checkSoft(playerHand, dealerHand, count, useDeviations): action;
        action = action == null ? checkHard(playerHand, dealerHand, count, useDeviations): action;
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

            if(playerActionObject.has(actionKey)) {
                return Actions.stringToAction(playerActionObject.get(actionKey).toString());
            }else{
                return null;
            }
        }
        return null;
    }

    public Actions checkSoft(Hand playerHand, Hand dealerHand, int count, boolean useDeviations) throws JSONException {
        if(playerHand.getHandType() == Hand.HandType.SOFT){
            handTypeObject = strategyObject.getJSONObject(Hand.HandType.SOFT.toString());
            dealerHandObject = handTypeObject.getJSONObject(dealerHand.getDealerUpCard().getName().toString());
            playerActionObject = dealerHandObject.getJSONObject(String.valueOf(playerHand.getHandTotal()));

            // Check for deviations first, against the count if we are using deviations
            if(playerActionObject.has(deviationKey) && useDeviations){
                deviationAction = checkDeviations(playerActionObject, count);
                if (deviationAction != null && deviationAction == Actions.DOUBLE_DOWN && playerHand.canDoubleDown()) {
                    return Actions.DOUBLE_DOWN;
                }else{
                    return deviationAction;
                }
            }

            return checkDouble(playerHand, playerActionObject);
        }

        return null;
    }

    public Actions checkHard(Hand playerHand, Hand dealerHand, int count, boolean useDeviations) throws JSONException {
        if(playerHand.getHandType() == Hand.HandType.HARD){
            handTypeObject = strategyObject.getJSONObject(Hand.HandType.HARD.toString());
            dealerHandObject = handTypeObject.getJSONObject(dealerHand.getDealerUpCard().getName().toString());
            playerActionObject = dealerHandObject.getJSONObject(String.valueOf(playerHand.getHandTotal()));

            // Check for deviations first, against the count if we are using deviations
            if(playerActionObject.has(deviationKey) && useDeviations){
                deviationAction = checkDeviations(playerActionObject, count);
                if (deviationAction != null && deviationAction == Actions.DOUBLE_DOWN && playerHand.canDoubleDown()) {
                    return Actions.DOUBLE_DOWN;
                }else{
                    return deviationAction;
                }
            }
            return checkDouble(playerHand, playerActionObject);
        }

        return null;
    }

    public Actions checkDouble(Hand playerHand, JSONObject playerActionObject) throws JSONException{
        action = Actions.stringToAction(playerActionObject.get(actionKey).toString());
        if(action.equals(Actions.DOUBLE_DOWN) && playerHand.canDoubleDown()){
            return Actions.DOUBLE_DOWN;
        }else if (action.equals(Actions.DOUBLE_DOWN) && !playerHand.canDoubleDown()){
            return Actions.HIT;
        }

        return action;
    }
}
