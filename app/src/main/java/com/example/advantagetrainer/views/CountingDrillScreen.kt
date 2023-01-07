package com.example.advantagetrainer.views

import android.content.SharedPreferences
import android.os.CountDownTimer
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.advantagetrainer.Card
import com.example.advantagetrainer.Settings


@Composable
fun CountingDrillScreen(
    sharedPref: SharedPreferences,
    deck: ArrayList<Card>,
    updateDeck: (ArrayList<Card>) -> Unit
){
    val cardVisible = remember { mutableStateOf(false) }
    val index = remember { mutableStateOf(0) }
    val cardFlashSpeed = Settings.cardFlashSpeedMapper[sharedPref.getInt(Settings.CARD_FLASH_SPEED, 2)]!!
    val numCardToFlashSetting = Settings.numCardToFlashMapper[sharedPref.getInt(Settings.NUM_CARDS_TO_FLASH, 0)]!!
    var numCardToFlash = numCardToFlashSetting

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
                if(index.value > deck.size){
                    index.value = 0
                    cardVisible.value = false
                    deck.clear()
                    this.cancel()
                }else{
                    index.value += numCardToFlash
                }
            }
        }.start()

        if(index.value < deck.size) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally){
                ShowCard(deck, index.value, numCardToFlash)
            }
        }
    }else if(deck.size == 0){
        updateDeck(createDeck(sharedPref = sharedPref))
    }


    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(!cardVisible.value){
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