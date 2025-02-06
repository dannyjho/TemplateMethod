package org.card.poker;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    private final String name;
    protected final List<PokerCard> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void addHand(PokerCard pokerCard) {
        hand.add(pokerCard);
    }

    public abstract PokerCard playTurn();

    public String getName() {
        return name;
    }
}
