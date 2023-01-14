package com.example.advantagetrainer.views

import android.content.SharedPreferences
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.example.advantagetrainer.Card

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountingTestScreen (
    count: Double,
    updateCountingDeck: (ArrayList<Card>) -> Unit,
    sharedPref: SharedPreferences,
){
    val newDeck = createDeck(sharedPref = sharedPref)
    var userInput by remember {
        mutableStateOf("")
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
    ) {
        TextField(
            value = userInput,
            onValueChange = { userInput = it },
            label = { Text("Current count?") }
        )

        Button(
            onClick = {
                if (count == userInput.toDoubleOrNull()) {
                    updateCountingDeck(newDeck) // Create a new deck
                }
            },
            Modifier.testTag("SubmitButton")
        ) {
            Text(text = "Submit")
        }
    }
}