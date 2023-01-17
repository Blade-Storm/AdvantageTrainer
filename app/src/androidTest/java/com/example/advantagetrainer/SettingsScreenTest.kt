package com.example.advantagetrainer

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.advantagetrainer.ui.theme.AdvantageTrainerTheme
import com.example.advantagetrainer.views.SettingsScreen
import org.junit.Rule
import org.junit.Test

class SettingsScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    
    @Test
    fun settingsScreen_countingDrills_defaults() {
        // Start the app
        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                TestUtils().TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE)

            with (sharedPref.edit()) {
                clear()
                apply()
            }

            AdvantageTrainerTheme {
                SettingsScreen({},{}, sharedPref = sharedPref)
            }
        }

        composeTestRule.onNode(hasTestTag("SelectedCardSpeedItem")).assertTextEquals("1.00")
        composeTestRule.onNode(hasTestTag("SelectedDeckTypeItem")).assertTextEquals("BLACKJACK")
        composeTestRule.onNode(hasTestTag("NumOfCardsToFlashItem")).assertTextEquals("1 card")
        composeTestRule.onNode(hasTestTag("NumOfDecksToUseItem")).assertTextEquals("1")
    }

    @Test
    fun settingsScreen_countingDrills_Overrides() {
        // Start the app
        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                TestUtils().TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE)

            with (sharedPref.edit()) {
                clear()
                putInt(Settings.CARD_FLASH_SPEED, 1)
                putInt(Settings.DECK_TYPE, 2)
                putInt(Settings.NUM_CARDS_TO_FLASH, 1)
                putInt(Settings.NUM_DECKS_TO_COUNT, 1)
                apply()
            }

            AdvantageTrainerTheme {
                SettingsScreen({},{}, sharedPref = sharedPref)
            }
        }

        composeTestRule.onNode(hasTestTag("SelectedCardSpeedItem")).assertTextEquals("0.50")
        composeTestRule.onNode(hasTestTag("SelectedDeckTypeItem")).assertTextEquals("SPANISH")
        composeTestRule.onNode(hasTestTag("NumOfCardsToFlashItem")).assertTextEquals("2 cards")
        composeTestRule.onNode(hasTestTag("NumOfDecksToUseItem")).assertTextEquals("2")
    }
}