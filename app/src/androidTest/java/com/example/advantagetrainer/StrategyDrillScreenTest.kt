package com.example.advantagetrainer

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.advantagetrainer.enums.CardNames
import com.example.advantagetrainer.enums.Suits
import com.example.advantagetrainer.views.getValidHandToShow
import com.example.advantagetrainer.views.isOddHand
import org.junit.Rule
import org.junit.Test

class StrategyDrillScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun getValidHandToShow_indexIsGreaterThanDeckSize_returnMinus1(){
        var index = 0

        composeTestRule.setContent {
            val card1 = Card(Suits.CLUB, CardNames.ACE, null, LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.ACE}", null, null))
            val card2 = Card(Suits.CLUB, CardNames.TEN, 10, LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.TEN}", null, null))
            val cards = arrayListOf(card1, card2)

            val numCardToFlashSetting = 3

            index = getValidHandToShow(cards, index, numCardToFlashSetting)
        }

        assert(index == -1)

    }

    @Test
    fun getValidHandToShow_handTotalIsEqualToBlackjack_returnsIndex(){
        var index = 0

        composeTestRule.setContent {
            val card1 = Card(Suits.CLUB, CardNames.ACE, null, LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.ACE}", null, null))
            val card2 = Card(Suits.CLUB, CardNames.TEN, 10, LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.TEN}", null, null))
            val card3 = Card(Suits.CLUB, CardNames.TEN, 10, LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.TEN}", null, null))
            val cards = arrayListOf(card1, card2, card3)

            val numCardToFlashSetting = 2

            index = getValidHandToShow(cards, index, numCardToFlashSetting)
        }

        assert(index == 0)

    }

    @Test
    fun getValidHandToShow_handTotalIsEqualTo21_returnsIndex(){
        var index = 0

        composeTestRule.setContent {
            val card1 = Card(Suits.CLUB, CardNames.SIX, 6, LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.SIX}", null, null))
            val card2 = Card(Suits.CLUB, CardNames.FIVE, 5, LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.FIVE}", null, null))
            val card3 = Card(Suits.CLUB, CardNames.TEN, 10, LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.TEN}", null, null))
            val card4 = Card(Suits.CLUB, CardNames.TEN, 10, LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.TEN}", null, null))
            val cards = arrayListOf(card1, card2, card3, card4)

            val numCardToFlashSetting = 3

            index = getValidHandToShow(cards, index, numCardToFlashSetting)
        }
        assert(index == 0)
    }

    @Test
    fun getValidHandToShow_handTotalIsLessThan21_returnsIndex(){
        var index = 0

        composeTestRule.setContent {
            val card1 = Card(Suits.CLUB, CardNames.TEN, 10, LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.TEN}", null, null))
            val card2 = Card(Suits.CLUB, CardNames.TEN, 10, LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.TEN}", null, null))
            val card3 = Card(Suits.CLUB, CardNames.TEN, 10, LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.TEN}", null, null))
            val cards = arrayListOf(card1, card2, card3)

            val numCardToFlashSetting = 2

            index = getValidHandToShow(cards, index, numCardToFlashSetting)
        }
        assert(index == 0)
    }

    @Test
    fun getValidHandToShow_handTotalIsGreaterThan21_returnsIndex(){
        var index = 0

        composeTestRule.setContent {
            val card1 = Card(Suits.CLUB, CardNames.TEN, 10, LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.TEN}", null, null))
            val card2 = Card(Suits.CLUB, CardNames.TEN, 10, LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.TEN}", null, null))
            val card3 = Card(Suits.CLUB, CardNames.TEN, 10, LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.TEN}", null, null))
            val card4 = Card(Suits.CLUB, CardNames.EIGHT, 8, LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.EIGHT}", null, null))
            val card5 = Card(Suits.CLUB, CardNames.TWO, 2, LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.FOUR}", null, null))
            val cards = arrayListOf(card1, card2, card3, card4, card5)

            val numCardToFlashSetting = 3

            index = getValidHandToShow(cards, index, numCardToFlashSetting)
        }
        assert(index == 0 || index == 1 || index == 2)
    }

    @Test
    fun isOddHand_blackJack_notOdd(){
        composeTestRule.setContent {
            val card1 = Card(
                Suits.CLUB,
                CardNames.ACE,
                null,
                LocalContext.current.resources.getIdentifier(
                    "com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.ACE}",
                    null,
                    null
                )
            )
            val card2 = Card(
                Suits.CLUB,
                CardNames.TEN,
                10,
                LocalContext.current.resources.getIdentifier(
                    "com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.TEN}",
                    null,
                    null
                )
            )
            val cards = arrayListOf(card1, card2)
            assert(!isOddHand(cards))
        }
    }

    @Test
    fun isOddHand_blackJackInThreeCardHand_isOdd(){
        composeTestRule.setContent {
            val card1 = Card(
                Suits.CLUB,
                CardNames.ACE,
                null,
                LocalContext.current.resources.getIdentifier(
                    "com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.ACE}",
                    null,
                    null
                )
            )
            val card2 = Card(
                Suits.CLUB,
                CardNames.TEN,
                10,
                LocalContext.current.resources.getIdentifier(
                    "com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.TEN}",
                    null,
                    null
                )
            )
            val card3 = Card(
                Suits.CLUB,
                CardNames.TEN,
                10,
                LocalContext.current.resources.getIdentifier(
                    "com.example.advantagetrainer:drawable/${Suits.CLUB}${CardNames.TEN}",
                    null,
                    null
                )
            )
            val cards = arrayListOf(card1, card2, card3)
            assert(isOddHand(cards))
        }
    }
}