package com.tlglearning.cards;

import com.tlglearning.cards.model.Card;
import com.tlglearning.cards.model.Deck;
import com.tlglearning.cards.model.Rank;
import java.security.SecureRandom;
import java.util.EnumSet;
import java.util.Random;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TestMain {

  public static void main(String[] args) {
    Deck deck = new Deck();
    Random rng = new SecureRandom();
    Set<Rank> excludedCards = EnumSet.range(Rank.TWO, Rank.EIGHT);
    deck.shuffle(rng);
    Spliterator<Card> splitter = Spliterators.spliterator(deck.iterator(), deck.size(), 0);
    StreamSupport
        .stream(splitter, false)
        .filter(card -> !excludedCards.contains(card))
        .collect(Collectors.toList());
  }

}
