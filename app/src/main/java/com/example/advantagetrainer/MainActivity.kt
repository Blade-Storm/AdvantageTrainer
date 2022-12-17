package com.example.advantagetrainer

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.advantagetrainer.ui.theme.AdvantageTrainerTheme
import org.json.JSONObject
import org.json.JSONTokener
import java.io.*


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdvantageTrainerTheme {
                GenerateAppView()
            }
        }
    }
}

enum class Coupons (val coupon: String) {
    FREE_CHIPS ("Free Chips"),
    MATCH_PLAY ("Match Play")
}

@Preview
@Composable
fun GenerateAppView(){
    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
        MyAppNavHost()
    }
}

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "home"
) {
    val (couponSelection, onOptionSelected) = rememberSaveable { mutableStateOf(Coupons.FREE_CHIPS)}
    val (couponGameEdge, updateCouponGameEdge ) = rememberSaveable { mutableStateOf("") }
    val (couponFaceValue, updateCouponFaceValue ) = rememberSaveable { mutableStateOf("") }
    val (couponBet, updateCouponBetValue ) = rememberSaveable { mutableStateOf("") }
    val (deck, updateDeck) = remember { mutableStateOf(ArrayList<Card>()) }

    val sharedPref = LocalContext.current.getSharedPreferences(
        Settings.SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE)

    with (sharedPref.edit()) {
        putInt(Settings.CARD_FLASH_SPEED, sharedPref.getInt(Settings.CARD_FLASH_SPEED, 0))
        putBoolean(Settings.USE_SPANISH_DECK, sharedPref.getBoolean(Settings.USE_SPANISH_DECK, false))
        putInt(Settings.NUM_CARDS_TO_FLASH, sharedPref.getInt(Settings.NUM_CARDS_TO_FLASH, 1))
        apply()
    }


    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("home") {
            HomeScreen(
                onNavigateToCouponCalculator = { navController.navigate("couponcalculator") },
                onNavigateToCountingDrill = {navController.navigate("countingdrill")},
                onNavigateToSettings = {navController.navigate("settings")},
                onNavigateToStrategyDrill = {navController.navigate("strategydrill")}
            )

        }
        composable("countingdrill") {
            CountingDrillScreen(
                sharedPref,
                deck,
                updateDeck
            )
        }
        composable("couponcalculator") {
            CouponCalculatorScreen(
                onNavigateToHome = { navController.navigate("home") },
                couponSelection,
                onOptionSelected,
                couponGameEdge,
                updateCouponGameEdge,
                couponFaceValue,
                updateCouponFaceValue,
                couponBet,
                updateCouponBetValue,
            )
        }
        composable("settings") {
            SettingsScreen(
                sharedPref
            )
        }
        composable("strategydrill") {
            StrategyDrillScreen(
                sharedPref
            )
        }
    }
}

@Composable
fun HomeScreen(
    onNavigateToCouponCalculator: () -> Unit,
    onNavigateToCountingDrill: () -> Unit,
    onNavigateToSettings: () -> Unit,
    onNavigateToStrategyDrill: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onNavigateToCountingDrill,
            Modifier.testTag("CountingDrillButton")
        ) {
            Text(text = "Counting Drill")
        }
        Button(
            onClick = onNavigateToStrategyDrill,
            Modifier.testTag("StrategyDrillButton")
        ) {
            Text(text = "Strategy Drill")
        }
        Button(
           onClick = onNavigateToCouponCalculator,
           Modifier.testTag("CouponCalculatorButton")
        ) {
            Text(text = "Coupon Calculator")
        }
        Button(
            onClick = onNavigateToSettings,
            Modifier.testTag("SettingsButton")
        ) {
            Text(text = "Settings")
        }

    }
}


@Composable
fun createDeck(sharedPref: SharedPreferences): ArrayList<Card>{
    val useSpanishDeck = sharedPref.getBoolean(Settings.USE_SPANISH_DECK, false)
    val numDeckToCountSetting = sharedPref.getInt(Settings.NUM_DECKS_TO_COUNT, 0)
    var numDecksToCount = 1

    // Protect ourself from trying to access the mapper with an index that is out of bounds
    // Default to and create a single deck instead
    if(numDeckToCountSetting <= Settings.numDecksToCountMapper.size - 1){
        numDecksToCount = Settings.numDecksToCountMapper[numDeckToCountSetting]!!
    }

    val deck = ArrayList<Card>()

    for (i in 0 until numDecksToCount){
        for (suit in Suits.values()) {
            CardValueMapper.cardValueMapper.forEach { (key, value) ->
                if(key == CardNames.TEN && useSpanishDeck){
                    return@forEach // Continue
                }
                val id = LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/$suit$key", null, null)
                deck.add(Card(suit, key, value, id))
            }
        }
    }

    deck.shuffle()

    return deck
}