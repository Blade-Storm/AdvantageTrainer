package com.example.advantagetrainer.views

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.advantagetrainer.*
import com.example.advantagetrainer.Settings.Deck
import com.example.advantagetrainer.Settings.deckTypeMapper
import com.example.advantagetrainer.enums.CardNames
import com.example.advantagetrainer.enums.Suits
import com.example.advantagetrainer.ui.theme.AdvantageTrainerTheme


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
        putInt(Settings.DECK_TYPE, sharedPref.getInt(Settings.DECK_TYPE, 0))
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
                onNavigateToStrategyDrill = {navController.navigate("strategydrill")},
                deck,
                updateDeck
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
                onNavigateToStrategyDisplayScreen = { navController.navigate("strategydisplay") },
                sharedPref
            )
        }
        composable("strategydrill") {
            val actionResolver = ActionResolver(setStrategy(sharedPref))
            StrategyDrillScreen(
                sharedPref,
                actionResolver
            )
        }
        composable("strategydisplay"){
            StrategyDisplayScreen(
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
    onNavigateToStrategyDrill: () -> Unit,
    deck: ArrayList<Card>,
    updateDeck: (ArrayList<Card>) -> Unit,
    ) {

    // Create the deck for the drills here so that we don't have to on those pages.
    // It causes a bug where the correct deck type isn't loaded
    val sharedPref = LocalContext.current.getSharedPreferences(
        Settings.SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE)

    // Check if we need to update the deck
    if(deck.size == 0) {
        updateDeck(createDeck(sharedPref = sharedPref))
    }else if(deckTypeMapper[sharedPref.getInt(Settings.DECK_TYPE, 0)] == Deck.SPANISH){
        if(deck.size != 48){
            updateDeck(createDeck(sharedPref = sharedPref))
        }
    }else if(deckTypeMapper[sharedPref.getInt(Settings.DECK_TYPE, 0)] == Deck.BLACKJACK){
        // Look for the PIP 10s
        var found10 = false
        deck.forEach {
            if (it.name == CardNames.TEN) {
                found10 = true
            }
        }

        if(found10){
            updateDeck(createDeck(sharedPref = sharedPref))
        }
    }else if(deckTypeMapper[sharedPref.getInt(Settings.DECK_TYPE, 0)] == Deck.BLACKJACK_HARD){
        // Make sure there aren't any 10 value cards
        var found10Value = false
        deck.forEach {
            if (
                it.name == CardNames.TEN
                || it.name == CardNames.JACK
                || it.name == CardNames.QUEEN
                || it.name == CardNames.KING
            ) {
                found10Value = true
            }
        }

        if(found10Value){
            updateDeck(createDeck(sharedPref = sharedPref))
        }
    }


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
    val deckToUse = sharedPref.getInt(Settings.DECK_TYPE, 0)
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
                if(key == CardNames.TEN && deckTypeMapper[deckToUse]!!.name == Deck.SPANISH.name){
                    return@forEach // Continue
                }else if(
                    (key == CardNames.TEN
                    || key == CardNames.JACK
                    || key == CardNames.QUEEN
                    || key == CardNames.KING)
                    && deckTypeMapper[deckToUse]!!.name == Deck.BLACKJACK_HARD.name
                ){
                    val id = LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/$suit${CardNames.ACE}", null, null)
                    deck.add(Card(suit, CardNames.ACE, null, id))
                }else{
                    val id = LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/$suit$key", null, null)
                    deck.add(Card(suit, key, value, id))
                }
            }
        }
    }

    deck.shuffle()

    return deck
}