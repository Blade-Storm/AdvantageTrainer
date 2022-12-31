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

var action: String? = null
var deviationCount: String? = null
var deviationAction: String? = null
var sign: String? = null
var altAction: String? = null
var modifier: Modifier? = null
var text: String? = null
val dealerHands = arrayListOf("2","3","4","5","6","7","8","9","t","a")

@Composable
fun StrategyDisplayScreen(
    sharedPref: SharedPreferences
) {
    // Get strategy JSON
    val strategy = setStrategy(sharedPref = sharedPref)
    val strategyHard = strategy.hard
    val strategySoft = strategy.soft
    val strategySplit = strategy.split
    val strategySurrender = strategy.surrender

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
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
            val set: MutableSet<String> = mutableSetOf("")
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(Color.LightGray)
            ) {
                strategySplit.sortedWith(nullsFirst(compareBy { it.playerHandTotal }))
                strategySplit.reverse()
                for(i in 0 until strategySplit.size){
                    if(strategySplit[i].playerCard == CardNames.ACE){
                        set.add("A,A")
                    }else if(strategySplit[i].playerCard == CardNames.TEN){
                        set.add("T,T")
                    }else if(strategySplit[i].playerCard != CardNames.QUEEN && strategySplit[i].playerCard != CardNames.JACK && strategySplit[i].playerCard != CardNames.KING){
                        val card = CardValueMapper.cardValueMapper[strategySplit[i].playerCard].toString()
                        set.add("$card,$card")
                    }
                }

                set.forEach {
                    Text(text = it, modifier = Modifier.padding(6.dp))
                }
            }
            for (i in 0 until dealerHands.size) {
                Column {
                    Text(
                        dealerHands[i].uppercase(),
                        modifier = Modifier
                            .background(Color.LightGray)
                            .padding(6.dp)
                            .width(20.dp),
                        textAlign = TextAlign.Center
                    )

                    for (j in 0 until strategySplit.size) {
                        if(strategySplit[j].playerCard != CardNames.QUEEN && strategySplit[j].playerCard != CardNames.JACK && strategySplit[j].playerCard != CardNames.KING){
                            if (strategySplit[j].dealerCard.name == CardNames.stringToCardNames(
                                    dealerHands[i]
                                ).name
                            ) {
                                assignCellValues2(strategySplit[j])

                                text = if(action != null) "Y" else "N"
                                text = if(deviationCount != null) deviationCount.toString() + sign else text
                                modifier = if(action != null) Modifier
                                    .background(Color.Green)
                                    .padding(6.dp)
                                    .width(20.dp) else Modifier
                                    .background(Color.White)
                                    .padding(6.dp)
                                    .width(20.dp)

                                GenerateCell2()
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
            val set: MutableSet<String> = mutableSetOf("")
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(Color.LightGray)
            ) {
                strategySoft.sortBy { it.playerHandTotal }
                strategySoft.reverse()
                for(i in 0 until strategySoft.size){
                    if(strategySoft[i].playerCard != null ){
                        val card = CardValueMapper.cardValueMapper[strategySoft[i].playerCard].toString()
                        set.add("$card,$card")
                    }else if(strategySoft[i].playerCard == null){
                        set.add(strategySoft[i].playerHandTotal.toString())
                    }
                }

                set.forEach {
                    if(it == ""){
                        Text(text = "", modifier = Modifier.padding(6.dp))
                    }else if(it == "13"){
                        Text(text = "A,2", modifier = Modifier.padding(6.dp))
                    }else if(it == "14"){
                        Text(text = "A,3", modifier = Modifier.padding(6.dp))
                    }else if(it == "15"){
                        Text(text = "A,4", modifier = Modifier.padding(6.dp))
                    }else if(it == "16"){
                        Text(text = "A,5", modifier = Modifier.padding(6.dp))
                    }else if(it == "17"){
                        Text(text = "A,6", modifier = Modifier.padding(6.dp))
                    }else if(it == "18"){
                        Text(text = "A,7", modifier = Modifier.padding(6.dp))
                    }else if(it == "19"){
                        Text(text = "A,8", modifier = Modifier.padding(6.dp))
                    }else if(it == "20"){
                        Text(text = "A,9", modifier = Modifier.padding(6.dp))
                    }
                }
            }
            for (i in 0 until dealerHands.size) {
                Column() {
                    Text(
                        dealerHands[i].uppercase(),
                        modifier = Modifier
                            .background(Color.LightGray)
                            .padding(6.dp)
                            .width(20.dp),
                        textAlign = TextAlign.Center
                    )

                    for (j in 0 until strategySoft.size) {
                        if(strategySoft[j].playerHandTotal in 13..20) {
                            if (strategySoft[j].dealerCard.name == CardNames.stringToCardNames(
                                    dealerHands[i]
                                ).name
                            ) {
                                assignCellValues2(strategySoft[j])
                                assignCellModifier2()
                                GenerateCell2()
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
            val set: MutableSet<String> = mutableSetOf("")
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(Color.LightGray)
            ) {
                strategyHard.sortBy { it.playerHandTotal }
                strategyHard.reverse()
                for(i in 0 until strategyHard.size){
                    if(strategyHard[i].playerCard != null ){
                        val card = CardValueMapper.cardValueMapper[strategyHard[i].playerCard].toString()
                        set.add("$card,$card")
                    }else if(strategyHard[i].playerCard == null){
                        if(strategyHard[i].playerHandTotal in 8..17){
                            set.add(strategyHard[i].playerHandTotal.toString())
                        }
                    }
                }

                set.forEach {
                    Text(text = it, modifier = Modifier.padding(6.dp))
                }
            }
            for (i in 0 until dealerHands.size) {
                Column() {
                    Text(
                        dealerHands[i].uppercase(),
                        modifier = Modifier
                            .background(Color.LightGray)
                            .padding(6.dp)
                            .width(20.dp),
                        textAlign = TextAlign.Center
                    )

                    for (j in 0 until strategyHard.size) {
                        if(strategyHard[j].playerHandTotal in 8..17){
                            if (strategyHard[j].dealerCard.name == CardNames.stringToCardNames(
                                    dealerHands[i]
                                ).name
                            ) {
                                assignCellValues2(strategyHard[j])
                                assignCellModifier2()
                                GenerateCell2()
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
            val set: MutableSet<String> = mutableSetOf("")
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(Color.LightGray)
            ) {
                strategySurrender.sortBy { it.playerHandTotal }
                strategySurrender.reverse()
                for(i in 0 until strategySurrender.size){
                    if(strategySurrender[i].playerCard != null ){
                        val card = CardValueMapper.cardValueMapper[strategySurrender[i].playerCard].toString()
                        set.add("$card,$card")
                    }else if(strategySurrender[i].playerCard == null){
                        set.add(strategySurrender[i].playerHandTotal.toString())
                    }
                }

                set.forEach {
                    Text(text = it, modifier = Modifier.padding(5.dp))
                }
            }
            for (i in 0 until dealerHands.size) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    if (CardNames.stringToCardNames(dealerHands[i]) == CardNames.ACE || CardValueMapper.cardValueMapper[(CardNames.stringToCardNames(dealerHands[i]))]!! > 5){
                        Text(
                            dealerHands[i].uppercase(),
                            modifier = Modifier
                                .background(Color.LightGray)
                                .padding(5.dp)
                                .width(35.dp),
                            textAlign = TextAlign.Center
                        )

                        for (j in 0 until strategySurrender.size) {
                            if (strategySurrender[j].dealerCard.name == CardNames.stringToCardNames(
                                    dealerHands[i]
                                ).name
                            ) {
                                assignCellValues2(strategySurrender[j])
                                assignCellModifier2()
                                GenerateCell2()
                            }
                        }
                    }
                }
            }
        }
    }
}

fun assignCellValues2(strategyHand: StrategyCombinatorial.Hand){
    if (strategyHand.deviationAction != null) {
        deviationCount = strategyHand.deviationCount.toString()
        sign = strategyHand.deviationSign.toString()
        deviationAction = strategyHand.deviationAction.toString()

        if (sign == StrategyDeviationSign.GREATER_OR_EQUAL.name || sign == StrategyDeviationSign.GREATER.name) {
            sign = "+"
        } else if (sign == StrategyDeviationSign.LESS_OR_EQUAL.name || sign == StrategyDeviationSign.LESS.name) {
            sign = "-"
        }
    }else{
        sign = null
        deviationCount = null
    }

    action = if(strategyHand.playerAction != null) strategyHand.playerAction.toString() else null
    altAction = if(strategyHand.playerAltAction != null) strategyHand.playerAltAction.toString() else null
}

fun assignCellModifier2(){
    if(action.toString() == Actions.DOUBLE_DOWN.toString() && (altAction != null && altAction.toString() == Actions.STAND.toString())){
        modifier = Modifier
            .background(Color.Cyan)
            .padding(6.dp)
            .width(20.dp)
        text = if(deviationCount != null) deviationCount.toString() + sign else "Ds"
    }else if(action.toString() == "hit"){
        modifier = Modifier
            .background(Color.White)
            .padding(6.dp)
            .width(20.dp)
        text = if(deviationCount != null) deviationCount.toString() + sign else "H"
    }else if (action.toString() == "stand"){
        modifier = Modifier
            .background(Color.Yellow)
            .padding(6.dp)
            .width(20.dp)
        text = if(deviationCount != null) deviationCount.toString() + sign else "S"
    }else if (action.toString() == "double") {
        modifier = Modifier
            .background(Color.Green)
            .padding(6.dp)
            .width(20.dp)
        text = if(deviationCount != null) deviationCount.toString() + sign else "D"
    }else if(action.toString() == "surrender"){
        modifier = Modifier
            .background(Color.Green)
            .padding(5.dp)
            .width(35.dp)
        text = if(deviationCount != null) deviationCount.toString() + sign else "LS"
    }else{
        modifier = Modifier
            .background(Color.White)
            .width(35.dp)
            .padding(5.dp)
        text = if(deviationCount != null) deviationCount.toString() + sign else ""
    }
}

@Composable
fun GenerateCell2(){
    Text(
        text!!,
        modifier = modifier!!,
        textAlign = TextAlign.Center,
        color = if(deviationCount != null) Color.Red else Color.Black
    )
}