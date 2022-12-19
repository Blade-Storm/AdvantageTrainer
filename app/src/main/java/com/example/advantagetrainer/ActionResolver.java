package com.example.advantagetrainer;

import org.json.JSONException;
import org.json.JSONObject;

public class ActionResolver {
    private static JSONObject strategyObject = null;
    private String actionKey = "action";
    private JSONObject handTypeObject;
    private JSONObject dealerHandObject;
    private JSONObject playerActionObject;
    public Actions action = null;

    ActionResolver(JSONObject strategy){
        strategyObject = strategy;
    }

    public Actions getActionFromStrategy(Hand playerHand, Hand dealerHand) throws JSONException{
        // Check for actions to take
        action = checkSurrender(playerHand, dealerHand);
        action = action == null ? checkSplit(playerHand, dealerHand) : action;
        action = action == null ? checkSoft(playerHand, dealerHand): action;
        action = action == null ? checkHard(playerHand, dealerHand): action;
        return action;
    }

    public Actions checkSurrender(Hand playerHand, Hand dealerHand) throws JSONException {
        if(playerHand.canSurrender() && playerHand.getHandType() != Hand.HandType.SOFT){
            handTypeObject = strategyObject.getJSONObject("surrender");
            dealerHandObject = handTypeObject.getJSONObject(dealerHand.getDealerUpCard().getName().toString());
            playerActionObject = dealerHandObject.getJSONObject(String.valueOf(playerHand.getHandTotal()));

            if(playerActionObject.length() > 0) {
                return Actions.stringToAction(playerActionObject.get(actionKey).toString());
            }else{
                return null;
            }
        }
        return null;
    }

    public Actions checkSplit(Hand playerHand, Hand dealerHand) throws JSONException {
        if(playerHand.canSplit()){
            handTypeObject = strategyObject.getJSONObject("split");
            dealerHandObject = handTypeObject.getJSONObject(dealerHand.getDealerUpCard().getName().toString());
            playerActionObject = dealerHandObject.getJSONObject(playerHand.getCards().get(0).getName().toString());

            if(playerActionObject.length() > 0) {
                return Actions.stringToAction(playerActionObject.get(actionKey).toString());
            }else{
                return null;
            }
        }
        return null;
    }

    public Actions checkSoft(Hand playerHand, Hand dealerHand) throws JSONException {
        if(playerHand.getHandType() == Hand.HandType.SOFT){
            handTypeObject = strategyObject.getJSONObject(Hand.HandType.SOFT.toString());
            dealerHandObject = handTypeObject.getJSONObject(dealerHand.getDealerUpCard().getName().toString());
            playerActionObject = dealerHandObject.getJSONObject(String.valueOf(playerHand.getHandTotal()));

            return checkDouble(playerHand, playerActionObject);
        }

        return null;
    }

    public Actions checkHard(Hand playerHand, Hand dealerHand) throws JSONException {
        if(playerHand.getHandType() == Hand.HandType.HARD){
            handTypeObject = strategyObject.getJSONObject(Hand.HandType.HARD.toString());
            dealerHandObject = handTypeObject.getJSONObject(dealerHand.getDealerUpCard().getName().toString());
            playerActionObject = dealerHandObject.getJSONObject(String.valueOf(playerHand.getHandTotal()));

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
