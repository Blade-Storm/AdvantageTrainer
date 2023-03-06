package com.example.advantagetrainer.views

import android.content.SharedPreferences
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
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
import com.example.advantagetrainer.CardValueMapper
import com.example.advantagetrainer.Hand
import com.example.advantagetrainer.StrategyCombinatorial
import com.example.advantagetrainer.enums.Actions
import com.example.advantagetrainer.enums.CardNames

private var action: String? = null
private var altAction: String? = null
private var modifier: Modifier? = null
private var text: String? = null
private val dealerHardHandTotals = arrayListOf("4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19")
private val dealerSoftHandTotals = arrayListOf("12","13","14","15","16","17","18","19","20")

@Composable
fun HoleCardStrategyDisplayScreen (sharedPref: SharedPreferences) {
    // Get strategy JSON
    val strategy = setHoleCardStrategy(sharedPref = sharedPref)
    val strategyHard = strategy.hard
    val strategySoft = strategy.soft
    val strategySplit = strategy.split
    val strategySurrender = strategy.surrender
    val strategyForfeit = strategy.forfeit
    val playerSoftHandsColumn: MutableSet<String> = mutableSetOf("")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .horizontalScroll(rememberScrollState())
    ) {

        if(strategySplit != null){
            Text(
                "Pair Splitting vs Dealer Hard Hands",
                modifier = Modifier.fillMaxWidth().padding(5.dp),
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
                for (i in 0 until dealerHardHandTotals.size) {
                    Column {
                        Text(
                            dealerHardHandTotals[i].uppercase(),
                            modifier = Modifier
                                .background(Color.LightGray)
                                .padding(6.dp)
                                .width(20.dp),
                            textAlign = TextAlign.Center
                        )

                        for (j in 0 until strategySplit.size) {
                            if(strategySplit[j].playerCard != CardNames.QUEEN && strategySplit[j].playerCard != CardNames.JACK && strategySplit[j].playerCard != CardNames.KING){
                                if (strategySplit[j].dealerHandTotal == dealerHardHandTotals[i].toInt() && Hand.HandType.stringToHandType(strategySplit[j].dealerHandType) == Hand.HandType.HARD) {
                                    assignCellValues(strategySplit[j])

                                    text = if(action != null) "Y" else "N"
                                    modifier = if(action != null) Modifier
                                        .background(Color.Green)
                                        .padding(6.dp)
                                        .width(20.dp) else Modifier
                                        .background(Color.White)
                                        .padding(6.dp)
                                        .width(20.dp)

                                    GenerateCell()
                                }
                            }
                        }

                    }
                }
            }
        }
        if(strategySplit != null){
            Text(
                "Pair Splitting vs Dealer Soft Hands",
                modifier = Modifier.fillMaxWidth().padding(5.dp),
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
                    // strategySplit.sortedWith(nullsFirst(compareBy { it.playerHandTotal }))
                    //strategySplit.reverse()
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
                for (i in 0 until dealerSoftHandTotals.size) {
                    Column {
                        Text(
                            dealerSoftHandTotals[i].uppercase(),
                            modifier = Modifier
                                .background(Color.LightGray)
                                .padding(6.dp)
                                .width(20.dp),
                            textAlign = TextAlign.Center
                        )

                        for (j in 0 until strategySplit.size) {
                            if(strategySplit[j].playerCard != CardNames.QUEEN && strategySplit[j].playerCard != CardNames.JACK && strategySplit[j].playerCard != CardNames.KING){
                                if (strategySplit[j].dealerHandTotal == dealerSoftHandTotals[i].toInt() && Hand.HandType.stringToHandType(strategySplit[j].dealerHandType) == Hand.HandType.SOFT) {
                                    assignCellValues(strategySplit[j])

                                    text = if(action != null) "Y" else "N"
                                    modifier = if(action != null) Modifier
                                        .background(Color.Green)
                                        .padding(6.dp)
                                        .width(20.dp) else Modifier
                                        .background(Color.White)
                                        .padding(6.dp)
                                        .width(20.dp)

                                    GenerateCell()
                                }
                            }
                        }

                    }
                }
            }
        }



        if(strategySoft != null){
            Text(
                "Soft Totals vs Dealer Hard Hands",
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
                    GeneratePlayerSoftHandsColumn(strategySoft, playerSoftHandsColumn)
                }
                for (i in 0 until dealerHardHandTotals.size) {
                    Column {
                        Text(
                            dealerHardHandTotals[i].uppercase(),
                            modifier = Modifier
                                .background(Color.LightGray)
                                .padding(6.dp)
                                .width(25.dp),
                            textAlign = TextAlign.Center
                        )

                        for (j in 0 until strategySoft.size) {
                            if(strategySoft[j].playerHandTotal in 11..20) {
                                if (strategySoft[j].dealerHandTotal == dealerHardHandTotals[i].toInt() && Hand.HandType.stringToHandType(strategySoft[j].dealerHandType) == Hand.HandType.HARD) {
                                    assignCellValues(strategySoft[j])
                                    assignCellModifier()
                                    GenerateCell()
                                }
                            }
                        }

                    }
                }
            }
        }
        if(strategySoft != null){
            Text(
                "Soft Totals vs Dealer Soft Hands",
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
                    GeneratePlayerSoftHandsColumn(strategySoft, playerSoftHandsColumn)
                }
                for (i in 0 until dealerSoftHandTotals.size) {
                    Column {
                        Text(
                            dealerSoftHandTotals[i].uppercase(),
                            modifier = Modifier
                                .background(Color.LightGray)
                                .padding(6.dp)
                                .width(25.dp),
                            textAlign = TextAlign.Center
                        )

                        for (j in 0 until strategySoft.size) {
                            if(strategySoft[j].playerHandTotal in 11..20) {
                                if (strategySoft[j].dealerHandTotal == dealerSoftHandTotals[i].toInt() && Hand.HandType.stringToHandType(strategySoft[j].dealerHandType) == Hand.HandType.SOFT) {
                                    assignCellValues(strategySoft[j])
                                    assignCellModifier()
                                    GenerateCell()
                                }
                            }
                        }

                    }
                }
            }
        }


        if(strategyHard != null){
            Text(
                "Hard Totals vs Dealer Hard Hands",
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
                            if(strategyHard[i].playerHandTotal in 7..18){
                                set.add(strategyHard[i].playerHandTotal.toString())
                            }
                        }
                    }

                    set.forEach {
                        Text(text = it, modifier = Modifier.padding(6.dp))
                    }
                }
                for (i in 0 until dealerHardHandTotals.size) {
                    Column {
                        Text(
                            dealerHardHandTotals[i].uppercase(),
                            modifier = Modifier
                                .background(Color.LightGray)
                                .padding(6.dp)
                                .width(25.dp),
                            textAlign = TextAlign.Center
                        )

                        for (j in 0 until strategyHard.size) {
                            if(strategyHard[j].playerHandTotal in 7..18){
                                if (strategyHard[j].dealerHandTotal == dealerHardHandTotals[i].toInt() && Hand.HandType.stringToHandType(strategyHard[j].dealerHandType) == Hand.HandType.HARD) {
                                    assignCellValues(strategyHard[j])
                                    assignCellModifier()
                                    GenerateCell()
                                }
                            }
                        }

                    }
                }
            }
        }
        if(strategyHard != null){
            Text(
                "Hard Totals vs Dealer Soft Hands",
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
                            if(strategyHard[i].playerHandTotal in 8..18) {
                                set.add(strategyHard[i].playerHandTotal.toString())
                            }
                        }
                    }

                    set.forEach {
                        Text(text = it, modifier = Modifier.padding(6.dp))
                    }
                }
                for (i in 0 until dealerSoftHandTotals.size) {
                    Column {
                        Text(
                            dealerSoftHandTotals[i].uppercase(),
                            modifier = Modifier
                                .background(Color.LightGray)
                                .padding(6.dp)
                                .width(25.dp),
                            textAlign = TextAlign.Center
                        )

                        for (j in 0 until strategyHard.size) {
                            if(strategyHard[j].playerHandTotal in 8..18) {
                                if (strategyHard[j].dealerHandTotal == dealerSoftHandTotals[i].toInt() && Hand.HandType.stringToHandType(strategyHard[j].dealerHandType) == Hand.HandType.SOFT) {
                                    assignCellValues(strategyHard[j])
                                    assignCellModifier()
                                    GenerateCell()
                                }
                            }
                        }

                    }
                }
            }
        }


