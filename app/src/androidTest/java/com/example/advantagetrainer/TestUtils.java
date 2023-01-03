package com.example.advantagetrainer;

import com.example.advantagetrainer.enums.CardNames;
import com.example.advantagetrainer.enums.Suits;

import java.util.List;

public class TestUtils {
    public String TEST_SETTINGS_FILE_LOCATION = "com.example.advantagetrainertest";

    Card card2 = new Card(Suits.CLUB, CardNames.TWO, CardValueMapper.cardValueMapper.get(CardNames.TWO), 1);
    Card card3 = new Card(Suits.CLUB, CardNames.THREE, CardValueMapper.cardValueMapper.get(CardNames.THREE), 1);
    Card card4 = new Card(Suits.CLUB, CardNames.FOUR, CardValueMapper.cardValueMapper.get(CardNames.FOUR), 1);
    Card card5 = new Card(Suits.CLUB, CardNames.FIVE, CardValueMapper.cardValueMapper.get(CardNames.FIVE), 1);
    Card card6 = new Card(Suits.CLUB, CardNames.SIX, CardValueMapper.cardValueMapper.get(CardNames.SIX), 1);
    Card card7 = new Card(Suits.CLUB, CardNames.SEVEN, CardValueMapper.cardValueMapper.get(CardNames.SEVEN), 1);
    Card card8 = new Card(Suits.CLUB, CardNames.EIGHT, CardValueMapper.cardValueMapper.get(CardNames.EIGHT), 1);
    Card card9 = new Card(Suits.CLUB, CardNames.NINE, CardValueMapper.cardValueMapper.get(CardNames.NINE), 1);
    Card cardt = new Card(Suits.CLUB, CardNames.TEN, CardValueMapper.cardValueMapper.get(CardNames.TEN), 1);
    Card cardj = new Card(Suits.CLUB, CardNames.JACK, CardValueMapper.cardValueMapper.get(CardNames.JACK), 1);
    Card cardq = new Card(Suits.CLUB, CardNames.QUEEN, CardValueMapper.cardValueMapper.get(CardNames.QUEEN), 1);
    Card cardk = new Card(Suits.CLUB, CardNames.KING, CardValueMapper.cardValueMapper.get(CardNames.KING), 1);
    Card carda = new Card(Suits.CLUB, CardNames.ACE, CardValueMapper.cardValueMapper.get(CardNames.ACE), 1);
    List<Card> cards = List.of(card2, card3, card4, card5, card6, card7, card8, card9, cardt, cardj, cardq, cardk, carda);

    Hand split2 = new Hand().withCards(List.of(card2, card2));
    Hand split3 = new Hand().withCards(List.of(card3, card3));
    Hand split4 = new Hand().withCards(List.of(card4, card4));
    Hand split5 = new Hand().withCards(List.of(card5, card5));
    Hand split6 = new Hand().withCards(List.of(card6, card6));
    Hand split7 = new Hand().withCards(List.of(card7, card7));
    Hand split8 = new Hand().withCards(List.of(card8, card8));
    Hand split9 = new Hand().withCards(List.of(card9, card9));
    Hand splitt = new Hand().withCards(List.of(cardt, cardt));
    Hand splitj = new Hand().withCards(List.of(cardj, cardj));
    Hand splitq = new Hand().withCards(List.of(cardq, cardq));
    Hand splitk = new Hand().withCards(List.of(cardk, cardk));
    Hand splita = new Hand().withCards(List.of(carda, carda));
    List<Hand> splitHands = List.of(split2,split3,split4,split5,split6,split7,split8,split9,splitt,splitj,splitq,splitk,splita);

    Hand hard2 = new Hand().withCards(List.of(card2));
    Hand hard3 = new Hand().withCards(List.of(card3));
    Hand hard4 = new Hand().withCards(List.of(card4));
    Hand hard5 = new Hand().withCards(List.of(card3, card2));
    Hand hard6 = new Hand().withCards(List.of(card4, card2));
    Hand hard7 = new Hand().withCards(List.of(card5, card2));
    Hand hard8 = new Hand().withCards(List.of(card6, card2));
    Hand hard9 = new Hand().withCards(List.of(card6, card3));
    Hand hard10 = new Hand().withCards(List.of(card6, card4));
    Hand hard11 = new Hand().withCards(List.of(card6, card5));
    Hand hard12 = new Hand().withCards(List.of(card7, card5));
    Hand hard13 = new Hand().withCards(List.of(card7, card6));
    Hand hard14 = new Hand().withCards(List.of(card8, card6));
    Hand hard15 = new Hand().withCards(List.of(card8, card7));
    Hand hard16 = new Hand().withCards(List.of(cardt, card6));
    Hand hard17 = new Hand().withCards(List.of(cardt, card7));
    Hand hard18 = new Hand().withCards(List.of(card8, cardt));
    Hand hard19 = new Hand().withCards(List.of(card9, cardt));
    Hand hard20 = new Hand().withCards(List.of(cardt, cardt));
    Hand hard21 = new Hand().withCards(List.of(card8, card7, card6));
    List<Hand> hardHands = List.of(hard2,hard3,hard4,hard5,hard6,hard7,hard8,hard9,hard10,hard11,hard12,hard13,hard14,hard15,hard16,hard17,hard18,hard19,hard20,hard21);

