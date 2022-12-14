package com.example.advantagetrainer

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.*
import com.example.advantagetrainer.ui.theme.AdvantageTrainerTheme
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    private val TEST_SETTINGS_FILE_LOCATION = "com.example.advantagetrainertest"

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun homeScreen_ShouldHaveButtonsForOtherScreens() {
        val buttonCount = 3
        val buttonTags = listOf<String>("CountingDrillButton", "CouponCalculatorButton", "SettingsButton")

        // Start the app
        composeTestRule.setContent {
            AdvantageTrainerTheme {
                GenerateAppView()
            }
        }

        val buttons = composeTestRule.onAllNodes(hasClickAction()).assertCountEquals(buttonCount)
        for(i in 0 until buttonCount){
            buttons[i].assertIsDisplayed()
            buttons.filter(hasTestTag(buttonTags[i])).assertCountEquals(1)
        }
    }

    @Test
    fun homeScreen_ShouldNavigateToCountingDrillScreen() {
        val homeButtonTag = "CountingDrillButton"
        val countingDrillButtonTags = listOf<String>("HomeButton", "StartButton")

        // Start the app
        composeTestRule.setContent {
            AdvantageTrainerTheme {
                GenerateAppView()
            }
        }

        val navigateToCountingDrillButton = composeTestRule.onAllNodes(hasClickAction()).filter(hasTestTag(homeButtonTag))
        navigateToCountingDrillButton.assertCountEquals(1)

        // Navigate to the CountingDrillScreen
        navigateToCountingDrillButton[0].performClick()

        // Assert we are on the CountingDrillScreen by looking at the buttons
        val countingDrillScreenButtons = composeTestRule.onAllNodes(hasClickAction()).assertCountEquals(2)
        for(i in 0 until 2){
            countingDrillScreenButtons[i].assertIsDisplayed()
            countingDrillScreenButtons.filter(hasTestTag(countingDrillButtonTags[i])).assertCountEquals(1)
        }
    }

    @Test
    fun homeScreen_ShouldNavigateToSettingsScreen() {
        val settingsButtonTag = "SettingsButton"

        // Start the app
        composeTestRule.setContent {
            AdvantageTrainerTheme {
                GenerateAppView()
            }
        }

        val navigateToSettingsButton =
            composeTestRule.onAllNodes(hasClickAction()).filter(hasTestTag(settingsButtonTag))
        navigateToSettingsButton.assertCountEquals(1)

        // Navigate to the SettingsScreen
        navigateToSettingsButton[0].performClick()

        composeTestRule.onNode(hasTestTag("CardFlashSpeedBox")).assertIsDisplayed()
        composeTestRule.onNode(hasTestTag("DeckTypeBox")).assertIsDisplayed()
        composeTestRule.onNode(hasTestTag("NumOfCardsToFlashBox")).assertIsDisplayed()
        composeTestRule.onNode(hasTestTag("NumOfDecksToUseBox")).assertIsDisplayed()
    }

    // TODO: Figure out how to assert on internal values
    @Test
    fun countingDrillScreen_ShouldStartDrill() {
        val countingDrillButtonTag = "CountingDrillButton"
        val startButton = "StartButton"

        // Start the app
        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE)

            with (sharedPref.edit()) {
                clear()
                apply()
            }

            AdvantageTrainerTheme {
                GenerateAppView()
            }
        }

        // Navigate to the counting drill screen
        val navigateToCountingDrillButton = composeTestRule.onAllNodes(hasClickAction()).filter(hasTestTag(countingDrillButtonTag))
        navigateToCountingDrillButton[0].performClick()

        // Click the start button
        val startDrillButton = composeTestRule.onAllNodes(hasClickAction()).filter(hasTestTag(startButton))
        startDrillButton[0].performClick()

        // Assert that cards are being displayed
        composeTestRule.onAllNodes(hasContentDescription("Card")).assertCountEquals(1)
    }

    @Test
    fun createDeck_CreatesAllCardsForBlackjack() {
        var deck = ArrayList<Card>()
        val deckSize = 52
        var heartsCount = 0
        var spadesCount = 0
        var diamondsCount = 0
        var clubsCount = 0

        var twoCount = 0
        var threeCount = 0
        var fourCount = 0
        var fiveCount = 0
        var sixCount = 0
        var sevenCount = 0
        var eightCount = 0
        var nineCount = 0
        var tenCount = 0
        var jackCount = 0
        var queenCount = 0
        var kingCount = 0
        var aceCount = 0

        // Start the app
        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE)

            with (sharedPref.edit()) {
                clear()
                apply()
            }

            AdvantageTrainerTheme {
                deck = CreateDeck(sharedPref = sharedPref)
            }
        }

        assert(deck.size == deckSize)
        deck.forEach {card ->
            if(card.suit == Suits.HEART){
                heartsCount++
            }else if (card.suit == Suits.SPADE){
                spadesCount++
            }else if (card.suit == Suits.DIAMOND){
                diamondsCount++
            }else if (card.suit == Suits.CLUB){
                clubsCount++
            }

            if(card.name == CardNames.TWO){
                twoCount++
            }else if(card.name == CardNames.THREE){
                threeCount++
            }else if(card.name == CardNames.FOUR){
                fourCount++
            }else if(card.name == CardNames.FIVE){
                fiveCount++
            }else if(card.name == CardNames.SIX){
                sixCount++
            }else if(card.name == CardNames.SEVEN){
                sevenCount++
            }else if(card.name == CardNames.EIGHT){
                eightCount++
            }else if(card.name == CardNames.NINE){
                nineCount++
            }else if(card.name == CardNames.TEN){
                tenCount++
            }else if(card.name == CardNames.JACK){
                jackCount++
            }else if(card.name == CardNames.QUEEN){
                queenCount++
            }else if(card.name == CardNames.KING){
                kingCount++
            }else if(card.name == CardNames.ACE){
                aceCount++
            }
        }

        assert(heartsCount == 13)
        assert(spadesCount == 13)
        assert(diamondsCount == 13)
        assert(clubsCount == 13)

        assert(twoCount == 4)
        assert(threeCount == 4)
        assert(fourCount == 4)
        assert(fiveCount == 4)
        assert(sixCount == 4)
        assert(sevenCount == 4)
        assert(eightCount == 4)
        assert(nineCount == 4)
        assert(tenCount == 4)
        assert(jackCount == 4)
        assert(queenCount == 4)
        assert(kingCount == 4)
        assert(aceCount == 4)

    }


    @Test
    fun createDeck_CreatesAllCardsForSpanish() {
        var deck = ArrayList<Card>()
        val deckSize = 48
        var heartsCount = 0
        var spadesCount = 0
        var diamondsCount = 0
        var clubsCount = 0

        var twoCount = 0
        var threeCount = 0
        var fourCount = 0
        var fiveCount = 0
        var sixCount = 0
        var sevenCount = 0
        var eightCount = 0
        var nineCount = 0
        var tenCount = 0
        var jackCount = 0
        var queenCount = 0
        var kingCount = 0
        var aceCount = 0

        // Start the app
        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE)

            with (sharedPref.edit()) {
                clear()
                putBoolean(Settings.USE_SPANISH_DECK, true)
                apply()
            }

            AdvantageTrainerTheme {
                deck = CreateDeck(sharedPref = sharedPref)
            }
        }

        assert(deck.size == deckSize)
        deck.forEach {card ->
            if(card.suit == Suits.HEART){
                heartsCount++
            }else if (card.suit == Suits.SPADE){
                spadesCount++
            }else if (card.suit == Suits.DIAMOND){
                diamondsCount++
            }else if (card.suit == Suits.CLUB){
                clubsCount++
            }

            if(card.name == CardNames.TWO){
                twoCount++
            }else if(card.name == CardNames.THREE){
                threeCount++
            }else if(card.name == CardNames.FOUR){
                fourCount++
            }else if(card.name == CardNames.FIVE){
                fiveCount++
            }else if(card.name == CardNames.SIX){
                sixCount++
            }else if(card.name == CardNames.SEVEN){
                sevenCount++
            }else if(card.name == CardNames.EIGHT){
                eightCount++
            }else if(card.name == CardNames.NINE){
                nineCount++
            }else if(card.name == CardNames.TEN){
                tenCount++
            }else if(card.name == CardNames.JACK){
                jackCount++
            }else if(card.name == CardNames.QUEEN){
                queenCount++
            }else if(card.name == CardNames.KING){
                kingCount++
            }else if(card.name == CardNames.ACE){
                aceCount++
            }
        }

        assert(heartsCount == 12)
        assert(spadesCount == 12)
        assert(diamondsCount == 12)
        assert(clubsCount == 12)

        assert(twoCount == 4)
        assert(threeCount == 4)
        assert(fourCount == 4)
        assert(fiveCount == 4)
        assert(sixCount == 4)
        assert(sevenCount == 4)
        assert(eightCount == 4)
        assert(nineCount == 4)
        assert(tenCount == 0)
        assert(jackCount == 4)
        assert(queenCount == 4)
        assert(kingCount == 4)
        assert(aceCount == 4)
    }

    @Test
    fun createDeck_CreateSingleDeck() {
        var deck = ArrayList<Card>()
        val deckSize = 52

        // Start the app
        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE)

            with (sharedPref.edit()) {
                clear()
                putInt(Settings.NUM_DECKS_TO_COUNT, 0)
                apply()
            }

            AdvantageTrainerTheme {
                deck = CreateDeck(sharedPref = sharedPref)
            }
        }

        assert(deck.size == deckSize)
    }

    @Test
    fun createDeck_CreateDoubleDeck() {
        var deck = ArrayList<Card>()
        val deckSize = 52 * 2

        // Start the app
        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE)

            with (sharedPref.edit()) {
                clear()
                putInt(Settings.NUM_DECKS_TO_COUNT, 1)
                apply()
            }

            AdvantageTrainerTheme {
                deck = CreateDeck(sharedPref = sharedPref)
            }
        }

        assert(deck.size == deckSize)
    }

    @Test
    fun createDeck_CreateFourDeck() {
        var deck = ArrayList<Card>()
        val deckSize = 52 * 4

        // Start the app
        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE)

            with (sharedPref.edit()) {
                clear()
                putInt(Settings.NUM_DECKS_TO_COUNT, 2)
                apply()
            }

            AdvantageTrainerTheme {
                deck = CreateDeck(sharedPref = sharedPref)
            }
        }

        assert(deck.size == deckSize)
    }

    @Test
    fun createDeck_CreateSixDeck() {
        var deck = ArrayList<Card>()
        val deckSize = 52 * 6

        // Start the app
        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE)

            with (sharedPref.edit()) {
                clear()
                putInt(Settings.NUM_DECKS_TO_COUNT, 3)
                apply()
            }

            AdvantageTrainerTheme {
                deck = CreateDeck(sharedPref = sharedPref)
            }
        }

        assert(deck.size == deckSize)
    }

    @Test
    fun createDeck_CreateEightsDeck() {
        var deck = ArrayList<Card>()
        val deckSize = 52 * 8

        // Start the app
        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE)

            with (sharedPref.edit()) {
                clear()
                putInt(Settings.NUM_DECKS_TO_COUNT, 4)
                apply()
            }

            AdvantageTrainerTheme {
                deck = CreateDeck(sharedPref = sharedPref)
            }
        }

        assert(deck.size == deckSize)
    }

    @Test
    fun createDeck_SettingIsOutOfBoundToMapper_CreateSingleDeck() {
        var deck = ArrayList<Card>()
        val deckSize = 52

        // Start the app
        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE)

            with (sharedPref.edit()) {
                clear()
                putInt(Settings.NUM_DECKS_TO_COUNT, 5)
                apply()
            }

            AdvantageTrainerTheme {
                deck = CreateDeck(sharedPref = sharedPref)
            }
        }

        assert(deck.size == deckSize)
    }

    @Test
    fun showCard_IndexOfCardToShowIsGreaterThanDeckSize_DontShowCard() {
        val deck = ArrayList<Card>()
        val indexOfCardToShow = 1
        val numCardToFlashSetting = 1

        // Start the app
        composeTestRule.setContent {
            AdvantageTrainerTheme {
                ShowCard(deck, indexOfCardToShow, numCardToFlashSetting)
            }
        }
        composeTestRule.onAllNodes(hasContentDescription("Card")).assertCountEquals(0)
    }

    @Test
    fun showCard_NumOfCardsToFlashIsZero_DontShowCard() {
        val indexOfCardToShow = 1
        val numCardToFlashSetting = 0

        // Start the app
        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE)

            with (sharedPref.edit()) {
                clear()
                apply()
            }

            AdvantageTrainerTheme {
                val deck = CreateDeck(sharedPref = sharedPref)
                ShowCard(deck, indexOfCardToShow, numCardToFlashSetting)
            }
        }
        composeTestRule.onAllNodes(hasContentDescription("Card")).assertCountEquals(0)
    }

    @Test
    fun showCard_NumOfCardsToFlashIsFour_DontShowCard() {
        val indexOfCardToShow = 1
        val numCardToFlashSetting = 4

        // Start the app
        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE)

            with (sharedPref.edit()) {
                clear()
                apply()
            }

            AdvantageTrainerTheme {
                val deck = CreateDeck(sharedPref = sharedPref)
                ShowCard(deck, indexOfCardToShow, numCardToFlashSetting)
            }
        }
        composeTestRule.onAllNodes(hasContentDescription("Card")).assertCountEquals(0)
    }

    @Test
    fun showCard_OneCardLeftInTheDeck_WantingToFlashMoreThanOne_ShowSingleCard() {
        val deck = ArrayList<Card>()
        val indexOfCardToShow = 0
        val numCardToFlashSetting = 2

        // Start the app
        composeTestRule.setContent {
            val id = LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/${Suits.DIAMOND}${CardNames.ACE}", null, null)
            deck.add(Card(Suits.DIAMOND, CardNames.ACE, null, id))
            
            AdvantageTrainerTheme {
                ShowCard(deck, indexOfCardToShow, numCardToFlashSetting)
            }
        }
        composeTestRule.onAllNodes(hasContentDescription("Card")).assertCountEquals(1)
    }


    @Test
    fun showCard_SingleCardFlash_ShowSingleCard() {
        val indexOfCardToShow = 0
        val numCardToFlashSetting = 1

        // Start the app
        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE)

            with (sharedPref.edit()) {
                clear()
                apply()
            }
            
            val deck = CreateDeck(sharedPref = sharedPref)

            AdvantageTrainerTheme {
                ShowCard(deck, indexOfCardToShow, numCardToFlashSetting)
            }
        }
        composeTestRule.onAllNodes(hasContentDescription("Card")).assertCountEquals(1)
    }

    @Test
    fun showCard_TwoCardsToFlash_ShowTwoCards() {
        val indexOfCardToShow = 0
        val numCardToFlashSetting = 2

        // Start the app
        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE)

            with (sharedPref.edit()) {
                clear()
                apply()
            }

            val deck = CreateDeck(sharedPref = sharedPref)

            AdvantageTrainerTheme {
                ShowCard(deck, indexOfCardToShow, numCardToFlashSetting)
            }
        }
        composeTestRule.onAllNodes(hasContentDescription("Card")).assertCountEquals(2)
    }

    @Test
    fun showCard_ThreeCardsToFlash_ShowThreeCards() {
        val indexOfCardToShow = 0
        val numCardToFlashSetting = 3

        // Start the app
        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE)

            with (sharedPref.edit()) {
                clear()
                apply()
            }

            val deck = CreateDeck(sharedPref = sharedPref)

            AdvantageTrainerTheme {
                ShowCard(deck, indexOfCardToShow, numCardToFlashSetting)
            }
        }
        composeTestRule.onAllNodes(hasContentDescription("Card")).assertCountEquals(3)
    }

    @Test
    fun showCard_TwoCardsInDeck_ThreeCardsToFlash_ShowTwoCards() {
        val deck = ArrayList<Card>()
        val indexOfCardToShow = 0
        val numCardToFlashSetting = 3

        // Start the app
        composeTestRule.setContent {
            val id = LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/${Suits.DIAMOND}${CardNames.ACE}", null, null)
            deck.add(Card(Suits.DIAMOND, CardNames.ACE, null, id))
            deck.add(Card(Suits.DIAMOND, CardNames.ACE, null, id))

            AdvantageTrainerTheme {
                ShowCard(deck, indexOfCardToShow, numCardToFlashSetting)
            }
        }
        composeTestRule.onAllNodes(hasContentDescription("Card")).assertCountEquals(2)
    }

}