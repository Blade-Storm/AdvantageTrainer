package com.example.advantagetrainer

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.advantagetrainer.enums.Actions
import com.example.advantagetrainer.enums.CardNames
import com.example.advantagetrainer.views.setCountingStrategy
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test

class BJAH17Test {
    lateinit var actionResolver: ActionResolver
    var testUtils = TestUtils()

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun split_v2() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card2)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                    || card.name == CardNames.EIGHT
                    || card.name == CardNames.NINE
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    card.name == CardNames.FOUR
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun split_v3() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card3)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                    || card.name == CardNames.EIGHT
                    || card.name == CardNames.NINE
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    card.name == CardNames.FOUR
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun split_v4() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card4)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                    || card.name == CardNames.EIGHT
                    || card.name == CardNames.NINE
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    card.name == CardNames.FOUR
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun split_v5() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card5)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                    || card.name == CardNames.EIGHT
                    || card.name == CardNames.NINE
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun split_v6() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card6)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                    || card.name == CardNames.EIGHT
                    || card.name == CardNames.NINE
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun split_v7() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card7)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.SEVEN
                    || card.name == CardNames.EIGHT
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    card.name == CardNames.FOUR
                    || card.name == CardNames.SIX
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                } else if (
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    card.name == CardNames.NINE
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun split_v8() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card8)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.EIGHT
                    || card.name == CardNames.NINE
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                } else if (
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun split_v9() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card9)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.EIGHT
                    || card.name == CardNames.NINE
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                } else if (
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun split_vt() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardt)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.EIGHT
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                } else if (
                    card.name == CardNames.NINE
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun split_vj() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardj)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.EIGHT
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                } else if (
                    card.name == CardNames.NINE
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun split_vq() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardq)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.EIGHT
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                } else if (
                    card.name == CardNames.NINE
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun split_vk() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardk)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.EIGHT
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                } else if (
                    card.name == CardNames.NINE
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun split_va() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.carda)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.EIGHT
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                } else if (
                    card.name == CardNames.NINE
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_v2() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card2)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                    || playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                    || playerHand.cards[1].name == CardNames.SIX
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.cards[1].name == CardNames.SEVEN
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                } else if (
                    playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_v3() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card3)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                    || playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.cards[1].name == CardNames.SIX
                    || playerHand.cards[1].name == CardNames.SEVEN
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                } else if (
                    playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_v4() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card4)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                    || playerHand.cards[1].name == CardNames.SIX
                    || playerHand.cards[1].name == CardNames.SEVEN
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                } else if (
                    playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_v5() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card5)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if (
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                    || playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                    || playerHand.cards[1].name == CardNames.SIX
                    || playerHand.cards[1].name == CardNames.SEVEN
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                } else if (
                    playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_v6() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card6)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if (
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                    || playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                    || playerHand.cards[1].name == CardNames.SIX
                    || playerHand.cards[1].name == CardNames.SEVEN
                    || playerHand.cards[1].name == CardNames.EIGHT
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                } else if (
                    playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_v7() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card7)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if (
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                    || playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                    || playerHand.cards[1].name == CardNames.SIX
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                } else if (
                    playerHand.cards[1].name == CardNames.SEVEN
                    || playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_v8() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card8)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if (
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                    || playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                    || playerHand.cards[1].name == CardNames.SIX
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                } else if (
                    playerHand.cards[1].name == CardNames.SEVEN
                    || playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_v9() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card9)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if (
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                    || playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                    || playerHand.cards[1].name == CardNames.SIX
                    || playerHand.cards[1].name == CardNames.SEVEN
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                } else if (
                    playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vt() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardt)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if (
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                    || playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                    || playerHand.cards[1].name == CardNames.SIX
                    || playerHand.cards[1].name == CardNames.SEVEN
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                } else if (
                    playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vj() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardj)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if (
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                    || playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                    || playerHand.cards[1].name == CardNames.SIX
                    || playerHand.cards[1].name == CardNames.SEVEN
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                } else if (
                    playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vq() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardq)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if (
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                    || playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                    || playerHand.cards[1].name == CardNames.SIX
                    || playerHand.cards[1].name == CardNames.SEVEN
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                } else if (
                    playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vk() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardk)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if (
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                    || playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                    || playerHand.cards[1].name == CardNames.SIX
                    || playerHand.cards[1].name == CardNames.SEVEN
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                } else if (
                    playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_va() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.carda)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if (
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                    || playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                    || playerHand.cards[1].name == CardNames.SIX
                    || playerHand.cards[1].name == CardNames.SEVEN
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                } else if (
                    playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_v2_threeCards() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card2)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards) {
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction =
                    actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.TEN   // This becomes a hard hand and hits
                    || card.name == CardNames.JACK  // This becomes a hard hand and hits
                    || card.name == CardNames.QUEEN // This becomes a hard hand and hits
                    || card.name == CardNames.KING  // This becomes a hard hand and hits
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else{
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_v3_threeCards() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card3)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards) {
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction =
                    actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.TEN   // This becomes a hard hand and hits
                    || card.name == CardNames.JACK  // This becomes a hard hand and hits
                    || card.name == CardNames.QUEEN // This becomes a hard hand and hits
                    || card.name == CardNames.KING  // This becomes a hard hand and hits
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else{
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_v4_threeCards() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card4)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards) {
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction =
                    actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else{
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_v5_threeCards() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card5)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards) {
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction =
                    actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else{
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_v6_threeCards() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card6)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards) {
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction =
                    actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else{
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_v7_threeCards() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card7)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards) {
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction =
                    actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else{
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_v8_threeCards() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card8)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards) {
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction =
                    actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else{
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_v9_threeCards() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card9)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards) {
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction =
                    actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else{
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vt_threeCards() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardt)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards) {
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction =
                    actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else{
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vj_threeCards() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardj)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards) {
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction =
                    actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else{
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vq_threeCards() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardq)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards) {
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction =
                    actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else{
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vk_threeCards() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardk)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards) {
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction =
                    actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else{
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_va_threeCards() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.carda)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(card in testUtils.cards) {
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction =
                    actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else{
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_v2() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card2)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 10
                    || hand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                    || hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_v3() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card3)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                    || hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_v4() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card4)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                    || hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_v5() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card5)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                    || hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_v6() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card6)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                    || hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_v7() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card7)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 10
                    || hand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_v8() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card8)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 10
                    || hand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_v9() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card9)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 10
                    || hand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if(
                    hand.handTotal == 16
                ){
                    TestCase.assertEquals(Actions.SURRENDER, playerAction)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vt() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardt)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                } else if (
                    hand.handTotal == 15
                    || hand.handTotal == 16
                ){
                    TestCase.assertEquals(Actions.SURRENDER, playerAction)
                } else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vj() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardj)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                } else if (
                    hand.handTotal == 15
                    || hand.handTotal == 16
                ){
                    TestCase.assertEquals(Actions.SURRENDER, playerAction)
                } else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vq() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardq)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                } else if (
                    hand.handTotal == 15
                    || hand.handTotal == 16
                ){
                    TestCase.assertEquals(Actions.SURRENDER, playerAction)
                } else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vk() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardk)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                } else if (
                    hand.handTotal == 15
                    || hand.handTotal == 16
                ){
                    TestCase.assertEquals(Actions.SURRENDER, playerAction)
                } else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_va() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.carda)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                } else if (
                    hand.handTotal == 16
                    || hand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.SURRENDER, playerAction)
                } else if (
                    hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_v2_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card2)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands_threeCard) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 11
                    || hand.handTotal == 12
                ) {
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                    || hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_v3_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card3)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands_threeCard) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 11
                    || hand.handTotal == 12
                ) {
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                    || hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_v4_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card4)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands_threeCard) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 11
                ) {
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                    || hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_v5_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card5)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands_threeCard) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 11
                ) {
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                    || hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_v6_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card6)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands_threeCard) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 11
                ) {
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                    || hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_v7_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card7)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands_threeCard) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 11
                    || hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                ) {
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_v8_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card8)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands_threeCard) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 11
                    || hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                ) {
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_v9_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card9)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands_threeCard) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 11
                    || hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                ) {
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vt_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardt)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands_threeCard) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 11
                    || hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                ) {
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vj_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardj)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands_threeCard) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 11
                    || hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                ) {
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vq_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardq)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands_threeCard) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 11
                    || hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                ) {
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vk_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardk)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands_threeCard) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 11
                    || hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                ) {
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_va_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.carda)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            for(hand in testUtils.hardHands_threeCard) {
                playerAction =
                    actionResolver.getActionFromStrategy(hand, dealerHand, 0, false)

                if(
                    hand.handTotal == 2
                    || hand.handTotal == 3
                    || hand.handTotal == 4
                    || hand.handTotal == 5
                    || hand.handTotal == 6
                    || hand.handTotal == 7
                    || hand.handTotal == 8
                    || hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 11
                    || hand.handTotal == 12
                    || hand.handTotal == 13
                    || hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                ) {
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun surrender_v9() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card9)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16, dealerHand, 0, false)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)
        }
    }

    @Test
    fun surrender_vt() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardt)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16, dealerHand, 0, false)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15, dealerHand, 0, false)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)
        }
    }

    @Test
    fun surrender_vj() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardj)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16, dealerHand, 0, false)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15, dealerHand, 0, false)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)
        }
    }

    @Test
    fun surrender_vq() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardq)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16, dealerHand, 0, false)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15, dealerHand, 0, false)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)
        }
    }

    @Test
    fun surrender_vk() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardk)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16, dealerHand, 0, false)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15, dealerHand, 0, false)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)
        }
    }

    @Test
    fun surrender_va() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.carda)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16, dealerHand, 0, false)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard17, dealerHand, 0, false)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)
        }
    }

    @Test
    fun deviation_split_v4() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card4)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.splitt, dealerHand, 6, true)
            TestCase.assertEquals(Actions.SPLIT, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.splitj, dealerHand, 6, true)
            TestCase.assertEquals(Actions.SPLIT, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.splitq, dealerHand, 6, true)
            TestCase.assertEquals(Actions.SPLIT, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.splitk, dealerHand, 6, true)
            TestCase.assertEquals(Actions.SPLIT, playerAction)
        }
    }

    @Test
    fun deviation_split_v5() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card5)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.splitt, dealerHand, 5, true)
            TestCase.assertEquals(Actions.SPLIT, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.splitj, dealerHand, 5, true)
            TestCase.assertEquals(Actions.SPLIT, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.splitq, dealerHand, 5, true)
            TestCase.assertEquals(Actions.SPLIT, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.splitk, dealerHand, 5, true)
            TestCase.assertEquals(Actions.SPLIT, playerAction)
        }
    }

    @Test
    fun deviation_split_v6() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card6)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.splitt, dealerHand, 4, true)
            TestCase.assertEquals(Actions.SPLIT, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.splitj, dealerHand, 4, true)
            TestCase.assertEquals(Actions.SPLIT, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.splitq, dealerHand, 4, true)
            TestCase.assertEquals(Actions.SPLIT, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.splitk, dealerHand, 4, true)
            TestCase.assertEquals(Actions.SPLIT, playerAction)
        }
    }

    @Test
    fun deviation_soft_v2() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card2)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.softa6, dealerHand, 1, true)
            TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
        }
    }

    @Test
    fun deviation_soft_v2_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card2)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.softaa5, dealerHand, 1, true)
            TestCase.assertEquals(Actions.HIT, playerAction)
        }
    }

    @Test
    fun deviation_soft_v4() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card4)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.softa8, dealerHand, 3, true)
            TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
        }
    }

    @Test
    fun deviation_soft_v4_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card4)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.softaa7, dealerHand, 3, true)
            TestCase.assertEquals(Actions.STAND, playerAction)
        }
    }

    @Test
    fun deviation_soft_v5() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card5)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.softa8, dealerHand, 1, true)
            TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
        }
    }

    @Test
    fun deviation_soft_v5_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card5)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.softaa7, dealerHand, 1, true)
            TestCase.assertEquals(Actions.STAND, playerAction)
        }
    }

    @Test
    fun deviation_soft_v6() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card6)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.softa8, dealerHand, -1, true)
            TestCase.assertEquals(Actions.STAND, playerAction)
        }
    }

    @Test
    fun deviation_soft_v6_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card6)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.softaa7, dealerHand, -1, true)
            TestCase.assertEquals(Actions.STAND, playerAction)
        }
    }

    @Test
    fun deviation_hard_v2() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card2)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard9, dealerHand, 1, true)
            TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard12, dealerHand, 3, true)
            TestCase.assertEquals(Actions.STAND, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard13, dealerHand, -1, true)
            TestCase.assertEquals(Actions.HIT, playerAction)
        }
    }

    @Test
    fun deviation_hard_v2_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card2)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard9_threeCard, dealerHand, 1, true)
            TestCase.assertEquals(Actions.HIT, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard12_threeCard, dealerHand, 3, true)
            TestCase.assertEquals(Actions.STAND, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard13_threeCard, dealerHand, -1, true)
            TestCase.assertEquals(Actions.HIT, playerAction)
        }
    }

    @Test
    fun deviation_hard_v3() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card3)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard12, dealerHand, 2, true)
            TestCase.assertEquals(Actions.STAND, playerAction)
        }
    }

    @Test
    fun deviation_hard_v3_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card3)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard12_threeCard, dealerHand, 2, true)
            TestCase.assertEquals(Actions.STAND, playerAction)
        }
    }

    @Test
    fun deviation_hard_v4() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card4)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard12, dealerHand, -1, true)
            TestCase.assertEquals(Actions.HIT, playerAction)
        }
    }

    @Test
    fun deviation_hard_v4_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card4)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard12_threeCard, dealerHand, -1, true)
            TestCase.assertEquals(Actions.HIT, playerAction)
        }
    }

    @Test
    fun deviation_hard_v6() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card6)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard8, dealerHand, 2, true)
            TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
        }
    }

    @Test
    fun deviation_hard_v6_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card6)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard8_threeCard, dealerHand, 2, true)
            TestCase.assertEquals(Actions.HIT, playerAction)
        }
    }

    @Test
    fun deviation_hard_v7() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card7)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard9, dealerHand, 3, true)
            TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
        }
    }

    @Test
    fun deviation_hard_v7_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card7)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard9_threeCard, dealerHand, 3, true)
            TestCase.assertEquals(Actions.HIT, playerAction)
        }
    }

    @Test
    fun deviation_hard_v9() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card9)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16, dealerHand, 4, true)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)
        }
    }

    @Test
    fun deviation_hard_v9_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card9)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16_threeCard, dealerHand, 4, true)
            TestCase.assertEquals(Actions.STAND, playerAction)
        }
    }

    @Test
    fun deviation_hard_vt() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardt)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard10, dealerHand, 4, true)
            TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15, dealerHand, 4, true)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16, dealerHand, 0, true)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)
        }
    }

    @Test
    fun deviation_hard_vt_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardt)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard10_threeCard, dealerHand, 4, true)
            TestCase.assertEquals(Actions.HIT, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15_threeCard, dealerHand, 4, true)
            TestCase.assertEquals(Actions.STAND, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16_threeCard, dealerHand, 1, true)
            TestCase.assertEquals(Actions.STAND, playerAction)
        }
    }

    @Test
    fun deviation_hard_vj() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardj)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard10, dealerHand, 4, true)
            TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15, dealerHand, 4, true)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16, dealerHand, 0, true)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)
        }
    }

    @Test
    fun deviation_hard_vj_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardj)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard10_threeCard, dealerHand, 4, true)
            TestCase.assertEquals(Actions.HIT, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15_threeCard, dealerHand, 4, true)
            TestCase.assertEquals(Actions.STAND, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16_threeCard, dealerHand, 1, true)
            TestCase.assertEquals(Actions.STAND, playerAction)
        }
    }

    @Test
    fun deviation_hard_vq() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardq)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard10, dealerHand, 4, true)
            TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15, dealerHand, 4, true)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16, dealerHand, 0, true)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)
        }
    }

    @Test
    fun deviation_hard_vq_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardq)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard10_threeCard, dealerHand, 4, true)
            TestCase.assertEquals(Actions.HIT, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15_threeCard, dealerHand, 4, true)
            TestCase.assertEquals(Actions.STAND, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16_threeCard, dealerHand, 1, true)
            TestCase.assertEquals(Actions.STAND, playerAction)
        }
    }

    @Test
    fun deviation_hard_vk() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardk)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard10, dealerHand, 4, true)
            TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15, dealerHand, 4, true)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16, dealerHand, 0, true)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)
        }
    }

    @Test
    fun deviation_hard_vk_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardk)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard10_threeCard, dealerHand, 4, true)
            TestCase.assertEquals(Actions.HIT, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15_threeCard, dealerHand, 4, true)
            TestCase.assertEquals(Actions.STAND, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16_threeCard, dealerHand, 1, true)
            TestCase.assertEquals(Actions.STAND, playerAction)
        }
    }

    @Test
    fun deviation_hard_va() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.carda)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard10, dealerHand, 3, true)
            TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15, dealerHand, 5, true)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16, dealerHand, 3, true)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)
        }
    }

    @Test
    fun deviation_hard_va_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.carda)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard10_threeCard, dealerHand, 3, true)
            TestCase.assertEquals(Actions.HIT, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15_threeCard, dealerHand, 5, true)
            TestCase.assertEquals(Actions.STAND, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16_threeCard, dealerHand, 3, true)
            TestCase.assertEquals(Actions.STAND, playerAction)
        }
    }

    @Test
    fun deviation_surrender_v8() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card8)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16, dealerHand, 4, true)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)
        }
    }

    @Test
    fun deviation_surrender_v8_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card8)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16_threeCard, dealerHand, 4, true)
            TestCase.assertEquals(Actions.HIT, playerAction)
        }
    }

    @Test
    fun deviation_surrender_v9() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card9)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15, dealerHand, 2, true)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16, dealerHand, -1, true)
            TestCase.assertEquals(Actions.HIT, playerAction)
        }
    }

    @Test
    fun deviation_surrender_v9_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card9)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15_threeCard, dealerHand, 2, true)
            TestCase.assertEquals(Actions.HIT, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16_threeCard, dealerHand, -1, true)
            TestCase.assertEquals(Actions.HIT, playerAction)
        }
    }

    @Test
    fun deviation_surrender_vt() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardt)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15, dealerHand, -1, true)
            TestCase.assertEquals(Actions.HIT, playerAction)
        }
    }

    @Test
    fun deviation_surrender_vt_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardt)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15_threeCard, dealerHand, -1, true)
            TestCase.assertEquals(Actions.HIT, playerAction)
        }
    }

    @Test
    fun deviation_surrender_vj() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardj)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15, dealerHand, -1, true)
            TestCase.assertEquals(Actions.HIT, playerAction)
        }
    }

    @Test
    fun deviation_surrender_vj_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardj)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15_threeCard, dealerHand, -1, true)
            TestCase.assertEquals(Actions.HIT, playerAction)
        }
    }

    @Test
    fun deviation_surrender_vq() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardq)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15, dealerHand, -1, true)
            TestCase.assertEquals(Actions.HIT, playerAction)
        }
    }

    @Test
    fun deviation_surrender_vq_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardq)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15_threeCard, dealerHand, -1, true)
            TestCase.assertEquals(Actions.HIT, playerAction)
        }
    }

    @Test
    fun deviation_surrender_vk() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardk)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15, dealerHand, -1, true)
            TestCase.assertEquals(Actions.HIT, playerAction)
        }
    }

    @Test
    fun deviation_surrender_vk_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardk)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15_threeCard, dealerHand, -1, true)
            TestCase.assertEquals(Actions.HIT, playerAction)
        }
    }

    @Test
    fun deviation_surrender_va() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.carda)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15, dealerHand, -1, true)
            TestCase.assertEquals(Actions.SURRENDER, playerAction)
        }
    }

    @Test
    fun deviation_surrender_va_threeCard() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.carda)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.COUNTING_STRATEGY, 1)
                apply()
            }

            actionResolver = ActionResolver(setCountingStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15_threeCard, dealerHand, -1, true)
            TestCase.assertEquals(Actions.HIT, playerAction)
        }
    }
}