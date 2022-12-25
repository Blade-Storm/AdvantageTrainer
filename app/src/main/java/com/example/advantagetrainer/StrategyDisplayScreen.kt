package com.example.advantagetrainer

import android.content.SharedPreferences
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun StrategyDisplayScreen(
    sharedPref: SharedPreferences
) {
    // Get strategy JSON
    val strategy = setStrategy(sharedPref = sharedPref)
    var action: String? = null
    var deviationCount: String? = null
    var sign: String? = null
    val strategyHard = strategy.getJSONObject("hard")
    val strategySoft = strategy.getJSONObject("soft")
    val strategySplit = strategy.getJSONObject("split")
    val strategySurrender = strategy.getJSONObject("surrender")

    Column(
        modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState())
    ) {
        Text(
            "Pair Splitting",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(Color.LightGray)
            ) {
                Text(text = "", modifier = Modifier.padding(6.dp))
                Text(text = "2,2", modifier = Modifier.padding(6.dp))
                Text(text = "3,3", modifier = Modifier.padding(6.dp))
                Text(text = "4,4", modifier = Modifier.padding(6.dp))
                Text(text = "5,5", modifier = Modifier.padding(6.dp))
                Text(text = "6,6", modifier = Modifier.padding(6.dp))
                Text(text = "7,7", modifier = Modifier.padding(6.dp))
                Text(text = "8,8", modifier = Modifier.padding(6.dp))
                Text(text = "9,9", modifier = Modifier.padding(6.dp))
                Text(text = "T,T", modifier = Modifier.padding(6.dp))
                Text(text = "A,A", modifier = Modifier.padding(6.dp))
            }
            for (i in 2 until strategySplit.length() + 2) {
                var dealerCardValue = i.toString()
                if (i.toString() == "10") {
                    dealerCardValue = "t"
                } else if (i.toString() == "13") {
                    dealerCardValue = "a"
                }

                if (strategySplit.has(dealerCardValue)) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.background(Color.LightGray)
                    ) {
                        Text(
                            if (dealerCardValue.uppercase() == "T") "10" else dealerCardValue.uppercase(),
                            modifier = Modifier.padding(6.dp),
                            textAlign = TextAlign.Center
                        )

                        val dealerHandObject = strategySplit.getJSONObject(dealerCardValue)

                        for (j in 0 until dealerHandObject.length()) {
                            var playerCardValue = (j+2).toString()
                            if ((j+2).toString() == "10") {
                                playerCardValue = "t"
                            } else if ((j+2).toString() == "13") {
                                playerCardValue = "a"
                            }

                            if (j in 0..13) {
                                if (dealerHandObject.has(playerCardValue)) {
                                    val playerHandObject =
                                        dealerHandObject.getJSONObject(playerCardValue)

                                    if (playerHandObject.has("deviation")) {
                                        deviationCount =
                                            playerHandObject.getJSONObject("deviation").get("count")
                                                .toString()
                                        sign =
                                            playerHandObject.getJSONObject("deviation").get("sign")
                                                .toString()

                                        if (sign == Settings.StrategyDeviationSign.GREATER_OR_EQUAL.sign || sign == Settings.StrategyDeviationSign.GREATER.sign) {
                                            sign = "+"
                                        } else if (sign == Settings.StrategyDeviationSign.LESS_OR_EQUAL.sign || sign == Settings.StrategyDeviationSign.LESS.sign) {
                                            sign = "-"
                                        }
                                    } else {
                                        deviationCount = null
                                        sign = null
                                    }

                                    action = if (playerHandObject.has("action")) playerHandObject.get("action").toString() else null

                                    if (deviationCount == null) {
                                        if (action != null) {
                                            Text(
                                                "Y",
                                                modifier = Modifier.background(Color.Green)
                                                    .padding(6.dp).width(20.dp),
                                                textAlign = TextAlign.Center
                                            )
                                        } else{
                                            Text(
                                                "N",
                                                modifier = Modifier.background(Color.White)
                                                    .padding(6.dp).width(20.dp),
                                                textAlign = TextAlign.Center
                                            )
                                        }
                                    } else {
                                        if (action != null) {
                                            Text(
                                                deviationCount.toString() + sign,
                                                color = Color.Red,
                                                modifier = Modifier.background(Color.Green)
                                                    .padding(6.dp).width(20.dp),
                                                textAlign = TextAlign.Center
                                            )
                                        } else {
                                            Text(
                                                deviationCount.toString() + sign,
                                                modifier = Modifier.background(Color.White)
                                                    .padding(6.dp).width(20.dp),
                                                color = Color.Red,
                                                textAlign = TextAlign.Center
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        Text(
            "Soft Totals",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(Color.LightGray)
            ) {
                Text(text = "", modifier = Modifier.padding(6.dp))
                Text(text = "A,2", modifier = Modifier.padding(6.dp))
                Text(text = "A,3", modifier = Modifier.padding(6.dp))
                Text(text = "A,4", modifier = Modifier.padding(6.dp))
                Text(text = "A,5", modifier = Modifier.padding(6.dp))
                Text(text = "A,6", modifier = Modifier.padding(6.dp))
                Text(text = "A,7", modifier = Modifier.padding(6.dp))
                Text(text = "A,8", modifier = Modifier.padding(6.dp))
                Text(text = "A,9", modifier = Modifier.padding(6.dp))
            }
            for (i in 2 until strategySoft.length() + 2) {
                var dealerCardValue = i.toString()
                if (i.toString() == "10") {
                    dealerCardValue = "t"
                } else if (i.toString() == "13") {
                    dealerCardValue = "a"
                }

                if (strategySoft.has(dealerCardValue)) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.background(Color.LightGray)
                    ) {
                        Text(
                            if (dealerCardValue.uppercase() == "T") "10" else dealerCardValue.uppercase(),
                            modifier = Modifier.padding(6.dp),
                            textAlign = TextAlign.Center
                        )

                        val dealerHandObject = strategySoft.getJSONObject(dealerCardValue)

                        for (j in 0 until dealerHandObject.length()) {
                            if (j+11 in 13..20) {
                                if (dealerHandObject.has((j+11).toString())) {
                                    val playerHandObject =
                                        dealerHandObject.getJSONObject((j+11).toString())

                                    if (playerHandObject.has("deviation")) {
                                        deviationCount =
                                            playerHandObject.getJSONObject("deviation").get("count")
                                                .toString()
                                        sign =
                                            playerHandObject.getJSONObject("deviation").get("sign")
                                                .toString()

                                        if (sign == Settings.StrategyDeviationSign.GREATER_OR_EQUAL.sign || sign == Settings.StrategyDeviationSign.GREATER.sign) {
                                            sign = "+"
                                        } else if (sign == Settings.StrategyDeviationSign.LESS_OR_EQUAL.sign || sign == Settings.StrategyDeviationSign.LESS.sign) {
                                            sign = "-"
                                        }
                                    } else {
                                        deviationCount = null
                                        sign = null
                                    }

                                    action = playerHandObject.get("action").toString()

                                    if (deviationCount == null) {
                                        if (action.toString().slice(0..0).uppercase() == "H") {
                                            Text(
                                                action.toString().slice(0..0).uppercase(),
                                                modifier = Modifier.background(Color.White)
                                                    .padding(6.dp).width(20.dp),
                                                textAlign = TextAlign.Center
                                            )
                                        } else if (action.toString().slice(0..0)
                                                .uppercase() == "S"
                                        ) {
                                            Text(
                                                action.toString().slice(0..0).uppercase(),
                                                modifier = Modifier.background(Color.Yellow)
                                                    .padding(6.dp).width(20.dp),
                                                textAlign = TextAlign.Center
                                            )
                                        } else if (action.toString().slice(0..0)
                                                .uppercase() == "D"
                                        ) {
                                            Text(
                                                action.toString().slice(0..0).uppercase(),
                                                modifier = Modifier.background(Color.Green)
                                                    .padding(6.dp).width(20.dp),
                                                textAlign = TextAlign.Center
                                            )
                                        }

                                    } else {
                                        if (action.toString().slice(0..0).uppercase() == "H") {
                                            Text(
                                                deviationCount.toString() + sign,
                                                color = Color.Red,
                                                modifier = Modifier.background(Color.White)
                                                    .padding(6.dp).width(20.dp),
                                                textAlign = TextAlign.Center
                                            )
                                        } else if (action.toString().slice(0..0)
                                                .uppercase() == "S"
                                        ) {
                                            Text(
                                                deviationCount.toString() + sign,
                                                modifier = Modifier.background(Color.Yellow)
                                                    .padding(6.dp).width(20.dp),
                                                color = Color.Red,
                                                textAlign = TextAlign.Center
                                            )
                                        } else if (action.toString().slice(0..0)
                                                .uppercase() == "D"
                                        ) {
                                            Text(
                                                deviationCount.toString() + sign,
                                                modifier = Modifier.background(Color.Green)
                                                    .padding(6.dp).width(20.dp),
                                                color = Color.Red,
                                                textAlign = TextAlign.Center
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        Text(
            "Hard Totals",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(Color.LightGray)
            ) {
                Text(text = "", modifier = Modifier.padding(6.dp))
                Text(text = "2-8", modifier = Modifier.padding(6.dp))
                Text(text = "9", modifier = Modifier.padding(6.dp))
                Text(text = "10", modifier = Modifier.padding(6.dp))
                Text(text = "11", modifier = Modifier.padding(6.dp))
                Text(text = "12", modifier = Modifier.padding(6.dp))
                Text(text = "13", modifier = Modifier.padding(6.dp))
                Text(text = "14", modifier = Modifier.padding(6.dp))
                Text(text = "15", modifier = Modifier.padding(6.dp))
                Text(text = "16", modifier = Modifier.padding(6.dp))
                Text(text = "17+", modifier = Modifier.padding(6.dp))
            }
            for (i in 2 until strategyHard.length() + 2) {
                var dealerCardValue = i.toString()
                if (i.toString() == "10") {
                    dealerCardValue = "t"
                } else if (i.toString() == "13") {
                    dealerCardValue = "a"
                }

                if (strategyHard.has(dealerCardValue)) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.background(Color.LightGray)
                    ) {
                        Text(
                            if (dealerCardValue.uppercase() == "T") "10" else dealerCardValue.uppercase(),
                            modifier = Modifier.padding(6.dp),
                            textAlign = TextAlign.Center
                        )

                        val dealerHandObject = strategyHard.getJSONObject(dealerCardValue)

                        for (j in 0 until dealerHandObject.length()) {
                            if (j in 8..17) {
                                if (dealerHandObject.has(j.toString())) {
                                    val playerHandObject =
                                        dealerHandObject.getJSONObject(j.toString())

                                    if (playerHandObject.has("deviation")) {
                                        deviationCount =
                                            playerHandObject.getJSONObject("deviation").get("count")
                                                .toString()
                                        sign =
                                            playerHandObject.getJSONObject("deviation").get("sign")
                                                .toString()

                                        if (sign == Settings.StrategyDeviationSign.GREATER_OR_EQUAL.sign || sign == Settings.StrategyDeviationSign.GREATER.sign) {
                                            sign = "+"
                                        } else if (sign == Settings.StrategyDeviationSign.LESS_OR_EQUAL.sign || sign == Settings.StrategyDeviationSign.LESS.sign) {
                                            sign = "-"
                                        }
                                    } else {
                                        deviationCount = null
                                        sign = null
                                    }

                                    action = playerHandObject.get("action").toString()

                                    if (deviationCount == null) {
                                        if (action.toString().slice(0..0).uppercase() == "H") {
                                            Text(
                                                action.toString().slice(0..0).uppercase(),
                                                modifier = Modifier.background(Color.White)
                                                    .padding(6.dp).width(20.dp),
                                                textAlign = TextAlign.Center
                                            )
                                        } else if (action.toString().slice(0..0)
                                                .uppercase() == "S"
                                        ) {
                                            Text(
                                                action.toString().slice(0..0).uppercase(),
                                                modifier = Modifier.background(Color.Yellow)
                                                    .padding(6.dp).width(20.dp),
                                                textAlign = TextAlign.Center
                                            )
                                        } else if (action.toString().slice(0..0)
                                                .uppercase() == "D"
                                        ) {
                                            Text(
                                                action.toString().slice(0..0).uppercase(),
                                                modifier = Modifier.background(Color.Green)
                                                    .padding(6.dp).width(20.dp),
                                                textAlign = TextAlign.Center
                                            )
                                        }

                                    } else {
                                        if (action.toString().slice(0..0).uppercase() == "H") {
                                            Text(
                                                deviationCount.toString() + sign,
                                                color = Color.Red,
                                                modifier = Modifier.background(Color.White)
                                                    .padding(6.dp).width(20.dp),
                                                textAlign = TextAlign.Center
                                            )
                                        } else if (action.toString().slice(0..0)
                                                .uppercase() == "S"
                                        ) {
                                            Text(
                                                deviationCount.toString() + sign,
                                                modifier = Modifier.background(Color.Yellow)
                                                    .padding(6.dp).width(20.dp),
                                                color = Color.Red,
                                                textAlign = TextAlign.Center
                                            )
                                        } else if (action.toString().slice(0..0)
                                                .uppercase() == "D"
                                        ) {
                                            Text(
                                                deviationCount.toString() + sign,
                                                modifier = Modifier.background(Color.Green)
                                                    .padding(6.dp).width(20.dp),
                                                color = Color.Red,
                                                textAlign = TextAlign.Center
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        Text(
            "Late Surrender",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.background(Color.LightGray)
            ) {
                Text(text = "", modifier = Modifier.padding(3.dp))
                Text(text = "14", modifier = Modifier.padding(3.dp))
                Text(text = "15", modifier = Modifier.padding(3.dp))
                Text(text = "16", modifier = Modifier.padding(3.dp))
                Text(text = "17", modifier = Modifier.padding(3.dp))
            }
            for (i in 2 until strategySurrender.length() + 2) {
                var dealerCardValue = i.toString()
                if (i.toString() == "10") {
                    dealerCardValue = "t"
                } else if (i.toString() == "13") {
                    dealerCardValue = "a"
                }

                if (strategySurrender.has(dealerCardValue)) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.background(Color.LightGray)
                    ) {
                        Text(
                            if (dealerCardValue.uppercase() == "T") "10" else dealerCardValue.uppercase(),
                            modifier = Modifier.padding(6.dp),
                            textAlign = TextAlign.Center
                        )

                        val dealerHandObject = strategySurrender.getJSONObject(dealerCardValue)

                        for (j in 0 until dealerHandObject.length()) {
                            if (j in 14..17) {
                                if (dealerHandObject.has(j.toString())) {
                                    val playerHandObject =
                                        dealerHandObject.getJSONObject(j.toString())

                                    if (playerHandObject.has("deviation")) {
                                        deviationCount =
                                            playerHandObject.getJSONObject("deviation").get("count")
                                                .toString()
                                        sign =
                                            playerHandObject.getJSONObject("deviation").get("sign")
                                                .toString()

                                        if (sign == Settings.StrategyDeviationSign.GREATER_OR_EQUAL.sign || sign == Settings.StrategyDeviationSign.GREATER.sign) {
                                            sign = "+"
                                        } else if (sign == Settings.StrategyDeviationSign.LESS_OR_EQUAL.sign || sign == Settings.StrategyDeviationSign.LESS.sign) {
                                            sign = "-"
                                        }
                                    } else {
                                        deviationCount = null
                                        sign = null
                                    }

                                    action = if(playerHandObject.has("action")) playerHandObject.get("action").toString() else null

                                    if (deviationCount == null) {
                                        if (action != null) {
                                            Text(
                                                "LS",
                                                modifier = Modifier.background(Color.Green)
                                                    .padding(2.dp).width(30.dp),
                                                textAlign = TextAlign.Center
                                            )
                                        } else {
                                            Text(
                                                "",
                                                modifier = Modifier.background(Color.White)
                                                    .padding(2.dp).width(30.dp),
                                                textAlign = TextAlign.Center
                                            )
                                        }
                                    } else {
                                        if (action != null) {
                                            Text(
                                                deviationCount.toString() + sign,
                                                modifier = Modifier.background(Color.Green)
                                                    .padding(2.dp).width(30.dp),
                                                textAlign = TextAlign.Center,
                                                color = Color.Red
                                            )
                                        } else {
                                            Text(
                                                deviationCount.toString() + sign,
                                                modifier = Modifier.background(Color.White)
                                                    .padding(2.dp).width(30.dp),
                                                textAlign = TextAlign.Center,
                                                color = Color.Red
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}