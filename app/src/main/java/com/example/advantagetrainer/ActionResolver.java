package com.example.advantagetrainer;

import static java.util.Objects.isNull;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;

public class ActionResolver {
    public enum Strategies {
        GREEN_GAMBIT ("BlackjackGreenUltiCounting");

        private final String name;

        Strategies(String s) {
            name = s;
        }

        @NonNull
        public String toString() {
            return this.name;
        }
    }

    private static JSONObject strategyObject = null;

    ActionResolver(JSONObject strategy){
        strategyObject = strategy;
    }

    public Actions getActionFromStrategy(Hand playerHand, Hand dealerHand) throws JSONException{
        String actionKey = "action";
        JSONObject handTypeObject;
        JSONObject dealerHandObject;
        JSONObject playerActionObject;
        JSONObject deviationActionObject;
        Actions action = null;

        // Check for Surrender
        action = checkSurrender(playerHand, dealerHand);
        if(playerHand.canSplit() && action == null){
            handTypeObject = strategyObject.getJSONObject("split");
            dealerHandObject = handTypeObject.getJSONObject(dealerHand.getDealerUpCard().getName().toString());
            playerActionObject = dealerHandObject.getJSONObject(playerHand.getCards().get(0).getName().toString());

            return Actions.stringToAction(playerActionObject.get(actionKey).toString());
        }
        if(playerHand.getHandType() == Hand.HandType.SOFT){
            handTypeObject = strategyObject.getJSONObject(Hand.HandType.SOFT.toString());
            dealerHandObject = handTypeObject.getJSONObject(dealerHand.getDealerUpCard().getName().toString());
            playerActionObject = dealerHandObject.getJSONObject(String.valueOf(playerHand.getHandTotal()));

            action = Actions.stringToAction(playerActionObject.get(actionKey).toString());
            if(action.equals(Actions.DOUBLE_DOWN) && playerHand.getCards().size() == 2){
                return Actions.DOUBLE_DOWN;
            }else if(action.equals(Actions.DOUBLE_DOWN) && playerHand.getCards().size() != 2){
                // Get the deviation
                if(Boolean.parseBoolean(playerActionObject.optString("hasDeviation"))){
                    deviationActionObject = playerActionObject.getJSONObject("deviationAction");
                    return Actions.stringToAction(deviationActionObject.get(actionKey).toString());
                }else{
                    return Actions.HIT;
                }
            }else{
                return action;
            }

        }else{
            handTypeObject = strategyObject.getJSONObject(Hand.HandType.HARD.toString());
            dealerHandObject = handTypeObject.getJSONObject(dealerHand.getDealerUpCard().getName().toString());
            playerActionObject = dealerHandObject.getJSONObject(String.valueOf(playerHand.getHandTotal()));

            action = Actions.stringToAction(playerActionObject.get(actionKey).toString());
            if(action.equals(Actions.DOUBLE_DOWN) && playerHand.getCards().size() == 2){
                return Actions.DOUBLE_DOWN;
            }else if (action.equals(Actions.DOUBLE_DOWN) && playerHand.getCards().size() != 2){
                // Get the deviation
                if(Boolean.parseBoolean(playerActionObject.optString("hasDeviation"))){
                    deviationActionObject = playerActionObject.getJSONObject("deviationAction");
                    return Actions.stringToAction(deviationActionObject.get(actionKey).toString());
                }else{
                    return Actions.HIT;
                }
            }else{
                return action;
            }
        }
    }

    public Actions checkSurrender(Hand playerHand, Hand dealerHand) throws JSONException {
        String actionKey = "action";
        JSONObject handTypeObject;
        JSONObject dealerHandObject;
        JSONObject playerActionObject;

        if(playerHand.canSurrender()){
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
}
