package org.card.uno;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnoDeck {
    List<UnoCard> unoCards;
    List<UnoCard> discardUnoCards;
    int valueLimit = 9;

    public UnoDeck() {
        this.unoCards = new ArrayList<>();
        this.discardUnoCards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        for (Color color : Color.values()) {
            for (int i = 0; i <= valueLimit; i++) {
                unoCards.add(new UnoCard(color, i));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(unoCards);
    }

    public UnoCard draw() {
        return unoCards.remove(unoCards.size() - 1);
    }

    public UnoCard showFirstCard() {
        UnoCard unoCard = draw();
        discardUnoCards.add(unoCard);
        return unoCard;
    }
}
