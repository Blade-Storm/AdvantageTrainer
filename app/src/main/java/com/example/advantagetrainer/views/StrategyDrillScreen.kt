package com.example.advantagetrainer.views

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
import com.example.advantagetrainer.*
import com.example.advantagetrainer.Settings.Strategy
import com.example.advantagetrainer.enums.Actions
import com.google.gson.Gson
import java.io.*

@Composable
fun StrategyDrillScreen(
    sharedPref: SharedPreferences,
    actionResolver: ActionResolver
) {
    val cardVisible = remember { mutableStateOf(false) }
    val deck = createDeck(sharedPref = sharedPref)
    var (index, updateIndex) = remember { mutableStateOf(1) }
    var numCardInHandSetting = Settings.numCardInHandMapper[sharedPref.getInt(Settings.NUM_CARDS_IN_HAND, 2)]!!
    val useDeviations = sharedPref.getBoolean(Settings.USE_DEVIATIONS, false)

    // If the user has setting to flash 1-3 cards set numCardToFlash to a random int between 1-3
    if(numCardInHandSetting == 4){
        numCardInHandSetting = (2..4).random()
    }else if(numCardInHandSetting == 5){
        numCardInHandSetting = (2..5).random()
    }

    if(cardVisible.value) {
        index = getValidHandToShow(deck, index, numCardInHandSetting)
        val dealerCardIndex = (0 until deck.size).random()

        val playerHand = Hand()
        for(i in 0 until numCardInHandSetting){
            playerHand.addCard(deck[index + i])
        }
        val dealerHand = Hand()
        dealerHand.addCard(deck[dealerCardIndex])

        // Get the action the player should take
        val count = (-10..10).random()
        val playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, count, useDeviations)


        // To prevent against an IndexOutOfBoundsException if we accidently call this function with a large index
        if(index < deck.size){
            Surface(
                color = Color.Transparent,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.offset(y = 6.dp, x = 6.dp)
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
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Box(
                            Modifier.offset(x = (-60).dp, y = 12.dp)
                        ) {
                            // Show 2 cards
                            if (numCardInHandSetting == 2 || (numCardInHandSetting > 2 && index == deck.size - 2)) {
                                for(i in 1 until numCardInHandSetting + 1){
                                    Image(
                                        painter = painterResource(deck[index + (numCardInHandSetting - i)].cardImageId),
                                        contentDescription = "Card",
                                        modifier = Modifier
                                            .offset(
                                                x = 1.dp * 36 * (i - 1),
                                                y = 104.dp - (36.dp * i)
                                            )
                                            .zIndex(i.toFloat())
                                    )
                                }
                                // Show 3 cards
                            } else if (numCardInHandSetting == 3) {
                                for(i in 1 until numCardInHandSetting + 1){
                                    Image(
                                        painter = painterResource(deck[index + (numCardInHandSetting - i)].cardImageId),
                                        contentDescription = "Card",
                                        modifier = Modifier
                                            .offset(
                                                x = 1.dp * 36 * (i - 1),
                                                y = 104.dp - (36.dp * i)
                                            )
                                            .zIndex(i.toFloat())
                                    )
                                }
                            } else if (numCardInHandSetting == 4) {
                                for(i in 1 until numCardInHandSetting + 1){
                                    Image(
                                        painter = painterResource(deck[index + (numCardInHandSetting - i)].cardImageId),
                                        contentDescription = "Card",
                                        modifier = Modifier
                                            .offset(
                                                x = 1.dp * 36 * (i - 1),
                                                y = 104.dp - (36.dp * i)
                                            )
                                            .zIndex(i.toFloat())
                                    )
                                }
                            } else if (numCardInHandSetting == 5) {
                                for(i in 1 until numCardInHandSetting + 1){
                                    Image(
                                        painter = painterResource(deck[index + (numCardInHandSetting - i)].cardImageId),
                                        contentDescription = "Card",
                                        modifier = Modifier
                                            .offset(
                                                x = 1.dp * 36 * (i - 1),
                                                y = 104.dp - (36.dp * i)
                                            )
                                            .zIndex(i.toFloat())
                                    )
                                }
                            }
                        }
                    }
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier.fillMaxHeight()
                ){
                    if(useDeviations){
                        Text(text = "True count: $count")
                    }
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Button(onClick = {
                            if(playerAction == Actions.DOUBLE_DOWN){
                                updateIndex((0 until deck.size).random())
                            }
                        },
                            Modifier.testTag("DoubleButton")
                        ) {
                            Text(text = "Double")
                        }
                        Button(onClick = {
                            if(playerAction == Actions.HIT){
                                updateIndex((0 until deck.size).random())
                            }
                        },
                            Modifier.testTag("HitButton")
                        ) {
                            Text(text = "Hit")
                        }
                        Button(onClick = {
                            if(playerAction == Actions.STAND){
                                updateIndex((0 until deck.size).random())
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
                                updateIndex((0 until deck.size).random())
                            }
                        },
                            Modifier.testTag("SplitButton")
                        ) {
                            Text(text = "Split")
                        }
                        Button(onClick = {
                            if(playerAction == Actions.SURRENDER){
                                updateIndex((0 until deck.size).random())
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
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(24.dp)
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
fun setStrategy(sharedPref: SharedPreferences): StrategyCombinatorial {
    val strategy = Settings.strategyMapper[sharedPref.getInt(Settings.STRATEGY, 1)]!!
    val inputStream = LocalContext.current.resources.openRawResource(strategy.rawId)
    Game.isSpanishGame = strategy.name == Strategy.SPANISH21_SECRET.name
    val strategyCombinatorial: StrategyCombinatorial

    val gson = Gson()

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

    strategyCombinatorial = gson.fromJson(writer.toString(), StrategyCombinatorial::class.java)
    strategyCombinatorial.validateHands()
    return strategyCombinatorial
}