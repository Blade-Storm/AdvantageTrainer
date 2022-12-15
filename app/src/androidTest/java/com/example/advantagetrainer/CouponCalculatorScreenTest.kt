package com.example.advantagetrainer

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.test.junit4.createComposeRule
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test
import java.math.BigDecimal
import java.math.RoundingMode

class CouponCalculatorScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculateCoupon(){
        composeTestRule.setContent {
            val (couponExpectedValue, onCouponExpectedValueChange)  = remember { mutableStateOf("0.0") }

            val value = calculateCoupon(
                Coupons.MATCH_PLAY,
                "5",
                "-1.41",
                "5",
                onCouponExpectedValueChange,
            )

            assertEquals(BigDecimal(2.39).setScale(2, RoundingMode.HALF_DOWN), value)
        }
    }
}