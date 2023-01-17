package com.example.advantagetrainer.views

import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.advantagetrainer.Card
import com.example.advantagetrainer.Hand
import com.example.advantagetrainer.Settings


@Composable
fun AddHandDrillScreen (
    sharedPref: SharedPreferences,
    deck: ArrayList<Card>
){
    val cardVisible = remember { mutableStateOf(false) }
    var (index, updateIndex) = remember { mutableStateOf(0) }
    var numCardInHandSetting = Settings.numCardInHandMapper[sharedPref.getInt(Settings.NUM_CARDS_IN_HAND, 0)]!!

    // If the user has setting to flash 1-3 cards set numCardToFlash to a random int between 1-3
    if(numCardInHandSetting == 4){
        numCardInHandSetting = (2..4).random()
    }else if(numCardInHandSetting == 5){
        numCardInHandSetting = (2..5).random()
    }

    index = getValidHandToShow(deck, index , numCardInHandSetting)

    if(cardVisible.value) {
        if(index < deck.size) {
            Column(
                modifier = Modifier.offset((-36).dp, 72.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally){
                ShowCard(deck, index, numCardInHandSetting)
            }
        }
    }


    Column(
        modifier = Modifier
            .offset(y= 72.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(cardVisible.value){
            AnswerField(deck, index, updateIndex, numCardInHandSetting)
        }
    }

    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnswerField(
    deck: ArrayList<Card>,
    index: Int,
    updateIndex: (Int) -> Unit,
    numCardInHandSetting: Int
) {

    var userInput by remember {
        mutableStateOf("")
    }

    TextField(
        value = userInput,
        onValueChange = { userInput = it },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        label = { Text("Hand Total") }
    )

    val context = LocalContext.current
    // Create the hand
    val hand = Hand()
    for(i in 0 until numCardInHandSetting){
        hand.addCard(deck[index + i])
    }

    Button(onClick = {
        if(isUserCorrect(hand, userInput)){
            userInput = ""
            deck.shuffle()
            updateIndex((0 until deck.size).random())
        }else{
            Toast.makeText(context, "Hand Total: " + hand.handTotal.toString(), Toast.LENGTH_SHORT).show()
        }
    },
        Modifier.testTag("SubmitButton")
    ) {
        Text(text = "Submit")
    }
}

fun isUserCorrect(
    hand: Hand,
    userInput: String
): Boolean {
    var userString = ""

    // Check if the user input contains `S` for Soft Hand. Get the next sequence of digits to convert to Int
    if(userInput[0].uppercase() == "S"){
        for(i in 1 until userInput.length){
            userString += userInput[i]
        }
    }else{
        userString = userInput
    }

    return userString.toInt() == hand.handTotal
}