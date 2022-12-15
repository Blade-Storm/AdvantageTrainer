package com.example.advantagetrainer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import java.math.BigDecimal
import java.math.RoundingMode

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CouponCalculatorScreen(
    onNavigateToHome: () -> Unit,
    couponSelection: Coupons,
    onOptionSelected: (Coupons) -> Unit,
    couponGameEdge: String,
    updateCouponGameEdge: (String) -> Unit,
    couponFaceValue: String,
    updateCouponFaceValue: (String) -> Unit,
    couponBet: String,
    updateCouponBetValue: (String) -> Unit
) {
    val (couponExpectedValue, onCouponExpectedValueChange)  = remember { mutableStateOf("0.0") }
    val radioOptions = Coupons.values()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
    ) {
        Column {
            radioOptions.forEach { couponType ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (couponType == couponSelection),
                            onClick = { onOptionSelected(couponType) }
                        )
                ) {
                    RadioButton(
                        selected = (couponType == couponSelection),
                        onClick = {
                            onOptionSelected(couponType)
                        },
                    )
                    Text(
                        text = couponType.coupon,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }

            Text("Dollar value of your coupon")
            Row( Modifier
                .fillMaxWidth()) {
                TextField(
                    value = couponFaceValue,
                    onValueChange = {
                        updateCouponFaceValue(it)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                )
            }

            if(couponSelection == Coupons.MATCH_PLAY){
                Text("Dollar amount of the bet you make with the match play")
                Row( Modifier
                    .fillMaxWidth()) {

                    TextField(
                        value = couponBet,
                        onValueChange = { it ->
                            updateCouponBetValue(it)
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    )
                }
            }

            Text("Your edge as a percent")
            Row( Modifier
                .fillMaxWidth()) {
                TextField(
                    value = couponGameEdge,
                    onValueChange = {
                        updateCouponGameEdge(it)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                )
            }

            if(couponExpectedValue.toDouble() != 0.0){
                Text("The value of your coupon is:")
                Text(couponExpectedValue)
            }
        }
    }


    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { calculateCoupon(couponSelection, couponFaceValue, couponGameEdge, couponBet, onCouponExpectedValueChange) }) {
            Text(text = "Calculate")
        }
        Button(onClick = onNavigateToHome) {
            Text(text = "Home")
        }
    }
}

// Math from https://www.casinocitytimes.com/john-grochowski/article/the-math-of-match-play-47523
/*
The 1.41% house edge on the pass line in craps means we win 49.295% of the time, and lose 50.705%. Subtract 49.295 from 50.705, and you get 1.41.
So let's say you wager $5 on the pass line for each of 100,000 comeout rolls. You risk $500,000, and your expectation is that you'll win 49,295 bets and lose 50,705.
Each time you win using the match play coupon, you get $10 in winnings, plus you keep your $5 bet. So after 100,000 trials, you have 49,295 x $15, or $739,425. Subtract the $500,000 that represent your wagers, and that means you have a profit of $239,425.
Divide that by $500,000 in wagers, then multiply by 100 to convert to percent, and your edge over the house is 47.885%.
*/
fun calculateCoupon(
    couponSelection: Coupons,
    couponFaceValue: String,
    couponGameEdge: String,
    couponBet: String,
    onCouponExpectedValueChange: (String) -> Unit,
): BigDecimal? {
    var expectedValue = 0.0
    var houseGameEdge = 0.50 + (couponGameEdge.toDouble() / 200.0)
    var action = 0.0

    if(couponSelection == Coupons.MATCH_PLAY){
        action = (couponBet.toDouble() + couponFaceValue.toDouble()) + couponBet.toDouble()
        expectedValue = (((houseGameEdge * action) - couponBet.toDouble()) /  couponBet.toDouble()) * couponFaceValue.toDouble()
    }else if (couponSelection == Coupons.FREE_CHIPS){
        action = couponFaceValue.toDouble()
        expectedValue = houseGameEdge * action
    }

    onCouponExpectedValueChange(BigDecimal(expectedValue).setScale(2, RoundingMode.HALF_DOWN).toString())
    return BigDecimal(expectedValue).setScale(2, RoundingMode.HALF_DOWN)
}