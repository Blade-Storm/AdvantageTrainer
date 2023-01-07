package com.example.advantagetrainer;

import com.example.advantagetrainer.enums.CardNames;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CountingSystem {
    public Map<CardNames, Double> countingSystemMapper = new HashMap<>();
    public JSONObject countingSystemJSON = new JSONObject();
    public Double TWO;
    public Double THREE;
    public Double FOUR;
    public Double FIVE;
    public Double SIX;
    public Double SEVEN;
    public Double EIGHT;
    public Double NINE;
    public Double TEN;
    public Double ACE;

    public Map<CardNames, Double> updateMap(){
        countingSystemMapper.put(CardNames.ACE, Objects.requireNonNullElse(ACE, 0.0));
        countingSystemMapper.put(CardNames.TEN, Objects.requireNonNullElse(TEN, 0.0));
        countingSystemMapper.put(CardNames.NINE, Objects.requireNonNullElse(NINE, 0.0));
        countingSystemMapper.put(CardNames.EIGHT, Objects.requireNonNullElse(EIGHT, 0.0));
        countingSystemMapper.put(CardNames.SEVEN, Objects.requireNonNullElse(SEVEN, 0.0));
        countingSystemMapper.put(CardNames.SIX, Objects.requireNonNullElse(SIX, 0.0));
        countingSystemMapper.put(CardNames.FIVE, Objects.requireNonNullElse(FIVE, 0.0));
        countingSystemMapper.put(CardNames.FOUR, Objects.requireNonNullElse(FOUR, 0.0));
        countingSystemMapper.put(CardNames.THREE, Objects.requireNonNullElse(THREE, 0.0));
        countingSystemMapper.put(CardNames.TWO, Objects.requireNonNullElse(TWO, 0.0));

        return countingSystemMapper;
    }

    public void updateMap(CardNames key, Double newValue){
        countingSystemMapper.put(key, newValue);
    }

    public Map<CardNames, Double> getMap(){
        return countingSystemMapper;
    }

    public String createJSON() throws JSONException {
        countingSystemJSON.put(CardNames.ACE.name(), countingSystemMapper.get(CardNames.ACE));
        countingSystemJSON.put(CardNames.TEN.name(), countingSystemMapper.get(CardNames.TEN));
        countingSystemJSON.put(CardNames.NINE.name(), countingSystemMapper.get(CardNames.NINE));
        countingSystemJSON.put(CardNames.EIGHT.name(), countingSystemMapper.get(CardNames.EIGHT));
        countingSystemJSON.put(CardNames.SEVEN.name(), countingSystemMapper.get(CardNames.SEVEN));
        countingSystemJSON.put(CardNames.SIX.name(), countingSystemMapper.get(CardNames.SIX));
        countingSystemJSON.put(CardNames.FIVE.name(), countingSystemMapper.get(CardNames.FIVE));
        countingSystemJSON.put(CardNames.FOUR.name(), countingSystemMapper.get(CardNames.FOUR));
        countingSystemJSON.put(CardNames.THREE.name(), countingSystemMapper.get(CardNames.THREE));
        countingSystemJSON.put(CardNames.TWO.name(), countingSystemMapper.get(CardNames.TWO));

        return countingSystemJSON.toString();
    }
}
