package com.example.advantagetrainer;

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

        // Check for Splits
        if(playerHand.canSplit()){
            handTypeObject = strategyObject.getJSONObject("split");
            dealerHandObject = handTypeObject.getJSONObject(dealerHand.getDealerUpCard().getName().toString());
            playerActionObject = dealerHandObject.getJSONObject(playerHand.getCards().get(0).getName().toString());

            return Actions.stringToAction(playerActionObject.get(actionKey).toString());
        }else if(playerHand.getHandType() == Hand.HandType.SOFT){
            handTypeObject = strategyObject.getJSONObject(Hand.HandType.SOFT.toString());
            dealerHandObject = handTypeObject.getJSONObject(dealerHand.getDealerUpCard().getName().toString());
            playerActionObject = dealerHandObject.getJSONObject(String.valueOf(playerHand.getHandTotal()));

            return Actions.stringToAction(playerActionObject.get(actionKey).toString());
        }else{
            handTypeObject = strategyObject.getJSONObject(Hand.HandType.HARD.toString());
            dealerHandObject = handTypeObject.getJSONObject(dealerHand.getDealerUpCard().getName().toString());
            playerActionObject = dealerHandObject.getJSONObject(String.valueOf(playerHand.getHandTotal()));

            return Actions.stringToAction(playerActionObject.get(actionKey).toString());
        }
    }
}
