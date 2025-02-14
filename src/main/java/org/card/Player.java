package org.card;

import org.card.showdown.PokerCard;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    private final String name;
    protected final List<PokerCard> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }


    public String getName() {
        return name;
    }
}
