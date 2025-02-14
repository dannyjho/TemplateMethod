package org.card.uno;

import org.card.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class UnoPlayer extends Player {

    List<UnoCard> hand;

    public UnoPlayer(String name) {
        super(name);
        this.hand = new ArrayList<>();
    }

    public void addHand(UnoCard unoCard) {
        hand.add(unoCard);
    }

    public abstract UnoCard playTurn(UnoCard currentUnoCard);

    public void playCard(UnoCard playerChooseCard) {
        System.out.println(getName() + "出了" + playerChooseCard.toString());
        hand.remove(playerChooseCard);
    }

    ;
}
