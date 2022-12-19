package com.example.advantagetrainer;

import java.util.List;

public class TestUtils {
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
    Hand hard16 = new Hand().withCards(List.of(card4, card4, card8));
    Hand hard17 = new Hand().withCards(List.of(card4, card4, card9));
    Hand hard18 = new Hand().withCards(List.of(card8, cardt));
    Hand hard19 = new Hand().withCards(List.of(card9, cardt));
    Hand hard20 = new Hand().withCards(List.of(cardt, cardt));
    Hand hard21 = new Hand().withCards(List.of(card8, card7, card6));

    List<Hand> hardHands = List.of(hard2,hard3,hard4,hard5,hard6,hard7,hard8,hard9,hard10,hard11,hard12,hard13,hard14,hard15,hard16,hard17,hard18,hard19,hard20,hard21);

    Hand sur16 = new Hand().withCards(List.of(card9, card7));
    Hand sur17 = new Hand().withCards(List.of(card9, card8));
    Hand sur88 = new Hand().withCards(List.of(card8, card8));

    List<Hand> surrenderHands = List.of(sur16,sur17,sur88);
}
