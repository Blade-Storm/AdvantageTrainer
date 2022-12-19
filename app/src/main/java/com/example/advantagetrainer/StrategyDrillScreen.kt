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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import org.json.JSONObject
import org.json.JSONTokener
import java.io.*

@Composable
fun StrategyDrillScreen(sharedPref: SharedPreferences) {
    val cardVisible = remember { mutableStateOf(false) }
    val deck = createDeck(sharedPref = sharedPref)
    var (index, updateIndex) = remember { mutableStateOf(1) }
    val numCardInHandSetting = Settings.numCardInHandMapper[sharedPref.getInt(Settings.NUM_CARDS_IN_HAND, 2)]!!
    val actionResolver = ActionResolver(setStrategy())

    if(cardVisible.value) {
        index = getValidHandToShow(deck, index, numCardInHandSetting)

        var xboxOffset = 0.dp
        var yboxOffset = 0.dp
        val dealerCardIndex = (0 .. deck.size).random()
        val singleCardIndex = index
        val doubleCardIndex = index + 1
        val tripleCardIndex = index + 2

        // Update the box offset to account for the additional cards
        if(numCardInHandSetting == 2 && index < deck.size - 1){
            xboxOffset = (-12).dp
            yboxOffset = 12.dp
        }else if (numCardInHandSetting == 3 && index < deck.size - 2){
            xboxOffset = (-24).dp
            yboxOffset = 12.dp
        }

        val playerHand = Hand()
        for(i in 0 until numCardInHandSetting){
            playerHand.addCard(deck[index + i])
        }
        val dealerHand = Hand()
        dealerHand.addCard(deck[dealerCardIndex])

        // Get the action the player should take
        val playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)


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
                            if (numCardInHandSetting == 2 || (numCardInHandSetting > 2 && index == deck.size - 2)) {
                                Image(
                                    painter = painterResource(deck[doubleCardIndex].cardImageId),
                                    contentDescription = "Card",
                                    modifier = Modifier.offset(x = 36.dp).zIndex(1.0F),
                                )
                                Image(
                                    painter = painterResource(deck[singleCardIndex].cardImageId),
                                    contentDescription = "Card",
                                    modifier = Modifier.offset(y = 36.dp),
                                )
                                // Show 3 cards
                            } else if (numCardInHandSetting == 3) {
                                Image(
                                    painter = painterResource(deck[tripleCardIndex].cardImageId),
                                    contentDescription = "Card",
                                    modifier = Modifier.offset(x = 72.dp).zIndex(1.0F),
                                )
                                Image(
                                    painter = painterResource(deck[doubleCardIndex].cardImageId),
                                    contentDescription = "Card",
                                    modifier = Modifier.offset(x = 36.dp, y = 36.dp).zIndex(0.5F)
                                )
                                Image(
                                    painter = painterResource(deck[singleCardIndex].cardImageId),
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
                            if(playerAction == Actions.DOUBLE_DOWN){
                                updateIndex((0..deck.size).random())
                            }
                        },
                            Modifier.testTag("DoubleButton")
                        ) {
                            Text(text = "Double")
                        }
                        Button(onClick = {
                            if(playerAction == Actions.HIT){
                                updateIndex((0..deck.size).random())
                            }
                        },
                            Modifier.testTag("HitButton")
                        ) {
                            Text(text = "Hit")
                        }
                        Button(onClick = {
                            if(playerAction == Actions.STAND){
                                updateIndex((0..deck.size).random())
                            }
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
                            if(playerAction == Actions.SPLIT){
                                updateIndex((0..deck.size).random())
                            }
                        },
                            Modifier.testTag("SplitButton")
                        ) {
                            Text(text = "Split")
                        }
                        Button(onClick = {
                            if(playerAction == Actions.SURRENDER){
                                updateIndex((0..deck.size).random())
                            }
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


    // Hide the start button if the drill is on
    if(!cardVisible.value){
        Surface(
            modifier = Modifier.fillMaxHeight().fillMaxWidth().padding(24.dp)
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

fun getValidHandToShow(deck: ArrayList<Card>, index: Int, numCardToFlashSetting: Int): Int {
    val hand = Hand()

    if(index + numCardToFlashSetting <= deck.size){
        // Create the hand out of the cards
        for(i in 0 until numCardToFlashSetting){
            hand.addCard(deck[index + i])
        }

        return if(hand.didBust() || isOddHand(hand.cards)){
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
fun setStrategy(): JSONObject {
    val inputStream = LocalContext.current.resources.openRawResource(R.raw.sp21secretmonkeycount)

    val writer: Writer = StringWriter()
    val buffer = CharArray(1024)
    try {
        val reader: Reader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
        var n: Int
        while (reader.read(buffer).also { n = it } != -1) {
            writer.write(buffer, 0, n)
        }
    } finally {
        inputStream.close()
    }

    val jsonString: String = writer.toString()

    val tokener = JSONTokener(jsonString)
    return JSONObject(tokener)
}