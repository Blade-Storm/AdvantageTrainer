package com.example.advantagetrainer

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.advantagetrainer.enums.Actions
import com.example.advantagetrainer.enums.CardNames
import com.example.advantagetrainer.views.setHoleCardStrategy
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test

class WizardOfOddsHoleCardBasicTest {
    lateinit var actionResolver: ActionResolver
    var testUtils = TestUtils()

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun hard_vHard4() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card2)
        dealerHand.addCard(testUtils.card2)

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vHard5() {
        var playerAction: Actions
        val dealerHand = testUtils.hard5

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vHard6() {
        var playerAction: Actions
        val dealerHand = testUtils.hard6

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 9
                    || playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vHard7() {
        var playerAction: Actions
        val dealerHand = testUtils.hard7

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vHard8() {
        var playerAction: Actions
        val dealerHand = testUtils.hard8

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vHard9() {
        var playerAction: Actions
        val dealerHand = testUtils.hard9

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vHard10() {
        var playerAction: Actions
        val dealerHand = testUtils.hard10

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 10
                    || playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vHard11() {
        var playerAction: Actions
        val dealerHand = testUtils.hard11

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                    || playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vHard12() {
        var playerAction: Actions
        val dealerHand = testUtils.hard12

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vHard13() {
        var playerAction: Actions
        val dealerHand = testUtils.hard13

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vHard14() {
        var playerAction: Actions
        val dealerHand = testUtils.hard14

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vHard15() {
        var playerAction: Actions
        val dealerHand = testUtils.hard15

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vHard16() {
        var playerAction: Actions
        val dealerHand = testUtils.hard16

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vHard17() {
        var playerAction: Actions
        val dealerHand = testUtils.hard17

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                    || playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vHard18() {
        var playerAction: Actions
        val dealerHand = testUtils.hard18

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                    || playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vHard19() {
        var playerAction: Actions
        val dealerHand = testUtils.hard19

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                    || playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vHard20() {
        var playerAction: Actions
        val dealerHand = testUtils.hard20

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                    || playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vHard21() {
        var playerAction: Actions
        val dealerHand = testUtils.hard21

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                    || playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vSoft12() {
        var playerAction: Actions
        val dealerHand = testUtils.softaa

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 10
                    || playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vSoft13() {
        var playerAction: Actions
        val dealerHand = testUtils.softa2

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vSoft14() {
        var playerAction: Actions
        val dealerHand = testUtils.softa3

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vSoft15() {
        var playerAction: Actions
        val dealerHand = testUtils.softa4

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vSoft16() {
        var playerAction: Actions
        val dealerHand = testUtils.softa5

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vSoft17() {
        var playerAction: Actions
        val dealerHand = testUtils.softa6

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                    || playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vSoft18() {
        var playerAction: Actions
        val dealerHand = testUtils.softa7

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                    || playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vSoft19() {
        var playerAction: Actions
        val dealerHand = testUtils.softa8

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                    || playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vSoft20() {
        var playerAction: Actions
        val dealerHand = testUtils.softa9

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                    || playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun hard_vSoft21() {
        var playerAction: Actions
        val dealerHand = testUtils.softat

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 2
                    || playerHand.handTotal == 3
                    || playerHand.handTotal == 4
                    || playerHand.handTotal == 5
                    || playerHand.handTotal == 6
                    || playerHand.handTotal == 7
                    || playerHand.handTotal == 8
                    || playerHand.handTotal == 9
                    || playerHand.handTotal == 10
                    || playerHand.handTotal == 11
                    || playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vHard4() {
        var playerAction: Actions
        val dealerHand = testUtils.hard4

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if (
                    playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vHard5() {
        var playerAction: Actions
        val dealerHand = testUtils.hard5

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if(
                    playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vHard6() {
        var playerAction: Actions
        val dealerHand = testUtils.hard6

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vHard7() {
        var playerAction: Actions
        val dealerHand = testUtils.hard7

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vHard8() {
        var playerAction: Actions
        val dealerHand = testUtils.hard8

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vHard9() {
        var playerAction: Actions
        val dealerHand = testUtils.hard9

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vHard10() {
        var playerAction: Actions
        val dealerHand = testUtils.hard10

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vHard11() {
        var playerAction: Actions
        val dealerHand = testUtils.hard11

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vHard12() {
        var playerAction: Actions
        val dealerHand = testUtils.hard12

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if(
                    playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vHard13() {
        var playerAction: Actions
        val dealerHand = testUtils.hard13

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if(
                    playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vHard14() {
        var playerAction: Actions
        val dealerHand = testUtils.hard14

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if(
                    playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vHard15() {
        var playerAction: Actions
        val dealerHand = testUtils.hard15

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if(
                    playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vHard16() {
        var playerAction: Actions
        val dealerHand = testUtils.hard16

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }else if(
                    playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vHard17() {
        var playerAction: Actions
        val dealerHand = testUtils.hard17

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vHard18() {
        var playerAction: Actions
        val dealerHand = testUtils.hard18

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vHard19() {
        var playerAction: Actions
        val dealerHand = testUtils.hard19

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vHard20() {
        var playerAction: Actions
        val dealerHand = testUtils.hard20

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vHard21() {
        var playerAction: Actions
        val dealerHand = testUtils.hard21

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vSoft12() {
        var playerAction: Actions
        val dealerHand = testUtils.softaa

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if(
                    playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vSoft13() {
        var playerAction: Actions
        val dealerHand = testUtils.softa2

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if(
                    playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vSoft14() {
        var playerAction: Actions
        val dealerHand = testUtils.softa3

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if(
                    playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vSoft15() {
        var playerAction: Actions
        val dealerHand = testUtils.softa4

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if(
                    playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vSoft16() {
        var playerAction: Actions
        val dealerHand = testUtils.softa5

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16

                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if(
                    playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vSoft17() {
        var playerAction: Actions
        val dealerHand = testUtils.softa6

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if(
                    playerHand.handTotal == 12
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vSoft18() {
        var playerAction: Actions
        val dealerHand = testUtils.softa7

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 18
                    || playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vSoft19() {
        var playerAction: Actions
        val dealerHand = testUtils.softa8

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vSoft20() {
        var playerAction: Actions
        val dealerHand = testUtils.softa9

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun soft_vSoft21() {
        var playerAction: Actions
        val dealerHand = testUtils.softat

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(playerHand in testUtils.softHands){
                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    playerHand.handTotal == 12
                    || playerHand.handTotal == 13
                    || playerHand.handTotal == 14
                    || playerHand.handTotal == 15
                    || playerHand.handTotal == 16
                    || playerHand.handTotal == 17
                    || playerHand.handTotal == 18
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    playerHand.handTotal == 19
                    || playerHand.handTotal == 20
                    || playerHand.handTotal == 21
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }
            }
        }
    }

    @Test
    fun split_vHard4() {
        var playerAction: Actions
        val dealerHand = testUtils.hard4

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

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
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    card.name == CardNames.SEVEN
                    || card.name == CardNames.EIGHT
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    card.name == CardNames.NINE
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if(
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }
            }
        }
    }

    @Test
    fun split_vHard5() {
        var playerAction: Actions
        val dealerHand = testUtils.hard5

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.FOUR
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
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
                    card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if(
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }
            }
        }
    }

    @Test
    fun split_vHard6() {
        var playerAction: Actions
        val dealerHand = testUtils.hard6

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.FOUR
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
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
                    card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if(
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }
            }
        }
    }

    @Test
    fun split_vHard7() {
        var playerAction: Actions
        val dealerHand = testUtils.hard7

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.FOUR
                    || card.name == CardNames.SIX
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.SEVEN
                    || card.name == CardNames.EIGHT
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    card.name == CardNames.NINE
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if(
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }
            }
        }
    }

    @Test
    fun split_vHard8() {
        var playerAction: Actions
        val dealerHand = testUtils.hard8

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

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
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    card.name == CardNames.SEVEN
                    || card.name == CardNames.EIGHT
                    ||  card.name == CardNames.NINE
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if(
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }
            }
        }
    }

    @Test
    fun split_vHard9() {
        var playerAction: Actions
        val dealerHand = testUtils.hard9

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

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
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    card.name == CardNames.EIGHT
                    || card.name == CardNames.NINE
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if(
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }
            }
        }
    }

    @Test
    fun split_vHard10() {
        var playerAction: Actions
        val dealerHand = testUtils.hard10

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    card.name == CardNames.EIGHT
                    || card.name == CardNames.NINE
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
    fun split_vHard11() {
        var playerAction: Actions
        val dealerHand = testUtils.hard11

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if (
                    card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if (
                    card.name == CardNames.EIGHT
                    || card.name == CardNames.NINE
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
    fun split_vHard12() {
        var playerAction: Actions
        val dealerHand = testUtils.hard12

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

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
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }
            }
        }
    }

    @Test
    fun split_vHard13() {
        var playerAction: Actions
        val dealerHand = testUtils.hard13

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

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
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }
            }
        }
    }

    @Test
    fun split_vHard14() {
        var playerAction: Actions
        val dealerHand = testUtils.hard14

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

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
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }
            }
        }
    }

    @Test
    fun split_vHard15() {
        var playerAction: Actions
        val dealerHand = testUtils.hard15

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

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
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }
            }
        }
    }

    @Test
    fun split_vHard16() {
        var playerAction: Actions
        val dealerHand = testUtils.hard16

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

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
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }
            }
        }
    }

    @Test
    fun split_vHard17() {
        var playerAction: Actions
        val dealerHand = testUtils.hard17

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

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
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
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
    fun split_vHard18() {
        var playerAction: Actions
        val dealerHand = testUtils.hard18

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

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
                    || card.name == CardNames.NINE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
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
    fun split_vHard19() {
        var playerAction: Actions
        val dealerHand = testUtils.hard19

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.NINE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                    || card.name == CardNames.EIGHT
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
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
    fun split_vHard20() {
        var playerAction: Actions
        val dealerHand = testUtils.hard20

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.NINE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                    || card.name == CardNames.EIGHT
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
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
    fun split_vHard21() {
        var playerAction: Actions
        val dealerHand = testUtils.hard21

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.NINE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                    || card.name == CardNames.EIGHT
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
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
    fun split_vSoft12() {
        var playerAction: Actions
        val dealerHand = testUtils.softaa

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

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
                }else if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
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
    fun split_vSoft13() {
        var playerAction: Actions
        val dealerHand = testUtils.softa2

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.SEVEN
                    || card.name == CardNames.EIGHT
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.SIX
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    card.name == CardNames.NINE
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if(
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }
            }
        }
    }

    @Test
    fun split_vSoft14() {
        var playerAction: Actions
        val dealerHand = testUtils.softa3

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.SEVEN
                    || card.name == CardNames.EIGHT
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.SIX
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    card.name == CardNames.NINE
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if(
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }
            }
        }
    }

    @Test
    fun split_vSoft15() {
        var playerAction: Actions
        val dealerHand = testUtils.softa4

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                    || card.name == CardNames.EIGHT
                    || card.name == CardNames.NINE
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if(
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }
            }
        }
    }

    @Test
    fun split_vSoft16() {
        var playerAction: Actions
        val dealerHand = testUtils.softa5

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

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
                }else if(
                    card.name == CardNames.FOUR
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
                    card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    TestCase.assertEquals(Actions.STAND, playerAction)
                }else if(
                    card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.DOUBLE_DOWN, playerAction)
                }
            }
        }
    }

    @Test
    fun split_vSoft17() {
        var playerAction: Actions
        val dealerHand = testUtils.softa6

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

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
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
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
    fun split_vSoft18() {
        var playerAction: Actions
        val dealerHand = testUtils.softa7

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

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
                    || card.name == CardNames.NINE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
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
    fun split_vSoft19() {
        var playerAction: Actions
        val dealerHand = testUtils.softa8

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.NINE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                    || card.name == CardNames.EIGHT
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
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
    fun split_vSoft20() {
        var playerAction: Actions
        val dealerHand = testUtils.softa9

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.NINE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                    || card.name == CardNames.EIGHT
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
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
    fun split_vSoft21() {
        var playerAction: Actions
        val dealerHand = testUtils.softat

        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.HOLE_CARD_STRATEGY, 0)
                apply()
            }

            actionResolver = ActionResolver(setHoleCardStrategy(sharedPref))

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand, 0, false)

                if(
                    card.name == CardNames.NINE
                ){
                    TestCase.assertEquals(Actions.SPLIT, playerAction)
                }else if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.FOUR
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                    || card.name == CardNames.EIGHT
                    || card.name == CardNames.ACE
                ){
                    TestCase.assertEquals(Actions.HIT, playerAction)
                }else if(
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
}