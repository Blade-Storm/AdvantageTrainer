package com.example.advantagetrainer

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.advantagetrainer.Hand.HandType
import junit.framework.TestCase.*
import org.junit.Rule
import org.junit.Test


class HandTest {
    private var hand = Hand()

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calcHandTotal_HardHand_WithFaceCard() {
        val expectedHandType = HandType.HARD
        val expectedTotal = 13

        composeTestRule.setContent {
            hand.addCard(
                Card(
                    Suits.SPADE,
                    CardNames.THREE,
                    CardValueMapper.cardValueMapper[CardNames.THREE],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.SPADE}${CardNames.THREE}",
                        null,
                        null
                    )
                )
            )
            hand.addCard(
                Card(
                    Suits.HEART,
                    CardNames.QUEEN,
                    CardValueMapper.cardValueMapper[CardNames.QUEEN],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.HEART}${CardNames.QUEEN}",
                        null,
                        null
                    )
                )
            )
        }
        assertEquals(expectedTotal.toLong(), hand.handTotal.toLong())
        assertEquals(expectedHandType, hand.handType)
    }

    @Test
    fun calcHandTotal_HardHand_WithoutFaceCard() {
        val expectedHandType = HandType.HARD
        val expectedTotal = 11

        composeTestRule.setContent {
            hand.addCard(
                Card(
                    Suits.SPADE,
                    CardNames.THREE,
                    CardValueMapper.cardValueMapper[CardNames.THREE],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.SPADE}${CardNames.THREE}",
                        null,
                        null
                    )
                )
            )
            hand.addCard(
                Card(
                    Suits.HEART,
                    CardNames.EIGHT,
                    CardValueMapper.cardValueMapper[CardNames.EIGHT],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.HEART}${CardNames.EIGHT}",
                        null,
                        null
                    )
                )
            )
        }
        assertEquals(expectedTotal.toLong(), hand.handTotal.toLong())
        assertEquals(expectedHandType, hand.handType)
    }

    @Test
    fun calcHandTotal_SoftHandLessThan10_WithSingeAce() {
        val expectedHandType = HandType.SOFT
        val expectedTotal = 14

        composeTestRule.setContent {
            hand.addCard(
                Card(
                    Suits.SPADE,
                    CardNames.THREE,
                    CardValueMapper.cardValueMapper[CardNames.THREE],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.SPADE}${CardNames.THREE}",
                        null,
                        null
                    )
                )
            )
            hand.addCard(
                Card(
                    Suits.HEART, CardNames.ACE,
                    CardValueMapper.cardValueMapper[CardNames.ACE],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.HEART}${CardNames.ACE}",
                        null,
                        null
                    )
                )
            )
        }
        assertEquals(expectedTotal.toLong(), hand.handTotal.toLong())
        assertEquals(expectedHandType, hand.handType)
    }

    @Test
    fun calcHandTotal_SoftHandLessThan10_WithMultipleAces() {
        val expectedHandType = HandType.SOFT
        val expectedTotal = 15

        composeTestRule.setContent {
            hand.addCard(
                Card(
                    Suits.SPADE,
                    CardNames.THREE,
                    CardValueMapper.cardValueMapper[CardNames.THREE],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.SPADE}${CardNames.THREE}",
                        null,
                        null
                    )
                )
            )
            hand.addCard(
                Card(
                    Suits.HEART, CardNames.ACE,
                    CardValueMapper.cardValueMapper[CardNames.ACE],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.HEART}${CardNames.ACE}",
                        null,
                        null
                    )
                )
            )
            hand.addCard(
                Card(
                    Suits.SPADE, CardNames.ACE,
                    CardValueMapper.cardValueMapper[CardNames.ACE],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.SPADE}${CardNames.ACE}",
                        null,
                        null
                    )
                )
            )
        }
        assertEquals(expectedTotal.toLong(), hand.handTotal.toLong())
        assertEquals(expectedHandType, hand.handType)
    }

    @Test
    fun calcHandTotal_HardHandLessThan10_WithMultipleAces() {
        val expectedHandType = HandType.HARD
        val expectedTotal = 12

        composeTestRule.setContent {
            hand.addCard(
                Card(
                    Suits.SPADE, CardNames.NINE,
                    CardValueMapper.cardValueMapper[CardNames.NINE],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.SPADE}${CardNames.NINE}",
                        null,
                        null
                    )
                )
            )
            hand.addCard(
                Card(
                    Suits.HEART, CardNames.ACE,
                    CardValueMapper.cardValueMapper[CardNames.ACE],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.HEART}${CardNames.ACE}",
                        null,
                        null
                    )
                )
            )
            hand.addCard(
                Card(
                    Suits.SPADE, CardNames.ACE,
                    CardValueMapper.cardValueMapper[CardNames.ACE],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.SPADE}${CardNames.ACE}",
                        null,
                        null
                    )
                )
            )
            hand.addCard(
                Card(
                    Suits.SPADE, CardNames.ACE,
                    CardValueMapper.cardValueMapper[CardNames.ACE],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.SPADE}${CardNames.ACE}",
                        null,
                        null
                    )
                )
            )
        }
        assertEquals(expectedTotal.toLong(), hand.handTotal.toLong())
        assertEquals(expectedHandType, hand.handType)
    }

    @Test
    fun calcHandTotal_HardHandIs10_WithMultipleAces() {
        val expectedHandType = HandType.HARD
        val expectedTotal = 12

        composeTestRule.setContent {
            hand.addCard(
                Card(
                    Suits.SPADE,
                    CardNames.QUEEN,
                    CardValueMapper.cardValueMapper[CardNames.QUEEN],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.SPADE}${CardNames.QUEEN}",
                        null,
                        null
                    )
                )
            )
            hand.addCard(
                Card(
                    Suits.HEART, CardNames.ACE,
                    CardValueMapper.cardValueMapper[CardNames.ACE],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.HEART}${CardNames.ACE}",
                        null,
                        null
                    )
                )
            )
            hand.addCard(
                Card(
                    Suits.SPADE, CardNames.ACE,
                    CardValueMapper.cardValueMapper[CardNames.ACE],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.SPADE}${CardNames.ACE}",
                        null,
                        null
                    )
                )
            )
        }
        assertEquals(expectedTotal.toLong(), hand.handTotal.toLong())
        assertEquals(expectedHandType, hand.handType)
    }

    @Test
    fun calcHandTotal_HardHandGreaterThan10_WithMultipleAces() {
        val expectedHandType = HandType.HARD
        val expectedTotal = 15

        composeTestRule.setContent {
            hand.addCard(
                Card(
                    Suits.SPADE,
                    CardNames.THREE,
                    CardValueMapper.cardValueMapper[CardNames.THREE],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.SPADE}${CardNames.THREE}",
                        null,
                        null
                    )
                )
            )
            hand.addCard(
                Card(
                    Suits.SPADE,
                    CardNames.QUEEN,
                    CardValueMapper.cardValueMapper[CardNames.QUEEN],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.SPADE}${CardNames.QUEEN}",
                        null,
                        null
                    )
                )
            )
            hand.addCard(
                Card(
                    Suits.HEART, CardNames.ACE,
                    CardValueMapper.cardValueMapper[CardNames.ACE],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.HEART}${CardNames.ACE}",
                        null,
                        null
                    )
                )
            )
            hand.addCard(
                Card(
                    Suits.SPADE, CardNames.ACE,
                    CardValueMapper.cardValueMapper[CardNames.ACE],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.SPADE}${CardNames.ACE}",
                        null,
                        null
                    )
                )
            )
        }
        assertEquals(expectedTotal.toLong(), hand.handTotal.toLong())
        assertEquals(expectedHandType, hand.handType)
    }

    @Test
    fun calcHandTotal_softHand_BlackjackWithFaceCard() {
        val expectedHandType = HandType.SOFT
        val expectedTotal = 21

        composeTestRule.setContent {
            hand.addCard(
                Card(
                    Suits.SPADE,
                    CardNames.QUEEN,
                    CardValueMapper.cardValueMapper[CardNames.QUEEN],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.SPADE}${CardNames.QUEEN}",
                        null,
                        null
                    )
                )
            )
            hand.addCard(
                Card(
                    Suits.HEART, CardNames.ACE,
                    CardValueMapper.cardValueMapper[CardNames.ACE],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.HEART}${CardNames.ACE}",
                        null,
                        null
                    )
                )
            )
        }
        assertEquals(expectedTotal.toLong(), hand.handTotal.toLong())
        assertTrue(
            "Hand was not a blackjack. HandTotal: " + hand.handTotal,
            hand.isBlackjack
        )
        assertEquals(expectedHandType, hand.handType)
    }

    @Test
    fun calcHandTotal_softHand_BlackjackWith10ValueCard() {
        val expectedHandType = HandType.SOFT
        val expectedTotal = 21

        composeTestRule.setContent {
            hand.addCard(
                Card(
                    Suits.SPADE, CardNames.TEN,
                    CardValueMapper.cardValueMapper[CardNames.TEN],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.SPADE}${CardNames.TEN}",
                        null,
                        null
                    )
                )
            )
            hand.addCard(
                Card(
                    Suits.HEART, CardNames.ACE,
                    CardValueMapper.cardValueMapper[CardNames.ACE],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.HEART}${CardNames.ACE}",
                        null,
                        null
                    )
                )
            )
        }
        assertEquals(expectedTotal.toLong(), hand.handTotal.toLong())
        assertTrue(
            "Hand was not a blackjack. HandTotal: " + hand.handTotal,
            hand.isBlackjack
        )
        assertEquals(expectedHandType, hand.handType)
    }

    @Test
    fun calcHandTotal_softHand_BlackjackWithAceFirst() {
        val expectedHandType = HandType.SOFT
        val expectedTotal = 21

        composeTestRule.setContent {
            hand.addCard(
                Card(
                    Suits.HEART, CardNames.ACE,
                    CardValueMapper.cardValueMapper[CardNames.ACE],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.HEART}${CardNames.ACE}",
                        null,
                        null
                    )
                )
            )
            hand.addCard(
                Card(
                    Suits.SPADE, CardNames.TEN,
                    CardValueMapper.cardValueMapper[CardNames.TEN],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.SPADE}${CardNames.TEN}",
                        null,
                        null
                    )
                )
            )
        }
        assertEquals(expectedTotal.toLong(), hand.handTotal.toLong())
        assertTrue(
            "Hand was not a blackjack. HandTotal: " + hand.handTotal,
            hand.isBlackjack
        )
        assertEquals(expectedHandType, hand.handType)
    }

    @Test
    fun calcHandTotal_HardHand_NonBlackjack21() {
        val expectedHandType = HandType.HARD
        val expectedTotal = 21

        composeTestRule.setContent {
            hand.addCard(
                Card(
                    Suits.HEART, CardNames.ACE,
                    CardValueMapper.cardValueMapper[CardNames.ACE],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.HEART}${CardNames.ACE}",
                        null,
                        null
                    )
                )
            )
            hand.addCard(
                Card(
                    Suits.SPADE, CardNames.TEN,
                    CardValueMapper.cardValueMapper[CardNames.TEN],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.SPADE}${CardNames.TEN}",
                        null,
                        null
                    )
                )
            )
            hand.addCard(
                Card(
                    Suits.SPADE,
                    CardNames.EIGHT,
                    CardValueMapper.cardValueMapper[CardNames.EIGHT],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.SPADE}${CardNames.EIGHT}",
                        null,
                        null
                    )
                )
            )
            hand.addCard(
                Card(
                    Suits.SPADE, CardNames.TWO,
                    CardValueMapper.cardValueMapper[CardNames.TWO],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.SPADE}${CardNames.TWO}",
                        null,
                        null
                    )
                )
            )
        }
        assertEquals(expectedTotal.toLong(), hand.handTotal.toLong())
        assertFalse(
            "Hand was a blackjack. HandTotal: " + hand.handTotal,
            hand.isBlackjack
        )
        assertEquals(expectedHandType, hand.handType)
    }

    @Test
    fun calcHandTotal_SoftHand_NonBlackjack21() {
        val expectedHandType = HandType.SOFT
        val expectedTotal = 21

        composeTestRule.setContent {
            hand.addCard(
                Card(
                    Suits.HEART, CardNames.ACE,
                    CardValueMapper.cardValueMapper[CardNames.ACE],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.HEART}${CardNames.ACE}",
                        null,
                        null
                    )
                )
            )
            hand.addCard(
                Card(
                    Suits.SPADE,
                    CardNames.EIGHT,
                    CardValueMapper.cardValueMapper[CardNames.EIGHT],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.SPADE}${CardNames.EIGHT}",
                        null,
                        null
                    )
                )
            )
            hand.addCard(
                Card(
                    Suits.SPADE, CardNames.TWO,
                    CardValueMapper.cardValueMapper[CardNames.TWO],
                    LocalContext.current.resources.getIdentifier(
                        "com.example.advantagetrainer:drawable/${Suits.SPADE}${CardNames.TWO}",
                        null,
                        null
                    )
                )
            )
        }
        assertEquals(expectedTotal.toLong(), hand.handTotal.toLong())
        assertFalse(
            "Hand was a blackjack. HandTotal: " + hand.handTotal,
            hand.isBlackjack
        )
        assertEquals(expectedHandType, hand.handType)
    }
}