package org.card.showdown;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<PokerCard> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new PokerCard(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public PokerCard drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return cards.remove(cards.size() - 1);
    }
}
