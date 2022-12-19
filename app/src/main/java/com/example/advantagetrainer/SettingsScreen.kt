package com.example.advantagetrainer

import android.content.SharedPreferences
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    sharedPref: SharedPreferences
) {
    Column{
        var isSpanishDeck by remember { mutableStateOf(sharedPref.getBoolean(Settings.USE_SPANISH_DECK, false)) }
        Box(Modifier.testTag("DeckTypeBox")){
            Column{
                Text("- Use Spanish21 deck? Default is Blackjack.")
                Row{
                    Checkbox(
                        checked = isSpanishDeck,
                        onCheckedChange = {
                            isSpanishDeck = it
                            with (sharedPref.edit()) {
                                putBoolean(Settings.USE_SPANISH_DECK, it)
                                apply()
                            }
                        },
                        Modifier.testTag("UseSpanishDeck")
                    )
                    Text("Spanish21 Deck", modifier = Modifier.padding(12.dp))
                }
            }

        }

        Text("Counting Drills: ")
        Text("- Speed of card flash, in seconds")
        var isSpeedDropdownExpanded by remember { mutableStateOf(false) }
        // TODO: Use mapper in settings instead of hardcoded list
        val cardSpeedItems = listOf("0.25", "0.50", "1.00", "1.50", "2.00")
        var selectedCardSpeedIndex by remember { mutableStateOf(sharedPref.getInt(Settings.CARD_FLASH_SPEED, 2)) }

        Box(Modifier.testTag("CardFlashSpeedBox")) {
            Text(
                cardSpeedItems[selectedCardSpeedIndex],
                modifier = Modifier
                .fillMaxWidth().testTag("SelectedCardSpeedItem")
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
                        with (sharedPref.edit()) {
                            putInt(Settings.CARD_FLASH_SPEED, index)
                            apply()
                        }
                    },
                        text = { Text(text = s) })
                }
            }
        }


        // TODO: Use mapper in settings instead of hardcoded list
        Text("- Number of cards to flash")
        val numCardToFlashItems = listOf("1 card", "2 cards", "1-3 cards")
        var isNumCardToFlashExpanded by remember { mutableStateOf(false) }
        var selectedNumCardsToFlashIndex by remember { mutableStateOf(sharedPref.getInt(Settings.NUM_CARDS_TO_FLASH, 0)) }

        Box(Modifier.testTag("NumOfCardsToFlashBox")) {
            Text(numCardToFlashItems[selectedNumCardsToFlashIndex],modifier = Modifier
                .fillMaxWidth().testTag("NumOfCardsToFlashItem")
                .clickable(onClick = { isNumCardToFlashExpanded = true }))
            DropdownMenu(
                expanded = isNumCardToFlashExpanded,
                onDismissRequest = { isNumCardToFlashExpanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                numCardToFlashItems.forEachIndexed { index, s ->
                    DropdownMenuItem(onClick = {
                        selectedNumCardsToFlashIndex = index
                        isNumCardToFlashExpanded = false
                        with (sharedPref.edit()) {
                            putInt(Settings.NUM_CARDS_TO_FLASH, index)
                            apply()
                        }
                    },
                        text = { Text(text = s) })
                }
            }
        }


        // TODO: Use mapper in settings instead of hardcoded list
        Text("- Number of decks to use")
        val numDecksToUse = listOf("1", "2", "4", "6", "8")
        var isNumOfDecksToUseExpanded by remember { mutableStateOf(false) }
        var selectedNumOfDecksToUseIndex by remember { mutableStateOf(sharedPref.getInt(Settings.NUM_DECKS_TO_COUNT, 0)) }

        Box(Modifier.testTag("NumOfDecksToUseBox")) {
            Text(numDecksToUse[selectedNumOfDecksToUseIndex],modifier = Modifier
                .fillMaxWidth().testTag("NumOfDecksToUseItem")
                .clickable(onClick = { isNumOfDecksToUseExpanded = true }))
            DropdownMenu(
                expanded = isNumOfDecksToUseExpanded,
                onDismissRequest = { isNumOfDecksToUseExpanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                numDecksToUse.forEachIndexed { index, s ->
                    DropdownMenuItem(onClick = {
                        selectedNumOfDecksToUseIndex = index
                        isNumOfDecksToUseExpanded = false
                        with (sharedPref.edit()) {
                            putInt(Settings.NUM_DECKS_TO_COUNT, index)
                            apply()
                        }
                    },
                        text = { Text(text = s) })
                }
            }
        }

        Text("Strategy Drills: ")
        Text("- Number of cards in hand")
        // TODO: Use mapper in settings instead of hardcoded list
        val numCardInHandItems = listOf("2 cards", "3 cards")
        var isNumCardInHandExpanded by remember { mutableStateOf(false) }
        var selectedNumCardsInHandIndex by remember { mutableStateOf(sharedPref.getInt(Settings.NUM_CARDS_IN_HAND, 0)) }

        Box(Modifier.testTag("NumOfCardsInHandBox")) {
            Text(numCardInHandItems[selectedNumCardsInHandIndex],modifier = Modifier
                .fillMaxWidth().testTag("NumOfCardsInHandItem")
                .clickable(onClick = { isNumCardInHandExpanded = true }))
            DropdownMenu(
                expanded = isNumCardInHandExpanded,
                onDismissRequest = { isNumCardInHandExpanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                numCardInHandItems.forEachIndexed { index, s ->
                    DropdownMenuItem(onClick = {
                        selectedNumCardsInHandIndex = index
                        isNumCardInHandExpanded = false
                        with (sharedPref.edit()) {
                            putInt(Settings.NUM_CARDS_IN_HAND, index)
                            apply()
                        }
                    },
                        text = { Text(text = s) })
                }
            }
        }

        Text("- Strategy to use:")
        // TODO: Use mapper in settings instead of hardcoded list
        val strategyItems = Settings.Strategy.values()
        var isStrategyExpanded by remember { mutableStateOf(false) }
        var strategyIndex by remember { mutableStateOf(sharedPref.getInt(Settings.STRATEGY, 0)) }

        Box(Modifier.testTag("NumOfCardsInHandBox")) {
            Text(strategyItems[strategyIndex].name,modifier = Modifier
                .fillMaxWidth().testTag("NumOfCardsInHandItem")
                .clickable(onClick = { isStrategyExpanded = true }))
            DropdownMenu(
                expanded = isStrategyExpanded,
                onDismissRequest = { isStrategyExpanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                strategyItems.forEachIndexed { index, s ->
                    DropdownMenuItem(onClick = {
                        strategyIndex = index
                        isStrategyExpanded = false
                        with (sharedPref.edit()) {
                            putInt(Settings.STRATEGY, index)
                            apply()
                        }
                    },
                        text = { Text(text = s.name) })
                }
            }
        }
    }
}