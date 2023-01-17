package com.example.advantagetrainer.views

import android.content.SharedPreferences
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.advantagetrainer.CountingSystem
import com.example.advantagetrainer.Settings
import com.example.advantagetrainer.enums.CardNames

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountingSystemEditScreen(
    sharedPref: SharedPreferences,
    onNavigateToSettings: () -> Unit
) {
    val countingSystem = getCountingSystem(sharedPref = sharedPref)
    var ace by remember { mutableStateOf(if(countingSystem.map[CardNames.ACE] == null) "0.0" else countingSystem.map[CardNames.ACE].toString()) }
    var ten by remember { mutableStateOf(if(countingSystem.map[CardNames.TEN] == null) "0.0" else countingSystem.map[CardNames.TEN].toString()) }
    var nine by remember { mutableStateOf(if(countingSystem.map[CardNames.NINE] == null) "0.0" else countingSystem.map[CardNames.NINE].toString()) }
    var eight by remember { mutableStateOf(if(countingSystem.map[CardNames.EIGHT] == null) "0.0" else countingSystem.map[CardNames.EIGHT].toString()) }
    var seven by remember { mutableStateOf(if(countingSystem.map[CardNames.SEVEN] == null) "0.0" else countingSystem.map[CardNames.SEVEN].toString()) }
    var six by remember { mutableStateOf(if(countingSystem.map[CardNames.SIX] == null) "0.0" else countingSystem.map[CardNames.SIX].toString()) }
    var five by remember { mutableStateOf(if(countingSystem.map[CardNames.FIVE] == null) "0.0" else countingSystem.map[CardNames.FIVE].toString()) }
    var four by remember { mutableStateOf(if(countingSystem.map[CardNames.FOUR] == null) "0.0" else countingSystem.map[CardNames.FOUR].toString()) }
    var three by remember { mutableStateOf(if(countingSystem.map[CardNames.THREE] == null) "0.0" else countingSystem.map[CardNames.THREE].toString()) }
    var two by remember { mutableStateOf(if(countingSystem.map[CardNames.TWO] == null) "0.0" else countingSystem.map[CardNames.TWO].toString()) }

    Column (modifier = Modifier.verticalScroll(rememberScrollState())){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(5.dp)
        ){
            Text(
                CardNames.ACE.toString().uppercase(),
                modifier = Modifier.padding(10.dp)
            )


            countingSystem.updateMap(CardNames.ACE, ace.toDoubleOrNull())
            TextField(
                modifier = Modifier.height(IntrinsicSize.Min),
                value = ace,
                onValueChange = {
                    ace = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )

        }

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(5.dp)
        ){
            Text(
                CardNames.TEN.toString().uppercase(),
                modifier = Modifier.padding(10.dp)
            )

            countingSystem.updateMap(CardNames.TEN, ten.toDoubleOrNull())
            TextField(
                value = ten,
                onValueChange = {
                    ten = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(5.dp)
        ){
            Text(
                CardNames.NINE.toString().uppercase(),
                modifier = Modifier.padding(10.dp)
            )

            countingSystem.updateMap(CardNames.NINE, nine.toDoubleOrNull())
            TextField(
                value = nine,
                onValueChange = {
                    nine = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(5.dp)
        ){
            Text(
                CardNames.EIGHT.toString().uppercase(),
                modifier = Modifier.padding(10.dp)
            )

            countingSystem.updateMap(CardNames.EIGHT, eight.toDoubleOrNull())
            TextField(
                value = eight,
                onValueChange = {
                    eight = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(5.dp)
        ){
            Text(
                CardNames.SEVEN.toString().uppercase(),
                modifier = Modifier.padding(10.dp)
            )

            countingSystem.updateMap(CardNames.SEVEN, seven.toDoubleOrNull())
            TextField(
                value = seven,
                onValueChange = {
                    seven = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(5.dp)
        ){
            Text(
                CardNames.SIX.toString().uppercase(),
                modifier = Modifier.padding(10.dp)
            )

            countingSystem.updateMap(CardNames.SIX, six.toDoubleOrNull())
            TextField(
                value = six,
                onValueChange = {
                    six = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(5.dp)
        ){
            Text(
                CardNames.FIVE.toString().uppercase(),
                modifier = Modifier.padding(10.dp)
            )

            countingSystem.updateMap(CardNames.FIVE, five.toDoubleOrNull())
            TextField(
                value = five,
                onValueChange = {
                    five = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(5.dp)
        ){
            Text(
                CardNames.FOUR.toString().uppercase(),
                modifier = Modifier.padding(10.dp)
            )

            countingSystem.updateMap(CardNames.FOUR, four.toDoubleOrNull())
            TextField(
                value = four,
                onValueChange = {
                    four = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(5.dp)
        ){
            Text(
                CardNames.THREE.toString().uppercase(),
                modifier = Modifier.padding(10.dp)
            )

            countingSystem.updateMap(CardNames.THREE, three.toDoubleOrNull())
            TextField(
                value = three,
                onValueChange = {
                    three = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }

        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(5.dp)
        ){
            Text(
                CardNames.TWO.toString().uppercase(),
                modifier = Modifier.padding(10.dp)
            )

            countingSystem.updateMap(CardNames.TWO, two.toDoubleOrNull())
            TextField(
                value = two,
                onValueChange = {
                    two = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            )
        }

        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Button(
                onClick = {
                    setCountingSystem(sharedPref, countingSystem)
                    onNavigateToSettings()
                }
            ) {
                Text("Save")
            }
        }
    }
}

fun setCountingSystem(sharedPref: SharedPreferences, countingSystem: CountingSystem) {
    val userString = countingSystem.createJSON()
    with (sharedPref.edit()) {
        putString(Settings.COUNTING_SYSTEM, userString)
        apply()
    }
}