    Hand hard6_threeCard = new Hand().withCards(List.of(card2, card2, card2));
    Hand hard7_threeCard = new Hand().withCards(List.of(card3, card2, card2));
    Hand hard8_threeCard = new Hand().withCards(List.of(card4, card2, card2));
    Hand hard9_threeCard = new Hand().withCards(List.of(card5, card2, card2));
    Hand hard10_threeCard = new Hand().withCards(List.of(card6, card2, card2));
    Hand hard11_threeCard = new Hand().withCards(List.of(card7, card2, card2));
    Hand hard12_threeCard = new Hand().withCards(List.of(card8, card2, card2));
    Hand hard13_threeCard = new Hand().withCards(List.of(card9, card2, card2));
    Hand hard14_threeCard = new Hand().withCards(List.of(cardt, card2, card2));
    Hand hard15_threeCard = new Hand().withCards(List.of(cardt, card3, card2));
    Hand hard16_threeCard = new Hand().withCards(List.of(cardt, card4, card2));
    Hand hard17_threeCard = new Hand().withCards(List.of(cardt, card5, card2));
    Hand hard18_threeCard = new Hand().withCards(List.of(cardt, card6, card2));
    Hand hard19_threeCard = new Hand().withCards(List.of(cardt, card7, card2));
    Hand hard20_threeCard = new Hand().withCards(List.of(cardt, card8, card2));
    Hand hard21_threeCard = new Hand().withCards(List.of(cardt, card9, card2));
    List<Hand> hardHands_threeCard = List.of(hard6_threeCard,hard7_threeCard,hard8_threeCard,hard9_threeCard,hard10_threeCard,hard11_threeCard,hard12_threeCard,hard13_threeCard,hard14_threeCard,hard15_threeCard,hard16_threeCard,hard17_threeCard,hard18_threeCard,hard19_threeCard,hard20_threeCard,hard21_threeCard);


    Hand softaa = new Hand().withCards(List.of(carda, carda));
    Hand softa2 = new Hand().withCards(List.of(carda, card2));
    Hand softa3 = new Hand().withCards(List.of(carda, card3));
    Hand softa4 = new Hand().withCards(List.of(carda, card4));
    Hand softa5 = new Hand().withCards(List.of(carda, card5));
    Hand softa6 = new Hand().withCards(List.of(carda, card6));
    Hand softa7 = new Hand().withCards(List.of(carda, card7));
    Hand softa8 = new Hand().withCards(List.of(carda, card8));
    Hand softa9 = new Hand().withCards(List.of(carda, card9));
    Hand softat = new Hand().withCards(List.of(carda, cardt));
    Hand softaj = new Hand().withCards(List.of(carda, cardj));
    Hand softaq = new Hand().withCards(List.of(carda, cardq));
    Hand softak = new Hand().withCards(List.of(carda, cardk));
    List<Hand> softHands = List.of(softaa,softa2,softa3,softa4,softa5,softa6,softa7,softa8,softa9,softat,softaj,softaq,softak);

    Hand softaaa = new Hand().withCards(List.of(carda, carda, carda));
    Hand softaa2 = new Hand().withCards(List.of(carda, carda, card2));
    Hand softaa3 = new Hand().withCards(List.of(carda, carda, card3));
    Hand softaa4 = new Hand().withCards(List.of(carda, carda, card4));
    Hand softaa5 = new Hand().withCards(List.of(carda, carda, card5));
    Hand softaa6 = new Hand().withCards(List.of(carda, carda, card6));
    Hand softaa7 = new Hand().withCards(List.of(carda, carda, card7));
    Hand softaa8 = new Hand().withCards(List.of(carda, carda, card8));
    Hand softaa9 = new Hand().withCards(List.of(carda, carda, card9));
    Hand softaat = new Hand().withCards(List.of(carda, carda, cardt));
    Hand softaaj = new Hand().withCards(List.of(carda, carda, cardj));
    Hand softaaq = new Hand().withCards(List.of(carda, carda, cardq));
    Hand softaak = new Hand().withCards(List.of(carda, carda, cardk));
    List<Hand> softHands_threeCard = List.of(softaaa,softaa2,softaa3,softaa4,softaa5,softaa6,softaa7,softaa8,softaa9,softaat,softaaj,softaaq,softaak);

    List<Hand> surrenderHands = List.of(hard16,hard17,split8);
}
