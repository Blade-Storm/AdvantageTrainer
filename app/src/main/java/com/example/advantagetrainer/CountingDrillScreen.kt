package com.example.advantagetrainer

import android.content.SharedPreferences
import android.os.CountDownTimer
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

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
            ShowCard(deck, index.value, numCardToFlash)
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

@Composable
fun ShowCard(deck: ArrayList<Card>, index: Int, numCardToFlashSetting: Int) {
    var boxOffset = 0.dp
    val doubleCardIndex = index + 1
    val tripleCardIndex = index + 2
    val quadrupleCardIndex = index + 3

    // Update the box offset to account for the additional cards
    if(numCardToFlashSetting == 2 && index < deck.size - 1){
        boxOffset = (-12).dp
    }else if (numCardToFlashSetting == 3 && index < deck.size - 2){
        boxOffset = (-24).dp
    }else if (numCardToFlashSetting == 4 && index < deck.size - 3){
        boxOffset = (-36).dp
    }

    // To prevent against an IndexOutOfBoundsException if we accidently call this function with a large index
    if(index < deck.size){
        Surface(
            color = Color.Transparent,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    Modifier.offset(x = boxOffset, y = boxOffset)
                ) {
                    // Show a single card. If there is only 1 card left in the deck to show, show one card regardless of the setting
                    if (numCardToFlashSetting == 1 || index == deck.size - 1) {
                        Image(
                            painter = painterResource(deck[index].cardImageId),
                            contentDescription = "Card",
                        )
                        // Show 2 cards
                    } else if (numCardToFlashSetting == 2 || (numCardToFlashSetting == 3 && index == deck.size - 2)) {
                        Image(
                            painter = painterResource(deck[index].cardImageId),
                            contentDescription = "Card",
                            modifier = Modifier.offset(x = 36.dp).zIndex(1.0F),
                        )
                        Image(
                            painter = painterResource(deck[doubleCardIndex].cardImageId),
                            contentDescription = "Card",
                            modifier = Modifier.offset(y = 36.dp),
                        )
                        // Show 3 cards
                    } else if (numCardToFlashSetting == 3) {
                        Image(
                            painter = painterResource(deck[index].cardImageId),
                            contentDescription = "Card",
                            modifier = Modifier.offset(x = 72.dp).zIndex(1.0F),
                        )
                        Image(
                            painter = painterResource(deck[doubleCardIndex].cardImageId),
                            contentDescription = "Card",
                            modifier = Modifier.offset(x = 36.dp, y = 36.dp).zIndex(0.5F)
                        )
                        Image(
                            painter = painterResource(deck[tripleCardIndex].cardImageId),
                            contentDescription = "Card",
                            modifier = Modifier.offset(y = 72.dp)
                        )
                    } else if (numCardToFlashSetting == 4) {
                        Image(
                            painter = painterResource(deck[index].cardImageId),
                            contentDescription = "Card",
                            modifier = Modifier.offset(x = 104.dp, y = (-36).dp).zIndex(1.5F)
                        )
                        Image(
                            painter = painterResource(deck[doubleCardIndex].cardImageId),
                            contentDescription = "Card",
                            modifier = Modifier.offset(x = 72.dp, y = 0.dp).zIndex(1.0F)
                        )
                        Image(
                            painter = painterResource(deck[tripleCardIndex].cardImageId),
                            contentDescription = "Card",
                            modifier = Modifier.offset(x = 36.dp, y = 36.dp).zIndex(0.5F)
                        )
                        Image(
                            painter = painterResource(deck[quadrupleCardIndex].cardImageId),
                            contentDescription = "Card",
                            modifier = Modifier.offset(y = 72.dp)
                        )
                    }
                }
            }
        }
    }
}