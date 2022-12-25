package com.example.advantagetrainer

import android.content.SharedPreferences
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.json.JSONObject

var action: String? = null
var deviationCount: String? = null
var sign: String? = null
var altAction: String? = null
var modifier: Modifier? = null
var text: String? = null
val splitHands = arrayListOf<String>("","2,2","3,3","4,4","5,5","6,6","7,7","8,8","9,9","T,T","A,A")
val softHands = arrayListOf<String>("","A,2","A,3","A,4","A,5","A,6","A,7","A,8","A,9")
val hardHands = arrayListOf<String>("","2-8","9","10","11","12","13","14","15","16","17+")

@Composable
fun StrategyDisplayScreen(
    sharedPref: SharedPreferences
) {
    // Get strategy JSON
    val strategy = setStrategy(sharedPref = sharedPref)
    val strategyHard = strategy.getJSONObject("hard")
    val strategySoft = strategy.getJSONObject("soft")
    val strategySplit = strategy.getJSONObject("split")
    val strategySurrender = strategy.getJSONObject("surrender")

    Column(
        modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState())
    ) {
        Text(
            "Pair Splitting",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(Color.LightGray)
            ) {
                for(i in 0 until splitHands.size){
                    Text(text = splitHands[i], modifier = Modifier.padding(6.dp))
                }
            }
            for (i in 2 until strategySplit.length() + 2) {
                var dealerCardValue = i.toString()
                if (i.toString() == "10") {
                    dealerCardValue = "t"
                } else if (i.toString() == "13") {
                    dealerCardValue = "a"
                }

                if (strategySplit.has(dealerCardValue)) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.background(Color.LightGray)
                    ) {
                        Text(
                            if (dealerCardValue.uppercase() == "T") "10" else dealerCardValue.uppercase(),
                            modifier = Modifier.padding(6.dp),
                            textAlign = TextAlign.Center
                        )

                        val dealerHandObject = strategySplit.getJSONObject(dealerCardValue)

                        for (j in 0 until dealerHandObject.length()) {
                            var playerCardValue = (j+2).toString()
                            if ((j+2).toString() == "10") {
                                playerCardValue = "t"
                            } else if ((j+2).toString() == "13") {
                                playerCardValue = "a"
                            }

                            if (j in 0..13) {
                                if (dealerHandObject.has(playerCardValue)) {
                                    val playerHandObject =
                                        dealerHandObject.getJSONObject(playerCardValue)

                                    assignCellValues(playerHandObject)

                                    text = if(action != null) "Y" else "N"
                                    modifier = if(action != null) Modifier.background(Color.Green).padding(6.dp).width(20.dp) else Modifier.background(Color.White).padding(6.dp).width(20.dp)

                                    GenerateCell()
                                }
                            }
                        }
                    }
                }
            }
        }
        
        Text(
            "Soft Totals",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(Color.LightGray)
            ) {
                for(i in 0 until softHands.size){
                    Text(text = softHands[i], modifier = Modifier.padding(6.dp))
                }
            }
            for (i in 2 until strategySoft.length() + 2) {
                var dealerCardValue = i.toString()
                if (i.toString() == "10") {
                    dealerCardValue = "t"
                } else if (i.toString() == "13") {
                    dealerCardValue = "a"
                }

                if (strategySoft.has(dealerCardValue)) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.background(Color.LightGray)
                    ) {
                        Text(
                            if (dealerCardValue.uppercase() == "T") "10" else dealerCardValue.uppercase(),
                            modifier = Modifier.padding(6.dp),
                            textAlign = TextAlign.Center
                        )

                        val dealerHandObject = strategySoft.getJSONObject(dealerCardValue)

                        for (j in 0 until dealerHandObject.length()) {
                            if (j+11 in 13..20) {
                                if (dealerHandObject.has((j+11).toString())) {
                                    val playerHandObject =
                                        dealerHandObject.getJSONObject((j+11).toString())

                                    assignCellValues(playerHandObject)
                                    assignCellModifier()
                                    GenerateCell()
                                }
                            }
                        }
                    }
                }
            }
        }

        Text(
            "Hard Totals",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(Color.LightGray)
            ) {
                for(i in 0 until hardHands.size){
                    Text(text = hardHands[i], modifier = Modifier.padding(6.dp))
                }
            }
            for (i in 2 until strategyHard.length() + 2) {
                var dealerCardValue = i.toString()
                if (i.toString() == "10") {
                    dealerCardValue = "t"
                } else if (i.toString() == "13") {
                    dealerCardValue = "a"
                }

                if (strategyHard.has(dealerCardValue)) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.background(Color.LightGray)
                    ) {
                        Text(
                            if (dealerCardValue.uppercase() == "T") "10" else dealerCardValue.uppercase(),
                            modifier = Modifier.padding(6.dp),
                            textAlign = TextAlign.Center
                        )

                        val dealerHandObject = strategyHard.getJSONObject(dealerCardValue)

                        for (j in 0 until dealerHandObject.length()) {
                            if (j in 8..17) {
                                if (dealerHandObject.has(j.toString())) {
                                    val playerHandObject =
                                        dealerHandObject.getJSONObject(j.toString())

                                    assignCellValues(playerHandObject)
                                    assignCellModifier()
                                    GenerateCell()
                                }
                            }
                        }
                    }
                }
            }
        }

        Text(
            "Late Surrender",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(Color.LightGray)
            ) {
                Text(text = "", modifier = Modifier.padding(3.dp))
                Text(text = "14", modifier = Modifier.padding(3.dp))
                Text(text = "15", modifier = Modifier.padding(3.dp))
                Text(text = "16", modifier = Modifier.padding(3.dp))
                Text(text = "17", modifier = Modifier.padding(3.dp))
            }
            for (i in 2 until strategySurrender.length() + 2) {
                var dealerCardValue = i.toString()
                if (i.toString() == "10") {
                    dealerCardValue = "t"
                } else if (i.toString() == "13") {
                    dealerCardValue = "a"
                }

                if (strategySurrender.has(dealerCardValue)) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.background(Color.LightGray)
                    ) {
                        Text(
                            if (dealerCardValue.uppercase() == "T") "10" else dealerCardValue.uppercase(),
                            modifier = Modifier.padding(6.dp),
                            textAlign = TextAlign.Center
                        )

                        val dealerHandObject = strategySurrender.getJSONObject(dealerCardValue)

                        for (j in 0 until dealerHandObject.length()) {
                            if (j in 14..17) {
                                if (dealerHandObject.has(j.toString())) {
                                    val playerHandObject =
                                        dealerHandObject.getJSONObject(j.toString())

                                    assignCellValues(playerHandObject)
                                    assignCellModifier()
                                    GenerateCell()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

fun assignCellValues(playerHandObject: JSONObject){
    if (playerHandObject.has("deviation")) {
        deviationCount = playerHandObject.getJSONObject("deviation").get("count").toString()
        sign = playerHandObject.getJSONObject("deviation").get("sign").toString()

        if (sign == Settings.StrategyDeviationSign.GREATER_OR_EQUAL.sign || sign == Settings.StrategyDeviationSign.GREATER.sign) {
            sign = "+"
        } else if (sign == Settings.StrategyDeviationSign.LESS_OR_EQUAL.sign || sign == Settings.StrategyDeviationSign.LESS.sign) {
            sign = "-"
        }
    } else {
        deviationCount = null
        sign = null
    }

    action = if (playerHandObject.has("action")) playerHandObject.get("action").toString() else null
    altAction = if(playerHandObject.has("altaction")) playerHandObject.get("altaction").toString() else null
}

fun assignCellModifier(){
    if(action.toString() == Actions.DOUBLE_DOWN.toString() && (altAction != null && altAction.toString() == Actions.STAND.toString())){
        modifier = Modifier.background(Color.Cyan).padding(6.dp).width(20.dp)
        text = "Ds"
    }else if(action.toString() == "hit"){
        modifier = Modifier.background(Color.White).padding(6.dp).width(20.dp)
        text = "H"
    }else if (action.toString() == "stand"){
        modifier = Modifier.background(Color.Yellow).padding(6.dp).width(20.dp)
        text = "S"
    }else if (action.toString() == "double") {
        modifier = Modifier.background(Color.Green).padding(6.dp).width(20.dp)
        text = "D"
    }else if(action.toString() == "surrender"){
        modifier = Modifier.background(Color.Green).padding(2.dp).width(30.dp)
        text = "LS"
    }else{
        modifier = Modifier.background(Color.White).padding(2.dp).width(30.dp)
        text = ""
    }
}

@Composable
fun GenerateCell(){
    if (deviationCount == null) {
        Text(
            text!!,
            modifier = modifier!!,
            textAlign = TextAlign.Center
        )
    } else {
        Text(
            deviationCount.toString() + sign,
            modifier = modifier!!,
            textAlign = TextAlign.Center,
            color = Color.Red
        )
    }
}