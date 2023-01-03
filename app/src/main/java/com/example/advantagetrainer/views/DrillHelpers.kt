package com.example.advantagetrainer.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.advantagetrainer.Card
import com.example.advantagetrainer.Hand

fun getValidHandToShow(
    deck: ArrayList<Card>,
    index: Int,
    numCardToFlashSetting: Int
): Int {
    val hand = Hand()

    if(index + numCardToFlashSetting < deck.size){
        // Create the hand out of the cards
        for(i in 0 until numCardToFlashSetting){
            hand.addCard(deck[index + i])
        }

        return if(hand.didBust() || isOddHand(hand.cards)){
            getValidHandToShow(deck,index + 1, numCardToFlashSetting)
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
    val hand = Hand()

    // Create the hand out of the first two cards
    for(i in 0 until 2){
        hand.addCard(deck[i])
    }

    // Check for odd hands like if the first two cards are blackjack but the hand has more than two cards
    if(hand.isBlackjack && deck.size > 2){
        return true
    }

    return false
}

@Composable
fun ShowCard(deck: ArrayList<Card>, index: Int, numCardToFlashSetting: Int) {
    var xboxOffset = 0.dp
    var yboxOffset = 0.dp

    // Update the box offset to account for the additional cards
    if (numCardToFlashSetting == 3 && index < deck.size - 2){
        xboxOffset = (-12).dp
        yboxOffset = 12.dp
    }else if (numCardToFlashSetting == 4 && index < deck.size - 3){
        xboxOffset = (-24).dp
        yboxOffset = 24.dp
    }

    // To prevent against an IndexOutOfBoundsException if we accidently call this function with a large index
    if(index < deck.size){

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    Modifier.offset(x = xboxOffset, y = yboxOffset)
                ) {
                    // Show a single card. If there is only 1 card left in the deck to show, show one card regardless of the setting
                    if (numCardToFlashSetting == 1 || index == deck.size - 1) {
                        Image(
                            painter = painterResource(deck[index].cardImageId),
                            contentDescription = "Card",
                        )
                        // Show 2 cards
                    } else if (numCardToFlashSetting == 2 || index == deck.size - 2) {
                        if(index == deck.size - 2){
                            for(i in 0 until 2){
                                Image(
                                    painter = painterResource(deck[index + i].cardImageId),
                                    contentDescription = "Card",
                                    modifier = Modifier.offset(x = 36.dp * (i), y = 72.dp - (36.dp * (i + 1))).zIndex(i.toFloat())
                                )
                            }
                        }else {
                            for (i in 0 until numCardToFlashSetting) {
                                Image(
                                    painter = painterResource(deck[index + i].cardImageId),
                                    contentDescription = "Card",
                                    modifier = Modifier.offset(
                                        x = 36.dp * (i),
                                        y = 72.dp - (36.dp * (i + 1))
                                    ).zIndex(i.toFloat())
                                )
                            }
                        }
                        // Show 3 cards
                    } else if (numCardToFlashSetting == 3 || index == deck.size - 3) {
                        if(index == deck.size - 3){
                            for(i in 0 until 3){
                                Image(
                                    painter = painterResource(deck[index + i].cardImageId),
                                    contentDescription = "Card",
                                    modifier = Modifier.offset(x = 36.dp * (i), y = 72.dp - (36.dp * (i + 1))).zIndex(i.toFloat())
                                )
                            }
                        }else{
                            for(i in 0 until numCardToFlashSetting){
                                Image(
                                    painter = painterResource(deck[index + i].cardImageId),
                                    contentDescription = "Card",
                                    modifier = Modifier.offset(x = 36.dp * (i), y = 72.dp - (36.dp * (i + 1))).zIndex(i.toFloat())
                                )
                            }
                        }
                    } else if (numCardToFlashSetting == 4 || index == deck.size - 4) {
                        if(index == deck.size - 4){
                            for(i in 0 until 4){
                                Image(
                                    painter = painterResource(deck[index + i].cardImageId),
                                    contentDescription = "Card",
                                    modifier = Modifier.offset(x = 36.dp * (i), y = 72.dp - (36.dp * (i + 1))).zIndex(i.toFloat())
                                )
                            }
                        }else{
                            for(i in 0 until numCardToFlashSetting){
                                Image(
                                    painter = painterResource(deck[index + i].cardImageId),
                                    contentDescription = "Card",
                                    modifier = Modifier.offset(x = 36.dp * (i), y = 72.dp - (36.dp * (i + 1))).zIndex(i.toFloat())
                                )
                            }
                        }
                    }
                }
            }

    }
}