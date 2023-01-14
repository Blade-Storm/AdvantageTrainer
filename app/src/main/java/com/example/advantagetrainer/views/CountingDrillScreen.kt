package com.example.advantagetrainer.views

import android.content.SharedPreferences
import android.os.CountDownTimer
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.advantagetrainer.Card
import com.example.advantagetrainer.Settings
import com.example.advantagetrainer.Settings.CountingTest
import com.example.advantagetrainer.enums.CardNames


@Composable
fun CountingDrillScreen(
    sharedPref: SharedPreferences,
){
    val cardVisible = remember { mutableStateOf(false) }
    val index = remember { mutableStateOf(0) }
    val cardFlashSpeed = Settings.cardFlashSpeedMapper[sharedPref.getInt(Settings.CARD_FLASH_SPEED, 2)]!!
    val numCardToFlashSetting = Settings.numCardToFlashMapper[sharedPref.getInt(Settings.NUM_CARDS_TO_FLASH, 0)]!!
    val countingTestType = Settings.countingTestMapper[sharedPref.getInt(Settings.COUNTING_TEST, 0)]!!
    var numCardToFlash = numCardToFlashSetting
    var inTest = false
    val (count, updateCount) = remember { mutableStateOf(0.0) }
    val tempdeck = createDeck(sharedPref = sharedPref)
    val (countingDeck, updateCountingDeck) = remember { mutableStateOf(tempdeck) }

    // If the user has setting to flash 1-3 cards set numCardToFlash to a random int between 1-3
    if(numCardToFlashSetting == 3){
        numCardToFlash = (1..3).random()
    }else if(numCardToFlashSetting == 4){
        numCardToFlash = (1..4).random()
    }

    if(cardVisible.value) {
        object : CountDownTimer(cardFlashSpeed, cardFlashSpeed) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                if(index.value > countingDeck.size){
                    index.value = 0
                    cardVisible.value = false
                    countingDeck.clear()
                    this.cancel()
                }else{
                    index.value += numCardToFlash
                }
            }
        }.start()

        if(index.value < countingDeck.size) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                ShowCard(countingDeck, index.value, numCardToFlash)
            }
        }
    }else if(countingDeck.size == 0){ // Represents we are done with the drill
        if(countingTestType == CountingTest.END_OF_DRILL){
            inTest = true
            CountingTestScreen(count, updateCountingDeck, sharedPref )
        }else{
            updateCountingDeck(createDeck(sharedPref = sharedPref)) // Create a new deck
        }
    }else if(countingTestType == CountingTest.END_OF_DRILL && (countingDeck.size == 48 || countingDeck.size == 52)){
        // Every time we created a new deck and we are doing END_OF_DRILL, remove a card and count the deck
        countingDeck.removeFirst()
        CountDeck(countingDeck, updateCount, sharedPref, countingTestType)
    }


    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(!cardVisible.value && !inTest){
            Button(onClick = {
                cardVisible.value = true
            },
                Modifier.testTag("StartButton")
            ) {
                Text(text = "Start")
            }
        }
    }
}

@Composable
fun CountDeck(
    countingDeck: ArrayList<Card>,
    updateCount: (Double) -> Unit,
    sharedPref: SharedPreferences,
    countingTestType: CountingTest
) {
    var count = 0.0
    val countingSystem = getCountingSystem(sharedPref = sharedPref)

    if(countingTestType == CountingTest.END_OF_DRILL){
        countingDeck.forEach {
            count += if(it.name == CardNames.JACK || it.name == CardNames.QUEEN || it.name == CardNames.KING){
                countingSystem.countingSystemMapper[CardNames.TEN]!!
            }else{
                countingSystem.countingSystemMapper[it.name]!!
            }
        }
    }


    updateCount(count)
}