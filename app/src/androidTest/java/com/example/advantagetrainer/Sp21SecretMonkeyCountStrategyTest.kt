package com.example.advantagetrainer

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class Sp21SecretMonkeyCountStrategyTest {
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
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

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
                }else if (
                    card.name == CardNames.FIVE
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if (
                    card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                    || card.name == CardNames.NINE
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
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.SEVEN
                    || card.name == CardNames.EIGHT
                    || card.name == CardNames.NINE
                    || card.name == CardNames.ACE
                ){
                    assert(playerAction == Actions.SPLIT)
                }else if (
                    card.name == CardNames.FOUR
                    || card.name == CardNames.SIX
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
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

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
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

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
    fun split_v6() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card6)

        composeTestRule.setContent {
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

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
    fun split_v7() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card7)

        composeTestRule.setContent {
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

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
                }else if (
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
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

                if(
                    card.name == CardNames.TWO
                    || card.name == CardNames.THREE
                    || card.name == CardNames.EIGHT
                    || card.name == CardNames.NINE
                    || card.name == CardNames.ACE
                ){
                    assert(playerAction == Actions.SPLIT)
                }else if (
                    card.name == CardNames.FOUR
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
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
    fun split_v9() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card9)

        composeTestRule.setContent {
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

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
                    || card.name == CardNames.FIVE
                    || card.name == CardNames.SIX
                    || card.name == CardNames.SEVEN
                ){
                    assert(playerAction == Actions.HIT)
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
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

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
    fun split_vj() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardj)

        composeTestRule.setContent {
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

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
    fun split_vq() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardq)

        composeTestRule.setContent {
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

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
    fun split_vk() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.cardk)

        composeTestRule.setContent {
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

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
    fun split_va() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.carda)

        composeTestRule.setContent {
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(card)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

                if(
                    card.name == CardNames.ACE
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
                }else if (
                    card.name == CardNames.NINE
                    || card.name == CardNames.TEN
                    || card.name == CardNames.JACK
                    || card.name == CardNames.QUEEN
                    || card.name == CardNames.KING
                ){
                    assert(playerAction == Actions.STAND)
                }else if (card.name == CardNames.EIGHT){
                    assert(playerAction == Actions.SURRENDER)
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
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

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
    fun soft_v3() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card3)

        composeTestRule.setContent {
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

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
    fun soft_v4() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card4)

        composeTestRule.setContent {
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

                if(
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                    || playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
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
                }else if(
                    playerHand.cards[1].name == CardNames.SIX
                    || playerHand.cards[1].name == CardNames.SEVEN
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
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
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

                if(
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                    || playerHand.cards[1].name == CardNames.FOUR
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
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
                }else if(
                    playerHand.cards[1].name == CardNames.FIVE
                    || playerHand.cards[1].name == CardNames.SIX
                    || playerHand.cards[1].name == CardNames.SEVEN
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
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
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

                if(
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
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
                }else if(
                    playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                    || playerHand.cards[1].name == CardNames.SIX
                    || playerHand.cards[1].name == CardNames.SEVEN
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
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
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

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
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

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
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

                if(
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                    || playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                    || playerHand.cards[1].name == CardNames.SIX
                    || playerHand.cards[1].name == CardNames.SEVEN
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
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
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

                if(
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                    || playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                    || playerHand.cards[1].name == CardNames.SIX
                    || playerHand.cards[1].name == CardNames.SEVEN
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
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
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

                if(
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                    || playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                    || playerHand.cards[1].name == CardNames.SIX
                    || playerHand.cards[1].name == CardNames.SEVEN
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
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
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

                if(
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                    || playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                    || playerHand.cards[1].name == CardNames.SIX
                    || playerHand.cards[1].name == CardNames.SEVEN
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
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
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

                if(
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                    || playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                    || playerHand.cards[1].name == CardNames.SIX
                    || playerHand.cards[1].name == CardNames.SEVEN
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
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
            actionResolver = ActionResolver(setStrategy())

            for(card in testUtils.cards){
                val playerHand = Hand()
                playerHand.addCard(testUtils.carda)
                playerHand.addCard(card)

                playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

                if(
                    playerHand.cards[1].name == CardNames.TWO
                    || playerHand.cards[1].name == CardNames.THREE
                    || playerHand.cards[1].name == CardNames.FOUR
                    || playerHand.cards[1].name == CardNames.FIVE
                    || playerHand.cards[1].name == CardNames.SIX
                    || playerHand.cards[1].name == CardNames.SEVEN
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
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
    fun hard_v2() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card2)

        composeTestRule.setContent {
            actionResolver = ActionResolver(setStrategy())

            for(hand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(hand, dealerHand)

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
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
                    hand.handTotal == 10
                    || hand.handTotal == 11
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if (
                    hand.handTotal == 15
                    || hand.handTotal == 16
                    || hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assert(playerAction == Actions.STAND)
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
            actionResolver = ActionResolver(setStrategy())

            for(hand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(hand, dealerHand)

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
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
                    hand.handTotal == 10
                    || hand.handTotal == 11
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if (
                    hand.handTotal == 15
                    || hand.handTotal == 16
                    || hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assert(playerAction == Actions.STAND)
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
            actionResolver = ActionResolver(setStrategy())

            for(hand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(hand, dealerHand)

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
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
                    hand.handTotal == 10
                    || hand.handTotal == 11
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if (
                    hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                    || hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assert(playerAction == Actions.STAND)
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
            actionResolver = ActionResolver(setStrategy())

            for(hand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(hand, dealerHand)

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
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
                    hand.handTotal == 10
                    || hand.handTotal == 11
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if (
                    hand.handTotal == 14
                    || hand.handTotal == 15
                    || hand.handTotal == 16
                    || hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assert(playerAction == Actions.STAND)
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
            actionResolver = ActionResolver(setStrategy())

            for(hand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(hand, dealerHand)

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
                    assert(playerAction == Actions.STAND)
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
            actionResolver = ActionResolver(setStrategy())

            for(hand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(hand, dealerHand)

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
                    assert(playerAction == Actions.STAND)
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
            actionResolver = ActionResolver(setStrategy())

            for(hand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(hand, dealerHand)

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
                    assert(playerAction == Actions.STAND)
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
            actionResolver = ActionResolver(setStrategy())

            for(hand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(hand, dealerHand)

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
                    || hand.handTotal == 16
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
                    hand.handTotal == 11
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assert(playerAction == Actions.STAND)
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
            actionResolver = ActionResolver(setStrategy())

            for(hand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(hand, dealerHand)

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
                    || hand.handTotal == 16
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
                    hand.handTotal == 11
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assert(playerAction == Actions.STAND)
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
            actionResolver = ActionResolver(setStrategy())

            for(hand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(hand, dealerHand)

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
                    || hand.handTotal == 16
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
                    hand.handTotal == 11
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assert(playerAction == Actions.STAND)
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
            actionResolver = ActionResolver(setStrategy())

            for(hand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(hand, dealerHand)

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
                    || hand.handTotal == 16
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
                    hand.handTotal == 11
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assert(playerAction == Actions.STAND)
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
            actionResolver = ActionResolver(setStrategy())

            for(hand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(hand, dealerHand)

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
                    || hand.handTotal == 16
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
                    hand.handTotal == 11
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if (
                    hand.handTotal == 17
                    || hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assert(playerAction == Actions.STAND)
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
            actionResolver = ActionResolver(setStrategy())

            for(hand in testUtils.hardHands){
                playerAction = actionResolver.getActionFromStrategy(hand, dealerHand)

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
                    || hand.handTotal == 16
                    || hand.handTotal == 17
                ){
                    assert(playerAction == Actions.HIT)
                }else if (
                    hand.handTotal == 11
                ){
                    assert(playerAction == Actions.DOUBLE_DOWN)
                }else if (
                    hand.handTotal == 18
                    || hand.handTotal == 19
                    || hand.handTotal == 20
                    || hand.handTotal == 21
                ){
                    assert(playerAction == Actions.STAND)
                }
            }
        }
    }

    @Test
    fun surrender_va() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.carda)

        composeTestRule.setContent {
            actionResolver = ActionResolver(setStrategy())

            for(hand in testUtils.surrenderHands){
                playerAction = actionResolver.getActionFromStrategy(hand, dealerHand)

                assert(playerAction == Actions.SURRENDER)
            }
        }
    }

    @Test
    fun double_threeCards() {
        var playerAction: Actions
        val dealerHand = Hand()
        dealerHand.addCard(testUtils.card2)

        composeTestRule.setContent {
            actionResolver = ActionResolver(setStrategy())

            Game.isSpanishGame = true;

            val playerHand = Hand()
            playerHand.addCard(testUtils.card2)
            playerHand.addCard(testUtils.card3)
            playerHand.addCard(testUtils.card6)

            playerAction = actionResolver.getActionFromStrategy(playerHand, dealerHand)

            assert(playerAction == Actions.DOUBLE_DOWN)

        }
    }
}