package com.example.advantagetrainer

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import junit.framework.TestCase.assertEquals
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.SPLIT)
                }else if (
                    card.name == CardNames.FOUR
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
                    card.name == CardNames.FIVE
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if (
                    card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.SPLIT)
                }else if (
                    card.name == CardNames.FOUR
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
                    card.name == CardNames.FIVE
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if (
                    card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.SPLIT)
                }else if (
                    card.name == CardNames.FOUR
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
                    card.name == CardNames.FIVE
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if (
                    card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.SPLIT)
                }else if (
                    card.name == CardNames.FIVE
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if (
                    card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.SPLIT)
                }else if (
                    card.name == CardNames.FIVE
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if (
                    card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.SPLIT)
                }else if (
                    card.name == CardNames.FOUR
                    || card.name == CardNames.SIX
                ){
                    assert(playerAction == Actions.HIT)
                } else if (
                    card.name == CardNames.FIVE
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if (
                    card.name == CardNames.NINE
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.SPLIT)
                }else if (
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                ){
                    assert(playerAction == Actions.HIT)
                } else if (
                    card.name == CardNames.FIVE
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if (
                    card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.SPLIT)
                }else if (
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                ){
                    assert(playerAction == Actions.HIT)
                } else if (
                    card.name == CardNames.FIVE
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if (
                    card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.EIGHT
                    || card.name == CardNames.ACE
                ){
                    assert(playerAction == Actions.SPLIT)
                }else if (
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                ){
                    assert(playerAction == Actions.HIT)
                } else if (
                    card.name == CardNames.NINE
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.EIGHT
                    || card.name == CardNames.ACE
                ){
                    assert(playerAction == Actions.SPLIT)
                }else if (
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                ){
                    assert(playerAction == Actions.HIT)
                } else if (
                    card.name == CardNames.NINE
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.EIGHT
                    || card.name == CardNames.ACE
                ){
                    assert(playerAction == Actions.SPLIT)
                }else if (
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                ){
                    assert(playerAction == Actions.HIT)
                } else if (
                    card.name == CardNames.NINE
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.EIGHT
                    || card.name == CardNames.ACE
                ){
                    assert(playerAction == Actions.SPLIT)
                }else if (
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                ){
                    assert(playerAction == Actions.HIT)
                } else if (
                    card.name == CardNames.NINE
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.EIGHT
                    || card.name == CardNames.ACE
                ){
                    assert(playerAction == Actions.SPLIT)
                }else if (
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                ){
                    assert(playerAction == Actions.HIT)
                } else if (
                    card.name == CardNames.NINE
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.HIT)
                }else if (
                    playerHand.cards[1].name == CardNames.SEVEN
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                } else if (
                    playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    assert(playerAction == Actions.SPLIT)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.HIT)
                }else if (
                    playerHand.cards[1].name == CardNames.SIX
                    || playerHand.cards[1].name == CardNames.SEVEN
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                } else if (
                    playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    assert(playerAction == Actions.SPLIT)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
                    playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                    || playerHand.cards[1].name == CardNames.SIX
                    || playerHand.cards[1].name == CardNames.SEVEN
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                } else if (
                    playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    assert(playerAction == Actions.SPLIT)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.DOUBLE_DOWN)
                } else if (
                    playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    assert(playerAction == Actions.SPLIT)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.DOUBLE_DOWN)
                } else if (
                    playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    assert(playerAction == Actions.SPLIT)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.HIT)
                } else if (
                    playerHand.cards[1].name == CardNames.SEVEN
                    || playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    assert(playerAction == Actions.SPLIT)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.HIT)
                } else if (
                    playerHand.cards[1].name == CardNames.SEVEN
                    || playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    assert(playerAction == Actions.SPLIT)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.HIT)
                } else if (
                    playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    assert(playerAction == Actions.SPLIT)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.HIT)
                } else if (
                    playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    assert(playerAction == Actions.SPLIT)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.HIT)
                } else if (
                    playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    assert(playerAction == Actions.SPLIT)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.HIT)
                } else if (
                    playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    assert(playerAction == Actions.SPLIT)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.HIT)
                } else if (
                    playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    assert(playerAction == Actions.SPLIT)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.HIT)
                } else if (
                    playerHand.cards[1].name == CardNames.EIGHT
                    || playerHand.cards[1].name == CardNames.NINE
                    || playerHand.cards[1].name == CardNames.TEN
                    || playerHand.cards[1].name == CardNames.JACK
                    || playerHand.cards[1].name == CardNames.QUEEN
                    || playerHand.cards[1].name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
                }else if (playerHand.cards[1].name == CardNames.ACE){
                    assert(playerAction == Actions.SPLIT)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else{
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else{
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else{
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else{
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else{
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else{
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else{
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else{
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else{
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else{
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else{
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else{
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else{
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.HIT)
                }else if (
                    hand.handTotal == 10
                    || hand.handTotal == 11
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
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
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.HIT)
                }else if (
                    hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 11
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
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
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.HIT)
                }else if (
                    hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 11
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
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
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.HIT)
                }else if (
                    hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 11
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
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
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.HIT)
                }else if (
                    hand.handTotal == 9
                    || hand.handTotal == 10
                    || hand.handTotal == 11
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
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
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.HIT)
                }else if (
                    hand.handTotal == 10
                    || hand.handTotal == 11
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.HIT)
                }else if (
                    hand.handTotal == 10
                    || hand.handTotal == 11
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assert(playerAction == Actions.HIT)
                }else if (
                    hand.handTotal == 10
                    || hand.handTotal == 11
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if(
                    hand.handTotal == 16
                ){
                    assert(playerAction == Actions.SURRENDER)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 11
                ){
                    assertEquals(Actions.DOUBLE_DOWN, playerAction)
                } else if (
                    hand.handTotal == 15
                    || hand.handTotal == 16
                ){
                    assertEquals(Actions.SURRENDER, playerAction)
                } else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 11
                ){
                    assertEquals(Actions.DOUBLE_DOWN, playerAction)
                } else if (
                    hand.handTotal == 15
                    || hand.handTotal == 16
                ){
                    assertEquals(Actions.SURRENDER, playerAction)
                } else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 11
                ){
                    assertEquals(Actions.DOUBLE_DOWN, playerAction)
                } else if (
                    hand.handTotal == 15
                    || hand.handTotal == 16
                ){
                    assertEquals(Actions.SURRENDER, playerAction)
                } else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 11
                ){
                    assertEquals(Actions.DOUBLE_DOWN, playerAction)
                } else if (
                    hand.handTotal == 15
                    || hand.handTotal == 16
                ){
                    assertEquals(Actions.SURRENDER, playerAction)
                } else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 11
                ){
                    assertEquals(Actions.DOUBLE_DOWN, playerAction)
                } else if (
                    hand.handTotal == 16
                ){
                    assertEquals(Actions.SURRENDER, playerAction)
                } else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
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
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
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
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
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
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
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
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
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
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

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
                    assertEquals(Actions.HIT, playerAction)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assertEquals(Actions.STAND, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

            playerAction =
                    actionResolver.getActionFromStrategy(testUtils.hard16, dealerHand, 0, false)
            assertEquals(Actions.SURRENDER, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16, dealerHand, 0, false)
            assertEquals(Actions.SURRENDER, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15, dealerHand, 0, false)
            assertEquals(Actions.SURRENDER, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16, dealerHand, 0, false)
            assertEquals(Actions.SURRENDER, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15, dealerHand, 0, false)
            assertEquals(Actions.SURRENDER, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16, dealerHand, 0, false)
            assertEquals(Actions.SURRENDER, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15, dealerHand, 0, false)
            assertEquals(Actions.SURRENDER, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16, dealerHand, 0, false)
            assertEquals(Actions.SURRENDER, playerAction)

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard15, dealerHand, 0, false)
            assertEquals(Actions.SURRENDER, playerAction)
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
                putInt(Settings.STRATEGY, 2)
                apply()
            }

            actionResolver = ActionResolver(setStrategy(sharedPref))

            playerAction =
                actionResolver.getActionFromStrategy(testUtils.hard16, dealerHand, 0, false)
            assertEquals(Actions.SURRENDER, playerAction)
        }
    }
}