//        if(strategySurrender != null){
//            Text(
//                "Late Surrender",
//                modifier = Modifier.fillMaxWidth(),
//                textAlign = TextAlign.Center,
//                fontWeight = FontWeight.Bold
//            )
//
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.Center
//            ) {
//                val set: MutableSet<String> = mutableSetOf("")
//                Column(
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    modifier = Modifier.background(Color.LightGray)
//                ) {
//                    strategySurrender.sortBy { it.playerHandTotal }
//                    strategySurrender.reverse()
//                    for(i in 0 until strategySurrender.size){
//                        if(strategySurrender[i].playerCard != null ){
//                            val card = CardValueMapper.cardValueMapper[strategySurrender[i].playerCard].toString()
//                            set.add("$card,$card")
//                        }else if(strategySurrender[i].playerCard == null){
//                            set.add(strategySurrender[i].playerHandTotal.toString())
//                        }
//                    }
//
//                    set.forEach {
//                        Text(text = it, modifier = Modifier.padding(5.dp))
//                    }
//                }
//                for (i in 0 until dealerHandTotals.size) {
//                    Column(
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                    ) {
//                        if (CardNames.stringToCardNames(dealerHandTotals[i]) == CardNames.ACE || CardValueMapper.cardValueMapper[(CardNames.stringToCardNames(
//                                dealerHandTotals[i]))]!! > 5){
//                            Text(
//                                dealerHandTotals[i].uppercase(),
//                                modifier = Modifier
//                                    .background(Color.LightGray)
//                                    .padding(5.dp)
//                                    .width(35.dp),
//                                textAlign = TextAlign.Center
//                            )
//
//                            for (j in 0 until strategySurrender.size) {
//                                if (strategySurrender[j].dealerCard.name == CardNames.stringToCardNames(
//                                        dealerHandTotals[i]
//                                    ).name
//                                ) {
//                                    assignCellValues(strategySurrender[j])
//                                    assignCellModifier()
//                                    GenerateCell()
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//
//        if(strategyForfeit != null){
//            Text(
//                "Forfeit",
//                modifier = Modifier.fillMaxWidth(),
//                textAlign = TextAlign.Center,
//                fontWeight = FontWeight.Bold
//            )
//
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.Center
//            ) {
//                val set: MutableSet<String> = mutableSetOf("")
//                Column(
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    modifier = Modifier.background(Color.LightGray)
//                ) {
//                    strategyForfeit.sortBy { it.playerHandTotal }
//                    strategyForfeit.reverse()
//                    for(i in 0 until strategyForfeit.size){
//                        if(strategyForfeit[i].playerCard != null ){
//                            val card = CardValueMapper.cardValueMapper[strategyForfeit[i].playerCard].toString()
//                            set.add("$card,$card")
//                        }else if(strategyForfeit[i].playerCard == null){
//                            set.add(strategyForfeit[i].playerHandTotal.toString())
//                        }
//                    }
//
//                    set.forEach {
//                        Text(text = it, modifier = Modifier.padding(5.dp))
//                    }
//                }
//                for (i in 0 until dealerHandTotals.size) {
//                    Column(
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                    ) {
//                        if (CardNames.stringToCardNames(dealerHandTotals[i]) == CardNames.ACE || CardValueMapper.cardValueMapper[(CardNames.stringToCardNames(
//                                dealerHandTotals[i]))]!! > 4){
//                            Text(
//                                dealerHandTotals[i].uppercase(),
//                                modifier = Modifier
//                                    .background(Color.LightGray)
//                                    .padding(5.dp)
//                                    .width(35.dp),
//                                textAlign = TextAlign.Center
//                            )
//
//                            for (j in 0 until strategyForfeit.size) {
//                                if (strategyForfeit[j].dealerCard.name == CardNames.stringToCardNames(
//                                        dealerHandTotals[i]
//                                    ).name
//                                ) {
//                                    assignCellValues(strategyForfeit[j])
//                                    assignCellModifier()
//                                    GenerateCell()
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }
}

