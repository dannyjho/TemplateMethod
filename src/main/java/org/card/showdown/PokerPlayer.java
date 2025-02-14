package org.card.showdown;

import org.card.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class PokerPlayer extends Player {

    protected List<PokerCard> hand;

    public PokerPlayer(String name) {
        super(name);
        this.hand = new ArrayList<>();
    }

    public abstract PokerCard playTurn();

    public void addHand(PokerCard pokerCard) {
        hand.add(pokerCard);
    }

    public List<PokerCard> getHand() {
        return hand;
    }
}
