package com.example.advantagetrainer

import android.content.SharedPreferences
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
fun StrategyDrillScreen(sharedPref: SharedPreferences) {
    val cardVisible = remember { mutableStateOf(false) }
    val deck = CreateDeck(sharedPref = sharedPref)
    var index = 0
    val numCardToFlashSetting = 3


    if(cardVisible.value) {
        index = getValidHandToShow(deck, index, numCardToFlashSetting)
        ShowStrategyDrillCard(deck = deck, index = index, numCardToFlashSetting = numCardToFlashSetting)
    }


    // Hide the start button if the drill is on
    if(!cardVisible.value){
        Surface(
            modifier = Modifier.fillMaxHeight().fillMaxWidth(),
        ) {
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ){
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
}

@Composable
fun ShowStrategyDrillCard(deck: ArrayList<Card>, index: Int, numCardToFlashSetting: Int) {
    var xboxOffset = 0.dp
    var yboxOffset = 0.dp
    val dealerCardIndex = (0 until deck.size).random()
    val singleCardIndex = index
    val doubleCardIndex = index + 1
    val tripleCardIndex = index + 2
    val numCardToFlash = numCardToFlashSetting


    // Update the box offset to account for the additional cards
    if(numCardToFlash == 2 && index < deck.size - 1){
        xboxOffset = (-12).dp
        yboxOffset = 12.dp
    }else if (numCardToFlash == 3 && index < deck.size - 2){
        xboxOffset = (-24).dp
        yboxOffset = 12.dp
    }

    // To prevent against an IndexOutOfBoundsException if we accidently call this function with a large index
    if(index < deck.size){
        Surface(
            color = Color.Transparent,
            modifier = Modifier.fillMaxHeight().fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.offset(y = 6.dp)
            ) {
                Row{
                    Image(
                        painter = painterResource(deck[dealerCardIndex].cardImageId),
                        contentDescription = "Card",
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Box(
                        Modifier.offset(x = xboxOffset, y = yboxOffset)
                    ) {
                        // Show 2 cards
                        if (numCardToFlash == 2 || (numCardToFlash > 2 && index == deck.size - 2)) {
                            Image(
                                painter = painterResource(deck[singleCardIndex].cardImageId),
                                contentDescription = "Card",
                                modifier = Modifier.offset(x = 36.dp).zIndex(1.0F),
                            )
                            Image(
                                painter = painterResource(deck[doubleCardIndex].cardImageId),
                                contentDescription = "Card",
                                modifier = Modifier.offset(y = 36.dp),
                            )
                            // Show 3 cards
                        } else if (numCardToFlash == 3) {
                            Image(
                                painter = painterResource(deck[singleCardIndex].cardImageId),
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
                        }
                    }
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.fillMaxHeight()
            ){
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Button(onClick = {

                    },
                        Modifier.testTag("DoubleButton")
                    ) {
                        Text(text = "Double")
                    }
                    Button(onClick = {

                    },
                        Modifier.testTag("HitButton")
                    ) {
                        Text(text = "Hit")
                    }
                    Button(onClick = {

                    },
                        Modifier.testTag("StandButton")
                    ) {
                        Text(text = "Stand")
                    }
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Button(onClick = {

                    },
                        Modifier.testTag("SplitButton")
                    ) {
                        Text(text = "Split")
                    }
                    Button(onClick = {

                    },
                        Modifier.testTag("SurrenderButton")
                    ) {
                        Text(text = "Surrender")
                    }
                }
            }
        }
    }
}

fun getValidHandToShow(deck: ArrayList<Card>, index: Int, numCardToFlashSetting: Int): Int {
    val handCreator = arrayListOf<Card>()
    val hand: Hand

    if(index + numCardToFlashSetting <= deck.size){
        // Create the hand out of the cards
        for(i in 0 until numCardToFlashSetting){
            handCreator.add(deck[index + i])
        }

        hand = Hand(handCreator)

        return if(hand.handTotal > 21 || isOddHand(hand.cards)){
            getValidHandToShow(deck, index + 1, numCardToFlashSetting)
        }else{
            index
        }
    }else if(deck.size < numCardToFlashSetting){
        // Something illogical is going on. This will throw an exception later
        return -1
    }else{
        // We went through the whole deck and couldn't find a hand to show the user. Shuffle the deck and try again
        deck.shuffle()
        return getValidHandToShow(deck, 0, numCardToFlashSetting)
    }
}

fun isOddHand(deck:ArrayList<Card>): Boolean{
    val handCreator = arrayListOf<Card>()

    // Create the hand out of the first two cards
    for(i in 0 until 2){
        handCreator.add(deck[i])
    }

    val hand = Hand(handCreator)

    // Check for odd hands like if the first two cards are blackjack but the hand has more than two cards
    if(hand.isBlackjack && deck.size > 2){
        return true
    }

    return false
}