package com.example.advantagetrainer.views

import android.content.SharedPreferences
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.advantagetrainer.CountingSystem
import com.example.advantagetrainer.Settings
import com.example.advantagetrainer.Settings.deckTypeMapper
import com.example.advantagetrainer.enums.CardNames
import com.google.gson.Gson

@Composable
fun SettingsScreen(
    onNavigateToStrategyDisplayScreen: () -> Unit,
    onNavigateToCountingSystemEditScreen: () -> Unit,
    sharedPref: SharedPreferences
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            "General Settings",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(5.dp, 10.dp, 0.dp, 5.dp)
        )
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text("Deck type to use in drills")
            var isDeckToUseExpanded by remember { mutableStateOf(false) }
            var selectedDeckToUseIndex by remember {
                mutableStateOf(
                    sharedPref.getInt(
                        Settings.DECK_TYPE,
                        0
                    )
                )
            }

            Box(Modifier.testTag("DeckTypeBox")) {
                Text(
                    deckTypeMapper[selectedDeckToUseIndex].toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("SelectedDeckTypeItem")
                        .clickable(onClick = { isDeckToUseExpanded = true }
                        ))
                DropdownMenu(
                    expanded = isDeckToUseExpanded,
                    onDismissRequest = { isDeckToUseExpanded = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    deckTypeMapper.values.forEachIndexed { index, s ->
                        DropdownMenuItem(onClick = {
                            selectedDeckToUseIndex = index
                            isDeckToUseExpanded = false
                            with(sharedPref.edit()) {
                                putInt(Settings.DECK_TYPE, index)
                                apply()
                            }
                        },
                            text = { Text(text = s.toString()) })
                    }
                }
            }
        }

        Text(
            "Counting Drill Settings",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(5.dp, 10.dp, 0.dp, 5.dp)
        )
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text("Speed of card flash, in seconds")
            var isSpeedDropdownExpanded by remember { mutableStateOf(false) }
            // TODO: Use mapper in settings instead of hardcoded list
            val cardSpeedItems = listOf("0.25", "0.50", "1.00", "1.50", "2.00")
            var selectedCardSpeedIndex by remember {
                mutableStateOf(
                    sharedPref.getInt(
                        Settings.CARD_FLASH_SPEED,
                        2
                    )
                )
            }

            Box(Modifier.testTag("CardFlashSpeedBox")) {
                Text(
                    cardSpeedItems[selectedCardSpeedIndex],
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("SelectedCardSpeedItem")
                        .clickable(onClick = { isSpeedDropdownExpanded = true }
                        ))
                DropdownMenu(
                    expanded = isSpeedDropdownExpanded,
                    onDismissRequest = { isSpeedDropdownExpanded = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    cardSpeedItems.forEachIndexed { index, s ->
                        DropdownMenuItem(onClick = {
                            selectedCardSpeedIndex = index
                            isSpeedDropdownExpanded = false
                            with(sharedPref.edit()) {
                                putInt(Settings.CARD_FLASH_SPEED, index)
                                apply()
                            }
                        },
                            text = { Text(text = s) })
                    }
                }
            }
        }

        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            // TODO: Use mapper in settings instead of hardcoded list
            Text("Number of cards to flash")
            val numCardToFlashItems = listOf("1 card", "2 cards", "1-3 cards", "1-4 cards")
            var isNumCardToFlashExpanded by remember { mutableStateOf(false) }
            var selectedNumCardsToFlashIndex by remember {
                mutableStateOf(
                    sharedPref.getInt(
                        Settings.NUM_CARDS_TO_FLASH,
                        0
                    )
                )
            }

            Box(Modifier.testTag("NumOfCardsToFlashBox")) {
                Text(
                    numCardToFlashItems[selectedNumCardsToFlashIndex], modifier = Modifier
                        .fillMaxWidth()
                        .testTag("NumOfCardsToFlashItem")
                        .clickable(onClick = { isNumCardToFlashExpanded = true })
                )
                DropdownMenu(
                    expanded = isNumCardToFlashExpanded,
                    onDismissRequest = { isNumCardToFlashExpanded = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    numCardToFlashItems.forEachIndexed { index, s ->
                        DropdownMenuItem(onClick = {
                            selectedNumCardsToFlashIndex = index
                            isNumCardToFlashExpanded = false
                            with(sharedPref.edit()) {
                                putInt(Settings.NUM_CARDS_TO_FLASH, index)
                                apply()
                            }
                        },
                            text = { Text(text = s) })
                    }
                }
            }
        }

        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            // TODO: Use mapper in settings instead of hardcoded list
            Text("Number of decks to use")
            val numDecksToUse = listOf("1", "2", "4", "6", "8")
            var isNumOfDecksToUseExpanded by remember { mutableStateOf(false) }
            var selectedNumOfDecksToUseIndex by remember {
                mutableStateOf(
                    sharedPref.getInt(
                        Settings.NUM_DECKS_TO_COUNT,
                        0
                    )
                )
            }

            Box(Modifier.testTag("NumOfDecksToUseBox")) {
                Text(
                    numDecksToUse[selectedNumOfDecksToUseIndex], modifier = Modifier
                        .fillMaxWidth()
                        .testTag("NumOfDecksToUseItem")
                        .clickable(onClick = { isNumOfDecksToUseExpanded = true })
                )
                DropdownMenu(
                    expanded = isNumOfDecksToUseExpanded,
                    onDismissRequest = { isNumOfDecksToUseExpanded = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    numDecksToUse.forEachIndexed { index, s ->
                        DropdownMenuItem(onClick = {
                            selectedNumOfDecksToUseIndex = index
                            isNumOfDecksToUseExpanded = false
                            with(sharedPref.edit()) {
                                putInt(Settings.NUM_DECKS_TO_COUNT, index)
                                apply()
                            }
                        },
                            text = { Text(text = s) })
                    }
                }
            }
        }

        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            // TODO: Use mapper in settings instead of hardcoded list
            Text("Counting Test")
            val countingTestType = listOf("No test", "End of drill")
            var isCountingTestTypeExpanded by remember { mutableStateOf(false) }
            var selectedCountingTestTypeIndex by remember {
                mutableStateOf(
                    sharedPref.getInt(
                        Settings.COUNTING_TEST,
                        0
                    )
                )
            }

            Box(Modifier.testTag("CountingTestTypeBox")) {
                Text(
                    countingTestType[selectedCountingTestTypeIndex], modifier = Modifier
                        .fillMaxWidth()
                        .testTag("CountingTestTypeItem")
                        .clickable(onClick = { isCountingTestTypeExpanded = true })
                )
                DropdownMenu(
                    expanded = isCountingTestTypeExpanded,
                    onDismissRequest = { isCountingTestTypeExpanded = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    countingTestType.forEachIndexed { index, s ->
                        DropdownMenuItem(onClick = {
                            selectedCountingTestTypeIndex = index
                            isCountingTestTypeExpanded = false
                            with(sharedPref.edit()) {
                                putInt(Settings.COUNTING_TEST, index)
                                apply()
                            }
                        },
                            text = { Text(text = s) })
                    }
                }
            }
        }




        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                Arrangement.SpaceBetween
            ){
                Text("Counting System")
                Text(
                    modifier = Modifier
                        .clickable { onNavigateToCountingSystemEditScreen() },
                    color = Color(0xFF3366CC),
                    text = "Edit"
                )
            }
        }
        TableScreen(getCountingSystem(sharedPref))


        Text(
            "Strategy/Add Hand Drill Settings",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(5.dp, 10.dp, 0.dp, 5.dp)
        )
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text("Number of cards in hand")
            // TODO: Use mapper in settings instead of hardcoded list
            val numCardInHandItems = listOf("2 cards", "3 cards", "2-4 cards", "2-5 cards")
            var isNumCardInHandExpanded by remember { mutableStateOf(false) }
            var selectedNumCardsInHandIndex by remember {
                mutableStateOf(
                    sharedPref.getInt(
                        Settings.NUM_CARDS_IN_HAND,
                        0
                    )
                )
            }

            Box(Modifier.testTag("NumOfCardsInHandBox")) {
                Text(
                    numCardInHandItems[selectedNumCardsInHandIndex], modifier = Modifier
                        .fillMaxWidth()
                        .testTag("NumOfCardsInHandItem")
                        .clickable(onClick = { isNumCardInHandExpanded = true })
                )
                DropdownMenu(
                    expanded = isNumCardInHandExpanded,
                    onDismissRequest = { isNumCardInHandExpanded = false },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    numCardInHandItems.forEachIndexed { index, s ->
                        DropdownMenuItem(onClick = {
                            selectedNumCardsInHandIndex = index
                            isNumCardInHandExpanded = false
                            with(sharedPref.edit()) {
                                putInt(Settings.NUM_CARDS_IN_HAND, index)
                                apply()
                            }
                        },
                            text = { Text(text = s) })
                    }
                }
            }
        }

        Column(
            modifier = Modifier.padding(12.dp)
        ) {

            Text("Strategy to use:")
            // TODO: Use mapper in settings instead of hardcoded list
            val countingStrategyItems = Settings.CountingStrategy.values()
            var isStrategyExpanded by remember { mutableStateOf(false) }
            var strategyIndex by remember {
                mutableStateOf(
                    sharedPref.getInt(
                        Settings.COUNTING_STRATEGY,
                        1
                    )
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                Arrangement.SpaceBetween
            ) {
                Box(
                    Modifier.testTag("StrategyToUse"),
                ) {
                    Text(
                        countingStrategyItems[strategyIndex].name,
                        modifier = Modifier
                            .testTag("StrategyToUseItem")
                            .clickable(onClick = { isStrategyExpanded = true })
                    )
                    DropdownMenu(
                        expanded = isStrategyExpanded,
                        onDismissRequest = { isStrategyExpanded = false }
                    ) {
                        countingStrategyItems.forEachIndexed { index, s ->
                            DropdownMenuItem(onClick = {
                                strategyIndex = index
                                isStrategyExpanded = false
                                with(sharedPref.edit()) {
                                    putInt(Settings.COUNTING_STRATEGY, index)
                                    apply()
                                }
                            },
                                text = { Text(text = s.name) })
                        }
                    }
                }

                Box{
                    Text(
                        modifier = Modifier
                            .clickable { onNavigateToStrategyDisplayScreen() },
                        color = Color(0xFF3366CC),
                        text = "View strategy table"
                    )
                }
            }
        }

        Column(
            modifier = Modifier.padding(0.dp, 12.dp)
        ) {
            var useDeviations by remember {
                mutableStateOf(
                    sharedPref.getBoolean(
                        Settings.USE_DEVIATIONS,
                        false
                    )
                )
            }
            Box(Modifier.testTag("UseDeviationsBox")) {
                Column {
                    Row {
                        Checkbox(
                            checked = useDeviations,
                            onCheckedChange = {
                                useDeviations = it
                                with(sharedPref.edit()) {
                                    putBoolean(Settings.USE_DEVIATIONS, it)
                                    apply()
                                }
                            },
                            Modifier.testTag("UseDeviations")
                        )
                        Text("Use deviations in strategy", modifier = Modifier.padding(0.dp, 12.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun getCountingSystem(sharedPref: SharedPreferences): CountingSystem {
    val countingSystem: CountingSystem
    val gson = Gson()
    val countingSystemString = sharedPref.getString(Settings.COUNTING_SYSTEM, "")

    countingSystem = gson.fromJson(countingSystemString, CountingSystem::class.java)
    countingSystem.updateMap()

    return countingSystem
}

@Composable
fun TableScreen(countingSystem: CountingSystem) {
    val cardNameList = countingSystem.map.toList().sortedBy { it.first }

    Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Center
    ){
        for(i in cardNameList.indices){
            Column{
                val cardNameText = if(cardNameList[i].first == CardNames.ACE){
                    "A"
                }else if(cardNameList[i].first == CardNames.TEN){
                    "T"
                }else {
                    cardNameList[i].first.toString()
                }

                Text(
                    text = cardNameText,
                    modifier = Modifier
                        .background(Color.LightGray)
                        .padding(4.dp)
                        .width(30.dp),
                    textAlign = TextAlign.Center
                )

                countingSystem.map[cardNameList[i].first].toString()

                Text(
                    text = countingSystem.map[cardNameList[i].first].toString(),
                    Modifier
                        .padding(4.dp)
                        .width(30.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