@Composable
fun GeneratePlayerSoftHandsColumn(strategySoft: ArrayList<StrategyCombinatorial.Hand>, playerSoftHandsColumn: MutableSet<String>) {
    strategySoft.sortBy { it.playerHandTotal }
    strategySoft.reverse()
    for(i in 0 until strategySoft.size){
        if(strategySoft[i].playerCard != null ){
            val card = CardValueMapper.cardValueMapper[strategySoft[i].playerCard].toString()
            playerSoftHandsColumn.add("$card,$card")
        }else if(strategySoft[i].playerCard == null){
            playerSoftHandsColumn.add(strategySoft[i].playerHandTotal.toString())
        }
    }

    playerSoftHandsColumn.forEach {
        if(it == ""){
            Text(text = "", modifier = Modifier.padding(6.dp))
        }else if(it == "12"){
            Text(text = "A,A", modifier = Modifier.padding(6.dp))
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

private fun assignCellValues(strategyHand: StrategyCombinatorial.Hand){
    action = if(strategyHand.playerAction != null) strategyHand.playerAction.toString() else null
    altAction = if(strategyHand.playerAltAction != null) strategyHand.playerAltAction.toString() else null
}

private fun assignCellModifier(){
    if(action.toString() == Actions.DOUBLE_DOWN.toString() && (altAction != null && altAction.toString() == Actions.STAND.toString())){
        modifier = Modifier
            .background(Color.Cyan)
            .padding(6.dp)
            .width(25.dp)
        text = "Ds"
    }else if(action.toString() == "hit"){
        modifier = Modifier
            .background(Color.White)
            .padding(6.dp)
            .width(20.dp)
        text = "H"
    }else if (action.toString() == "stand"){
        modifier = Modifier
            .background(Color.Yellow)
            .padding(6.dp)
            .width(25.dp)
        text = "S"
    }else if (action.toString() == "double") {
        modifier = Modifier
            .background(Color.Green)
            .padding(6.dp)
            .width(25.dp)
        text = "D"
    }else if(action.toString() == "surrender"){
        modifier = Modifier
            .background(Color.Green)
            .padding(5.dp)
            .width(35.dp)
        text = "LS"
    }else{
        modifier = Modifier
            .background(Color.White)
            .width(35.dp)
            .padding(5.dp)
        text = ""
    }
}

@Composable
private fun GenerateCell(){
    Text(
        text!!,
        modifier = modifier!!,
        textAlign = TextAlign.Center,
        color = Color.Black
    )
}